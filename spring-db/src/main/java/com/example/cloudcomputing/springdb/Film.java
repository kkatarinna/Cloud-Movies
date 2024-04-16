package com.example.cloudcomputing.springdb;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="sv_64_2021")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private Long year;
}
