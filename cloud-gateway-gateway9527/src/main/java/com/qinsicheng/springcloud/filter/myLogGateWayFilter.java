package com.qinsicheng.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 01/05/2022 16:59
 */
@Slf4j
@Component
public class myLogGateWayFilter implements GlobalFilter, Ordered {
    //具体过滤规则
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String ename = exchange.getRequest().getQueryParams().getFirst("ename");
        log.info("-------------------已进入 myLogGateWayFilter-----------");
        if (ename == null) {
            log.info("-------------有非法用户进入-----------"+new Date());
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //通过请求
        return chain.filter(exchange);
    }

    //过滤链的顺序优先级
    @Override
    public int getOrder() {
        return 0;
    }
}
