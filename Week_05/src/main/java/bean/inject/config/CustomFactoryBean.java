package bean.inject.config;

import bean.inject.bean.ConditionBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author deepin
 */
public class CustomFactoryBean implements FactoryBean<ConditionBean> {
    public ConditionBean getObject() throws Exception {
        return new ConditionBean();
    }

    public Class<?> getObjectType() {
        return ConditionBean.class;
    }
}
