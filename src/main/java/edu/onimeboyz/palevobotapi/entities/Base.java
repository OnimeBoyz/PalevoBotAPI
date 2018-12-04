package edu.onimeboyz.palevobotapi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    public Base(){
        this.dateOfCreation = new Date(System.currentTimeMillis());
    }

    public Base(Date dateOfCreation){this.dateOfCreation = dateOfCreation; }
    public Base(int id){
        this();
        this.id = id;
    }

    public Base(int id, Date dateOfCreation) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }
}
