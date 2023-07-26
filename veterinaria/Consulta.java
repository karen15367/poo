class Consulta{
    private Mascota mascota;
    private String fecha;
    private String diagnostico;
    private Tratamiento tratamiento;
    private String proxCita;
    Consulta(Mascota mascota, String fecha, String diagnostico, Tratamiento tratamiento, String proxCita){
        this.mascota=mascota;
        this.fecha=fecha;
        this.diagnostico=diagnostico;
        this.tratamiento=tratamiento;
        this.proxCita=proxCita;
    }
    void mostrarInformacion(){
        mascota.mostrarInformacion();
        System.out.println("fecha: "+fecha);
        System.out.println("diagnostico: "+ diagnostico);
        tratamiento.mostrarInfo();
        System.out.println("Proxima cita: "+proxCita);
    }
    
    public Mascota getMascota() {
        return mascota;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public Tratamiento getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
    public String getProxCita() {
        return proxCita;
    }
    public void setProxCita(String proxCita) {
        this.proxCita = proxCita;
    }
}