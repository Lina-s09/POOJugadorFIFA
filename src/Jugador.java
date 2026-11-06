import java.time.LocalDate; //Abre con la fecha actual
import java.time.Period;

public class Jugador extends Persona { //Herencia de persona
    public int dorsal; //atributos para el objeto persona
    public Posicion posicion;
    private LocalDate nacimiento;

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento; //arreglar esta parte
    } //metodo que utiliza el set para calcular la edad partiendo de la fecha de nacimiento

    public int getEdad()
    {
         return Period.between(
                nacimiento,
                LocalDate.now()
        ).getYears();
        //metodo que utiliza el get para devolver la edad que se dtermina con el set
    }


    @Override //string que muestra la informacion del jugador en conjunto
    public String toString() {
        return "Jugador{" +
                "dorsal=" + dorsal +
                "} "
                + super.toString();
    }


    public Jugador(String nombre, LocalDate nacimiento) //metodo constructor para crear el jugador
    {
        super.name=nombre;
        this.nacimiento=nacimiento;
    }

    public Jugador() //metodo para crear un jugador vacio
    {}

    public String playerToCSV () //metodo que retorna la información de los jugadores como archivo CSV
    {
        return this.name + ", "+this.dorsal+", "+this.getEdad()+", "+is_alive;
    }
}
