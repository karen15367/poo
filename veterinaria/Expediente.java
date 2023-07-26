import java.util.ArrayList;
class Expediente{
    private String id;
    private Mascota mascota;
    private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
    private ArrayList<Vacuna> vacunas = new ArrayList<Vacuna>();
    Expediente(String id, Mascota mascota){
        this.id=id;
        this.mascota=mascota;
    }
    void mostrarContenido(){
        System.out.println("mascota: ");
        mascota.mostrarInformacion();
    }
    void mostrarHistorialConsultas(){
        int i=1;
        for(Consulta c:consultas){
            System.out.println(i);
            c.mostrarInformacion();
            i++;
        }
    }
    void mostrarHistorialVacunacion(){
        int i=1;
        for(Vacuna v : vacunas){
            System.out.println(i);
            v.mostrarInfo();
            i++;
        }
    }
    void agregarConsulta(Consulta consulta){
        consultas.add(consulta);
    }
    void agregarVacuna(Vacuna vacuna){
        vacunas.add(vacuna);
    }  
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Mascota getMascota() {
        return mascota;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }  
    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }
    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }   
    public ArrayList<Vacuna> getVacunas() {
        return vacunas;
    }
    public void setVacunas(ArrayList<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }    
}