public class Perro {
    private String placa;
    private String nombre;
    private String raza;
    private int edad;
    private String tamanio;

    public Perro() {

    }

    public Perro(String placa, String nombre, String raza, int edad, String tamanio) {
        this.placa = placa;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamanio = tamanio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "placa= " + placa +
                ", nombre= " + nombre +
                ", raza= " + raza +
                ", edad= " + edad +
                ", tamanio= " + tamanio;
    }
}
