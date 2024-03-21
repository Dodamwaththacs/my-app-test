package io.test_group.my_app_test.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.test_group.my_app_test.domain.KeyStorage;

@Repository
public interface KeyStorageRepository extends JpaRepository<KeyStorage, String> {
    KeyStorage findByUsername(String username);
}