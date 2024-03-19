package io.test_group.my_app_test.repos;

import io.test_group.my_app_test.domain.KeyStorage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyStorageRepository extends JpaRepository<KeyStorage, Long> {
}
