package com.pedroacbg.api.zntcentral.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
