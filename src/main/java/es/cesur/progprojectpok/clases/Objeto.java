package es.cesur.progprojectpok.clases;

public class Objeto {

    //Atibutos
    private String nombre;
    private String descripcion;
    private int precio;

    //Constantes
    public static final Objeto ANILLO = new Objeto("anillo", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 1000000 );
    public static final Objeto BASTON = new Objeto("baston", "Aumenta la estamina un 20%, pero disminuye en un 15% la velocidad"
                                                    , 200 );
    public static final Objeto CHALECO = new Objeto("chaleco", "Aumenta la defensa y la defensa especial un 20%, pero disminuye la velocidad y el ataque un 15%"
                                                    , 100 );
    public static final Objeto ETER = new Objeto("eter", " restaura el número de movimientos en un movimiento"
                                                    , 50 );
    public static final Objeto PESA = new Objeto("pesa", "Aumenta el ataque y la defensa un 20%, pero disminuye su velocidad un 20%"
                                                    , 300 );
    public static final Objeto PILA = new Objeto("pila", "Aumenta la recuperación de estamina en un 50%, pero disminuye la defensa especial un 30%"
                                                    , 250 );
    public static final Objeto PLUMA = new Objeto("pluma", "Aumenta la velocidad un 30%, pero disminuye la defensa y la defensa especial en un 20%"
                                                    , 100 );
    public static final Objeto POKEBALL = new Objeto("pokeball", "25 pokedolares"
                                                    , 25 );




    //Constructores
    public Objeto(String nombre, String descripcion, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Objeto() {
        this.nombre = "";
        this.descripcion = "";
        this.precio = 0;
    }

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}



