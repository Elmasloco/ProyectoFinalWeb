/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.*;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author samue
 */
public class PersonaDAO {
//?useSSL=false
    Connection conectar;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3307/proyectofinaldb", "root", "");
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la bases datos");
            System.out.println("Error: " + e.getMessage());
        }
        return conectar;
    }

    public void cerrarConexion() throws SQLException {
        conectar.close();
        System.out.println("Conexion cerrada");
    }

    public void insertar(Persona persona) {
        String sql = "INSERT INTO proyectofinaldb.registros(nombre,apellido,edad,genero,documento,tipoDoc) VALUES (?,?,?,?,?,?)";
        try {
            conexion();

            if (conectar == null) {
                throw new SQLException("missing connection");
            }

            ps = conectar.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setInt(3, persona.getEdad());
            ps.setString(4, persona.getGenero());
            ps.setInt(5, persona.getIdentificacion());
            ps.setString(6, persona.getTipoIdentificacion());
            int resultId = ps.executeUpdate();
            System.out.println("Se inserto el ID: " + resultId);
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al insertar en la tabla");
            System.out.println("Error:" + e.getMessage());
        }
    }

    public ArrayList<HashMap> listar() {
        String sql = "SELECT * FROM registros";
        ArrayList<HashMap> resultado = new ArrayList<>();
        try {
            conexion();
            if (conectar == null) {
                throw new SQLException("missing connection");
            }
            st = conectar.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                HashMap mapa = new HashMap();
                mapa.put("id", rs.getInt("id"));
                mapa.put("nombre", rs.getString("nombre"));
                mapa.put("apellido", rs.getString("apellido"));
                mapa.put("edad", rs.getInt("edad"));
                mapa.put("genero", rs.getString("genero"));
                mapa.put("documento", rs.getInt("documento"));
                mapa.put("tipoDoc", rs.getString("tipoDoc"));
                resultado.add(mapa);
            }
            cerrarConexion();
        } catch (SQLException e) {
        }
        return resultado;
    }

}
