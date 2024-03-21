package io.test_group.my_app_test.controller;

import io.test_group.my_app_test.domain.KeyStorage;
import io.test_group.my_app_test.service.KeyStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @GetMapping("/{username}")
    public ResponseEntity<Map<String, String>> getKeyStorage(@PathVariable String username) {
        KeyStorage keyStorage = keyStorageService.getKeyStorage(username);
        Map<String, String> response = new HashMap<>();
        response.put("username", keyStorage.getUsername());
        response.put("encryptionKey", keyStorage.getEncryptionKey());
        return ResponseEntity.ok(response);
    }


    // Other API endpoints can be added here
}