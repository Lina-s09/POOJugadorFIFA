package operations;

//Librerías

import models.Equipo;
import models.Jugador;

import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;


public class Operations {

    //Crear el metodo para definir el ID
    public static int idplayers()
    {
        int ID = 1; //definirlo en 1 para el conteo

    try {
            FileReader lector = new FileReader("players.csv");
            BufferedReader buffer = new BufferedReader(lector); //lee los jugadores que se estan guardando
            String playerReader;

            while ((playerReader = buffer.readLine()) != null) //para leer los jugadores que no estan vacíos, lee todas las lineas
            {
                String[] data_readed = playerReader.split(",");
                ID = Integer.parseInt(data_readed[0].trim()) + 1; //para definir como será el id sumando uno por jugador
            }
            buffer.close(); //cierra la lectura

        } catch (IOException e) {
            System.out.println("Algo salió mal :(");
        }
        return ID;
    }

    public static void savePlayer(Jugador jugadorToSave) { //Metodo para escribir los jugadores
        try {
            FileWriter escribir = new FileWriter("players.csv", true); //Para guardar los jugadores, que se escriben, creando el objeto de ese tipo
            //escribir.write(jugadorToSave.playerToCSV());
            escribir.write(jugadorToSave.playerToCSV()); //es la unica que permite almacenar una cantidad de jugadores
            escribir.write("\n"); //para un salto de línea
            escribir.close();
            System.out.println("El jugador fue guardado correctamente"); //mensaje para indicar que salió bien

        } catch (IOException e) {
            System.out.println("Algo anda mal :("); //mensaje de error
        }
    }

    public static void saveEquipos (Equipo equipoToSave)
    {
        try {
            FileWriter escribir = new FileWriter("equipos.csv", true); //Para guardar los jugadores, que se escriben, creando el objeto de ese tipo
            escribir.write(equipoToSave.EquiposToSCV()); //es la unica que permite almacenar una cantidad de jugadores
            escribir.write("\n"); //para un salto de línea
            escribir.close();
            System.out.println("El equipo fue guardado correctamente"); //mensaje para indicar que salió bien

        } catch (IOException e) {
            System.out.println("Algo anda mal :("); //mensaje de error
        }
    }

    public static ArrayList<Jugador> readPlayers() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try {
            FileReader lector = new FileReader("players.csv");
            BufferedReader buffer = new BufferedReader(lector); //lee los jugadores que se estan guardando
            String playerReader;

            while ((playerReader = buffer.readLine()) != null) //para leer los jugadores que no estan vacíos, lee todas las lineas
            {
                //System.out.println(playerReader); //muestra los elementos que se están almacenando

                String[] data_readed = playerReader.split(",");

                int ID = Integer.parseInt(data_readed[0].trim());
                String nombre = data_readed[1].trim();
                int dorsal = Integer.parseInt(data_readed[2].trim());
                int edad = Integer.parseInt(data_readed[3].trim());
                boolean is_alive = Boolean.parseBoolean(data_readed[4].trim());
                int IDEquipo = Integer.parseInt(data_readed[5].trim());

                Jugador JugadorparaEq = new Jugador();

                JugadorparaEq.ID = ID;
                JugadorparaEq.name = nombre;
                JugadorparaEq.dorsal = dorsal;
                JugadorparaEq.edad = edad;
                JugadorparaEq.is_alive = is_alive;
                JugadorparaEq.IDequipo = IDEquipo;

                jugadores.add(JugadorparaEq);

                String readPlayers;
            }
            buffer.close(); //cierra la lectura
            System.out.println("Todos los jugadores fueron leídos correctamente");

        } catch (IOException e) {
            System.out.println("Algo salió mal :(");
        }
        return jugadores;
    }

    public static void readOnePlayer(String name) //metodo para leer un jugador, recibiendo el parametro de nombre
    {
        //System.out.println("ENTRANDO A readOnePlayer()");

        try {
            FileReader lector = new FileReader("players.csv"); //entra al archivo de jugadores de csv, paar leer los jugadores
            BufferedReader buffer = new BufferedReader(lector);
            String playerReader;

            Boolean encontrado = false; //Se utiliza para determinar que el jugador fue leído o no, y establecer las condiciones para enviar los mensajes por la salida

            while ((playerReader = buffer.readLine()) != null) { //para recorrer todas las lineas de jugares y leerlas
                // System.out.println("Linea encontrada"+ playerReader);
                String[] data_readed = playerReader.split(",\\s*"); //divide ña cadena en comas
                Jugador temp_player = new Jugador(); //se crea un jugador temporal, con las características que indica para ser guardado
                temp_player.name = data_readed[1]; //posicion de como se muestran en un tipo de arreglo
                temp_player.dorsal = Integer.parseInt(data_readed[2]); //aqui pasa a ser un string
                int edad = Integer.parseInt(data_readed[3]);
                temp_player.is_alive = Boolean.parseBoolean(data_readed[4]);

                //para detrminar que los uygadores se estén leyendo correctamnete
                // System.out.println("Nombre leido "+ temp_player.name);
                // System.out.println("Nombre buscado"+ name);

                if (temp_player.name.equalsIgnoreCase(name)) { //Indica la igualdad para encontra al jugado por el nombre ingresado
                    encontrado = true; //establece que el jugador si es encontrado es verdadero
                    System.out.println("El jugador encontrado es: " + playerReader);
                    break;
                }
            }
            buffer.close(); //cierra el buffer
            System.out.println("Finalizó la búsqueda");

            if (!encontrado) //si es difrente al que fue encontrado se envia un mensaje que lo indica
            {
                System.out.println("El jugador a buscar no fue encontrado, verifíque la información ingresada");
            }
        } catch (Exception e) {
            System.out.println("Algo salió mal :(, el jugador no fue encontrado");
            e.printStackTrace();
        }
    }

    public static void BorrarPlayer(String name) //Metodo para borrar el jugador
    {
        Scanner leer = new Scanner(System.in);
        String jugadores = "";

        Boolean encontrado = false;

        try {
            FileReader lector = new FileReader("players.csv"); //entra al archivo de jugadores de csv, paar leer los jugadores
            BufferedReader buffer = new BufferedReader(lector);
            String playerReader;

            while ((playerReader = buffer.readLine()) != null) { //para recorrer todas las lineas de jugadores y leerlas
                // System.out.println("Línea encontrada"+ playerReader);
                String[] data_readed = playerReader.split(",\\s*"); //divide la cadena en comas
                Jugador temp_player = new Jugador(); //se crea un jugador temporal, con las características que indica para ser guardado como dato
                temp_player.name = data_readed[1]; //posicion de como se muestran en un tipo de arreglo
                temp_player.dorsal = Integer.parseInt(data_readed[2]); //aqui pasa a ser un string
                temp_player.edad = Integer.parseInt(data_readed[3]);
                temp_player.is_alive = Boolean.parseBoolean(data_readed[4]);
                temp_player.ID = Integer.parseInt(data_readed[0]);

                //para detrminar que los jugadores se estén leyendo correctamnete
                // System.out.println("Nombre leido "+ temp_player.name);
                // System.out.println("Nombre buscado"+ name);

                if (temp_player.name.equalsIgnoreCase(name)) {
                    //System.out.println("El jugador encontrado es: "+ playerReader);
                    encontrado = true;
                    System.out.println("¿Desea borrar este jugador? " + playerReader); //Preguntar de encontrar el jugador
                    System.out.println("Indicar SI en caso de ser así");
                    String decidir = leer.nextLine();

                    if (decidir.equalsIgnoreCase("SI")) //Ignora las mayúsculas y minúsculas
                    {
                        System.out.println("Se eliminará el jugador seleccionado");
                    } else {
                        System.out.println("Se canceló la operación, el jugador no será eliminado");
                        jugadores += playerReader + "\n";// eSsto es lo que permite ALMACENAR EL NUEVO ARCHIVO DE JUGADORES
                    }
                } else {
                    jugadores += playerReader + "\n"; //se almacenan los jugadores si no son los que se están buscando, adicioanlmente para seguir siendo guardados se agrega el salto de línea
                }
            }
            buffer.close(); //cierra el buffer

            //Para almacenarlos en el CSV
            FileWriter escribirCSV = new FileWriter("players.csv"); //para indicar que entre al archivo scv
            escribirCSV.write(jugadores); //que escriba sobre jugadores a los jugadores que ya están
            escribirCSV.close(); //cerrar

            if (!encontrado) {
                System.out.println("No se encontró el jugador que se estaba buscando, ingrese su nombre nuevamente");
            }
        } catch (Exception e) {
            //System.out.println("Algo salió mal :(");
            e.printStackTrace();
        }

    }

    public static void EditarPlayer(String name)
    {
        try {
            String jugadores = "";

            //Para leer el jugador
            FileReader lector = new FileReader("players.csv"); //entra al archivo de jugadores de csv, paar leer los jugadores
            BufferedReader buffer = new BufferedReader(lector);
            String playerReader;
            Scanner leer = new Scanner(System.in);

            Boolean encontrado = false; //Se utiliza para determinar que el jugador fue leído o no, y establecer las condiciones para enviar los mensajes por la salida
            int editplyr = 0; //definir la variable de editar jugador que abre el menú como 0

            while ((playerReader = buffer.readLine()) != null) { //para recorrer todas las lineas de jugares y leerlas
                // System.out.println("Linea encontrada"+ playerReader);
                String[] data_readed = playerReader.split(",\\s*"); //divide ña cadena en comas
                Jugador temp_player = new Jugador(); //se crea un jugador temporal, con las características que indica para ser guardado
                temp_player.name = data_readed[1]; //posicion de como se muestran en un tipo de arreglo
                temp_player.dorsal = Integer.parseInt(data_readed[2]); //aqui pasa a ser un string
                //int edad = Integer.parseInt(data_readed[2]);
                temp_player.edad = Integer.parseInt(data_readed[3]); //Definir la edad para el juagdor temporal que se crea co le fin de editar esta vez
                temp_player.is_alive = Boolean.parseBoolean(data_readed[4]);
                temp_player.ID = Integer.parseInt(data_readed[0]);//Establecer el id para que siempre sea leído
                temp_player.IDequipo = Integer.parseInt(data_readed[5]);

                    if (temp_player.name.equalsIgnoreCase(name)) { //Indica la igualdad para encontra al jugado por el nombre ingresado

                        encontrado = true; //establece que el jugador si es encontrado es verdadero

                        while (editplyr != 4) {
                            //indicar una especie de menú para indicar que se busca cambiar de un jugador
                            System.out.println("El jugador encontrado es: " + temp_player.playerToCSV());
                            System.out.println("Qué desea editar del jugador?");
                            System.out.println("1. Nombre");
                            System.out.println("2. Dorsal");
                            System.out.println("3. Definir si está vivo");
                            System.out.println("4. Nada");

                            editplyr = leer.nextInt(); //leer la opción del jugador
                            leer.nextLine();

                            //Usar el switch para establacer las funciones a través de métodos
                        switch (editplyr) {
                            case 1:
                                //NOMBRE
                                System.out.println("Editar el nombre de " + playerReader);
                                System.out.println("Indica el nuevo nombre del jugador");

                                String newname = leer.nextLine();
                                temp_player.name = newname;
                                break;
                            case 2:
                                //DORSAL
                                if (temp_player.name.equalsIgnoreCase(name))
                                {
                                    //manejar de la misma forma que el nombre, porque la estructura de guardar ya esta lista
                                    System.out.println("Editar el dorsal de "+ playerReader);
                                    System.out.println("Ingrese el numero del nuevo dorsal");
                                    int newDorsal = leer.nextInt();
                                    leer.nextLine();
                                    temp_player.dorsal = newDorsal;
                                    break;
                                }
                            case 3:
                                //IS_ALIVE
                                if (temp_player.name.equalsIgnoreCase(name))
                                {
                                    //manejar de la misma forma que el nombre, porque la estructura de guardar ya está lista
                                    System.out.println("Editar el estado de "+ playerReader);
                                    System.out.println("Ingrese si el jugador esta vivo");
                                    System.out.println("false para indicar que no y true para indicar que sí");
                                    boolean now_is_alive = leer.nextBoolean();
                                    leer.nextLine();
                                    temp_player.is_alive = now_is_alive;
                                    break;
                                }
                            case 4:
                                System.out.println("Terminó la edición");
                                break;
                            default:
                                System.out.println("Ingrese un número que sea válido");
                        }
                    }
                        jugadores += temp_player.playerToCSV() + "\n"; //es lo que se agrega a jugadpres en csv
                }
                    else
                    {
                        //para conservar el registro original
                        jugadores += playerReader + "\n";
                    }
            }
            buffer.close(); //cierra el buffer

            if (!encontrado) //si es difrente al que fue encontrado se envia un mensaje que lo indica
            {
                System.out.println("El jugador a buscar no fue encontrado, verifíque la información ingresada");
            }
            else
            {
                // Sobrescribir el archivo con los datos actualizados
                FileWriter escribirCSV = new FileWriter("players.csv");
                escribirCSV.write(jugadores);
                escribirCSV.close();
                System.out.println("El jugador fue editado");
            }
        }

        catch(Exception e)
        {
            System.out.println("Algo salió mal :(, el jugador no fue encontrado");
            e.printStackTrace();
        }
    }
    public static ArrayList<Equipo> readEquipos() {//metodo para leer los equipos y poder añadir a lo juagadores

        ArrayList<Equipo> equipos = new ArrayList<>();

        try {
            FileReader lector = new FileReader("equipos.csv");
            BufferedReader buffer = new BufferedReader(lector); //lee los jugadores que se estan guardando
            String equiposreader;

            while ((equiposreader = buffer.readLine()) != null) //para leer los jugadores que no estan vacíos, lee todas las lineas
            {
                String[] data_readed = equiposreader.split(",");
                int ID = Integer.parseInt(data_readed[0]); //convierte para que se pueda leer al momento de añadir a equipos
                String teamName = data_readed[1];
                String pais = data_readed[2];

                Equipo nuevoEquipo = new Equipo(ID, teamName, pais);
                equipos.add(nuevoEquipo);
                System.out.println(equiposreader); //muestra los elementos que se están almacenando
            }
            buffer.close(); //cierra la lectura
            System.out.println("Todos los equipos fueron leídos correctamente");

        } catch (IOException e) {
            System.out.println("Algo salió mal :(");
        }
        return equipos;

    }

    public static void asignarJugadores(
            ArrayList<Equipo> equipos,
            ArrayList<Jugador> jugadores) //opraciones para los arreglos
    {
        for (Jugador jugador : jugadores)
        {
            for (Equipo equipo : equipos)
            {
                if (equipo.ID == jugador.IDequipo)
                {
                    equipo.addJugador(jugador); //En caso de que el Id coincida con el Equipo se agregara el jugador mediante la operacion llamada
                    break;
                }
            }
        }
        System.out.println("Jugadores asignados correctamente a sus equipos");
    }
    public static void mostrarEquipos() //metodo para lograr visualizar los equipos
    {
        ArrayList<Equipo> equipos = readEquipos();
        ArrayList<Jugador> jugadores = readPlayers();

        asignarJugadores(equipos, jugadores); //llamar la operacion de asiganr los juagdores

        for (Equipo equipo : equipos) {
            System.out.println("\nEquipo: " + equipo.teamName); //muestra la información del equipo
            System.out.println("País: " + equipo.pais);
            System.out.println("Jugadores: ");

            for (int i = 0; i < equipo.getNj(); i++) {
                Jugador jugador = equipo.getPlantilla()[i]; //para establcer la plantilla segun sea el numero de jugadores
                System.out.println((i + 1) + ". " + jugador.name + " - Dorsal: " + jugador.dorsal); //se muestra de acuerdo a la cantidad
            }
            System.out.println("Plantilla: " + equipo.getNj() + "de 5");
        }
    }
    public static void savePlayers(ArrayList<Jugador> jugadores) { //Metodo llamado de guardar juagdores

        try {
            FileWriter escribir = new FileWriter("players.csv", false); //escribir en el archivo scv

            for (Jugador jugador : jugadores) {
                escribir.write(jugador.playerToCSV());
                escribir.write("\n");
            }
            escribir.close();
            System.out.println("Jugadores enviados a sus equipos correctamente");

        } catch (IOException e) {
            System.out.println("Error al guardar los jugadores");
        }
    }

}