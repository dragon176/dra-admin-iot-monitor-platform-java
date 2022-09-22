package com.dra.mqtt.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplate<T> {
    private T data;
    private Integer code;
    private String message;
}
