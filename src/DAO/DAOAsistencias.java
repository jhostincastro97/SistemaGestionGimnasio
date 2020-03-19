/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.ModeloAsistencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phant
 */
public class DAOAsistencias implements IDAO{

    @Override
    public boolean agregar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloAsistencia ast = (ModeloAsistencia) obj;
        String query = "INSERT INTO asistencia(fecha, idcliente) VALUES(\'" + ast.getFecha().toString() + "\',\'" + ast.getCte().getId()+"\');";

        try {
            Statement s = conn.createStatement();
            s.execute(query);
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean eliminar(Object obj) {
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();
        ModeloAsistencia aa = (ModeloAsistencia) obj;

        String query = "DELETE FROM asistencia WHERE idcliente=" + aa.getCte().getId() + ";";

        try {
            Statement s = conn.createStatement();
            s.execute(query);
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean actualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscar(Object obj) {
        List lista = getAll();

        for (Object mem : lista) {
            if (mem.toString().equals(obj.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean existeAsistenciaIdCliente(int id) {
        List lista = getAll();

        for (Object lis : lista) {
            ModeloAsistencia aaa = (ModeloAsistencia) lis;
            if (aaa.getCte().getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Object get(Object obj) {
        int id = Integer.parseInt(obj.toString());
        if (existeAsistenciaIdCliente(id)) {
            List lista = getAll();

            for (Object ob : lista) {
                ModeloAsistencia aa = (ModeloAsistencia) ob;
                if (aa.getCte().getId() == id) {
                    System.out.println("Se encontró la asistencia");
                    return aa;
                }
            }
        }
        System.out.println("No hay una asistencia con ese id de cliente");

        return null;
    }

    @Override
    public List getAll() {
        List asistencias = new ArrayList<>();
        ConexionMySQL c = new ConexionMySQL();
        Connection conn = c.connect();

        try {
            Statement s = conn.createStatement();
            String query = "SELECT * FROM asistencia";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                ModeloAsistencia cte = new ModeloAsistencia(Integer.parseInt(rs.getString("idasistencia")), rs.getDate("fecha"), Integer.parseInt(rs.getString("idcliente")));
                asistencias.add(cte);
            }
            conn.close();
        } catch (SQLException | NumberFormatException ex) {
            System.out.println(ex);
        }
        return asistencias;
    }
    
}
