package com.snippet.multiple.datasource;

import com.snippet.multiple.datasource.repository.market.model.MarketInfo;
import com.snippet.multiple.datasource.repository.market.repo.MarketInfoRepository;
import com.snippet.multiple.datasource.repository.order.model.OrderInfo;
import com.snippet.multiple.datasource.repository.order.repo.OrderInfoRepository;
import com.snippet.multiple.datasource.repository.user.model.UserInfo;
import com.snippet.multiple.datasource.repository.user.repo.UserInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMultipleDataSourceExampleApplication {

	@Autowired
    private MarketInfoRepository marketInfoRepository;
	@Autowired
	private OrderInfoRepository orderInfoRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Test
	public void testGetFromMultipleDataSource() {
		MarketInfo marketInfo = marketInfoRepository.findOne(1);
		OrderInfo orderInfo = orderInfoRepository.findOne(1);
		UserInfo userInfo = userInfoRepository.findOne(1);
		Assert.notNull(marketInfo, "market_info is null");
		Assert.notNull(orderInfo, "order_info is null");
		Assert.notNull(userInfo, "user_info is null");
	}

}
