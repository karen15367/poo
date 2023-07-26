import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Main {

    public static void main(String[] args)throws Exception{
        Scanner rI=new Scanner(System.in);
        Scanner rS=new Scanner(System.in);
        Scanner rL=new Scanner(System.in);
        Veterinaria vet = new Veterinaria();
        int op;
        do{
            System.out.println("1 ver todos los expedientes");
            System.out.println("2 buscar expediente (por id)");
            System.out.println("3 agregar nuevo expediente");
            System.out.println("4 imprimir una cartilla");
            System.out.println("0 salir");
            op=rI.nextInt();
            if(op==1){
                for(int i=0;i<vet.getExpedientes().size();i++){
                    System.out.println(i+1);
                    Expediente expe=vet.getExpedientes().get(i);
                    try{
                        expe.mostrarContenido();
                        int op1;
                        do{
                            System.out.println("1 ver historial de consultas");
                            System.out.println("2 ver historial de vacunacion");
                            System.out.println("3 ver ambos");
                            System.out.println("0 Siguiente");
                            op1=rI.nextInt();
                            if(op1==1){
                                vet.getExpedientes().get(i).mostrarHistorialConsultas();
                            }
                            else if(op1==2){
                                vet.getExpedientes().get(i).mostrarHistorialVacunacion();
                            }
                            else if(op1==3){
                                vet.getExpedientes().get(i).mostrarHistorialConsultas();
                                vet.getExpedientes().get(i).mostrarHistorialVacunacion();
                            }
                            else if(op1!=0){
                                System.out.println("opcion invalida");
                            }
                        }while(op1<0 || op1>3);
                    }catch(Exception exx){
                        System.out.println("archivo no encontrado");
                    }
                }
            }
            else if(op==2){
                String nId;
                nId=rS.next();
                System.out.println("Ingrese el id que desea buscar");
                Expediente e=vet.buscarId(nId);
                try{
                    e.mostrarContenido();
                    int op2;
                    do{
                        System.out.println("1 ver historial de consultas");
                        System.out.println("2 ver historial de vacunacion");
                        System.out.println("3 ver ambos");
                        System.out.println("4 agregar Consulta");
                        System.out.println("5 agregar vacuna");
                        System.out.println("0 Siguiente");
                        op2=rI.nextInt();
                        if(op2==1){
                            e.mostrarHistorialConsultas();
                        }
                        else if(op2==2){
                            e.mostrarHistorialVacunacion();
                        }
                        else if(op2==3){
                            e.mostrarHistorialConsultas();
                            e.mostrarHistorialVacunacion();
                        }
                        if(op==4){
                            System.out.println("Fecha (dd/mm/aa)");
                            String fecha=rS.next();
                            System.out.println("diagnostico");
                            String diagnostico = rL.nextLine();
                            System.out.println("Tratamiento");
                            Tratamiento t = new Tratamiento();
                            int otro;
                            do{
                                System.out.println("Agregar medicamento 1: si, 0: no");
                                otro=rI.nextInt();
                                if(otro==1){
                                    System.out.println("nombre");
                                    String nombre = rL.nextLine();
                                    System.out.println("dosis");
                                    String dosis = rL.nextLine();
                                    System.out.println("duracion");
                                    String duracion=rL.nextLine();
                                    t.agregarMedicamento(new Medicamento(nombre,dosis,duracion));
                                }
                                else if(otro!=0){
                                    System.out.println("agregue opcion valida");
                                }
                            }while(otro!=0);
                            do{
                                System.out.println("Agregar restriccion 1: si, 0: no");
                                otro=rI.nextInt();
                                if(otro==1){
                                    System.out.println("restriccion");
                                    String r=rL.nextLine();
                                    t.agregarRestriccion(r);
                                }
                                else if(otro!=0){
                                    System.out.println("opcion invalida");
                                }
                            }while(otro!=0);
                            System.out.println("Proxima cita");
                            String proxCita=rL.nextLine();
                            e.agregarConsulta(new Consulta(e.getMascota(),fecha,diagnostico,t,proxCita));
                        }if(op2==5){
                            System.out.println("nombre de la vacuna");
                            String nv=rL.nextLine();
                            System.out.println("fecha de aplicacion (dd/mm/aa)");
                            String fecha=rS.next();
                            System.out.println("fecha de la proxima aplcacion (dd/mm/aa)");
                            String pA=rS.next();
                            e.agregarVacuna(new Vacuna(nv,fecha,pA));
                        }
                        else if(op2!=0){
                            System.out.println("opcion invalida");
                        }
                    }while(op2<0 || op2>3);
                }
                catch(Exception exx){
                    System.out.println("Archivo no encontrado");
                }
            }
            else if(op==3){
                System.out.println("Datos de la mascota");
                System.out.println("Nombre");
                String nombre=rL.nextLine();
                System.out.println("edad");
                String edad=rL.nextLine();
                System.out.println("sexo");
                String sexo=rL.nextLine();
                System.out.println("raza");
                String raza=rL.nextLine();
                System.out.println("Este dueño ya tiene una mascota? 0: no, 1: si");
                int af=rI.nextInt();
                String iddd="";
                if(af==0){
                    System.out.println("Nombre");
                    String nombreDueño=rL.nextLine();
                    System.out.println("telefono");
                    String telefonoDueño=rL.nextLine();
                    Dueño d = new Dueño(nombreDueño,telefonoDueño);
                    String idd=vet.toString(vet.getIdActual());
                    iddd=idd;
                    Mascota m = new Mascota(idd,nombre,edad,sexo,raza,d);
                    vet.agregarExpediente(new Expediente(idd,m));
                    d.agregarMascota(m);
                }
                else if(af==1){
                    System.out.println("ingrese el id de alguna de sus mascotas");
                    String id=rS.next();
                    Expediente e=vet.buscarId(id);
                    if(e!=null){
                        Dueño d=e.getMascota().getDueño();     
                        String idd=vet.toString(vet.getIdActual());
                        Mascota m = new Mascota(idd,nombre,edad,sexo,raza,d);
                        vet.agregarExpediente(new Expediente(idd,m));
                        d.agregarMascota(m);
                        iddd=idd;
                    }
                }
                System.out.println("expediente de la mascota "+nombre+" agregado exitosamente con id "+iddd);
                vet.aumentarId();
            }
            else if(op==4){
                //se guarda una cartilla y se guarda en otro archivo en txt
            }
            else if(op!=0){
                System.out.println("Opcion invalida");
            }
        }while(op!=0);    
        System.out.println("1 Crear nuevo archivo \n2 Rescribir Archivo");
    }
}
