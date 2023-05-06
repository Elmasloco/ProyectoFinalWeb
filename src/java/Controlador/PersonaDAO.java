/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.*;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.HashMap;

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
        if (ps != null) {
            ps.close();
        }
        if (st != null) {
            st.close();
        }
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
                Persona persona = new Persona(rs);
                resultado.add(persona.toHashMap());
            }
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al leer registros: " + e);
        }
        return resultado;
    }

    public HashMap buscar(int id) {
        String busca = "SELECT * FROM registros WHERE id=" + id;
        try {
            conexion();
            if (conectar == null) {
                throw new SQLException("missing connection");
            }
            st = conectar.createStatement();
            rs = st.executeQuery(busca);
            if (rs.next()) {
                Persona persona = new Persona(rs);
                return persona.toHashMap();
            }
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al buscar registro: " + e);
        }
        return null;
    }

    public void eliminar(int id) {
        String elimina = "DELETE FROM registros WHERE id=" + id;
        String busca = "SELECT * FROM registros WHERE id=" + id;
        try {
            conexion();
            if (conectar == null) {
                throw new SQLException("missing connection");
            }
            st = conectar.createStatement();
            rs = st.executeQuery(busca);
            if (rs.next()) {
                st.executeUpdate(elimina);
                System.out.println("Registro eliminado");
            } else {
                System.out.println("Registro no encontrado");
            }
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al eliminar registro: " + e);
        }
    }

    public void actualizar(Persona persona) {
        if (persona.getId() == -1) {
            return;
        }

        String sql = "UPDATE proyectofinaldb.registros "
                + "SET nombre=?,"
                + "apellido=?,"
                + "edad=?,"
                + "genero=?,"
                + "documento=?,"
                + "tipoDoc=?"
                + "WHERE id=" + persona.getId();
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
            System.out.println("Se modifico el ID: " + resultId);
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al actualizar registro: " + e);
        }
    }

}
