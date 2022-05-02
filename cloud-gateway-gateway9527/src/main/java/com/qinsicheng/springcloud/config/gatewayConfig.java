package com.qinsicheng.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 01/05/2022 16:22
 */
@Configuration
public class gatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_qinsicheng",
                r -> r.path("/guonei").
                        uri("https://news.baidu.com/guonei"));
        routes.route("path_route_qinsicheng_",
                r -> r.path("/guoji").
                        uri("https://news.baidu.com/guoji"));
        return routes.build();
    }
}
