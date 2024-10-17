package com.systech.hawkeye.medm.SchemaValidator.Implementation.repositories;
import com.systech.hawkeye.medm.SchemaValidator.Implementation.model.SchemaValidatorModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SchemaValidatorRepository extends JpaRepository<SchemaValidatorModel, Long> {
}
