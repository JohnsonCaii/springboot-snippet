package com.rabbit.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by caie on 09/11/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBO {

    private String name;

    private Integer age;

    private String address;

}
