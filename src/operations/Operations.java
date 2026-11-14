package operations;

//Librerías

import models.Jugador;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Operations
{
    public static void savePlayer(Jugador jugadorToSave) { //Metodo para escribir los jugadores
        try {
            FileWriter escribir = new FileWriter("players.csv",true); //Para guardar los jugadores, que se escriben, creando el objeto de ese tipo
            //escribir.write(jugadorToSave.playerToCSV());
            escribir.write(jugadorToSave.playerToCSV()); //es la unica que permite almacenar una cantidad de jugadores
            escribir.write("\n"); //para un salto de línea
            escribir.close();
            System.out.println("El jugador fue guardado correctamente"); //mensaje para indicar que salió bien

        } catch (IOException e) {
            System.out.println("Algo anda mal :("); //mensaje de error
        }
    }
    public static void readPlayers() {
        try {
            FileReader lector = new FileReader("players.csv");
            BufferedReader buffer = new BufferedReader(lector); //lee los jugadores que se estan guardando
            String playerReader;

            while ((playerReader = buffer.readLine()) != null) //para leer los jugadores que no estan vacíos, lee todas las lineas
            {
                System.out.println(playerReader); //muestra los elementos que se están almacenando
            }
            buffer.close(); //cierra la lectura
            System.out.println("Todos los jugadores fueron leídos correctamente");

        } catch (IOException e) {
            System.out.println("Algo salió mal :(");
        }
    }
    public static void readOnePlayer (String name) //metodo para leer un jugador, recibiendo el parametro de nombre
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
                temp_player.name = data_readed[0]; //posicion de como se muestran en un tipo de arreglo
                temp_player.dorsal = Integer.parseInt(data_readed[1]); //aqui pasa a ser un string
                int edad = Integer.parseInt(data_readed[2]);
                temp_player.is_alive = Boolean.parseBoolean(data_readed[3]);

                //para detrminar que los uygadores se estén leyendo correctamnete
                   // System.out.println("Nombre leido "+ temp_player.name);
                   // System.out.println("Nombre buscado"+ name);

                if (temp_player.name.equals(name)) { //Indica la igualdad para encontra al jugado por el nombre ingresado
                    encontrado = true; //establece que el jugador si es encontrado es verdadero
                    System.out.println("El jugador encontrado es: "+ playerReader);
                    break;
                }
            }
            buffer.close(); //cierra el buffer
            System.out.println("Finalizó la búsqueda");

            if (!encontrado) //si es difrente al que fue encontrado se envia un mensaje que lo indica
            {
                System.out.println("El jugador a buscar no fue encontrado, verifíque la información ingresada");
            }
        }

            catch(Exception e)
            {
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
                     temp_player.name = data_readed[0]; //posicion de como se muestran en un tipo de arreglo
                     temp_player.dorsal = Integer.parseInt(data_readed[1]); //aqui pasa a ser un string
                     int edad = Integer.parseInt(data_readed[2]);
                     temp_player.is_alive = Boolean.parseBoolean(data_readed[3]);

                     //para detrminar que los jugadores se estén leyendo correctamnete
                     // System.out.println("Nombre leido "+ temp_player.name);
                     // System.out.println("Nombre buscado"+ name);

                     if (temp_player.name.equals(name)) {
                         //System.out.println("El jugador encontrado es: "+ playerReader);
                         encontrado = true;
                         System.out.println("¿Desea borrar este jugador? " + playerReader); //Preguntar de encontrar el jugador
                         System.out.println("Indicar SI en caso de ser así");
                         String decidir = leer.nextLine();

                         if (decidir.equalsIgnoreCase("SI")) //Ignora las mayúsculas y minúsculas
                         {
                             System.out.println("Se eliminará el jugador seleccionado");
                         }
                         else
                         {
                             System.out.println("Se canceló la operación, el jugador no será eliminado");
                             jugadores += playerReader + "\n";
                         }
                     }

                     else
                     {
                         jugadores += playerReader + "\n"; //se almacenan los jugadores si no son los que se están buscando, adicioanlmente para seguir siendo guardados se agrega el salto de línea
                     }
                 }
                 buffer.close(); //cierra el buffer

                 //Para almacenarlos en el CSV
                 FileWriter escribirCSV = new FileWriter("players.csv"); //para indicar que entre al archivo scv
                 escribirCSV.write(jugadores); //que escriba sobre jugadores a los jugadores que ya están
                 escribirCSV.close(); //cerrar

                 if (!encontrado)
                 {
                     System.out.println("No se encontró el jugador que se estaba buscando, ingrese su nombre nuevamente");
                 }
             }
             catch(Exception e)
             {
                 //System.out.println("Algo salió mal :(");
                 e.printStackTrace();
             }

        }
        public static void EditarPlayer(String name)
        {
            try {
                //Para leer el jugador
                FileReader lector = new FileReader("players.csv"); //entra al archivo de jugadores de csv, paar leer los jugadores
                BufferedReader buffer = new BufferedReader(lector);
                String playerReader;
                Scanner leer = new Scanner(System.in);

                Boolean encontrado = false; //Se utiliza para determinar que el jugador fue leído o no, y establecer las condiciones para enviar los mensajes por la salida

                while ((playerReader = buffer.readLine()) != null) { //para recorrer todas las lineas de jugares y leerlas
                    // System.out.println("Linea encontrada"+ playerReader);
                    String[] data_readed = playerReader.split(",\\s*"); //divide ña cadena en comas
                    Jugador temp_player = new Jugador(); //se crea un jugador temporal, con las características que indica para ser guardado
                    temp_player.name = data_readed[0]; //posicion de como se muestran en un tipo de arreglo
                    temp_player.dorsal = Integer.parseInt(data_readed[1]); //aqui pasa a ser un string
                    int edad = Integer.parseInt(data_readed[2]);
                    temp_player.is_alive = Boolean.parseBoolean(data_readed[3]);

                    if (temp_player.name.equals(name)) { //Indica la igualdad para encontra al jugado por el nombre ingresado
                        encontrado = true; //establece que el jugador si es encontrado es verdadero
                        System.out.println("El jugador encontrado es: "+ playerReader);
                        System.out.println(
                                "¿Qué desea editar del jugador?" +
                                "1. Nombre" +
                                "2. Dorsal" +
                                "3. Edad" +
                                "4. Definir si están vivos" +
                                "5. Nada"); //indicar una especie de menú para indicar que se busca cambiar de un jugador

                        int editplyr = leer.nextInt(); //leer la opción del jugador
                        while (editplyr != 5) //establecer un while para que se puedan editar varias cosas sin que se cierre tras una
                        {
                            switch (editplyr)
                            {
                                case 1:
                                    //nombre
                                    break;
                                case 2:
                                    //dorsal
                                    break;
                                case 3:
                                    //edad
                                    break;
                                case 4:
                                    //is_alive
                                    break;
                                default:
                                    System.out.println("Ingrese un número que sea válido");
                            }
                        }
                    }
                }
                buffer.close(); //cierra el buffer
                System.out.println("Finalizó la búsqueda");

                if (!encontrado) //si es difrente al que fue encontrado se envia un mensaje que lo indica
                {
                    System.out.println("El jugador a buscar no fue encontrado, verifíque la información ingresada");
                }
            }

            catch(Exception e)
            {
                System.out.println("Algo salió mal :(, el jugador no fue encontrado");
                e.printStackTrace();
            }

        }
    }

