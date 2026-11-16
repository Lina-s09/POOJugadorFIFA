package models;

public class Equipo { //Atributos para equipo
    Tecnico tecnico_equipo;
    Jugador plantilla[]; //arreglo para determinar los jugadores de un equipo

    //atributos para equipo
    public String teamName;
    public int ID;
    public String pais;

    //metodo constructor para desarrollar la creación de equipos
    public Equipo(int ID, String teamName, String pais) {
        this.ID = ID;
        this.teamName = teamName;
        this.pais = pais;
    }

    //para desarrollarlos en un archivo scv
    public String EquiposToSCV ()
    {
        return this.ID + ", " + this.teamName + ", "+ this.pais;
    }
}
