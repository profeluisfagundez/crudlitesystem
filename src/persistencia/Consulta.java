package persistencia;

import logica.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author eduardo
 */
public class Consulta {

    private static Consulta consulta;

    private Consulta() {

    }

    public static Consulta getInstance() {
        if (consulta == null) {
            consulta = new Consulta();
        }
        return consulta;
    }

    public void agregarUsuario(Usuario u) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO usuario(ci, nombre, apellido) VALUES ('" + u.getCi() + "', '" + u.getNombre() + "', '" + u.getApellido() + "');";
        Connection conexion = Conexion.getInstance().conectar();
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.executeUpdate(sql);
        Conexion.getInstance().desconectar();
    }

    public boolean borrarUsuario(String cedula) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM usuario WHERE usuario.ci='" + cedula + "';";
        Connection conexion = Conexion.getInstance().conectar();
        boolean respuesta = false;
        PreparedStatement statement = conexion.prepareStatement(sql);
        int fila = statement.executeUpdate(sql);
        if (fila == 1) {
            respuesta = true;
        }
        Conexion.getInstance().desconectar();
        return respuesta;
    }

    public ArrayList<Usuario> getUsuariosBD() throws SQLException, ClassNotFoundException {
        ArrayList<Usuario> aux = new ArrayList<>();
        String sql = "SELECT * FROM usuario;";
        Connection conexion = Conexion.getInstance().conectar();
        PreparedStatement statement = conexion.prepareStatement(sql);
        ResultSet dato = statement.executeQuery(sql);
        while (dato.next()) {
            String ci = dato.getString("ci");
            String nombre = dato.getString("nombre");
            String apellido = dato.getString("apellido");
            Usuario u = new Usuario(nombre, apellido, ci);
            aux.add(u);
        }
        Conexion.getInstance().desconectar();
        return aux;
    }

    public boolean modificarUsuario(Usuario u) throws SQLException, ClassNotFoundException {
        //Se debe de colocar la sentencia UPDATE para que funcione!
        String sql = "";
        Connection conexion = Conexion.getInstance().conectar();
        boolean respuesta = false;
            PreparedStatement statement = conexion.prepareStatement(sql);
            int fila = statement.executeUpdate(sql);
            if (fila == 1) {
                respuesta = true;
            }
            Conexion.getInstance().desconectar();
        return respuesta;
    }

}
