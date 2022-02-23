package com.livevox.phonebook.infraestructure.persistence.repository;

import com.livevox.phonebook.domain.User;
import com.livevox.phonebook.domain.UserRepository;
import com.livevox.phonebook.infraestructure.persistence.entity.QUserEntity;
import com.livevox.phonebook.infraestructure.persistence.entity.UserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringUserRepository springUserRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        var userEntity = UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .build();
        springUserRepository.save(userEntity);
    }

    @Override
    public List<User> findAll() {
        return springUserRepository.findAll().stream().map(userEntity -> User.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .phone(userEntity.getPhone())
                .build()).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<User> findBySearchValue(String value) {
        var queryFactory = new JPAQueryFactory(em);
        var user = QUserEntity.userEntity;
        return queryFactory.selectFrom(user)
                .where(user.firstName.containsIgnoreCase(value).or(user.lastName.containsIgnoreCase(value).or(user.phone.containsIgnoreCase(value))))
                .fetch()
                .stream()
                .map(userEntity -> User.builder()
                        .firstName(userEntity.getFirstName())
                        .lastName(userEntity.getLastName())
                        .phone(userEntity.getPhone())
                        .build()).collect(Collectors.toUnmodifiableList());
    }
}
