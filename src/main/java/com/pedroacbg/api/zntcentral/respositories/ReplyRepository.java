package com.pedroacbg.api.zntcentral.respositories;

import com.pedroacbg.api.zntcentral.models.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Reply obj WHERE obj.post.id = :postId ORDER BY obj.id")
    List<Reply> findReplies(@Param("postId") Long post_id);
}
