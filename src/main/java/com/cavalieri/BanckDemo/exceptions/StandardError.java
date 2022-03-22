package com.cavalieri.BanckDemo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardError implements Serializable {

    private Instant instant;
    private Integer status;
    private String error;
    private String message;
    private String path;



}
