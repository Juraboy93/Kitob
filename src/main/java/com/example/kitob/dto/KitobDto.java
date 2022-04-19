package com.example.kitob.dto;

import com.example.kitob.entity.enums.Sinf;
import com.example.kitob.entity.enums.Til;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class KitobDto {
    private String name;
    private Sinf sinfi;
    private Til tili;

}
