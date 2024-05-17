package es.cesur.progprojectpok.clases;

public class EstadoMov extends Movimiento {

    //Atributos
    private Estado estadoMov;
    private boolean persistente;
    private int numTurnos;


    //Constructores
    public EstadoMov(String nomMovimiento, int pp, Estado estadoMov) {
        super(nomMovimiento, pp);
        this.estadoMov = estadoMov;
    }

    public EstadoMov() {
        super();
        this.estadoMov = null;
        this.persistente = true;
        this.numTurnos = 0;
    }

    //Getters & Setters
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


    /**
     * Establece el estado del pokemon
     * @param pokemonObjetivo
     * @param movimiento
     * @return
     */
    @Override
    public int accionMov(Pokemon pokemonObjetivo, Movimiento movimiento) {

        pokemonObjetivo.setEstadoPok(estadoMov);

        return 0;
        }


    @Override
    public String toString() {
        return "estadoMov{" +
                "estadoMov=" + estadoMov +
                ", persistente=" + persistente +
                ", numTurnos=" + numTurnos +
                ", nomMovimiento='" + nomMovimiento + '\'' +
                ", pp=" + pp +
                '}';
    }
}

