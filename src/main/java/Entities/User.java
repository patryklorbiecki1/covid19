package Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column
    private String pesel;
    @Column
    private String lastName;
    @Column
    private int quarantine;
    @Column
    private int recovered;
    @Column
    private int infected;
    @Column
    private int dead;
    @Column
    private int admin;
    @Column
    private String name;
    @Column
    private String region;
    @Column
    private String city;
    @Column
    private String district;
    @Column
    private String community;
    @Column
    private String postcode;
    @Column
    private String street;
    @Column
    private String houseNr;

}