package net.myplayplanet.jpatest.repository;

import net.myplayplanet.jpatest.model.UserTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserTestEntityRepository extends JpaRepository<UserTestEntity, String>, JpaSpecificationExecutor<UserTestEntity> {

}