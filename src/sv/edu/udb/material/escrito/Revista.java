package sv.edu.udb.material.escrito;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;
import sv.edu.udb.util.Util;

public class Revista {

    private Conexion conexion;
    private Util util;
    private final String NOMBRE_TABLA = "revistas";

    public Revista() {
        try {
            this.conexion = new Conexion();
            this.util = new Util();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultSet obtenerRevistas() {
        this.conexion.setRs("SELECT * FROM " + this.NOMBRE_TABLA);

        return this.conexion.getRs();
    }

    public ResultSet obtenerRevista(String codigo) {
        this.conexion.setRs("SELECT * FROM " + this.NOMBRE_TABLA + " WHERE codigo = '" + codigo + "'");

        return this.conexion.getRs();
    }

    public Boolean crearRevista(String titulo, String periodicidad, String fechaPublicacion, int unidadesDisponibles, int codigoEditorial) {
        try {
            String codigo = this.util.obtenerSiguienteCodigo(this.NOMBRE_TABLA);

            int result = this.conexion.executeSQL("INSERT INTO " + this.NOMBRE_TABLA + ""
                    + "(codigo, titulo, periodicidad, fecha_publicacion, unidades_disponibles, codigo_editorial) "
                    + "VALUES ('" + codigo + "', '" + titulo + "', '" + periodicidad + "', '" + fechaPublicacion + "', " + unidadesDisponibles + ", "
                    + codigoEditorial + ")");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public Boolean modificarRevista(String codigo, String titulo, String periodicidad, String fechaPublicacion, int unidadesDisponibles, int codigoEditorial) {
        try {
            int result = this.conexion.executeSQL("UPDATE " + this.NOMBRE_TABLA
                    + " SET titulo = '" + titulo + "', periodicidad = '" + periodicidad + "', fecha_publicacion = '" + fechaPublicacion + "', unidades_disponibles = " + unidadesDisponibles + ", "
                    + "codigo_editorial = " + codigoEditorial
                    + " WHERE codigo = '" + codigo + "'"
            );

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean eliminarRevista(String codigo) {
        try {
            int result = this.conexion.executeSQL("DELETE FROM " + this.NOMBRE_TABLA + " WHERE codigo = '" + codigo + "'");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }
}
