package com.livevox.phonebook.infraestructure.persistence.repository;

import com.livevox.phonebook.infraestructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringUserRepository extends JpaRepository<UserEntity, String> {
}
