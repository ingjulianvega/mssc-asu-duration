package ingjulianvega.ximic.msscasuduration.bootstrap;

import ingjulianvega.ximic.msscasuduration.domain.DurationEntity;
import ingjulianvega.ximic.msscasuduration.domain.repositories.DurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class DurationLoader implements CommandLineRunner {

    private final DurationRepository durationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (durationRepository.count() == 0) {
            loadAdministrationMethodObjects();
        }
    }

    private void loadAdministrationMethodObjects() {
        durationRepository.saveAll(Arrays.asList(
                DurationEntity.builder().name("Dia(s)").build(),
                DurationEntity.builder().name("Mes(es)").build(),
                DurationEntity.builder().name("Año(s)").build()
        ));
    }
}