package com.qinsicheng.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 23/02/2022 10:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class payment implements Serializable {
    private long id;
    private String serial;

    public payment(String serial) {
        this.serial = serial;
    }
}
