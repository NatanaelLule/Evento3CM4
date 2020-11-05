/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.Evento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class EventoDAO {

    private static final String SQL_INSERT = "insert into Evento(nombreEvento,sede,fechaInicio,fechaTermino)"
            + " values (?,?,?,?)";
    private static final String SQL_UPDATE = "update Evento set nombreEvento= ?, sede = ?, fechaInicio = ?, fechaTermino = ? "
            + " where idEvento = ?";
    private static final String SQL_DELETE = "delete from Evento where idEvento = ?";
    private static final String SQL_SELECT = "select * from Evento where idEvento = ?";
    private static final String SQL_SELECT_ALL = "select * from Evento";

    private Connection con = null;

    private void obtenerConexion() throws SQLException {
        String usr = "root";
        String pwd = "Enock!23";
        String driver = "com.mysql.cj.jdbc.Driver";
        //String driver = "con.mysql.jdbc.Driver"; Comando con Driver descargado
        //String url = "jdbc:mysql://locoalhost:3306/3cm4";
        String url = "jdbc:mysql://localhost:3306/3cm4?serverTimezone=America/Mexico_City&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void create(Evento e) throws SQLException {
//        obtenerConexion();
//        PreparedStatement ps = null;
//        try {
//            ps = conexion.prepareStatement(SQL_INSERT);
//            ps.setString(1, e.getNombreEvento());
//            ps.setString(2, e.getSede());
//            ps.setDouble(3, e.getDuracion());
//            ps.setDate(4, e.getFechaInicio());
//            ps.setDate(5, e.getFechaTermino());
//            ps.executeUpdate();
//        } finally {
//            if (ps != null) {
//                ps.close();
//            }
//            if (conexion != null) {
//                conexion.close();
//            }
//        }
//    }
//
//    public void update(Evento e) throws SQLException {
//        obtenerConexion();
//        PreparedStatement ps = null;
//        try {
//            ps = conexion.prepareStatement(SQL_UPDATE);
//            ps.setString(1, e.getNombreEvento());
//            ps.setString(2, e.getSede());
//            ps.setDouble(3, e.getDuracion());
//            ps.setDate(4, e.getFechaInicio());
//            ps.setDate(5, e.getFechaTermino());
//            ps.setInt(6, e.getIdEvento());
//            ps.executeUpdate();
//        } finally {
//            if (ps != null) {
//                ps.close();
//            }
//            if (conexion != null) {
//                conexion.close();
//            }
//        }
//    }
//
//    public void delete(Evento e) throws SQLException {
//        obtenerConexion();
//        PreparedStatement ps = null;
//        try {
//            ps = conexion.prepareStatement(SQL_DELETE);
//            ps.setInt(1, e.getIdEvento());
//            ps.executeUpdate();
//        } finally {
//            if (ps != null) {
//                ps.close();
//            }
//            if (conexion != null) {
//                conexion.close();
//            }
//        }
//    }
//
//    public List readAll() throws SQLException {
//        obtenerConexion();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = conexion.prepareStatement(SQL_SELECT_ALL);
//            rs = ps.executeQuery();
//            List resultados = obtenerResultados(rs);
//            if (resultados.size() > 0) {
//                return resultados;
//            } else {
//                return null;
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ps != null) {
//                ps.close();
//            }
//            if (conexion != null) {
//                conexion.close();
//            }
//        }
//    }
//
//    public Evento read(Evento e) throws SQLException {
//        obtenerConexion();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = conexion.prepareStatement(SQL_SELECT);
//            ps.setInt(1, e.getIdEvento());
//            rs = ps.executeQuery();
//            List resultados = obtenerResultados(rs);
//            if(resultados.size()>0){
//                return (Evento) resultados.get(0);
//            }else{
//                return null;
//            }
//        } finally{
//            if (rs != null) {
//                rs.close();
//            }
//            if (ps != null) {
//                ps.close();
//            }
//            if (conexion != null) {
//                conexion.close();
//            }      
//        }
//    }
//    public static void main(String[] args) throws SQLException {
//        Evento e = new Evento();
//        //e.setIdEvento(1);
//        e.setNombreEvento("Fornicación");
//        e.setSede("Baños ESCOM");
//        e.setDuracion(10.0);
//        e.setFechaInicio(Date.valueOf("2020-10-07"));
//        e.setFechaTermino(Date.valueOf("2020-10-27"));
//
//        EventoDAO dao = new EventoDAO();
//        try {
//            dao.create(e);
//        } catch (SQLException ex) {
//            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //dao.create(e);
//        //dao.update(e);
//        //dao.delete(e);
//    }
//
//    private List obtenerResultados(ResultSet rs) throws SQLException {
//        List resultados = new ArrayList();
//        while (rs.next()) {
//            Evento e = new Evento();
//            e.setIdEvento(rs.getInt("idEvento"));
//            e.setNombreEvento(rs.getString("nombreEvento"));
//            e.setSede(rs.getString("sede"));
//            e.setDuracion(rs.getDouble("duracion"));
//            e.setFechaInicio(rs.getDate("fechaInicio"));
//            e.setFechaTermino(rs.getDate("fechaTermino"));
//            resultados.add(e);
//        }
//        return resultados;
//    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void create(Evento e) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, e.getNombreEvento());
            ps.setString(2, e.getSede());
            ps.setDate(3, e.getFechaInicio());
            ps.setDate(4, e.getFechaTermino());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void update(Evento e) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, e.getNombreEvento());
            ps.setString(2, e.getSede());
            ps.setDate(3, e.getFechaInicio());
            ps.setDate(4, e.getFechaTermino());
            ps.setInt(5, e.getIdEvento());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void delete(Evento e) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, e.getIdEvento());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List readAll() throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public Evento read(Evento e) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, e.getIdEvento());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (Evento) resultados.get(0);
            } else {
                return null;
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            Evento e = new Evento();
            e.setIdEvento(rs.getInt("idEvento"));
            e.setNombreEvento(rs.getString("nombreEvento"));
            e.setSede(rs.getString("sede"));
            e.setFechaInicio(rs.getDate("fechaInicio"));
            e.setFechaTermino(rs.getDate("fechaTermino"));
            resultados.add(e);
        }
        return resultados;
    }

    public static void main(String[] args) {
        Evento e = new Evento();
        e.setNombreEvento("Fornicacion55");
        e.setSede("Baños ESCOM");
        e.setFechaInicio(Date.valueOf("2020-09-25"));
        e.setFechaTermino(Date.valueOf("2020-10-06"));

        EventoDAO dao = new EventoDAO();
        try {
            dao.create(e);
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
