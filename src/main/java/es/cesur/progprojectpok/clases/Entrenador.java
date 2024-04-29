package es.cesur.progprojectpok.clases;

public class Entrenador {

    private String nombreEntrenador;
    private Pokemon[] equipo;
    private Pc caja;
    private int pokedollars;
    private Objeto[] listObjetos;

    public Entrenador(String nombreEntrenador, Pokemon[] equipo, Pc caja, int pokedollars, Objeto[] listObjetos) {
        this.nombreEntrenador = nombreEntrenador;
        this.equipo = equipo;
        this.caja = caja;
        this.pokedollars = pokedollars;
        this.listObjetos = listObjetos;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public Pokemon[] getEquipo() {
        return equipo;
    }

    public void setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
    }

    public Pc getCaja() {
        return caja;
    }

    public void setCaja(Pc caja) {
        this.caja = caja;
    }

    public int getPokedollars() {
        return pokedollars;
    }

    public void setPokedollars(int pokedollars) {
        this.pokedollars = pokedollars;
    }

    public Objeto[] getListObjetos() {
        return listObjetos;
    }

    public void setListObjetos(Objeto[] listObjetos) {
        this.listObjetos = listObjetos;
    }

    public void capturar(){

    }





}
