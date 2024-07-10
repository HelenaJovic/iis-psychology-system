package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupSessionDTO extends SessionDTO {

    private int participantsNumber;

    private String topic;

    private String description;

    private List<Long> registeredUserIds;
}
