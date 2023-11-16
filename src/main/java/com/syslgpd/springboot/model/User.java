package com.syslgpd.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    int id;
    String nome;
    int idade;
    String cargo;


    public int getId(){return this.id;}

}
