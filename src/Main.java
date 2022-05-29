import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int folios[];
    static Participante listaParticipantes[];
    public static void main(String[] args) {
        byte opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Antes de comenzar el concurso cuanto es el cupo maximo de partipantes?");
        System.out.print(":");
        opcion = entrada.nextByte();
         listaParticipantes= new Participante[opcion];
        folios = new int [opcion];

        do{
            System.out.println("*********************************");
            System.out.println("1)Registrarme como participante");
            System.out.println("2)Consulta");
            System.out.println("3-Salir");
            opcion = (byte) entrada.nextInt();

            switch (opcion){
                case 1:
                    AddParticipante();
                    break;
                case 2:
                    ConsultarInformacion();
                    break;
            }
        }while(opcion != 3);

    }

    public static void AddParticipante(){
        String nombre="";
        String lugar = "";
        int folio;
        String ingredientes[];
        int aux = 0;
        Scanner entrada = new Scanner(System.in);
        for(int i = 0; i < listaParticipantes.length; i++){
            if(listaParticipantes[i] == null){
                System.out.println("*************************************");
                System.out.println("            Registro");
                System.out.println("*************************************");
                System.out.println("Ingrese su nombre");
                nombre = entrada.nextLine();
                System.out.println("Ingrese lugar de origen");
                lugar = entrada.nextLine();
                folio = GenerarFolio();
                Participante p1 = new Participante(nombre,folio,lugar);
                listaParticipantes[i] = p1;
                System.out.println("ingrese el nombre del postre");
                nombre = entrada.nextLine();
                System.out.println("Ingrese el numero de ingredientes");
                aux = entrada.nextByte();
                 ingredientes = new String[aux];
                System.out.println("ingrese los ingredientes");
                for(aux = 0;aux < ingredientes.length; aux++ ){
                    System.out.println("ingrese el ingrediente");
                    ingredientes[aux] = entrada.next();
                }
                Postre p2 = new Postre(folio,ingredientes,nombre);
                listaParticipantes[i].setPostre(p2);
                aux = i;
                i = listaParticipantes.length;
            }
        }

        if(nombre == "") {
            System.out.println("***************************");
            System.out.println("ya no hay cupos disponible");
            System.out.println("***************************");
        }else{
            System.out.println("*******************************************************************");
            System.out.println("Registro exitoso " + listaParticipantes[aux].getNombre());
            System.out.println("Folio:" + listaParticipantes[aux].getFolio());
            System.out.println("Lugar proviniente: " + listaParticipantes[aux].getLugar());
            System.out.println("Postre Participante: " + listaParticipantes[aux].getPostre().getNombre());
            System.out.println("*******************************************************************");
        }

    }

    public static int GenerarFolio(){
       boolean bandera = true;
        int aleatorio = 0;
        while(bandera){
            bandera = false;
            aleatorio = (int) ((int) 2000 * Math.random());
            for (int i = 0; i < folios.length;i++){
                if(folios[i] == aleatorio){
                    bandera = true;
                }
            }
        }
        return aleatorio;
    }
   public static void ConsultarInformacion(){
        byte opcion;
       Scanner entrada = new Scanner(System.in);
       do{
           System.out.println("Manera de consultar informacion");
           System.out.println("1)Folio y nombre del participante");
           System.out.println("2)Postres participantes");
           System.out.println("3)Salir");
           opcion = entrada.nextByte();
           switch (opcion){
               case 1:
                   ConsultarByFolio();
                   break;
               case 2:
                   ConsultarByPostre();
                   break;

           }
       }while(opcion != 3);
   }

   public static void ConsultarByFolio(){
        int folio;
       String name;
       byte i = 0;
       byte incremento = 0;
       boolean bandera = false;
        Scanner entrada = new Scanner(System.in);
       System.out.println("ingrese el nombre");
        name = entrada.next();
       System.out.println("ingrese el folio");
       folio = entrada.nextInt();


       while(listaParticipantes[i] != null && incremento < listaParticipantes.length){
            if(listaParticipantes[i].getNombre().equals(name) && listaParticipantes[i].getFolio() == folio){
                System.out.println("*************************************");
                System.out.println("      Participante encontrado");
                System.out.println("*************************************");
                System.out.println("nombre:" + listaParticipantes[i].getNombre());
                System.out.println("lugar de origen: " + listaParticipantes[i].getLugar());
                System.out.println("Folio: " + listaParticipantes[i].getFolio());
                System.out.println("Postre: " + listaParticipantes[i].getPostre().getNombre());
                System.out.println("*************************************");
                bandera = true;
            }
           i++;
           incremento++;

            if(i == listaParticipantes.length){
              i--;
            }
       }

       if(!bandera)
           System.out.println("No pudimos encontrar el participante");
   }
   public static void ConsultarByPostre(){
        Scanner entrada = new Scanner(System.in);
       String postre;
       byte incremento = 0;
       boolean bandera = false;
       System.out.println("Ingrese el nombre del postres");
       postre = entrada.nextLine();
       byte i = 0;
       while(listaParticipantes[i] != null && incremento < listaParticipantes.length){
           if(listaParticipantes[i].getPostre().getNombre().equals(postre)){
               System.out.println("*************************************");
               System.out.println("Resultado de la busqueda");
               System.out.println("*************************************");
               System.out.println("nombre:" + listaParticipantes[i].getNombre());
               System.out.println("lugar de origen: " + listaParticipantes[i].getLugar());
               System.out.println("Folio: " + listaParticipantes[i].getFolio());
               System.out.println("Postre: " + listaParticipantes[i].getPostre().getNombre());
               System.out.println("*************************************");
               Visualizarpostre(i);
               bandera = true;
           }

           i++;
           incremento++;

           if(i == listaParticipantes.length){
               i--;
           }
       }

       if(!bandera)
           System.out.println("Lo sentimos no encontramos nada");
   }

   public static void Visualizarpostre(byte indice){
        byte opcion;
        String arreglo = Arrays.toString(listaParticipantes[indice].getPostre().getIngredientes());
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("Desea visualizar los ingredientes de " + listaParticipantes[indice].getPostre().getNombre());
            System.out.println("1)Si");
            System.out.println("2)No");
            opcion = entrada.nextByte();
        }while(opcion < 1 || opcion > 2);

        if(opcion == 1){
            System.out.println("Ingredientes: ");
            System.out.println(arreglo);
        }
   }

}