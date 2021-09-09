package com.hai.code.netty.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author admin_z by 2021/9/8
 * @ClassName MyTestRequest
 */
@Data
public class MyTestRequest implements Serializable {
    public MyTestRequest(String id) {
        this.id = id;
    }

    private String id;
}
