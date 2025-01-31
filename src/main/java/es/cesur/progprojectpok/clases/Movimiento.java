package es.cesur.progprojectpok.clases;

public abstract class Movimiento {

    //Atributos
    protected String nomMovimiento;
    protected int pp;
    protected int precision;
    protected int prioridad;


    //Constructores
    public Movimiento(String nomMovimiento, int pp) {
        super();
        this.nomMovimiento = nomMovimiento;
        this.pp = pp;

    }

    public Movimiento() {
        super();
        this.nomMovimiento = "";
        this.pp = 0;
        this.precision = 0;
        this.prioridad = 0;
    }


    //Getters & Setters
    public String getNomMovimiento() {
        return nomMovimiento;
    }

    public void setNomMovimiento(String nomMovimiento) {
        this.nomMovimiento = nomMovimiento;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public abstract int accionMov(Pokemon pokemonObjetivo, Movimiento movimiento);

}
