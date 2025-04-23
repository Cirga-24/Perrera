import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String documento;
    private String nombre;
    private String apellido;
    private int edad, perritosAdoptados;
    private List<Perro> lstPerros = new ArrayList<Perro>();
    private List<Perro> lstPerrosConMismaEdad = new ArrayList<Perro>();

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
        if (lstPerros.size() < 3) {
            lstPerros.add(perro);
            perritosAdoptados++;
            System.out.println("Felicidades, acaba de hacer a un cachorrito muy feliz.");
        } else {
            System.out.println("Alcanzó su límite de adopciones.");

        }
    }

    public void perroMasGrande() {
        boolean moreThanOne = false;
        if(lstPerros.isEmpty()){
            System.out.println("Este usuario no ha adoptado ningun perrito.");
        } else {
            int edadMayor = 0, edadNueva;
            for (Perro p : lstPerros) {
                edadNueva = p.getEdad();
                if (edadMayor < edadNueva) {
                    edadMayor = edadNueva;
                    System.out.println(p.toString());
                } else if (edadMayor == edadNueva) {
                    System.out.println("Hay dos o más perros con la misma edad que fueron adoptados por este usuario.");
                    lstPerrosConMismaEdad.add(p);
                    moreThanOne = true;
                }
            }
        }
        if (moreThanOne) {
            for (Perro p : lstPerrosConMismaEdad) {
                System.out.println(p.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "nombre=" + nombre +
                ", apellido= " + apellido +
                ", edad= " + edad +
                ", perritosAdoptados= " + perritosAdoptados;
    }
}
