package com.cybersoft.uniclub14.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
  private int code;
  private String message;
  private Object data;

  public static BaseResponse success(Object data) {
    return BaseResponse.builder().code(200).message("success").data(data).build();
  }
}
