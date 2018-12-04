package edu.onimeboyz.palevobotapi.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends Base{

    private String content;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "palevo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Palevo palevo;



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Palevo getPalevo() {
        return palevo;
    }

    public void setPalevo(Palevo palevo) {
        this.palevo = palevo;
    }
}
