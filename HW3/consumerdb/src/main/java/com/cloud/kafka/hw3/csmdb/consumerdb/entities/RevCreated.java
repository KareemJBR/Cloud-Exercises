package com.cloud.kafka.hw3.csmdb.consumerdb.entities;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Table(name = "my_data_revisions_created")
public class RevCreated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rv_id;
    @Column(name = "page_id")
    private long page_id;
    @Column(name = "page_title")
    private String page_title;
    @Column(name = "rev_id")
    private long rev_id;
    @Column(name = "rev_timestamp")
    private String rev_timestamp;
    @Column(name = "rev_len")
    private String rev_len;
    public RevCreated() {
    }

    public RevCreated(long rv_id, long page_id, String page_title, long rev_id, String rev_timestamp, String rev_len) {
        this.rv_id = rv_id;
        this.page_id = page_id;
        this.page_title = page_title;
        this.rev_id = rev_id;
        this.rev_timestamp = rev_timestamp;
        this.rev_len = rev_len;
    }

    public long getRv_id() {
        return rv_id;
    }

    public void setRv_id(long rv_id) {
        this.rv_id = rv_id;
    }

    public long getPage_id() {
        return page_id;
    }

    public void setPage_id(long page_id) {
        this.page_id = page_id;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public long getRev_id() {
        return rev_id;
    }

    public void setRev_id(long rev_id) {
        this.rev_id = rev_id;
    }

    public String getRev_timestamp() {
        return rev_timestamp;
    }

    public void setRev_timestamp(String rev_timestamp) {
        this.rev_timestamp = rev_timestamp;
    }

    public String getRev_len() {
        return rev_len;
    }

    public void setRev_len(String rev_len) {
        this.rev_len = rev_len;
    }
    
}
