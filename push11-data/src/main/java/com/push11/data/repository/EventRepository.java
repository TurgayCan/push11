package com.push11.data.repository;

import com.push11.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {

    @Query("{'user.app._id' : ?0}")
    public List<Event> getEventsFindByApp(String appId);

    @Query(value = "{ 'user.app._id': ?0 ,'event_name':?1} ")
    public List<Event> getEventsFindByAppAndEventName(String appId, String eventName);
}
