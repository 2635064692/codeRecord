package com.hai.code.netty;

import lombok.Data;

/**
 * @author admin_z by 2021/9/8
 * @ClassName MyTestRequest
 */
@Data
public class MyTestRequest {
    public MyTestRequest(String id) {
        this.id = id;
    }

    private String id;
}
