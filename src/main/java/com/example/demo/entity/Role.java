package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles", uniqueConstraints = {
        @UniqueConstraint(name = "unique_role",
                columnNames = {"role"})
})
@Setter
@Getter
public class Role {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "information_seq_gen")
    @SequenceGenerator(name = "information_seq_gen",sequenceName = "information_seq",
            allocationSize = 1,initialValue = 1)
    @Id
    private Integer id;

    @Column(name="role",length = 255)
    private String role;
}