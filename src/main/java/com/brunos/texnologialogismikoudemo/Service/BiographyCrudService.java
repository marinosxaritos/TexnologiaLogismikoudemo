package com.brunos.texnologialogismikoudemo.Service;

import com.brunos.texnologialogismikoudemo.entity.Biography;
import com.brunos.texnologialogismikoudemo.entity.Singer;
import com.brunos.texnologialogismikoudemo.repository.BiographyRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BiographyCrudService implements CrudService<Biography> {

    private final BiographyRepository biographyRepository;
    private final SingerCrudService singerCrudService;

    public BiographyCrudService(BiographyRepository biographyRepository, SingerCrudService singerCrudService) {
        this.biographyRepository = biographyRepository;
        this.singerCrudService = singerCrudService;
    }

    @Override
    public Biography create(Biography entity) {
        Optional<Singer> read = singerCrudService.read(entity.getSinger().getId());

        if(!(read.isPresent())) {
            throw new EntityNotFoundException("This singer not exists");
        }

        Singer singer = read.get();

        entity.setSinger(singer);

        return biographyRepository.save(entity);
    }

    @Override
    public Optional<Biography> read(String id) {

        return biographyRepository.findById(id);
    }

    @Override
    public List<Biography> read() {

        return biographyRepository.findAll();
    }

    @Override
    public Biography update(Biography entity, String id) {
        Optional<Biography> oldRecord = read(id);

        if (oldRecord.isEmpty()) {
            return create(entity);
        }

        Biography oldRecordActual = oldRecord.get();

        Singer oldSinger = oldRecordActual.getSinger();
        String oldId = oldRecordActual.getId();

        entity.setId(oldId);
        entity.setSinger(oldSinger);

        return biographyRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        biographyRepository.deleteById(id);
    }
}
