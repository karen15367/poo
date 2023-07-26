import java.util.ArrayList;
class Dueño{
    private String nombre;
    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private String telefono;

    Dueño(String nombre, String telefono){
        this.nombre=nombre;
        this.telefono=telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    void mostrarContenido(){
        System.out.println("Nombre: "+ this.nombre);
        System.out.println("telefono: "+ this.telefono);
    }
    void mostrarMascotas(){
        System.out.println("Mascota(s)");
        int i=1;
        for(Mascota m : mascotas){
            System.out.println(i);
            m.mostrarInformacion();
            i++;
        }
    }
    void agregarMascota(Mascota mascota){
        mascotas.add(mascota);
    }
}