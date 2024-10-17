package com.systech.hawkeye.medm.SchemaValidator.Implementation.services;

import org.everit.json.schema.ValidationException;
import com.systech.hawkeye.medm.SchemaValidator.Implementation.model.SchemaValidatorModel;
import com.systech.hawkeye.medm.SchemaValidator.Implementation.repositories.SchemaValidatorRepository;
import com.systech.hawkeye.medm.SchemaValidator.Implementation.schemas.JsonSchema;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchemaValidatorService {

    @Autowired
    private SchemaValidatorRepository itemRepository;

    public List<SchemaValidatorModel> findAll() {
        return itemRepository.findAll();
    }

    public Optional<SchemaValidatorModel> findById(Long id) {
        return itemRepository.findById(id);
    }

    public SchemaValidatorModel save(SchemaValidatorModel item) {
        // Validate the JSON against the schema before saving
        validateJson(item);
        return itemRepository.save(item);
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

    private void validateJson(SchemaValidatorModel item) {
        JSONObject jsonObject = new JSONObject(item); // Convert your model to JSON

        try {
            JsonSchema.validate(jsonObject); // Call the static validate method
        } catch (ValidationException e) {
            throw new IllegalArgumentException("JSON validation error: " + e.getMessage());
        }
    }
}
