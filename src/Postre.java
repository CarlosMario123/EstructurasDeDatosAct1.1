public class Postre {

        private int folio = 0;
        private String nombre;
        private String[] ingredientes;



        public Postre(int folio, String ingredientes[],String nombre) {
            this.folio = folio;
            this.nombre = nombre;
            this.ingredientes = ingredientes;
        }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }
}
