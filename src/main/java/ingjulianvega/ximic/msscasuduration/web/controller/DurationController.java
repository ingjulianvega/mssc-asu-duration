package ingjulianvega.ximic.msscasuduration.web.controller;


import ingjulianvega.ximic.msscasuduration.services.DurationService;
import ingjulianvega.ximic.msscasuduration.web.model.Duration;
import ingjulianvega.ximic.msscasuduration.web.model.DurationDto;
import ingjulianvega.ximic.msscasuduration.web.model.DurationList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DurationController implements DurationI {

    private final DurationService durationService;

    @Override
    public ResponseEntity<DurationList> get(Boolean usingCache) {
        return new ResponseEntity<>(durationService.get(usingCache), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DurationDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(durationService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Duration duration) {
        durationService.create(duration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Duration duration) {
        durationService.updateById(id, duration);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        durationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
