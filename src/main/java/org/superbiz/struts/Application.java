package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.FilterRegistration;

import static java.util.Arrays.asList;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean siteMeshFilterBean() {

        FilterRegistrationBean bean = new FilterRegistrationBean(new SiteMeshFilter());
        bean.addUrlPatterns("/*");

        bean.setOrder(Integer.MIN_VALUE);

        return bean;
    }

    @Bean
    public FilterRegistrationBean strutsPrepareAndExecuteFilterBean() {

        FilterRegistrationBean bean = new FilterRegistrationBean(new StrutsPrepareAndExecuteFilter());

//        bean.setUrlPatterns(asList("/", "/addUserForm.action", "/addUser.action",
//                "/findUserForm.action", "/findUser.action",
//                "/listAllUsers.action"));
        bean.addUrlPatterns("/");
        bean.addUrlPatterns("/addUserForm.action");
        bean.addUrlPatterns("/addUser.action");
        bean.addUrlPatterns("/findUserForm.action");
        bean.addUrlPatterns("/findUser.action");
        bean.addUrlPatterns("/listAllUsers.action");

        bean.setOrder(Integer.MIN_VALUE + 1);

        return bean;
    }
}

