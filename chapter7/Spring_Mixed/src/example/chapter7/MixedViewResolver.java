package example.chapter7;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class MixedViewResolver implements ViewResolver {

    private Map<String, ViewResolver> resolvers;

    public void setResolvers(Map<String, ViewResolver> resolvers) {
        this.resolvers = resolvers;
    }

    public View resolveViewName(String viewName, Locale locale) throws Exception {
        int n = viewName.lastIndexOf('.');
        if(n==(-1))
            throw new NoSuchViewResolverException();
        String suffix = viewName.substring(n+1);
        ViewResolver resolver = resolvers.get(suffix);
        if(resolver!=null)
            return resolver.resolveViewName(viewName, locale);
        throw new NoSuchViewResolverException("No ViewResolver for " + suffix);
    }

}
