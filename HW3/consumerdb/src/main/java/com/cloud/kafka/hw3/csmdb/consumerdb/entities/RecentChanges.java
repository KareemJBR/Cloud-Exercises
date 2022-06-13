package com.cloud.kafka.hw3.csmdb.consumerdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "my_data_recent_changes")
public class RecentChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    @Column(name = "wiki_id")
    private long id;
    @Column(name = "type")
    private String type;
    @Column(name = "title")
    private String title;
    @Column(name = "user")
    private String user;
    @Column(name = "bot")
    private boolean bot;
    @Column(name = "server_url")
    private String server_url;
    // @Column(name = "request_id")
    // private String request_id;

    public RecentChanges() {
    }
    public RecentChanges(long _id ,long id, String type, String title, String user, boolean bot, String server_url) {
    
        this._id = _id;
        this.id = id;   
        this.type = type;
        this.title = title;
        this.user = user;
        this.bot = bot;
        this.server_url = server_url;
        // this.request_id = request_id;
    }

    public long get_id() {
        return _id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }


    public String getServer_url() {
        return server_url;
    }

    public void setServer_url(String server_url) {
        this.server_url = server_url;
    }

    // public String getRequestId() {
    //     return request_id;
    // }

    // public void setRequestId(String rqid) {
    //     this.request_id = rqid;
    // }


    
}
