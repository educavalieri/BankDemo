package com.cavalieri.BanckDemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class WithdrawDTO {

    private Long id;
    private Integer draw;

}
