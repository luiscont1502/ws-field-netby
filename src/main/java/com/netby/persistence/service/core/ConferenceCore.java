package com.netby.persistence.service.core;

import com.netby.persistence.service.entity.TalkEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConferenceCore {
    public ConferenceCore() {}
    public TalkEntity parseTalk(String talkInput) {
        String title = talkInput.replaceAll("\\d+min|lightning", "").trim();
        int duration = talkInput.contains("lightning") ? 5 : Integer.parseInt(talkInput.replaceAll("\\D+", ""));
        return new TalkEntity(title, duration);
    }


}
