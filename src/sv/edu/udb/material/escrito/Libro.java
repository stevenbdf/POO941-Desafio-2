package sv.edu.udb.material.escrito;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;
import sv.edu.udb.util.Util;

public class Libro {

    private Conexion conexion;
    private Util util;
    private final String NOMBRE_TABLA = "libros";

    public Libro() {
        try {
            this.conexion = new Conexion();
            this.util = new Util();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultSet obtenerLibros() {
        this.conexion.setRs("SELECT libros.codigo, titulo, autor, numero_paginas, ISBN, anio_publicacion, unidades_disponibles, "
                + "codigo_editorial, editoriales.nombre as editorial FROM " + this.NOMBRE_TABLA
                + " INNER JOIN editoriales ON libros.codigo_editorial = editoriales.codigo");

        return this.conexion.getRs();
    }

    public ResultSet obtenerLibro(String codigo) {
        this.conexion.setRs("SELECT * FROM " + this.NOMBRE_TABLA + " WHERE codigo = '" + codigo + "'");

        return this.conexion.getRs();
    }

    public Boolean crearLibro(String titulo, String autor, int numeroPaginas, String ISBN, int anioPublicacion, int unidadesDisponibles, int codigoEditorial) {
        try {
            String codigo = this.util.obtenerSiguienteCodigo(this.NOMBRE_TABLA);

            int result = this.conexion.executeSQL("INSERT INTO " + this.NOMBRE_TABLA + ""
                    + "(codigo, titulo, autor, numero_paginas, ISBN, anio_publicacion, unidades_disponibles, codigo_editorial) "
                    + "VALUES ('" + codigo + "', '" + titulo + "', '" + autor + "', " + numeroPaginas + ", '" + ISBN + "', "
                    + anioPublicacion + ", " + unidadesDisponibles + ", " + codigoEditorial + ")");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public Boolean modificarLibro(String codigo, String titulo, String autor, int numeroPaginas, String ISBN, int anioPublicacion, int unidadesDisponibles, int codigoEditorial) {
        try {
            int result = this.conexion.executeSQL("UPDATE " + this.NOMBRE_TABLA
                    + " SET titulo = '" + titulo + "', autor = '" + autor + "', numero_paginas = " + numeroPaginas + ", ISBN = '" + ISBN + "', "
                    + "anio_publicacion = " + anioPublicacion + ", unidades_disponibles =" + unidadesDisponibles + ", codigo_editorial = " + codigoEditorial
                    + " WHERE codigo = '" + codigo + "'"
            );

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean eliminarLibro(String codigo) {
        try {
            int result = this.conexion.executeSQL("DELETE FROM " + this.NOMBRE_TABLA + " WHERE codigo = '" + codigo + "'");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }
}
