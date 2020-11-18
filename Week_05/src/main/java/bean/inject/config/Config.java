package bean.inject.config;

import bean.inject.bean.ConditionBean;
import bean.inject.bean.ConfigurationClassConfigBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ConfigurationClassConfigBean bean() {
        return new ConfigurationClassConfigBean();
    }


    @Bean
    public FactoryBean<ConditionBean> conditionBeanFactoryBean() {
        return new CustomFactoryBean();
    }
}
