package sv.edu.udb.material.audiovisual;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;
import sv.edu.udb.util.Util;

public class CD {

    private Conexion conexion;
    private Util util;
    private final String NOMBRE_TABLA = "cds";

    public CD() {
        try {
            this.conexion = new Conexion();
            this.util = new Util();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultSet obtenerCDs() {
        this.conexion.setRs("SELECT * FROM " + this.NOMBRE_TABLA);

        return this.conexion.getRs();
    }

    public ResultSet obtenerCD(String codigo) {
        this.conexion.setRs("SELECT * FROM " + this.NOMBRE_TABLA + " WHERE codigo = '" + codigo + "'");

        return this.conexion.getRs();
    }

    public Boolean crearCD(String titulo, int duracion, int numeroCanciones, int unidadesDisponibles, int codigoArtista, int codigoGenero) {
        try {
            String codigo = this.util.obtenerSiguienteCodigo(this.NOMBRE_TABLA);

            int result = this.conexion.executeSQL("INSERT INTO " + this.NOMBRE_TABLA
                    + "(codigo, titulo, duracion, numero_canciones, unidades_disponibles, codigo_artista, codigo_genero) "
                    + "VALUES ('" + codigo + "', '" + titulo + "', " + duracion + ", " + numeroCanciones + ", " + unidadesDisponibles + ", " + codigoArtista + ", " + codigoGenero + ")");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public Boolean modificarCD(String codigo, String titulo, int duracion, int numeroCanciones, int unidadesDisponibles, int codigoArtista, int codigoGenero) {
        try {
            int result = this.conexion.executeSQL("UPDATE " + NOMBRE_TABLA
                    + " SET titulo = '" + titulo + "', duracion = " + duracion + ", numero_canciones = " + numeroCanciones + ", "
                    + "unidades_disponibles = " + unidadesDisponibles + ", "
                    + "codigo_artista = " + codigoArtista + ", codigo_genero = " + codigoGenero + " WHERE codigo = '" + codigo + "'");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean eliminarCD(String codigo) {
        try {
            int result = this.conexion.executeSQL("DELETE FROM " + NOMBRE_TABLA + " WHERE codigo = '" + codigo + "'");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }
}
