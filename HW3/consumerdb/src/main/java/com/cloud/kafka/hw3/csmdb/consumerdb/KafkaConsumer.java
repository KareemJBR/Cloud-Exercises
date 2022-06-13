package com.cloud.kafka.hw3.csmdb.consumerdb;


import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cloud.kafka.hw3.csmdb.consumerdb.entities.PagesCreated;
import com.cloud.kafka.hw3.csmdb.consumerdb.entities.RecentChanges;
import com.cloud.kafka.hw3.csmdb.consumerdb.entities.RevCreated;
import com.cloud.kafka.hw3.csmdb.consumerdb.repository.RecentChangesRepository;
import com.cloud.kafka.hw3.csmdb.consumerdb.repository.RevCreatedRepository;
import com.cloud.kafka.hw3.csmdb.consumerdb.repository.PagesCreatedRepository;
import com.google.gson.Gson;

@Service
public class KafkaConsumer {
    
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(KafkaConsumer.class);

    private RecentChangesRepository recentChangesRepository;
    private PagesCreatedRepository pagesCreatedRepository;
    private RevCreatedRepository revCreatedRepository;

    public KafkaConsumer(RecentChangesRepository recentChangesRepository, PagesCreatedRepository pagesCreatedRepository, RevCreatedRepository revCreatedRepository) {
        this.recentChangesRepository = recentChangesRepository;
        this.pagesCreatedRepository = pagesCreatedRepository;
        this.revCreatedRepository = revCreatedRepository;
    }
    @KafkaListener(topics = {"wikimedia_recent_changes","wikimedia_page_create","wikimedia_revision_create"}, groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message recieved: %s", message));
        String message_type_create = "eqiad.mediawiki.page-create";



        if(message.contains("edit")){
            RecentChanges recentChanges = new RecentChanges();
            RecentChanges tmp = new RecentChanges();
            Gson gson = new Gson();
            tmp = gson.fromJson(message, RecentChanges.class);
            recentChanges.setId(tmp.getId());
            recentChanges.setType(tmp.getType());
            recentChanges.setTitle(tmp.getTitle());
            recentChanges.setUser(tmp.getUser());
            recentChanges.setBot(tmp.isBot());
            recentChanges.setServer_url(tmp.getServer_url());
            recentChangesRepository.save(recentChanges);
    
        }

    else if(message.contains(message_type_create)){
            PagesCreated pagesCreated = new PagesCreated();
            PagesCreated tmp2 = new PagesCreated();
            Gson gson = new Gson();
            tmp2 = gson.fromJson(message, PagesCreated.class);
            pagesCreated.setPage_id(tmp2.getPage_id());
            pagesCreated.setPage_title(tmp2.getPage_title());
            pagesCreated.setRev_id(tmp2.getRev_id());
            pagesCreated.setRev_timestamp(tmp2.getRev_timestamp());
            pagesCreated.setRev_len(tmp2.getRev_len());
            pagesCreatedRepository.save(pagesCreated);

    }

    else{
        RevCreated revCreated = new RevCreated();
        RevCreated tmp3 = new RevCreated();
        Gson gson = new Gson();
        tmp3 = gson.fromJson(message, RevCreated.class);
        revCreated.setPage_id(tmp3.getPage_id());
        revCreated.setRev_id(tmp3.getRev_id());
        revCreated.setRev_timestamp(tmp3.getRev_timestamp());
        revCreated.setRev_len(tmp3.getRev_len());
        revCreated.setPage_title(tmp3.getPage_title());
        revCreatedRepository.save(revCreated);
    }
}
}
