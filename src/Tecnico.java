public class Tecnico extends Persona{ //atributos de tecnico que extiende de persona
    public String club;

    @Override //string grande de la informacion de tecnico
    public String toString() {
        return "Tecnico{" +
                "club='" + club + '\'' +
                "} " + super.toString();
    }
}

