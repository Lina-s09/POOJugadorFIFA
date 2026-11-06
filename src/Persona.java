public class Persona { //atributos de persona
    public String name;
    private String country ;
    private String id ;
    public boolean is_alive = true;

    public String getCountry(){
        return country;
    } //get para devolver el pais que es un dato privado

    public void setCountry(String newCountry){
        this.country=newCountry;
    }

    @Override
    public String toString() { //string completo de all lo de persona
        return "Persona{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", is_alive=" + is_alive +
                '}';
    }




}
