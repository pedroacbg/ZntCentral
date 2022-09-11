package com.pedroacbg.api.zntcentral.respositories;

import com.pedroacbg.api.zntcentral.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
