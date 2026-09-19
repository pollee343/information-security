package org.example.lab1_code.controllers;

import jakarta.validation.Valid;
import org.example.lab1_code.dto.CreateDataRequest;
import org.example.lab1_code.entities.DataItem;
import org.example.lab1_code.repositories.DataItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataItemRepository dataRepository;

    public DataController(DataItemRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping
    public List<Map<String, Object>> getData() {
        return dataRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createData(@Valid @RequestBody CreateDataRequest request) {
        DataItem item = new DataItem(request.getContent());
        DataItem savedItem = dataRepository.save(item);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(savedItem));
    }

    private Map<String, Object> toResponse(DataItem item) {
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("id", item.getId());
        response.put("content", HtmlUtils.htmlEscape(item.getContent()));

        return response;
    }
}