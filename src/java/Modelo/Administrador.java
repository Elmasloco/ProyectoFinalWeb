/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samue
 */
public class Administrador extends Persona{
    private String cargo;
    private String contraseña;

    public Administrador() {
    }

    public Administrador(String nombre, String apellido, String cargo, String contraseña){
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.cargo = cargo;
        this.contraseña = contraseña;
    }
    
    public Administrador(HttpServletRequest request) throws SQLException {
        super(request);
    }

    public Administrador(ResultSet resultSet) throws SQLException {
        super(resultSet);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
