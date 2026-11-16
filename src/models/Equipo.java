package models;

public class Equipo { //Atributos para equipo
    Tecnico tecnico_equipo;
    Jugador plantilla[]; //arreglo para determinar los jugadores de un equipo

    //atributos para equipo
    public String teamName;
    public int ID;
    public String pais;
    int nj = 0; //Cantidad de jugadores

    //metodo constructor para desarrollar la creación de equipos
    public Equipo(int ID, String teamName, String pais) {
        this.ID = ID;
        this.teamName = teamName;
        this.pais = pais;
        this.plantilla = new Jugador [5];
    }

    //Crear metodo para añadir a los jugadores, como una especie de contador e acuerdo al espacio que en este caso es 5
    public void  addJugador(Jugador jugador)
    {
        if (nj<5) //para la cantidad de jugadoes que se tienen
        {
            plantilla[nj] = jugador; //la palntilla para agregarlos po arreglos
            nj ++;
        }
        else
        {
            System.out.println("El equipo ya cuenta con los jugadores completos");
        }
    }

    //para desarrollarlos en un archivo scv
    public String EquiposToSCV ()
    {
        return this.ID + ", " + this.teamName + ", "+ this.pais;
    }
    public Jugador[] getPlantilla() {
        return plantilla;
    }

    public int getNj() {
        return nj;
    }

}
