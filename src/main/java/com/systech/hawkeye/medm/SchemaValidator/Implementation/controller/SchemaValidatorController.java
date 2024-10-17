package com.systech.hawkeye.medm.SchemaValidator.Implementation.controller;

import com.systech.hawkeye.medm.SchemaValidator.Implementation.model.SchemaValidatorModel;
import com.systech.hawkeye.medm.SchemaValidator.Implementation.services.SchemaValidatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class SchemaValidatorController {

    @Autowired
    private SchemaValidatorService schemaValidatorService;

    @GetMapping
    public ResponseEntity<List<SchemaValidatorModel>> getAllItems() {
        List<SchemaValidatorModel> items = schemaValidatorService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchemaValidatorModel> getItemById(@PathVariable Long id) {
        Optional<SchemaValidatorModel> item = schemaValidatorService.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SchemaValidatorModel> createItem(@Valid @RequestBody SchemaValidatorModel item) {
        SchemaValidatorModel createdItem = schemaValidatorService.save(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchemaValidatorModel> updateItem(@PathVariable Long id, @Valid @RequestBody SchemaValidatorModel item) {
        Optional<SchemaValidatorModel> existingItem = schemaValidatorService.findById(id);
        if (existingItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        item.setId(id); // Ensure setId method exists in SchemaValidatorModel
        SchemaValidatorModel updatedItem = schemaValidatorService.save(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        Optional<SchemaValidatorModel> existingItem = schemaValidatorService.findById(id);
        if (existingItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        schemaValidatorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
