package com.springmvc.Configuration;

import org.springframework.context.MessageSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springmvc.*")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	//added for multipart 
	 @Bean(name="multipartResolver")
	    public StandardServletMultipartResolver resolver(){
	        return new StandardServletMultipartResolver();
	    }
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver  viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	 @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("messages");
	        return messageSource;
	    }
	
	 
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		}
	 
	 @Override
	    public void configurePathMatch(PathMatchConfigurer matcher) {
	        matcher.setUseRegisteredSuffixPatternMatch(true);
	    }
	 
}
