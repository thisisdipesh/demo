package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="book_information")

@Setter
@Getter
public class Book{


    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "information_seq_gen")
    @SequenceGenerator(name = "information_seq_gen",sequenceName = "information_seq",
            allocationSize = 1,initialValue = 1)

    @Id
    private Integer id;

    @Column(name="date",length = 255)
    private Integer date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ground_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name= "fk_ground_id"))
    private Futsal grounds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name= "fk_user_id"))
    private Futsal users;

}