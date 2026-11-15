//Librerias

import models.Jugador;
import operations.Operations;

import static operations.Operations.*;

import java.time.LocalDate;//abre con la fecha actual
import java.util.Scanner;

public class Main { //crea juagdores
    public static void main(String[] args) {
        /*


        models.Jugador j1 = new models.Jugador();


        models.Equipo e1 = new models.Equipo();


        models.Jugador j3 = new models.Jugador("Quintero",
                LocalDate.of(1993,1,18)); //crea juagador con la fecha local


        e1.plantilla = new models.Jugador[5]; //arreglo para crear el equipo de jugadores
        e1.plantilla[0] = j1;
        j1.posicion = models.Posicion.EXTREMO;

        models.Persona p1 = new models.Persona(); //crea persona
        p1.name = "Daniel";
        p1.setCountry("Colombia");

        models.Jugador j2 = new models.Jugador();
        //j2.p1 = p1;
        j2.posicion = models.Posicion.DELANTERO;
        j1.name = "Messi";
        j1.dorsal = 10;
        j1.setNacimiento(LocalDate.of(1987,9,28));
        //j1.country = "Argentina";
        //j1.id = "1";
        j1.setCountry("España");
        System.out.println(j1.getCountry());

        System.out.println(j1); //muestra juagdor


        models.Tecnico t1 = new models.Tecnico();

        t1.name="Pekerman";
        t1.club="Desempleado"; //crea tecnico

        System.out.println(t1); //muestra juagor

        System.out.println(j3.getEdad()); //muestra la edad

         */

        /*
        Jugador newPlayer = new Jugador("Carlos", LocalDate.of(2008, 11, 1));
        newPlayer.is_alive = true;
        newPlayer.dorsal = 20;
        //System.out.println(" Edad: "+newPlayer.getEdad());
        //System.out.println(newPlayer);
        System.out.println(newPlayer.playerToCSV()); //La forma en la que se van a enseñar los jugaores en archivo SCV
        savePlayer(newPlayer);
        readPlayer();
        Jugador newPlayer2 = new Jugador("Arnulfo", LocalDate.of(1960,5,17));
        savePlayer(newPlayer2);
        System.out.println("Hola, aquí cierra manito");
        readPlayer();

         */


        /* Desarrollo del menú para los jugadores que se vea así
           Menu
           Ingresar jugador -> pulsa 1
           Leer todos jugadores -> pulsa 2
           Buscar jugador -> pulsa 3
         */
        Scanner leer = new Scanner(System.in);

        System.out.println("Bienvenido"); //Decirle que holi :D

        int opcion;
        do
        {
            System.out.println("\n------------ MENÚ JUGADORES ------------");
            System.out.println("1. Crear jugador");
            System.out.println("2. Buscar jugador");
            System.out.println("3. Leer todos los jugadores");
            System.out.println("4. Editar Jugador");
            System.out.println("5. Eliminar Jugador");
            System.out.println("6. Crear técnico");
            System.out.println("7. Crear un equipo");
            System.out.println("8. Añadir jugadores y técnico al equipo");
            System.out.println("0. Salir");
            System.out.println("----------------------------------------");

            opcion = leer.nextInt();

            switch (opcion)
            {
                case 1:
                    newPlayer();
                    break;
                case 2:
                    findPlayer();
                    break;
                case 3:
                    showAllPlayers();
                    break;
                case 4:
                    editPlayer();
                    break;
                case 5:
                    Borrar();
                case 0:
                    System.out.println("Hasta pronto");
                    System.exit(0); //Para finalizar el programa
                    break;
                default:
                    System.out.println("Ingresa un número válido");

            }

        }
        while (opcion != 0);
    }

    public static void newPlayer() {
        Scanner leer = new Scanner(System.in); //para leer los datos que se van a ingresar
        int ID = idplayers();

        //informacion de los juagdores a leer
        System.out.println("Ingrese el nombre del nuevo jugador");
        String name_player = leer.nextLine();
        System.out.println("Ingrese el año de nacimiento del nuevo jugador");
        int year = leer.nextInt();
        System.out.println("Ingrese el mes de nacimiento del nuevo jugador");
        int mont = leer.nextInt();
        System.out.println("Ingrese el dia de nacimiento del nuevo jugador");
        int day = leer.nextInt();
        //se crea el jugador con estos nuevos parametros
        Jugador j2db = new Jugador(ID,name_player, LocalDate.of(year, mont, day));
        //se le añade la informacion que falta
        System.out.println("Ingrese el dorsal del nuevo jugador");
        j2db.dorsal = leer.nextInt();
        j2db.is_alive = true;
        //guardar jugador
        Operations.savePlayer(j2db);

    }
    public static void findPlayer() { //buscar jugador
        Scanner leer = new Scanner(System.in); //para definir que lea
        System.out.println("Ingrese el jugador que desea buscar");
        String jbrc = leer.nextLine();
        System.out.println("El nombre del jugador ingresado es: " + jbrc);
        Operations.readOnePlayer(jbrc);

    }
    public static void showAllPlayers()
    {
        Operations.readPlayers();
    }

    public static void Borrar()
    {
        Scanner leer = new Scanner(System.in); //para definir que jugador busca para borrar
        System.out.println("Ingrese el jugador que desea borrar");
        String jborrar = leer.nextLine();
        System.out.println("El jugador es : " + jborrar);
        Operations.BorrarPlayer(jborrar);
    }
    public static void editPlayer()
    {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador que desea editar");
        String jEditar = leer.nextLine();
        System.out.println("El nombre del jugador que se desea editar es " + jEditar);
        System.out.println("");
        Operations.EditarPlayer(jEditar);
    }



     //TODO desarrollar la parte de editar jugador
}
