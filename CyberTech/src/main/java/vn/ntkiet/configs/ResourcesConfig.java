package vn.ntkiet.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourcesConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry ) {
		registry.addResourceHandler("/images/**")
				.addResourceLocations("file:D:/University/Nam3-HK1/Web Programming/DoAnCuoiKy/CyberTech/src/uploads/images/");
	}
}
