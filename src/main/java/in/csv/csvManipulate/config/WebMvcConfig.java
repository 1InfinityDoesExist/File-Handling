package in.csv.csvManipulate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import in.csv.csvManipulate.util.MultiTenancyInterceptorHandler;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("-----WebMvcConfig Class, Inside add Interceptor method-----");
		registry.addInterceptor(new MultiTenancyInterceptorHandler());
	}
}
