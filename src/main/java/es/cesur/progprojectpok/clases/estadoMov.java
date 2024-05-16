package es.cesur.progprojectpok.clases;

public class estadoMov extends Movimiento {

    private Estado estadoMov;
    private boolean persistente;
    private int numTurnos;


    public estadoMov(String nomMovimiento, int pp, Estado estadoMov) {
        super(nomMovimiento, pp);
        this.estadoMov = estadoMov;
    }

    public estadoMov() {
        super();
        this.estadoMov = null;
        this.persistente = true;
        this.numTurnos = 0;
    }

    public Estado getEstadoMov() {
        return estadoMov;
    }

    public void setEstadoMov(Estado estadoMov) {
        this.estadoMov = estadoMov;
    }

    public boolean isPersistente() {
        return persistente;
    }

    public void setPersistente(boolean persistente) {
        this.persistente = persistente;
    }

    public int getNumTurnos() {
        return numTurnos;
    }

    public void setNumTurnos(int numTurnos) {
        this.numTurnos = numTurnos;
    }

    @Override
    public int accionMov(Pokemon pokemonObjetivo, Movimiento movimiento) {

        pokemonObjetivo.setEstadoPok(estadoMov);

        return 0;
        }
    }

