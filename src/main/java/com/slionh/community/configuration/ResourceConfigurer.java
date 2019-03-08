package com.slionh.community.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/*
 * Create by s lion h on 2019/1/2
 */
@Configuration
public class ResourceConfigurer extends WebMvcConfigurerAdapter implements com.slionh.community.configuration.Configuration {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+IMAGE_PATH);
        registry.addResourceHandler("/head/**").addResourceLocations("file:"+HEAD_IMAGE_PATH);
//        registry.addResourceHandler("/myimgs/**").addResourceLocations("file:H:/myimgs/");
        super.addResourceHandlers(registry);
    }
}
