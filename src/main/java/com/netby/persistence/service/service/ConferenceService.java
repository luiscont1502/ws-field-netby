package com.netby.persistence.service.service;

import com.netby.persistence.service.entity.TalkEntity;

import java.util.List;

public interface ConferenceService {
    List<String> scheduleTalks(List<TalkEntity> talks);
    void fillSession(List<TalkEntity> talks, List<TalkEntity> session, int maxDuration);
    List<String> createTrackSchedule(String trackName, List<TalkEntity> morningSession, List<TalkEntity> afternoonSession);
}
