/*
 * Copyright Stuff Limited
 */

package com.think.clean.repository.log;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payload")
@Data
@Accessors(chain = true)
public class PayloadEntity {

    @Id
    @Column(name = "log_item_id")
    private String id;
    @Column(name = "item_id")
    private String itemId;
    private Integer amount;

    @OneToOne
    @MapsId
    @JoinColumn(name = "log_item_id")
    private LogItemEntity logItem;

}
