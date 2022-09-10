package com.pedroacbg.api.zntcentral.respositories;

import com.pedroacbg.api.zntcentral.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
