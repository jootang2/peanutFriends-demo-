//package com.sjh.peanutfriends_0324.config;
//
//import com.sjh.peanutfriends_0324.security.jwt.util.IfLoginArgumentResolver;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
////                .allowedOrigins("https://www.fakeshop.com")
//                .allowedMethods("GET", "POST", "PATCH", "PUT", "OPTIONS", "DELETE")
//                .allowCredentials(true);
//    }
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(new IfLoginArgumentResolver());
//    }
//}
