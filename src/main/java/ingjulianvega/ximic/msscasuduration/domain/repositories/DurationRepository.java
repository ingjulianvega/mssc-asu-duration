package ingjulianvega.ximic.msscasuduration.domain.repositories;

import ingjulianvega.ximic.msscasuduration.domain.DurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface DurationRepository extends JpaRepository<DurationEntity, UUID>, JpaSpecificationExecutor<DurationEntity> {
}
