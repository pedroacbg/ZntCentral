package com.pedroacbg.api.zntcentral.respositories;

import com.pedroacbg.api.zntcentral.models.Post;
import com.pedroacbg.api.zntcentral.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUser(User user, Pageable pageable);

}
