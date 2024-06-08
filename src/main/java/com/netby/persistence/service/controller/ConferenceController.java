package com.netby.persistence.service.controller;

import com.netby.persistence.service.core.ConferenceCore;
import com.netby.persistence.service.emuns.EnumResponse;
import com.netby.persistence.service.entity.TalkEntity;
import com.netby.persistence.service.model.ResponseData;
import com.netby.persistence.service.service.ConferenceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log4j2
@RequestMapping("/api")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private ConferenceCore conferenceCore;
    @PostMapping("/schedule")
    public ResponseEntity<ResponseData<List<String>>> scheduleConference(@RequestBody List<String> talkInputs) {
        ResponseData<List<String>> response=new ResponseData<>(EnumResponse.VACIO.code());
        try{
            List<TalkEntity> talks = talkInputs.stream()
                    .map(conferenceCore::parseTalk)
                    .collect(Collectors.toList());
            response.setData(conferenceService.scheduleTalks(talks));
            response.setMessage("Consulta Exitosa");
        }catch(Exception e){
            log.info("Error scheduleConference(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
