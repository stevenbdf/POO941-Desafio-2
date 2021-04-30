package sv.edu.udb.catalogos;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;

public class Genero {

    private Conexion conexion;
    private final String NOMBRE_TABLA = "generos";

    public Genero() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultSet obtenerGeneros() {
        this.conexion.setRs("SELECT codigo, nombre, descripcion FROM " + this.NOMBRE_TABLA);

        return this.conexion.getRs();
    }

    public ResultSet obtenerGenero(int codigo) {
        this.conexion.setRs("SELECT codigo, nombre, descripcion FROM " + this.NOMBRE_TABLA + " WHERE codigo = " + codigo);

        return this.conexion.getRs();
    }

    public Boolean crearGenero(String nombre, String descripcion) {
        try {
            int result = this.conexion.executeSQL("INSERT INTO " + NOMBRE_TABLA + "(nombre, descripcion) VALUES ('" + nombre + "', '" + descripcion + "')");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean modificarGenero(int codigo, String nombre, String descripcion) {
        try {
            int result = this.conexion.executeSQL("UPDATE " + NOMBRE_TABLA
                    + " SET nombre = '" + nombre + "', descripcion = '" + descripcion + "' WHERE codigo = " + codigo);

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean eliminarGenero(int codigo) {
        try {
            int result = this.conexion.executeSQL("DELETE FROM " + NOMBRE_TABLA + " WHERE codigo = " + codigo);

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }
}
