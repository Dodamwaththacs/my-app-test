package io.test_group.my_app_test.controller;

import io.test_group.my_app_test.domain.KeyStorage;
import io.test_group.my_app_test.service.KeyStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/key-storage")
public class KeyStorageController {

    private final KeyStorageService keyStorageService;

    public KeyStorageController(KeyStorageService keyStorageService) {
        this.keyStorageService = keyStorageService;
    }

    @PostMapping
    public ResponseEntity<KeyStorage> createKeyStorage(@RequestBody KeyStorage keyStorage) {
        KeyStorage savedKeyStorage = keyStorageService.saveKeyStorage(keyStorage);
        return ResponseEntity.ok(savedKeyStorage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<KeyStorage> getKeyStorage(@PathVariable Long id) {
        KeyStorage keyStorage = keyStorageService.getKeyStorage(id);
        return ResponseEntity.ok(keyStorage);
    }

    // Other API endpoints can be added here
}