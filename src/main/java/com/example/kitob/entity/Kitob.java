package com.example.kitob.entity;

import com.example.kitob.entity.enums.Sinf;
import com.example.kitob.entity.enums.Til;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Kitob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    private Sinf sinf;

    private Til til;


}
