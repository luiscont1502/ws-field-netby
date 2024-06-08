package com.netby.persistence.service.service.impl;

import com.netby.persistence.service.entity.TalkEntity;
import com.netby.persistence.service.service.ConferenceService;
import com.netby.persistence.service.utils.Constant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ConferenceServiceImpl implements ConferenceService {

    @Override
    public List<String> scheduleTalks(List<TalkEntity> talks) {
        List<String> schedule = new ArrayList<>();
        List<TalkEntity> morningSession = new ArrayList<>();
        List<TalkEntity> afternoonSession = new ArrayList<>();

        // Dividir las charlas en sesiones de la mañana y la tarde
        fillSession(talks, morningSession, 180);
        fillSession(talks, afternoonSession, 240);

        // Crear Pista 1
        schedule.addAll(createTrackSchedule("Track 1", morningSession, afternoonSession));

        // Crear Pista 2 con las charlas restantes
        if (!talks.isEmpty()) {
            morningSession.clear();
            afternoonSession.clear();
            fillSession(talks, morningSession, 180);
            fillSession(talks, afternoonSession, 240);
            schedule.addAll(createTrackSchedule("Track 2", morningSession, afternoonSession));
        }
        return schedule;
    }

    @Override
    public void fillSession(List<TalkEntity> talks, List<TalkEntity> session, int maxDuration) {
        int currentDuration = 0;
        for (int i = 0; i < talks.size(); ) {
            TalkEntity talk = talks.get(i);
            if (currentDuration + talk.getDuration() <= maxDuration) {
                session.add(talk);
                currentDuration += talk.getDuration();
                talks.remove(i);
            } else {
                i++;
            }
        }
    }

    @Override
    public List<String> createTrackSchedule(String trackName, List<TalkEntity> morningSession, List<TalkEntity> afternoonSession) {
        List<String> schedule = new ArrayList<>();
        schedule.add(trackName + ":");
        // Programar sesión de la mañana
        LocalTime currentTime = Constant.MORNING_SESSION_START;
        for (TalkEntity talk : morningSession) {
            schedule.add(Constant.formatTime(currentTime) + " " + talk.getTitle() + " " + talk.getDuration() + "min");
            currentTime = currentTime.plusMinutes(talk.getDuration());
        }
        schedule.add("12:00PM Lunch");
        // Programar sesión de la tarde
        currentTime = Constant.AFTERNOON_SESSION_START;
        for (TalkEntity talk : afternoonSession) {
            schedule.add(Constant.formatTime(currentTime) + " " + talk.getTitle() + " " + talk.getDuration() + "min");
            currentTime = currentTime.plusMinutes(talk.getDuration());
        }

        // Programar evento de networking
        if (currentTime.isBefore(Constant.NETWORKING_EVENT_EARLIEST_START)) {
            currentTime = Constant.NETWORKING_EVENT_EARLIEST_START;
        }
        schedule.add(Constant.formatTime(currentTime) + " Networking Event");

        return schedule;
    }

}
