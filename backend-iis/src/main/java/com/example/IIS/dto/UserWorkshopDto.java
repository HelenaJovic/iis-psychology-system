package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserWorkshopDto {
    private Long id;

    private Long userId;

    private Long workshopId;

    private boolean isCanceled;
}
