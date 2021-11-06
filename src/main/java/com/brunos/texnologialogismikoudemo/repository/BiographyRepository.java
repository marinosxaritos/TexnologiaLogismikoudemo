package com.brunos.texnologialogismikoudemo.repository;

import com.brunos.texnologialogismikoudemo.entity.Biography;
import com.brunos.texnologialogismikoudemo.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiographyRepository extends JpaRepository<Biography, String> {
}
