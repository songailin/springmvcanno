package com.easysoft.initializer;

import com.easysoft.config.MyRootConfig;
import com.easysoft.config.MyServletConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {MyRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MyServletConfig.class};
    }

    /**
     * 获取DispatcherServlet的映射信息
     * /:拦截所有请求资源，但不包括*.jsp
     * /*:拦截包括*.jsp的所有请求资源
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
