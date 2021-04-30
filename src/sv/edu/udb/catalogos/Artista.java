package sv.edu.udb.catalogos;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;

public class Artista {
    private Conexion conexion;
    private final String NOMBRE_TABLA = "artistas";

    public Artista() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultSet obtenerArtistas() {
        this.conexion.setRs("SELECT codigo, nombre FROM " + this.NOMBRE_TABLA);

        return this.conexion.getRs();
    }

    public ResultSet obtenerArtista(int codigo) {
        this.conexion.setRs("SELECT codigo, nombre FROM " + this.NOMBRE_TABLA + " WHERE codigo = " + codigo);

        return this.conexion.getRs();
    }

    public Boolean crearArtista(String nombre) {
        try {
            int result = this.conexion.executeSQL("INSERT INTO " + NOMBRE_TABLA + "(nombre) VALUES ('" + nombre + "')");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean modificarArtista(int codigo, String nombre) {
        try {
            int result = this.conexion.executeSQL("UPDATE " + NOMBRE_TABLA + " SET nombre = '" + nombre + "' WHERE codigo = " + codigo);

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean eliminarArtista(int codigo) {
        try {
            int result = this.conexion.executeSQL("DELETE FROM " + NOMBRE_TABLA + " WHERE codigo = " + codigo);

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }
}
