package com.qinsicheng.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 23/02/2022 10:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class returnMessage<T> {
    //200 - 执行成功
    private int status;
    private String reason;
    private T data;

    public returnMessage(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }
}
