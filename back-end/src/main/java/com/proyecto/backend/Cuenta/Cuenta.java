package com.proyecto.backend.Cuenta;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "num_documento")
    private int numDocumento;
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Column(name = "numero_cuenta")
    private int numCuenta;
    @Column(name = "estado")
    private String estado;
    @Column(name = "saldo")
    private double saldo;
    @Column(name = "fecha_apertura")
    private Date fechaApertura = new Date();
    public Cuenta(){}

    

    public Cuenta(int id, int numDocumento, String tipoCuenta, int numCuenta, String estado, double saldo,
            Date fechaApertura) {
        this.id = id;
        this.numDocumento = numDocumento;
        this.tipoCuenta = tipoCuenta;
        if(numCuenta != 0){ this.numCuenta = numCuenta;}
        else{this.numCuenta= (int) (Math.random() * 99999 ) + 10000;}
        this.estado = estado;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    

}
