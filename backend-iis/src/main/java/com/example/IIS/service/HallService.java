package com.example.IIS.service;

import com.example.IIS.domain.Hall;
import com.example.IIS.dto.HallDto;

import java.util.List;

public interface HallService {
    List<HallDto> getAllHalls();
    HallDto findHallByWorkshopId(Long workshopId);

    HallDto saveHall(HallDto hallDto); // Dodajte parametar za prenos informacija o hali

    HallDto findById(long id);


}
