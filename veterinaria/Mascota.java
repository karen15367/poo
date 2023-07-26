class Mascota{
    private String id;
    private String nombre;
    private String edad;
    private String sexo;
    private String raza;
    private Dueño dueño;
    private Expediente expediente;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public Dueño getDueño() {
        return dueño;
    }
    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    public Expediente getExpediente() {
        return expediente;
    }
    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }
    Mascota(String id, String nombre, String edad, String sexo, String raza, Dueño dueño){
        this.nombre=nombre;
        this.id=id;
        this.edad=edad;
        this.sexo=sexo;
        this.raza=raza;
        this.dueño=dueño;
    }
    void mostrarInformacion(){
        System.out.println("id: "+id);
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+ edad);
        System.out.println("Sexo: "+sexo);
        System.out.println("Raza: "+raza);
        System.out.println("Dueño ");
        dueño.mostrarContenido();
        //expediente.mostrarContenido();
    }
    void actualizarEdad(String edad){
        this.edad=edad;
    }
    void actualizarDueño(Dueño dueño){
        this.dueño=dueño;
    }
}