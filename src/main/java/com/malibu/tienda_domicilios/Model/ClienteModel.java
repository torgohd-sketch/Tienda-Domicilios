package com.malibu.tienda_domicilios.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String Conjunto;
    private String torre;
    private String apartamento;
    private String telefono;

    public ClienteModel() {
    }

    
    public ClienteModel(Long id, String nombre, String torre, String apartamento, String telefono, String Conjunto) {
        this.id = id;
        this.nombre = nombre;
        this.torre = torre;
        this.apartamento = apartamento;
        this.telefono = telefono;
        this.Conjunto = Conjunto;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

       public String getConjunto() {
        return Conjunto;
    }

    public void setConjunto(String Conjunto) {
        this.Conjunto = Conjunto;
    }

}