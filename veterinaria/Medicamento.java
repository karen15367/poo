class Medicamento{
    private String nombre;
    private String dosis;
    private String duracion;

    Medicamento(String nombre, String dosis, String duracion){
        this.nombre=nombre;
        this.dosis=dosis;
        this.duracion=duracion;
    }

    void mostrarContenido(){
        System.out.println("medicamento: "+this.nombre);
        System.out.println("dosis: "+this.dosis);
        System.out.println("duracion del tratamiento: "+ this.duracion);
    }
    
    String getNombre(){
        return nombre;
    }
    String getDosis(){
        return dosis;
    }
    String getDuracion(){
        return duracion;
    }
    void setNombre(String nombre){
        this.nombre = nombre;
    }
    void setDosis(String dosis){
        this.dosis = dosis;
    }
    void setDuracion(String duracion){
        this.duracion = duracion;
    }
}