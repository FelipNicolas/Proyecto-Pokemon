package es.cesur.progprojectpok.clases;

public class mejoraMov extends Movimiento{

    private int mejoraStat;
    private String nombreStat;
    private int numTurnos;

    public mejoraMov(String nomMovimiento, int pp, int precision, int prioridad, int mejoraStat, String nombreStat, int numTurnos) {
        super(nomMovimiento, pp, precision, prioridad);
        this.mejoraStat = mejoraStat;
        this.nombreStat = nombreStat;
        this.numTurnos = numTurnos;
    }

    public mejoraMov() {
        super();
        this.mejoraStat = 0;
        this.nombreStat = "";
        this.numTurnos = 0;
    }

    @Override
    public int accionMov(Pokemon pokemonObjetivo, Movimiento movimiento) {


        switch (nombreStat) {

            case "ataque":
                pokemonObjetivo.setPtsAtaque(mejoraStat);
                break;
            case "ataqueEspecial":
                pokemonObjetivo.setPtsAtaqueEsp(mejoraStat);
                break;
            case "defensa":
                pokemonObjetivo.setPtsDefensa(mejoraStat);
                break;
            case "defensaEspecial":
                pokemonObjetivo.setPtsDefensaEsp(mejoraStat);
                break;
            case "velocidad":
                pokemonObjetivo.setVelocidadPok(mejoraStat);
                break;
        }
        return mejoraStat;
    }


    public int getMejoraStat() {
        return mejoraStat;
    }

    public void setMejoraStat(int mejoraStat) {
        this.mejoraStat = mejoraStat;
    }

    public String getNombreStat() {
        return nombreStat;
    }

    public void setNombreStat(String nombreStat) {
        this.nombreStat = nombreStat;
    }

    public int getNumTurnos() {
        return numTurnos;
    }

    public void setNumTurnos(int numTurnos) {
        this.numTurnos = numTurnos;
    }




}
