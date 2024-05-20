package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="grounds", uniqueConstraints = {
        @UniqueConstraint(name = "unique_ground_name",
                columnNames = {"ground_name"})
})
@Setter
@Getter
public class Futsal {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "information_seq_gen")
    @SequenceGenerator(name = "information_seq_gen",sequenceName = "information_seq",
            allocationSize = 1,initialValue = 1)
    @Id
    private Integer id;

    @Column(name="futsal_name",length = 255)
    private String futsal_name;

    @Column(name="address",length = 255)
    private String address;

    @Column(name="phone_number",length = 255)
    private String phoneNumber;

    @OneToMany(mappedBy = "grounds" ,cascade = CascadeType.ALL)
    private List<Book>books;

}
