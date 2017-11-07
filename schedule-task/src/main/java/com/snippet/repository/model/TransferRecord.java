package com.snippet.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by johnson on 4/12/17.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferRecord implements Serializable {

    private static final long serialVersionUID = 7899827017572039853L;

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransferCurrency currency;

    @Basic(optional = false)
    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
