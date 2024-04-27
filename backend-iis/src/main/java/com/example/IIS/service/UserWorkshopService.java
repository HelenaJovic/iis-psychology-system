package com.example.IIS.service;

import com.example.IIS.dto.UserWorkshopDto;

import java.util.List;

public interface UserWorkshopService {
    public void addUserToWorkshop(long workshopId, long userId);

    public List<UserWorkshopDto> getAll ();

    }
