package com.example.demo;

import com.example.demo.domain.dto.UserRole;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("com.example")
public class AppConfig {
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


}
