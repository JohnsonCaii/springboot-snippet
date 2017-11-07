package com.snippet.repository;

import com.snippet.repository.model.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by johnson on 4/12/17.
 */
public interface TransferRecordRepository extends JpaRepository<TransferRecord, Integer> {

}
