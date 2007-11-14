package example.chapter3;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class GreetBean implements ApplicationContextAware {

    private ApplicationContext context;
    private Locale locale = Locale.getDefault();

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String greet() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if(hour<6)
            return context.getMessage("night", null, "Good night!", locale);
        if(hour<12)
            return context.getMessage("morning", null, "Good morning!", locale);
        if(hour<18)
            return context.getMessage("afternoon", null, "Good afternoon", locale);
        return context.getMessage("evening", null, "Good evening!", locale);
    }

}
