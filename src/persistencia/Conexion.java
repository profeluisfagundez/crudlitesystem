package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis Eduardo Fagúndez
 */
public class Conexion {

    private static Conexion conexion;
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crudlitesystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    private Conexion() {

    }

    public static Conexion getInstance() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection conectar() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public void desconectar() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

}
