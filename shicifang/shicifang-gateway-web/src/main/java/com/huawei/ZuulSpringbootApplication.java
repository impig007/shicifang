package com.huawei;


import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableServiceComb
@EnableZuulProxy//开启zuul网关
public class ZuulSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulSpringbootApplication.class,args);
    }
    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();//跨域设置
        corsConfiguration.setAllowCredentials(true);//允许cookie跨域
        corsConfiguration.addAllowedOrigin("*");//允许向该服务器提交请求的url，* 表示全部允许
        corsConfiguration.addAllowedHeader("*");//允许访问头信息，*表示全部允许
        corsConfiguration.setMaxAge(18000L);//允许预请求的时间
        corsConfiguration.addAllowedMethod("OPTIONS");//预请求，必设
        corsConfiguration.addAllowedMethod("HEAD");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PATCH");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
