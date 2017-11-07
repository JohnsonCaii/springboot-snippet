package com.snippet.multiple.datasource.repository.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by johnson on 5/3/17.
 */
@Entity
@Table(name = "order_info")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = -2017748168939674582L;
    @Id
    @GeneratedValue
    private Integer id;
    private String orderId;
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "createTime", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

}
