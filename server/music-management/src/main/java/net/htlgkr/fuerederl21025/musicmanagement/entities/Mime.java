package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Mime {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    private Track track;
}
