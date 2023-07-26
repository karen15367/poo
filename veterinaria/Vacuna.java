class Vacuna{
    
    private String nombre;
    private String fecha;
    private String sigDosis;
    Vacuna(String nombre, String fecha, String sigDosis){
        this.nombre=nombre;
        this.fecha=fecha;
        this.sigDosis=sigDosis;
    }
    void mostrarInfo(){
        System.out.println("nombre de la vacuna: "+ this.nombre);
        System.out.println("fecha: "+ this.fecha);
        System.out.println("siguiente dosis: "+ this.sigDosis);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getSigDosis() {
        return sigDosis;
    }
    public void setSigDosis(String sigDosis) {
        this.sigDosis = sigDosis;
    }
}