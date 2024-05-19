package com.example.IIS.service;

import com.example.IIS.dto.UserWorkshopDto;
import com.example.IIS.dto.WorkShopDto;

import java.util.List;

public interface UserWorkshopService {
    public void addUserToWorkshop(long workshopId, long userId);

    public List<UserWorkshopDto> getAll ();

    public UserWorkshopDto cancelWorkshop(long id);


}
