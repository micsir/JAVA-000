package bean.inject.config;

import bean.inject.bean.ConditionBean;
import bean.inject.bean.ConfigurationClassConfigBean;
import bean.inject.bean.JSRConfigBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author deepin
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("bean.inject");

        JSRConfigBean jsrConfigBean = configApplicationContext.getBean(JSRConfigBean.class);
        jsrConfigBean.show();

        ConfigurationClassConfigBean configurationClassConfigBean = configApplicationContext.getBean(ConfigurationClassConfigBean.class);
        configurationClassConfigBean.show();

        ConditionBean conditionBean = configApplicationContext.getBean(ConditionBean.class);
        conditionBean.show();


    }
}
