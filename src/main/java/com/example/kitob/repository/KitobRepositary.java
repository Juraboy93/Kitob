package com.example.kitob.repository;

import com.example.kitob.entity.Kitob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KitobRepositary extends JpaRepository<Kitob,Integer> {
    @Override
    Optional<Kitob> findById(Integer id);
}
