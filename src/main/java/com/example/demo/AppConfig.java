package com.example.demo;

import com.example.demo.common.aop.SetAuditInfoInterceptor;
import com.example.demo.domain.dto.UserRole;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.example")
public class AppConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, WebMvcConfigurer {
        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }

        @Bean
        public UserRole userRole(){return new UserRole();}

        @Bean
        public LocalValidatorFactoryBean beanValidator(MessageSource messageSource){
                val bean = new LocalValidatorFactoryBean();
                bean.setValidationMessageSource(messageSource);
                return bean;
        }

        @Bean
        public SetAuditInfoInterceptor setAuditInfoInterceptor() {
                // システム制御項目を保存してDB保存時に利用する
                return new SetAuditInfoInterceptor();
        }


        @Override
        public void customize(ConfigurableServletWebServerFactory factory) {

        }
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(setAuditInfoInterceptor());
        }
}
