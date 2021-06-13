package ingjulianvega.ximic.msscasuduration.services;

import ingjulianvega.ximic.msscasuduration.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasuduration.domain.DurationEntity;
import ingjulianvega.ximic.msscasuduration.domain.repositories.DurationRepository;
import ingjulianvega.ximic.msscasuduration.exception.DurationException;
import ingjulianvega.ximic.msscasuduration.web.Mappers.DurationMapper;
import ingjulianvega.ximic.msscasuduration.web.model.Duration;
import ingjulianvega.ximic.msscasuduration.web.model.DurationDto;
import ingjulianvega.ximic.msscasuduration.web.model.DurationList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class DurationServiceImpl implements DurationService {

    private final DurationRepository durationRepository;
    private final DurationMapper durationMapper;

    @Cacheable(cacheNames = "durationListCache", condition = "#usingCache == false")
    @Override
    public DurationList get(Boolean usingCache) {
        log.debug("get()...");
        return DurationList
                .builder()
                .bodyPartList(durationMapper.administrationMethodEntityListToAdministrationMethodDtoList(durationRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "durationCache")
    @Override
    public DurationDto getById(UUID id) {
        log.debug("getById()...");
        return durationMapper.administrationMethodEntityToAdministrationMethodDto(
                durationRepository.findById(id)
                        .orElseThrow(() -> new DurationException(ErrorCodeMessages.DURATION_NOT_FOUND, "")));
    }

    @Override
    public void create(Duration duration) {
        log.debug("create()...");
        durationMapper.administrationMethodEntityToAdministrationMethodDto(
                durationRepository.save(
                        durationMapper.administrationMethodDtoToAdministrationMethodEntity(
                                DurationDto
                                        .builder()
                                        .name(duration.getName())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Duration duration) {
        log.debug("updateById...");
        DurationEntity evidenceEntity = durationRepository.findById(id)
                .orElseThrow(() -> new DurationException(ErrorCodeMessages.DURATION_NOT_FOUND, ""));

        evidenceEntity.setName(duration.getName());

        durationRepository.save(evidenceEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        durationRepository.deleteById(id);
    }
}
