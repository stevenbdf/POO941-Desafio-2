package sv.edu.udb.catalogos;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;

public class Director {
    private Conexion conexion;
    private final String NOMBRE_TABLA = "directores";

    public Director() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultSet obtenerDirectores() {
        this.conexion.setRs("SELECT codigo, nombre FROM " + this.NOMBRE_TABLA);

        return this.conexion.getRs();
    }

    public ResultSet obtenerDirector(int codigo) {
        this.conexion.setRs("SELECT codigo, nombre FROM " + this.NOMBRE_TABLA + " WHERE codigo = " + codigo);

        return this.conexion.getRs();
    }

    public Boolean crearDirector(String nombre) {
        try {
            int result = this.conexion.executeSQL("INSERT INTO " + NOMBRE_TABLA + "(nombre) VALUES ('" + nombre + "')");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean modificarDirector(int codigo, String nombre) {
        try {
            int result = this.conexion.executeSQL("UPDATE " + NOMBRE_TABLA + " SET nombre = '" + nombre + "' WHERE codigo = " + codigo);

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean eliminarDirector(int codigo) {
        try {
            int result = this.conexion.executeSQL("DELETE FROM " + NOMBRE_TABLA + " WHERE codigo = " + codigo);

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }
}
