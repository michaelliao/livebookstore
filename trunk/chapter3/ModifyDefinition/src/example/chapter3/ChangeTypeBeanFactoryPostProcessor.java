package example.chapter3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ChangeTypeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException
    {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            if(bd.getBeanClassName().equals("example.chapter3.BeanA"))
                bd.setBeanClassName("example.chapter3.BeanB");
        }
    }

}
