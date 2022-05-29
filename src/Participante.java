public class Participante {
    private String nombre;
    private int folio;
    private String lugar;
    private Postre postre;

    public Participante(String nombre, int folio, String lugar) {
        this.nombre = nombre;
        this.folio = folio;
        this.lugar = lugar;
    }

    public void setPostre(Postre postre){
        this.postre = postre;
    }
    public int getFolio() {
        return folio;
    }

    public String getLugar() {
        return lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public Postre getPostre() {
        return postre;
    }
}
