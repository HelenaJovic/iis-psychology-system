package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SessionDocumentationDTO {

    private Long id;

    private String topicSummary;

    private String emotionalReactions;

    private String plan;

    private Long individualSessionId;

}
