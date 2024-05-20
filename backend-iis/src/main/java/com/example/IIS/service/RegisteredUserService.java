package com.example.IIS.service;

import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.dto.RegisterDTO;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.WorkShopDto;

import java.util.List;

public interface RegisteredUserService {
    RegisteredUserDto createReg(RegisteredUserDto registerDTO);

    List<RegisteredUserDto> getAllUsers();

    RegisteredUserDto getById(long id);

    RegisteredUser getByIdEntity(long id);

    List<RegisteredUser> findAllById(List<Long> ids);
}
