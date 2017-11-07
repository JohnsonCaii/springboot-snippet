package com.snippet.multiple.datasource.repository.market.repo;

import com.snippet.multiple.datasource.repository.market.model.MarketInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by johnson on 5/3/17.
 */
public interface MarketInfoRepository extends JpaRepository<MarketInfo, Integer> {
}
