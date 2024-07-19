package com.example.IIS.repository;

import com.example.IIS.domain.Hall;
import com.example.IIS.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HallRepo extends JpaRepository<Hall, Long> {

    @Query("SELECT h FROM Hall h WHERE h.isFree = true")
    List<Hall> findFreeHalls();

    @Query("SELECT h FROM Hall h JOIN h.workshops w WHERE w.id = :workshopId")
    Hall findHallByWorkshopId(Long workshopId);

    Hall findById(long id);

}
