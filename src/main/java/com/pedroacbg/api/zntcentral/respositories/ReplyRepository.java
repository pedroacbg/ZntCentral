package com.pedroacbg.api.zntcentral.respositories;

import com.pedroacbg.api.zntcentral.models.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
