package com.learn.gateway;

import org.springframework.beans.BeansException;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;

import java.util.logging.Logger;

@Configuration
public class ZuulHandlerMappingCustomizer extends BeanValidationPostProcessor {
    private static final Logger LOG = Logger.getLogger(ZuulHandlerMappingCustomizer.class.getName());

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ZuulHandlerMapping){
            LOG.info("Zuul mapping : "+bean);
        }
        return super.postProcessAfterInitialization(bean, beanName);
    }
}
