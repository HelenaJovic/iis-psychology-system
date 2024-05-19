package com.example.IIS.service.impl;

import com.example.IIS.domain.Role;
import com.example.IIS.domain.User;
import com.example.IIS.dto.RoleDto;
import com.example.IIS.dto.UserDTO;
import com.example.IIS.repository.RoleRepo;
import com.example.IIS.repository.UserRepository;
import com.example.IIS.service.RoleService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private ModelMapper mapper;

    private RoleDto mapToDTO(Role role){
        RoleDto roleDto = mapper.map(role, RoleDto.class);
        return roleDto;
    }

    @Transactional
    @Override
    public RoleDto findByName(String name) {
        return mapToDTO(roleRepo.findByName(name));
    }
}
