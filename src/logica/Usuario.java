package logica;

/**
 *
 * @author Eduardo Fagúndez
 */

public class Usuario {
    private String nombre;
    private String apellido;
    private String ci;

    public Usuario(String nombre, String apellido, String ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Apellido: " + getApellido() + " CI: " + getCi();
    }
    
    @Override
    public boolean equals(Object obj){
        boolean valido = false;
        if(obj instanceof Usuario){
            Usuario usuario=(Usuario)obj;
            valido=(getNombre()==usuario.getNombre() && getApellido()==usuario.getApellido() && getCi()==usuario.getCi());
        }
        return valido;
    }
}
