package com.sveticov.cloudtest.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CloudModel {
    private int id_model;
    private String name_model;
    private String description_model;
}
