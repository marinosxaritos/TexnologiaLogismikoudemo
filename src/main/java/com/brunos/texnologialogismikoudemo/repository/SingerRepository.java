package com.brunos.texnologialogismikoudemo.repository;

import com.brunos.texnologialogismikoudemo.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends JpaRepository<Singer, String> {
}
