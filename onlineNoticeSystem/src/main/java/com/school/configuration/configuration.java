package com.school.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.school.dao.AdminDao;
import com.school.dao.LoginDao;
import com.school.dao.NoticeDao;
import com.school.daoImpl.UserLoginDaoImpl;
import com.school.daoImpl.AdminDaoImpl;
import com.school.daoImpl.NoticeDaoImpl;

@Configuration
@ComponentScan(basePackages="com.school")
@EnableWebMvc
public class configuration extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/login/");
		
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/Picture/**").addResourceLocations("file:E:/Picture/");
	}
	
	

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/noticedb");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		
		return dataSource;
	}
	
	
	private int maxUploadSizeInMb = 20 * 1024 * 1024 ; // MB

	@Bean
	public CommonsMultipartResolver multipartResolver() {

		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		//cmr.setMaxUploadSize(maxUploadSizeInMb * 2);
		cmr.setMaxUploadSizePerFile(maxUploadSizeInMb); // bytes
		return cmr;
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleError2(MaxUploadSizeExceededException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/adminindex";

    }
	
	@Bean
	public NoticeDao getUserDAO() {
		return new NoticeDaoImpl(getDataSource());
	}
	
	
	@Bean
	public LoginDao getLoginDao() {
		return new UserLoginDaoImpl(getDataSource());
	}
	
	@Bean
	public AdminDao getAdminDao() {
		return new AdminDaoImpl(getDataSource());
	}

	

}
