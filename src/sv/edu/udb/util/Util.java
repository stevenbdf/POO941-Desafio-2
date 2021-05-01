package sv.edu.udb.util;

import java.sql.*;

import sv.edu.udb.basedatos.Conexion;

public class Util {

    public String obtenerSiguienteCodigo(String nombreTabla) throws Exception {
        String palabra = "";
        
        switch (nombreTabla) {
            case "cds":
                palabra = "CDA";
                break;
            case "dvds":
                palabra = "DVD";
                break;
            case "libros":
                palabra = "LIB";
                break;
            case "revistas":
                palabra = "REV";
                break;
            default:
                throw new Exception("Nombre de tabla invalido");
        }
        
        try {

            Conexion conexion = new Conexion();
            conexion.setRs("SELECT codigo FROM " + nombreTabla + " ORDER BY codigo DESC");

            ResultSet rs = conexion.getRs();

            if (rs.next()) {
                String codigoActual = rs.getString("codigo");

                Integer nuevoCodigo = Integer.parseInt(codigoActual.substring(3)) + 1;

                String formatted = String.format("%05d", nuevoCodigo);

                return palabra + formatted;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return palabra + "00001";
    }
}
