package ingjulianvega.ximic.msscasuduration.services;


import ingjulianvega.ximic.msscasuduration.web.model.Duration;
import ingjulianvega.ximic.msscasuduration.web.model.DurationDto;
import ingjulianvega.ximic.msscasuduration.web.model.DurationList;

import java.util.UUID;

public interface DurationService {
    DurationList get();

    DurationDto getById(UUID id);

    void create(Duration duration);

    void updateById(UUID id, Duration duration);

    void deleteById(UUID id);
}
