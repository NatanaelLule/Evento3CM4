/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class Evento implements Serializable{
    private int idEvento;
    private String nombreEvento;
    private String sede;
//  private Double duracion;
    private Date fechaInicio;
    private Date fechaTermino;

    public Evento(){
        
    }

    /**
     * @return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return the nombreEvento
     */
    public String getNombreEvento() {
        return nombreEvento;
    }

    /**
     * @param nombreEvento the nombreEvento to set
     */
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    /**
     * @return the sede
     */
    public String getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(String sede) {
        this.sede = sede;
    }
    
        /**
     * @return the duracion
     */
//    public Double getDuracion() {
//        return duracion;
//    }

    /**
     * @param duracion the duracion to set
     */
//    public void setDuracion(Double duracion) {
//        this.duracion = duracion;
//    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaTermino
     */
    public Date getFechaTermino() {
        return fechaTermino;
    }

    /**
     * @param fechaTermino the fechaTermino to set
     */
    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evento(idEvento=").append(getIdEvento()).append("\n");
        sb.append(", nombreEvento=").append(nombreEvento).append("\n");
        sb.append(", sede=").append(sede).append("\n");
//        sb.append(", duracion=").append(sede).append("\n");
        sb.append(", fechaInicio=").append(fechaInicio).append("\n");
        sb.append(", fechaTermino=").append(fechaTermino).append("\n");
        sb.append("}");
        return sb.toString();
    }
    
    public static void main(String[] args){
        Evento e = new Evento();
        e.setIdEvento(1);
        e.setNombreEvento("Recurse2");
        e.setSede("Salon 1115 ESCOM");
//        e.setDuracion(10.0);
        e.setFechaInicio(Date.valueOf("2020-10-07"));
        e.setFechaTermino(Date.valueOf("2020-10-17"));
        System.out.println(e);
    
        Connection conexion=null;
        String usr = "root";    
        String pwd = "Enock!23";
        String driver = "com.mysql.cj.jdbc.Driver";
        //String driver = "con.mysql.cj.jdbc.Driver";
        //String url = "jdbc:mysql://locoalhost:3306/3cm4";
        String url = "jdbc:mysql://localhost:3306/3cm4?serverTimezone=America/Mexico_City&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usr, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Evento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement ps = null;
        String SQL_INSERT = "Insert into Evento(nombreEvento, sede, fechaInicio, fechaTermino)"
                + "values(?,?,?,?)";
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, e.getNombreEvento());
            ps.setString(2, e.getSede());
//            ps.setDouble(3, e.getDuracion());
            ps.setDate(3, e.getFechaInicio());
            ps.setDate(4, e.getFechaTermino());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Evento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public String getFechaFin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



