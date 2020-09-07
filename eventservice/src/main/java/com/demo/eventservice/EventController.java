package com.demo.eventservice;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import io.micrometer.core.annotation.Timed;
import java.util.List;
import javax.persistence.Query;
import org.slf4j.Logger;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController
{
    @PersistenceContext
    private EntityManager em;
    private static final Logger log;
    String eventQ;
    
    public EventController() {
        this.eventQ = "SELECT service_id, COUNT(*) FROM service_event   WHERE status = 'error' AND created_at >= DATE('2018-06-24 22:23:00') - INTERVAL 1 WEEK GROUP BY service_id";
    }
    
    @Timed("eventservice.time")
    @GetMapping({ "/getEvents" })
    public String getEvents() {
        final Query q = this.em.createNativeQuery(this.eventQ);
        final List<Object[]> resultList = (List<Object[]>)q.getResultList();
        EventController.log.info("Query Result count --- " + resultList.size());
        resultList.clear();
        return "events fetched";
    }
    
    static {
        log = LoggerFactory.getLogger((Class)EventController.class);
    }
}