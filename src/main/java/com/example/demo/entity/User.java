package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(name = "unique_user_name",
                columnNames = {"user_name"})
})
@Setter
@Getter
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "information_seq_gen")
    @SequenceGenerator(name = "information_seq_gen",sequenceName = "information_seq",allocationSize = 1,initialValue = 1)
    @Id
    private Integer id;

    @Column(name="user_name",length = 255)
    private String userName;

    @Column(name="address",length=255)
    private String address;

    @Column(name="contact",length = 255)
    private  Integer contactNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_role",
            foreignKey = @ForeignKey(name=
                    "FK_users_role_userID"),
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id")
    )
    private List<Role>roles;
}
