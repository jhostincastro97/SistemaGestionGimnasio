/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author phant
 */
public class ModeloAsistencia {
    ModeloCliente cte;
    Date fecha;
    int id;
    int idcliente;
    public ModeloAsistencia(int id,Date fecha,int idcliente) {
        this.cte = cte;
        this.fecha = fecha;
    }
    public ModeloCliente getCte() {
        return cte;
    }

    public void setCte(ModeloCliente cte) {
        this.cte = cte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ModeloAsistencia{" + "cte=" + cte + ", fecha=" + fecha + '}';
    }
    
    
}
