package com.example.IIS.service;

import com.example.IIS.domain.Role;
import com.example.IIS.dto.RoleDto;

public interface RoleService {
    RoleDto findByName(String name);

}
