package com.snippet.multiple.datasource.repository.market.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by johnson on 5/3/17.
 */
@Entity
@Table(name = "market_info")
public class MarketInfo {

    @Id
    @GeneratedValue
    private Integer id;
    private String marketName;
    private String marketAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketAddress() {
        return marketAddress;
    }

    public void setMarketAddress(String marketAddress) {
        this.marketAddress = marketAddress;
    }
}
