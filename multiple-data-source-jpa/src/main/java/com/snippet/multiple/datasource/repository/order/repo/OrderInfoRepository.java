package com.snippet.multiple.datasource.repository.order.repo;

import com.snippet.multiple.datasource.repository.order.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by johnson on 5/3/17.
 */
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer> {
}
