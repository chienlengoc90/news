package vn.chienlengoc.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.chienlengoc.core.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
