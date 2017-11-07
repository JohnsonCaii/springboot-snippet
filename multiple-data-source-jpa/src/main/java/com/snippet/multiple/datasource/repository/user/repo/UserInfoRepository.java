package com.snippet.multiple.datasource.repository.user.repo;

import com.snippet.multiple.datasource.repository.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by johnson on 5/3/17.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
}
