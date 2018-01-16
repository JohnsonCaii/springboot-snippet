package com.snippet.api.response;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by caie on 07/11/2017.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    @ApiModelProperty(value = "user name", required = true)
    private String name;
    private Integer age;
    private String address;

}
