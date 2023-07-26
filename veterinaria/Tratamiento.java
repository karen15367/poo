import java.util.ArrayList;
class Tratamiento{
    private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    private ArrayList<String> restricciones = new ArrayList<String>();

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ArrayList<String> getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(ArrayList<String> restricciones) {
        this.restricciones = restricciones;
    }

    void mostrarInfo(){
        System.out.println("Medicamentos:");
        int i=1;
        for(Medicamento m: medicamentos){
            System.out.println(i);
            m.mostrarContenido();
            i++;
        }
        System.out.println("Restricciones");
        i=1;
        for(String r: restricciones){
            System.out.println(i);
            System.out.println(r);
            i++;
        }
    }

    void agregarMedicamento(Medicamento medicamento){
        medicamentos.add(medicamento);
    }
    void agregarRestriccion(String restriccion){
        restricciones.add(restriccion);
    }
}