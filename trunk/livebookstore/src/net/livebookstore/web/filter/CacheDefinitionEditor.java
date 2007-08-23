package net.livebookstore.web.filter;

import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Support for spring dependency inject. Convert multiline-text to 
 * <code>CacheDefinition</code> object. No need to register this property 
 * editor, spring will automatically discover it.
 * 
 * @author Xuefeng
 */
public class CacheDefinitionEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new StringReader(text));
        List<CacheEntry> entries = new ArrayList<CacheEntry>();
        try {
            for(;;) {
                String s = reader.readLine();
                if(s==null)
                    break;
                s = s.trim();
                if(s.equals(""))
                    continue;
                entries.add(new CacheEntry(s));
            }
        }
        catch(IOException e) {}
        setValue(new CacheDefinition(entries.toArray(new CacheEntry[0])));
    }

}
