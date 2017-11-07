package com.snippet.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by caie on 07/11/2017.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

    @NotNull
    @ApiModelProperty(value = "user name", required = true)
    private String name;
    @Min(value = 1)
    @ApiModelProperty(value = "user age", required = true)
    private Integer age;
    @NotNull
    @ApiModelProperty(value = "user address", required = true)
    private String address;
    @NotNull
    @ApiModelProperty(value = "user password", required = true)
    private String password;
}
