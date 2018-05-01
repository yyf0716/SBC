package com.sbc.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {

	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource druid() {
		return new DruidDataSource();
	}

	// 后台管理的Servlet
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean bean = new ServletRegistrationBean();
		bean.setServlet(new StatViewServlet());

		bean.addUrlMappings("/druid/*");

		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("resetEnable", "false"); // 禁用HTML页面上的“Rest All”功能
		initParameters.put("loginUsername", "admin"); // ++监控页面登录用户名
		initParameters.put("loginPassword", "admin"); // ++监控页面登录用户密码
		initParameters.put("deny", ""); // ip黑名单
		initParameters.put("allow", ""); // ip白名单（没有配置或者为空，则允许所有访问）

		// 如果某个ip同时存在，deny优先于allow
		bean.setInitParameters(initParameters);

		return bean;
	}

	// 监控FILTER
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		// bean.addUrlPatterns("/*");
		// bean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico"); //
		// 不过滤
		// bean.addInitParameter("profileEnable", "true");
		return bean;
	}
}
