package com.proyecto.backend.Transferencias;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "transferencias")
public class Transferencias implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fecha_realizacion")
    private Date fechaRealizacion= new Date();
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    @Column(name = "cuenta_traslado")
    private int cuentaTraslado;
    @Column(name = "transferencia")
    private double transferencia;
    @Column(name = "saldo")
    private double saldo;
    @Column(name = "num_documento")
    private int numDocumento;
    
    public Transferencias(){}

    public Transferencias(int id, String tipoMovimiento, int cuentaTraslado, double transferencia, double saldo,
            int numDocumento) {
        this.id = id;
        this.tipoMovimiento = tipoMovimiento;
        this.cuentaTraslado = cuentaTraslado;
        this.transferencia = transferencia;
        this.saldo = saldo;
        this.numDocumento = numDocumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCuentaTraslado() {
        return cuentaTraslado;
    }

    public void setCuentaTraslado(int cuentaTraslado) {
        this.cuentaTraslado = cuentaTraslado;
    }

    public double getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    
    
}
