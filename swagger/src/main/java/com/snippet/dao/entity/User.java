package com.snippet.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by caie on 07/11/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -1212941056792352928L;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String password;
}
