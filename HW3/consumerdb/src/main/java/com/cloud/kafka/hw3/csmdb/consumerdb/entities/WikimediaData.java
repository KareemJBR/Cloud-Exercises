package com.cloud.kafka.hw3.csmdb.consumerdb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
@Table(name = "wikimedia_recent_changes")
@Getter
@Setter
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String wikiData;

    public void setWikimediaData(String wikiData) {
        this.wikiData = wikiData;
    }

}
