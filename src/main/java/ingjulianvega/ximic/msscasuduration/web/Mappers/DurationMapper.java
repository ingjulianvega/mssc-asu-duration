package ingjulianvega.ximic.msscasuduration.web.Mappers;


import ingjulianvega.ximic.msscasuduration.domain.DurationEntity;
import ingjulianvega.ximic.msscasuduration.web.model.DurationDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface DurationMapper {
    DurationDto administrationMethodEntityToAdministrationMethodDto(DurationEntity administrationMethodEntity);

    DurationEntity administrationMethodDtoToAdministrationMethodEntity(DurationDto administrationMethodDto);

    ArrayList<DurationDto> administrationMethodEntityListToAdministrationMethodDtoList(List<DurationEntity> administrationMethodEntityList);
}
