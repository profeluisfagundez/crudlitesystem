/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import persistencia.Consulta;

/**
 *
 * @author eduardo
 */
public class Sistema {

    private ArrayList<Usuario> user;
    private static Sistema sistema;

    private Sistema() throws SQLException, ClassNotFoundException {
        this.user = new ArrayList<>();
        this.user = Consulta.getInstance().getUsuariosBD();
    }

    public static Sistema getInstance() throws SQLException, ClassNotFoundException {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    public Iterator<Usuario> iterador() {
        return this.user.iterator();
    }

    public void agregarUsuario(Usuario u) throws SQLException, ClassNotFoundException {
        this.user.add(u);
        Consulta.getInstance().agregarUsuario(u);
    }

    public boolean borrarUsuario(String cedula) throws SQLException, ClassNotFoundException {
        Iterator<Usuario> it = iterador();
        while (it.hasNext()) {
            Usuario e = it.next();
            if (e.getCi().equals(cedula)) {
                it.remove();
                return Consulta.getInstance().borrarUsuario(cedula);
            }
        }
        return false;
    }

    public ArrayList<Usuario> getUsuarios() throws SQLException, ClassNotFoundException {
        return Consulta.getInstance().getUsuariosBD();
    }

    /*
    *Este método se uso para probar que trajera correctamente los usuarios de
    *la base de datos. NO SE DEBE DE USAR YA QUE USA UN System.out.println()
    *DENTRO DE LA CLASE SISTEMA PARA MOSTRAR LOS USURIOS.
    public void listarEmpleadosShell(){
        Iterator<Usuario> it = iterador();
        while (it.hasNext()) {
            Usuario e = it.next();
            System.out.println(e.toString());
        }    
    }*/
}
