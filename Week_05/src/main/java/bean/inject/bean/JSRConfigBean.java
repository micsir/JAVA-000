package bean.inject.bean;

import org.springframework.stereotype.Component;

/**
 * @author deepin
 */
@Component
public class JSRConfigBean {
    public void show() {
        System.out.println("spring JSR注解方式配置的bean");
    }
}
