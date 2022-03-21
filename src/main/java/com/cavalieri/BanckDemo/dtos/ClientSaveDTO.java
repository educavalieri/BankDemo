package com.cavalieri.BanckDemo.dtos;

import com.cavalieri.BanckDemo.enumms.Titular;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientSaveDTO {

    private Titular titular;
    private String name;
    private String lastName;
    private String document;
}
