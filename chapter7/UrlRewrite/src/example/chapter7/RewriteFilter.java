/*
 * Copyright (c) 1998-2006 Caucho Technology -- all rights reserved
 *
 * This file is part of Resin(R) Open Source
 *
 * Each copy or derived work must preserve the copyright notice and this
 * notice unmodified.
 *
 * Resin Open Source is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Resin Open Source is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, or any warranty
 * of NON-INFRINGEMENT.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Resin Open Source; if not, write to the
 *   Free SoftwareFoundation, Inc.
 *   59 Temple Place, Suite 330
 *   Boston, MA 02111-1307  USA
 *
 * @author Scott Ferguson
 */
package example.chapter7;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Rewrites URL patterns.
 * 
 * @since Resin 3.0.0
 */
public class RewriteFilter implements Filter {
    private final Log log = LogFactory.getLog(RewriteFilter.class);
    private ServletContext _app;
    private ArrayList<RewriteEntry> _entries = new ArrayList<RewriteEntry>();

    public void init(FilterConfig config) throws ServletException {
        _app = config.getServletContext();
        // 读取配置文件:
        File conf_file = new File(_app.getRealPath("/WEB-INF/rewrite.properties"));
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(conf_file));
            for(;;) {
                String s = reader.readLine();
                if(s==null)
                    break;
                if(s.trim().equals(""))
                    continue;
                if(s.trim().startsWith("#"))
                    continue;
                String[] ss = s.trim().split(" ", 2);
                if(ss.length!=2) {
                    log.warn("Invaild rule: " + s);
                }
                else {
                    log.info("Add rewrite entry: " + s);
                    _entries.add(new RewriteEntry(ss[0], ss[1]));
                }
            }
        }
        catch(IOException ioe) {
            log.warn("Exception in init RewriteFilter.", ioe);
        }
        finally {
            if(reader!=null) {
                try {
                    reader.close();
                }
                catch(IOException e) {}
            }
        }
    }

    /**
     * Any cleanup for the filter.
     */
    public void destroy() {}

    /**
     * Creates a wrapper to compress the output.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
            throws ServletException, IOException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

        for (int i = 0; i < _entries.size(); i++) {
            RewriteEntry entry = _entries.get(i);
            Pattern pattern = entry.getRegexp();
            Matcher matcher = pattern.matcher(url);
            if (! matcher.find(0))
                continue;
            String replacement = replace(matcher, entry.getTarget());
            String query = req.getQueryString();
            if (query != null) {
                if (replacement.indexOf('?') > 0)
                    replacement = replacement + '&' + query;
                else
                    replacement = replacement + '?' + query;
            }
            log.info("forwarding '" + url + "' to '" + replacement + "'");
            if (replacement.startsWith("/")) {
                RequestDispatcher disp = _app.getRequestDispatcher(replacement);
                disp.forward(request, response);
                return;
            }
            else {
                res.sendRedirect(res.encodeRedirectURL(replacement));
                return;
            }
        }
        nextFilter.doFilter(request, response);
    }

    private String replace(Matcher matcher, String target) {
        StringBuffer cb = new StringBuffer(512);
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (ch != '$' || i == target.length() - 1)
                cb.append(ch);
            else {
                ch = target.charAt(i + 1);
                if (ch >= '0' && ch <= '9') {
                    int group = ch - '0';
                    cb.append(matcher.group(group));
                    i++;
                }
                else if (ch == '$') {
                    cb.append('$');
                    i++;
                }
                else
                    cb.append('$');
            }
        }
        return cb.toString();
    }

    public static class RewriteEntry {
        private Pattern _pattern;
        private String _target;

        public RewriteEntry(String pattern, String target) {
            _pattern = Pattern.compile(pattern);
            _target = target;
        }

        public Pattern getRegexp() {
            return _pattern;
        }

        public String getTarget() {
            return _target;
        }
    }
}
