package com.cybersoft.demojpa.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private int code = 200;
    private String message = "";
    private Object data;

}
