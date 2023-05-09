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
public class Usuario extends Persona{

    public Usuario() {
    }

    public Usuario(HttpServletRequest request) throws SQLException {
        super(request);
    }

    public Usuario(ResultSet resultSet) throws SQLException {
        super(resultSet);
    }
    
}
