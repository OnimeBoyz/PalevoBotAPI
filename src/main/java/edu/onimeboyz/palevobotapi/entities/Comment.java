package edu.onimeboyz.palevobotapi.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Comment {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "palevo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Palevo palevo;
}
