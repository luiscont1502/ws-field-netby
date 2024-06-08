package com.netby.persistence.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TalkEntity {
    private String title;
    private Integer duration;
}
