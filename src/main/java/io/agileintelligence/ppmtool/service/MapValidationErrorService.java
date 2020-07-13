package io.agileintelligence.ppmtool.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> mapValidationService(BindingResult result) {
        if (result.hasErrors()) {
            var errors = new HashMap<String, String>();

            result.getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
