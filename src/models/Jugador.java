package models;

import java.time.LocalDate; //Abre con la fecha actual
import java.time.Period;

public class Jugador extends Persona { //Herencia de persona
    public int dorsal; //atributos para el objeto persona
    public Posicion posicion;
    private LocalDate nacimiento;
    public int ID; //Para iniciar a crear el ID

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento; //arreglar esta parte
    } //metodo que utiliza el set para calcular la edad partiendo de la fecha de nacimiento

    public int getEdad()
    {
         return Period.between(
                nacimiento,
                LocalDate.now()
        ).getYears();//metodo que utiliza el get para devolver la edad que se dtermina con el set
    }
    public int edad = 0;


    @Override //string que muestra la informacion del jugador en conjunto
public String toString() {
    return "models.Jugador{" +
            "dorsal=" + dorsal +
            "} "
            + super.toString();
}


public Jugador(int ID,String nombre, LocalDate nacimiento) //metodo constructor para crear el jugador
{
    this.ID = ID;
    super.name = nombre;
    this.nacimiento=nacimiento;
    this.edad = getEdad(); //PARA YA INDICA EL ID DEL JUGADOR
}

public Jugador() //metodo para crear un jugador vacio
{}

public String playerToCSV () //metodo que retorna la información de los jugadores como archivo CSV
{
    return this.ID + ", " + this.name + ", "+ this.dorsal+", "+ this.edad+", "+ is_alive;
}
}
