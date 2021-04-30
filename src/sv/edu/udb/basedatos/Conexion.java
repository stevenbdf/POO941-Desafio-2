package sv.edu.udb.basedatos;

import java.sql.*;

public class Conexion {

    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String query = "";

    private final String SERVIDOR_BD = "localhost";
    private final String PUERTO_BD = "3306";
    private final String NOMBRE_BD = "mediateca";
    private final String USUARIO_BD = "root";
    private final String CONTRASENA_BD = "";

    //Contructor
    public Conexion() throws SQLException {
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://" + this.SERVIDOR_BD + ":" + this.PUERTO_BD + "/" + this.NOMBRE_BD,
                    this.USUARIO_BD, this.CONTRASENA_BD);

            // Permite ejecutar sentencias SQL sin parámetros
            s = conexion.createStatement();
        } catch (ClassNotFoundException e1) {
            //Error si no puedo leer el driver de MySQL
            System.out.println("ERROR:No encuentro el driver de la BD:" + e1.getMessage());
        }
    }

    //Metodo que permite obtener los valores del resulset
    public ResultSet getRs() {
        return this.rs;
    }

    //Metodo que permite fijar la tabla resultado de la pregunta
    //SQL realizada
    public void setRs(String consulta) {
        try {
            this.rs = s.executeQuery(consulta);
        } catch (SQLException e2) {
            System.out.println("ERROR:Fallo en SQL: " + e2.getMessage());
        }
    }

    //Metodo que recibe un sql como parametro que sea un update,insert.delete
    public int executeSQL(String query) throws SQLException {
        return this.s.executeUpdate(query);
    }

    //Metodo que cierra la conexion
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
}
