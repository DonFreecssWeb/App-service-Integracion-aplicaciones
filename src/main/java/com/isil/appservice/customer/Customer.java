package com.isil.appservice.customer;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data //para getter and setter
@Entity(name = "Customer") //para que sepa que representa una tabla en la base de datso
//si se borra el table por defecto toma el nombre de la clase o el nombre de la entity
//si tengo 5 entidades, me amarra 5 tablas
@Table(name = "tbl_Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;

    @Column(name="email",length=50,nullable = false,unique = true)
    private String email;

    private String address;

    private String documentId;

    private Date createdAt;

    @PostPersist //se dispara automaticamente al registrar un neuvo recurso en la base de datos
    public void postPersist(){
        this.createdAt = new Date();
    }

}
