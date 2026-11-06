import java.io.File;
import java.time.LocalDate;//abre con la fecha actual
import java.io.FileWriter; //para empezar con las persistencias y guardar los archivos en CSV
import java.io.IOException;

public class Main { //crea juagdores
    public static void main(String[] args) {
        /*


        Jugador j1 = new Jugador();


        Equipo e1 = new Equipo();


        Jugador j3 = new Jugador("Quintero",
                LocalDate.of(1993,1,18)); //crea juagador con la fecha local


        e1.plantilla = new Jugador[5]; //arreglo para crear el equipo de jugadores
        e1.plantilla[0] = j1;
        j1.posicion = Posicion.EXTREMO;

        Persona p1 = new Persona(); //crea persona
        p1.name = "Daniel";
        p1.setCountry("Colombia");

        Jugador j2 = new Jugador();
        //j2.p1 = p1;
        j2.posicion = Posicion.DELANTERO;
        j1.name = "Messi";
        j1.dorsal = 10;
        j1.setNacimiento(LocalDate.of(1987,9,28));
        //j1.country = "Argentina";
        //j1.id = "1";
        j1.setCountry("España");
        System.out.println(j1.getCountry());

        System.out.println(j1); //muestra juagdor


        Tecnico t1 = new Tecnico();

        t1.name="Pekerman";
        t1.club="Desempleado"; //crea tecnico

        System.out.println(t1); //muestra juagor

        System.out.println(j3.getEdad()); //muestra la edad

         */

        Jugador newPlayer = new Jugador("Carlos", LocalDate.of(2008, 11, 1));
        newPlayer.is_alive = true;
        newPlayer.dorsal = 20;
        //System.out.println(" Edad: "+newPlayer.getEdad());

        System.out.println(newPlayer.playerToCSV()); //La forma en la que se van a enseñar los jugaores en archivo SCV
        savePlayer(newPlayer);
    }

        public static void savePlayer(Jugador jugadorToSave) {
            try {
                FileWriter escribir = new FileWriter("players.csv");
                escribir.write(jugadorToSave.playerToCSV());
                escribir.close();
                System.out.println("El jugador fue guardado correctamente");
            } catch (IOException e) {
                System.out.println("Algo anda mal :(");
            }
        }


    }
