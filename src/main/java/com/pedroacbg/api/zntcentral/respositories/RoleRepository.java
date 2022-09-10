package com.pedroacbg.api.zntcentral.respositories;

import com.pedroacbg.api.zntcentral.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
