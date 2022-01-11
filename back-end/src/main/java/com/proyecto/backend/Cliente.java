package com.proyecto.backend;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    private Date fecha_inicio = new Date();
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "tipo_documento")
    private String tipo_documento;
    @Column(name = "num_documento")
    private int num_documento;
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    @Column(name = "email")
    private String email;
    //@Column(name = "fecha_inicio")
    java.sql.Date sqlfecha_inicio = new java.sql.Date(fecha_inicio.getTime());
    public Cliente(){}
    
    
    public Cliente(int id, String nombre, String apellido, String tipo_documento, int num_documento,
            Date fecha_nacimiento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;   
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(int num_documento) {
        this.num_documento = num_documento;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
