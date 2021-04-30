package sv.edu.udb.catalogos;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;

public class Editorial {

    private Conexion conexion;
    private final String NOMBRE_TABLA = "editoriales";

    public Editorial() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultSet obtenerEditoriales() {
        this.conexion.setRs("SELECT codigo, nombre, direccion, telefono, correo_electronico FROM " + this.NOMBRE_TABLA);

        return this.conexion.getRs();
    }

    public ResultSet obtenerEditorial(int codigo) {
        this.conexion.setRs("SELECT codigo, nombre, direccion, telefono, correo_electronico FROM " + this.NOMBRE_TABLA + " WHERE codigo = " + codigo);

        return this.conexion.getRs();
    }

    public Boolean crearEditorial(String nombre, String direccion, String telefono, String correoElectronico) {
        try {
            int result = this.conexion.executeSQL("INSERT INTO " + NOMBRE_TABLA
                    + "(nombre, direccion, telefono, correo_electronico) "
                    + "VALUES ('" + nombre + "', '" + direccion + "', '" + telefono + "', '" + correoElectronico + "')");

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean modificarEditorial(int codigo, String nombre, String direccion, String telefono, String correoElectronico) {
        try {
            int result = this.conexion.executeSQL("UPDATE " + NOMBRE_TABLA + " "
                    + "SET nombre = '" + nombre + "', direccion = '" + direccion + "', telefono = '" + telefono + "', correo_electronico = '" + correoElectronico + "' "
                    + "WHERE codigo = " + codigo);

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }

    public Boolean eliminarEditorial(int codigo) {
        try {
            int result = this.conexion.executeSQL("DELETE FROM " + NOMBRE_TABLA + " WHERE codigo = " + codigo);

            return result == 1;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return false;
    }
}
