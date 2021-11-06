package com.brunos.texnologialogismikoudemo.Service;

import java.util.List;
import java.util.Optional;

//ENTITY_TYPE = BIOGRAPHY
public interface CrudService<ENTITY_TYPE> {

    ENTITY_TYPE create(ENTITY_TYPE entity);

    Optional <ENTITY_TYPE> read(String id);

    List<ENTITY_TYPE> read();

    ENTITY_TYPE update(ENTITY_TYPE entity, String id);

    void delete(String id);
}
