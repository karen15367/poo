import java.util.ArrayList;
class Veterinaria{
    private static int idActual;
    private ArrayList<Expediente> expedientes = new ArrayList<Expediente>();

    Veterinaria(){
        idActual=0;
    }
    public ArrayList<Expediente> getExpedientes() {
        return expedientes;
    }
    public void setExpedientes(ArrayList<Expediente> expedientes) {
        this.expedientes = expedientes;
    } 
    public static int getIdActual() {
        return idActual;
    }
    public static void setIdActual(int idActual) {
        Veterinaria.idActual = idActual;
    }
    void mostrarExpedientes(){
        int i=1;
        for(Expediente e:expedientes){
            System.out.println(i);
            e.mostrarContenido();
            e.mostrarHistorialConsultas();
            e.mostrarHistorialVacunacion();
            i++;
        }
    }
    Expediente buscarId(String id){
        for(int i=0;i<expedientes.size();i++){
            if(expedientes.get(i).getId().equals(id)){
                return expedientes.get(i);
            }
        }
        return null;
    }
    void agregarExpediente(Expediente e){
        expedientes.add(e);
    }
    void aumentarId(){
        idActual++;
    }
    public String toString(int id){
        return ""+id;
    }
}