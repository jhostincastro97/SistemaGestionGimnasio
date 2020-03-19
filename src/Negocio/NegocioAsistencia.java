/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DAOAsistencias;
import DAO.DAOClientes;
import Modelos.ModeloAsistencia;
import java.util.ArrayList;

/**
 *
 * @author phant
 */
public class NegocioAsistencia {
    DAOAsistencias asis = new DAOAsistencias();
    DAOClientes ctes = new DAOClientes();
    public boolean addAsistencia(ModeloAsistencia asi) {
        return asis.agregar(asi);
    }
    
    public boolean delAsistencia(ModeloAsistencia asi) {
        return asis.eliminar(asi);
    }
    
    public ArrayList buscarAsistencias() {
        throw new UnsupportedOperationException("lol nope");
    }
}
