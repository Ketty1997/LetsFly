package com.letsfly.utils.conversionUtils;

import java.util.ArrayList;
import java.util.List;

import com.letsfly.utils.restUtils.DtoInterface;
import com.letsfly.utils.restUtils.EntityInterface;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter<Entity extends EntityInterface<Dto>,Dto extends DtoInterface<Entity>> {

    public List<Entity> dtoToEntity(List<Dto> list){
        List<Entity> nL = new ArrayList<>();
        for (Dto dto : list) {
            nL.add(dto.toEntity());
        }
        return nL;
    }

    public List<Dto> entityToDto(List<Entity> list){
        List<Dto> nL = new ArrayList<>();
        for (Entity entity : list) {
            nL.add(entity.toDto());
        }
        return nL;
    }

}
