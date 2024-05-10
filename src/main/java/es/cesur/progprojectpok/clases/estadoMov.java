package es.cesur.progprojectpok.clases;

public class estadoMov extends Movimiento {

    private Estado estadoMov;
    private boolean persistente;
    private int numTurnos;


    public estadoMov(String nomMovimiento, int pp, int precision, int prioridad, Estado estadoMov, boolean persistente, int numTurnos) {
        super(nomMovimiento, pp, precision, prioridad);
        this.estadoMov = estadoMov;
        this.persistente = persistente;
        this.numTurnos = numTurnos;
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
    public void accionMov(Pokemon pokemonObjetivo) {

        pokemonObjetivo.setEstadoPok(estadoMov);

        }
    }

