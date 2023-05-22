import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class AgendaMain{
    public static void main(String args[]) throws Exception{
        //System.out.println("Holi");
        Agenda miAgenda = new Agenda();
        miAgenda.menuPrincipal();
    }
}

class Agenda{   
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    Agenda() {}
    void menuPrincipal(){
        int op=-1;
        Scanner r = new Scanner(System.in);
        System.out.println("presione el numero a la opcion correspondiente que desea realizar");
        System.out.println("1 Agregar contacto");
        System.out.println("2 buscar contacto");
        System.out.println("3 mostrar lista de contactos");
        System.out.println("0 cerrar y salir");
        do{
            op=r.nextInt();
            if(op==1){
                agregarContacto();
            }
            else if(op==2){
                buscarContacto();
            }
            else if(op==3){
                mostrarContactos();
            }
            else if(op==0){
                return;
            }
            else{
                System.out.println("ingrese una opcion valida ");
            }
        }while(op!=1 && op!=2 && op!=3 && op!=0);
        r.close();
    }
    void agregarContacto(){
        Scanner r = new Scanner(System.in);
       //BufferedReader bf = new BufferedReader(Reader);
        String nombre=" ",apellido=" ";
        System.out.println("Nnullombre: ");
        nombre=r.nextLine();
        System.out.println("Apellido: ");
        apellido=r.nextLine();

        String ciudad=" ",calle=" ",numero=" ",descripcion=" ";
        System.out.println("desea agregar direccion? s = si n = no");
        char ap;
        do{
            ap=r.next().charAt(0);  
            if(ap=='s'){
                System.out.println("Ciudad: ");
                ciudad=r.next();
                System.out.println("Calle: ");
                calle=r.next();
                System.out.println("numero: ");
                numero=r.next();
                System.out.println("descripcion: ");
                descripcion=r.next();
            }
            else{
                System.out.println("Ingrese una opcion valida");
            }
        }while(ap!='s' && ap!='n');
        String lada=" ";
        String number=" ";
        System.out.println("lada: ");
        lada=r.next();
        System.out.println("numero: ");
        number=r.next();
        Contacto nuevoContacto= new Contacto(new Persona(nombre,apellido,new Direccion(ciudad,calle,numero,descripcion)),new Telefono(lada,number));
        contactos.add(nuevoContacto);
        System.out.println("contacto agregado correctamente");
        menuPrincipal();
        r.close();
    }
    void buscarContacto(){
        Scanner r = new Scanner(System.in);
        String nombre;
        String apellido;
        System.out.println("Ingrese el nombre de la persona que desea buscar");
        nombre=r.nextLine();
        System.out.println("Ingrese el apellido de la persona que desea buscar");
        apellido = r.nextLine();
        for(Contacto actual: contactos){
            if(actual.getPersona().getNombre()==nombre && actual.getPersona().getApellido()==apellido){
                actual.mostrarContenido();
                mostrarOpcionesParaContacto(actual);
                return;
            }
        }
    }
    void eliminarContacto(Contacto contacto){
        for(int i=0;i<contactos.size();i++){
            if(contactos.get(i)==contacto){
                contactos.remove(i);
                i=contactos.size();
            }
        }
        System.out.println("contacto eliminado correctamente");
    }
    void mostrarOpcionesParaContacto(Contacto contacto){
        contacto.mostrarContenido();
        System.out.println("Presione el numero correspondiente a la opcion que desea realizar ");
        System.out.println("1 eliminar");
        System.out.println("2 editar contacto");
        System.out.println("3 llamar");
        System.out.println("0 regresar al menu principal");
        Scanner r = new Scanner(System.in);
        String op;
        do{
            op=r.nextLine();
            if(op=="1"){
              eliminarContacto(contacto);
             }
            else if(op=="2"){
                contacto.mostrarOpcionesEdit();
            }
            else if(op=="3"){
               contacto.llamar();
            }
            else if(op=="0"){
                menuPrincipal();
            }
            else{
                System.out.println("ingrese una opcion valida");
            }
        }while(op!="0" && op!="1" && op!="2" && op!="3");
    }
    void mostrarContactos(){
        for(int i=0;i<contactos.size();i++){
            System.out.println(i+1+" "+contactos.get(i).getPersona().getNombre()+" "+contactos.get(i).getPersona().getApellido());
        }
        System.out.println("si desea ver mas opciones para un contacto, ingrese su respectivo numero");
        System.out.println("si desea regresar al menú inicio, presione 0");
        Scanner r = new Scanner(System.in);
        int val;
        do{
            val=r.nextInt();
            if(val==0){
                menuPrincipal();
                return;
            }
            else if(val>0 && val<=contactos.size()){
                mostrarOpcionesParaContacto(contactos.get(val-1));
            }
            else{
                System.out.println("Ingrese una opcion valida");
            }
        }while(val<0 && val>=contactos.size());
    }
    
}

class Contacto{
    private Persona persona;
    private ArrayList<Telefono> telefonos = new ArrayList<Telefono>();

    Contacto(){}
    Contacto(Persona persona, Telefono telefono){
        this.persona=persona;
        telefonos.add(telefono);
    }
    Persona getPersona(){
        return this.persona;
    }
    Telefono getTelefono(int i){
        return telefonos.get(i);
    }
    void setPersona(Persona persona){
        this.persona=persona;
    }
    void setTelefonos(int pos, Telefono telefono){
        telefonos.set(pos,telefono);
    }
    void agregarTelefono(Telefono telefono){
        telefonos.add(telefono);
    }
    void llamar(){
        System.out.println("llamando a "+this.persona.getNombre()+" "+this.persona.getApellido());
    }
    void mostrarContenido(){
        this.persona.mostrarContenido();
        System.out.println("Telefono(s)");
        for(int i=0;i<telefonos.size();i++){
            System.out.println((i+1));
            telefonos.get(i).mostrarContenido();
        }
    }
    void mostrarOpcionesEdit(){
        System.out.println("Ingrese la opcion correspondiente al apartado que desea editar");
        System.out.println("1 Persona (nombre, apellido)");
        System.out.println("2 Direccion(es)");
        System.out.println("3 telefono(s)");
        Scanner r = new Scanner(System.in);
        Scanner ri = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String op;
        do{
            op=r.nextLine();
            if(op=="1"){
                System.out.println("Nombre: "+ persona.getNombre());
                System.out.println("Apellido: "+ persona.getApellido());
                System.out.println("Presione 1 si desea editar nombre, 2 si desea editar apellido seguido del nuevo dato");
                int ed;
                String nuevo;
                do{
                    ed=ri.nextInt();
                    nuevo=r.nextLine();
                    if(ed==1){
                        persona.setNombre(nuevo);
                    }
                    else if(ed==2){
                        persona.setApellido(nuevo);
                    }
                    else{
                        System.out.println("Ingrese un valor valido");
                    }
                }while(ed!=1 && ed!=2);
            }
            else if(op=="2"){
                System.out.println("ingrese el numero en la lista de la direccion que desea editar o 0 en caso de que desee agregar otra direccion");
                int val;
                val=ri.nextInt();
                while(val<0 && val>persona.sizeDirecciones()){
                    System.out.println("Ingrese una posicion valida");
                    val=ri.nextInt();
                }
                if(val==0){
                    String ciudad="",calle="",numero="",descripcion="";
                    System.out.println("Ciudad: ");
                    ciudad=r.next();
                    System.out.println("Calle: ");
                    calle=r.next();
                    System.out.println("numero: ");
                    numero=r.next();
                    System.out.println("descripcion: ");
                    descripcion=r.next();

                }else{
                    val--;
                    persona.getDireccionI(val).mostrarContenido();
                    System.out.println("Ingrese la opcion correspondiente de al apartado que desea editar seguido del nuevo dato");
                    System.out.println("1 ciudad");
                    System.out.println("2 calle");
                    System.out.println("3 numero");
                    System.out.println("4 descripcion");
                    String ap;
                    String nuevoDato;
                    do{
                        ap=ri.nextLine();
                        nuevoDato=r.nextLine();
                        if(ap=="1"){
                            persona.getDireccionI(val).setCiudad(nuevoDato);
                        }
                        else if(ap=="2"){
                            persona.getDireccionI(val).setCalle(nuevoDato);
                        }
                        else if(ap=="3"){
                            persona.getDireccionI(val).setNumero(nuevoDato);
                        }
                        else if(ap=="4"){
                            persona.getDireccionI(val).setDescripcion(nuevoDato);
                        }
                        else{
                            System.out.println("ingrese una opcion valida");
                        }
                    }while(ap!="1" && ap!="2" && ap!="3" && ap!="4");
                }
            }
            else if(op=="3"){
                System.out.println("ingrese el numero en la lista del telefono que desea editar o 0 si desea agregar otro telefono");
                int val;
                val=ri.nextInt();
                while(val<0 && val>persona.sizeDirecciones()){
                    System.out.println("Ingrese una posicion valida");
                    val=ri.nextInt();
                }
                if(val==0){
                    String lada, numero;
                    System.out.println("Lada: ");
                    lada=r.next();
                    System.out.println("Nombre: ");
                    numero=r.next();
                }else{
                    val--;
                    telefonos.get(val).mostrarContenido();
                    System.out.println("Ingrese el numero correspondiente al apartado que quiera editar seguido del nuevo dato");
                    System.out.println("1 lada");
                    System.out.println("2 numero");
                    String apr;
                    String nuevo;
                    do{
                        apr=r.nextLine();
                        nuevo=r.nextLine();
                        if(apr=="1"){
                            telefonos.get(val).setLada(nuevo);
                        }
                        else if(apr=="2"){
                            telefonos.get(val).setNumero(nuevo);
                        }
                        else{
                            System.out.println("Ingrese una opcion valida");
                        }
                    }while(apr!="1" && apr=="2");
                }
            }
            else{
                System.out.println("ingrese una opcion valida");
            }
        }while(op!="1" && op!="2" && op!="3");
        System.out.println("Contacto editado correctamente");
    }
}

class Persona{
    private String nombre;
    private String apellido;
    private ArrayList<Direccion> direcciones = new ArrayList<Direccion>();

    Persona(){}
    Persona(String nombre, String apellido, Direccion direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        direcciones.add(direccion);
    }
    void mostrarContenido(){
        System.out.println("Persona");
        System.out.println("Nombre: "+ this.nombre);
        System.out.println("Apellido: "+ this.apellido);
        System.out.println("Direccion(es)");
        for(int i=0;i<direcciones.size();i++){
            System.out.println("Direccion "+(i+1));
            direcciones.get(i).mostrarContenido();
        }
    }
    String getNombre(){
        return this.nombre;
    }
    String getApellido(){
        return this.apellido;
    }
    Direccion getDireccionI(int i){
        return direcciones.get(i);
    }
    int sizeDirecciones(){
        return direcciones.size();
    }
    void setNombre(String nombre){
        this.nombre=nombre;
    }
    void setApellido(String apellido){
        this.apellido=apellido;
    }
    void setDireccionI(int pos,Direccion direccion){
        direcciones.set(pos, direccion);
    }
    void agregarDireccion(Direccion direccion){
        direcciones.add(direccion);
    }
}

class Telefono{
    private String lada;
    private String numero;
    
    Telefono(){}
    Telefono(String lada,String numero){
        this.numero=numero;
        this.lada=lada;
    }
    void mostrarContenido(){
        System.out.println("Lada: "+this.lada);
        System.out.println("Numero: "+this.numero);
    }

    String getLada(){
        return this.lada;
    }
    String getNumero() {
        return this.numero;
    }
    void setLada(String lada){
        this.lada=lada;
    }
    void setNumero(String numero) {
        this.numero = numero;
    }
}

class Direccion{
    private String ciudad;
    private String calle;
    private String numero;
    private String descripcion;
    
    Direccion(){}
    Direccion(String ciudad, String calle,String numero, String descripcion){
        this.ciudad=ciudad;
        this.calle=calle;
        this.numero=numero;
        this.descripcion=descripcion;
    }
    void mostrarContenido(){
        System.out.println("Ciudad: "+ this.ciudad);
        System.out.println("calle: "+ this.calle);
        System.out.println("numero: "+ this.numero);
        System.out.println("Descripcion: "+ this.descripcion);
    }

    String getCiudad(){
        return this.ciudad;
    }
    String getCalle(){
        return this.calle;
    }
    String getNumero(){
        return this.numero;
    }
    String getDescripcion(){
        return this.descripcion;
    }
    void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    void setCalle(String calle){
        this.calle=calle;
    }
    void setNumero(String numero){
        this.numero=numero;
    }
    void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
}
