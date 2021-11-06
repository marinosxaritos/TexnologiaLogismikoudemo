package com.brunos.texnologialogismikoudemo.controller;

import com.brunos.texnologialogismikoudemo.Service.BiographyCrudService;
import com.brunos.texnologialogismikoudemo.Service.CrudService;
import com.brunos.texnologialogismikoudemo.entity.Biography;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biographies")
public class BiographyCrudController implements CrudController<Biography> {

    private final BiographyCrudService biographyCrudService;

    public BiographyCrudController(BiographyCrudService biographyCrudService) {
        this.biographyCrudService = biographyCrudService;
    }

    @Override
    public CrudService<Biography> getCrudService() {
        return biographyCrudService;
    }
}
