package vn.chienlengoc.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.chienlengoc.core.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserName(String name);
}
