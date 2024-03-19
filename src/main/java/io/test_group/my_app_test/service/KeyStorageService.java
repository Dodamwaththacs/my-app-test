package io.test_group.my_app_test.service;

import io.test_group.my_app_test.domain.KeyStorage;
import io.test_group.my_app_test.repos.KeyStorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KeyStorageService {

    private final KeyStorageRepository keyStorageRepository;

    public KeyStorageService(KeyStorageRepository keyStorageRepository) {
        this.keyStorageRepository = keyStorageRepository;
    }

    @Transactional
    public KeyStorage saveKeyStorage(KeyStorage keyStorage) {
        return keyStorageRepository.save(keyStorage);
    }

    public KeyStorage getKeyStorage(Long id) {
        return keyStorageRepository.findById(id).orElse(null);
    }

    // Other business logic methods can be added here
}
