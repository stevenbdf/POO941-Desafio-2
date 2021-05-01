package sv.edu.udb.material.audiovisual;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;
import sv.edu.udb.util.Util;

public class DVD {

    private Conexion conexion;
    private Util util;
    private final String NOMBRE_TABLA = "dvds";

    public DVD() {
        try {
            this.conexion = new Conexion();
            this.util = new Util();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultSet obtenerDVDs() {
        this.conexion.setRs("SELECT * FROM " + this.NOMBRE_TABLA);

        return this.conexion.getRs();
    }

    public ResultSet obtenerDVD(String codigo) {
        this.conexion.setRs("SELECT * FROM " + this.NOMBRE_TABLA + " WHERE codigo = '" + codigo + "'");

        return this.conexion.getRs();
    }

    public Boolean crearDVD(String titulo, int duracion, int codigoDirector, int codigoGenero) {
        try {
            String codigo = this.util.obtenerSiguienteCodigo(this.NOMBRE_TABLA);

            int result = this.conexion.executeSQL("INSERT INTO " + this.NOMBRE_TABLA + "(codigo, titulo, duracion, codigo_director, codigo_genero) "
                    + "VALUES ('" + codigo + "', '" + titulo + "', " + duracion + ", " + codigoDirector + ", " + codigoGenero + ")");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public Boolean modificarDVD(String codigo, String titulo, int duracion, int codigoDirector, int codigoGenero) {
        try {
            int result = this.conexion.executeSQL("UPDATE " + this.NOMBRE_TABLA
                    + " SET titulo = '" + titulo + "', duracion = " + duracion + ", codigo_director = " + codigoDirector + ", codigo_genero = " + codigoGenero + " "
                    + "WHERE codigo = '" + codigo + "'"
            );

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean eliminarDVD(String codigo) {
        try {
            int result = this.conexion.executeSQL("DELETE FROM " + this.NOMBRE_TABLA + " WHERE codigo = '" + codigo + "'");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }
}
