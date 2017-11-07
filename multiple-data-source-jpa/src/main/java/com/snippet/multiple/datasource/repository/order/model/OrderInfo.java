package com.snippet.multiple.datasource.repository.order.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by johnson on 5/3/17.
 */
@Entity
@Table(name = "order_info")
public class OrderInfo {

    @Id
    @GeneratedValue
    private Integer id;

    private String orderId;

    private BigDecimal price;

    @Basic(optional = false)
    @Column(name = "createTime", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
