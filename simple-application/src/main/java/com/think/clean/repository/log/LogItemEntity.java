/*
 * Copyright Stuff Limited
 */

package com.think.clean.repository.log;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "log_item")
@Data
@Accessors(chain = true)
public class LogItemEntity {

    @Id
    private String id;
    private Instant created;
    @Column(name = "user_id")
    private String userId;
    private String action;
    private String url;

    @OneToOne(mappedBy = "logItem", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PayloadEntity payload;

    public LogItemEntity setPayload(PayloadEntity payload) {
        this.payload = payload;
        payload.setLogItem(this);

        return this;
    }

}
