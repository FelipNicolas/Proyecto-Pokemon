package es.cesur.progprojectpok.clases;

public class Objeto {


    private String nombre;
    private String descripcion;
    private int precio;

    public static final Objeto ANILLO = new Objeto("anillo", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 1000000 );
    public static final Objeto BASTON = new Objeto("baston", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 200 );
    public static final Objeto CHALECO = new Objeto("chaleco", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 100 );
    public static final Objeto ETER = new Objeto("eter", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 50 );
    public static final Objeto PESA = new Objeto("pesa", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 300 );
    public static final Objeto PILA = new Objeto("pila", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 250 );
    public static final Objeto PLUMA = new Objeto("pluma", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 100 );
    public static final Objeto POKEBALL = new Objeto("pokeball", "vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer daño, su ataque aumento *10"
                                                    , 25 );





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



