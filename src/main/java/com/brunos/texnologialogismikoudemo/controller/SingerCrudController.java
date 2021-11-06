package com.brunos.texnologialogismikoudemo.controller;

import com.brunos.texnologialogismikoudemo.Service.CrudService;
import com.brunos.texnologialogismikoudemo.Service.SingerCrudService;
import com.brunos.texnologialogismikoudemo.entity.Singer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singers")
public class SingerCrudController implements CrudController<Singer> {

    private final SingerCrudService singerCrudService;

    public SingerCrudController(SingerCrudService singerCrudService) {
        this.singerCrudService = singerCrudService;
    }

    @Override
    public CrudService<Singer> getCrudService() {
         return singerCrudService;
    }
}
