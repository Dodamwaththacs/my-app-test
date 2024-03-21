package io.test_group.my_app_test.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;

@Getter
@Setter
@Entity
@Table(name = "Key_storage")
public class KeyStorage {

    @Id
    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String encryptionKey;

//    @CreatedDate
//    @Column(nullable = true, updatable = false)
//    private OffsetDateTime dateCreated;

//    @LastModifiedDate
//    @Column(nullable = true)
//    private OffsetDateTime lastUpdated;

    // getters and setters
}