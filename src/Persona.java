import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String documento;
    private String nombre;
    private String apellido;
    private int edad, perritosAdoptados;
    private List<Perro> lstPerros = new ArrayList<Perro>();

    public Persona() {
    }

    public Persona(String documento, String nombre, String apellido, int edad) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Perro> getLstPerros() {
        return lstPerros;
    }

    public void setLstPerros(List<Perro> lstPerros) {
        this.lstPerros = lstPerros;
    }

    public int getPerritosAdoptados() {
        return perritosAdoptados;
    }

    public void setPerritosAdoptados(int perritosAdoptados) {
        this.perritosAdoptados = perritosAdoptados;
    }

    public void adoptarPerro (Perro perro) {

    }

    public void perroMasGrande() {

    }

    @Override
    public String toString() {
        String parrafo = "";
        if (!lstPerros.isEmpty()) {
        }
        return parrafo;
    }
}
