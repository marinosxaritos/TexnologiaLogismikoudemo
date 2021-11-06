package com.brunos.texnologialogismikoudemo.Service;

import com.brunos.texnologialogismikoudemo.entity.Singer;
import com.brunos.texnologialogismikoudemo.repository.SingerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingerCrudService implements  CrudService<Singer>{

    private final SingerRepository singerRepository;

    public SingerCrudService(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    @Override
    public Singer create(Singer entity) {
        return singerRepository.save(entity);
    }

    @Override
    public Optional<Singer> read(String id) {
        return singerRepository.findById(id);
    }

    @Override
    public List<Singer> read() {
        return singerRepository.findAll();
    }

    @Override
    public Singer update(Singer entity, String id) {
        Optional<Singer> oldSinger = read(id);

        if(oldSinger.isEmpty()) {
            return create(entity);
        }

        Singer oldSingerActual = oldSinger.get();

        String oldId = oldSingerActual.getId();

        entity.setId(oldId);

        return singerRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        singerRepository.deleteById(id);
    }
}
