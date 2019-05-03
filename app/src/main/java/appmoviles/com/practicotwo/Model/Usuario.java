package appmoviles.com.practicotwo.Model;

public class Usuario {

    private String id;
    private String genero;
    private String edad ;
    private String superheroe;

    public Usuario() {
    }

    public Usuario(String id, String genero, String edad, String superheroe) {
        this.id = id;
        this.genero = genero;
        this.edad = edad;
        this.superheroe = superheroe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSuperheroe() {
        return superheroe;
    }

    public void setSuperheroe(String superheroe) {
        this.superheroe = superheroe;
    }

}
