package com.zcgl.zcgl;

import com.zcgl.zcgl.sysConfig.reuquest.MyWebFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@MapperScan("com.zcgl.zcgl.*.*.mapper")
public class ZcglApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcglApplication.class, args);
    }

//    @Bean
//    public ErrorPageRegistry registerErrorPages(ErrorPageRegistry errorPageRegistry) {
//        //1、按错误的类型显示错误的网页
//        //错误类型为404，找不到网页的，默认显示404.html网页
//        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
//        //错误类型为500，表示服务器响应错误，默认显示500.html网页
//        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
//        errorPageRegistry.addErrorPages(e404, e500);
//        return errorPageRegistry;
//    }

    //    自定义过滤器
    @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new MyWebFilter());
        frBean.addUrlPatterns("/*");
        return frBean;
    }

    //    websocket
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
