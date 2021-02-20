/*
 * Copyright Stuff Limited
 */

package com.think.clean.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LogItemRepository extends JpaRepository<LogItemEntity, String>, 
    JpaSpecificationExecutor<LogItemEntity> {
}
