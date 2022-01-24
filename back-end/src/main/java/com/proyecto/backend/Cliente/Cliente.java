package com.proyecto.backend.Cliente;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "num_documento")
    private int numDocumento;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_inicio")
    private Date fechaInicio = new Date();
    @Column(name = "contraseña")
    private String contra;
    public Cliente(){}
    public Cliente(int id, String nombre, String apellido, String tipoDocumento, int numDocumento, Date fechaNacimiento,
            String email, String contra) {
        this.id= id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.contra =contra;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public int getNumDocumento() {
        return numDocumento;
    }
    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
    

}
