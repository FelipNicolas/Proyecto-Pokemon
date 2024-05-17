package es.cesur.progprojectpok.clases;

public class AtaqueMov extends Movimiento{

    //Atributos
    private int potenciaMov;
    private Tipos tipoMov;

    private String categoriaMov;
    private String tipoMovimientoEst;

    public static final double INMUNE = 0.0;
    public static final double SUPER_EFICAZ = 2.0;
    public static final double POCO_EFICAZ = 0.5;
    public static final double NORMAL = 1.0;

    //Constructores
    public AtaqueMov(String nomMovimiento, int pp,int potenciaMov, Tipos tipoMov, String categoriaMov, String tipoMovimientoEst) {
        super(nomMovimiento, pp);
        this.potenciaMov = potenciaMov;
        this.tipoMov = tipoMov;
        this.categoriaMov = categoriaMov;
        this.tipoMovimientoEst = tipoMovimientoEst;
    }

    public AtaqueMov() {
        super();
        this.potenciaMov = 0;
        this.tipoMov = null;
        this.categoriaMov = "fisico";
    }

    /**
     *
     * @param pokemonObjetivo
     * @param movimiento
     * @return
     */
    @Override
    public int accionMov(Pokemon pokemonObjetivo, Movimiento movimiento) {

        return 0;
    }


    /**
     * Calcular daño
     * @param pokemonObjetivo
     * @param movimiento
     * @return
     */
    public int danoAtaque(Pokemon pokemonObjetivo, AtaqueMov movimiento) {


        int valorAtaque = movimiento.getPotenciaMov();

     return valorAtaque;
    }

    /**
     *  Calcular multiplicador ataque con matriz e indice
     * @param tipoAtaque
     * @param tipoPok1
     * @param tipoPok2
     * @return
     */
    public static double calcularMultiplicador(Tipos tipoAtaque, Tipos tipoPok1, Tipos tipoPok2 ) {

                // Matriz de efectividad de los ataques
                double[][] efectividad = {


                        // Fila tipo pokemon
                        //   NOR   FUE   AGU   PLA   ELE   HIE   LUC   VEN   TIE   VOL   PSÍ   BIC   ROC   FAN   DRA   SIN   ACE
                        { 1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.0,  1.0,  1.0,  1.0   }, // NORMAL
                        { 1.0,  0.5,  0.5,  2.0,  1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  0.5,  1.0,  0.5   }, // FUEGO
                        { 1.0,  2.0,  0.5,  0.5,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  1.0,  1.0,  2.0,  1.0,  0.5,  1.0,  1.0   }, // AGUA
                        { 1.0,  0.5,  2.0,  0.5,  1.0,  1.0,  1.0,  1.0,  0.5,  2.0,  1.0,  1.0,  1.0,  1.0,  0.5,  1.0,  1.0   }, // PLANTA
                        { 1.0,  1.0,  2.0,  0.5,  0.5,  1.0,  1.0,  1.0,  0.0,  2.0,  1.0,  1.0,  1.0,  1.0,  0.5,  1.0,  1.0   }, // ELÉCTRICO
                        { 1.0,  0.5,  0.5,  2.0,  1.0,  0.5,  1.0,  1.0,  2.0,  2.0,  1.0,  1.0,  2.0,  1.0,  0.5,  1.0,  1.0   }, // HIELO
                        { 2.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  0.5,  1.0,  0.5,  0.5,  0.5,  2.0,  0.0,  1.0,  2.0,  2.0   }, // LUCHA
                        { 1.0,  1.0,  1.0,  2.0,  1.0,  1.0,  1.0,  0.5,  0.5,  1.0,  1.0,  1.0,  1.0,  0.5,  1.0,  2.0,  1.0   }, // VENENO
                        { 1.0,  2.0,  1.0,  2.0,  0.0,  2.0,  1.0,  2.0,  1.0,  0.5,  1.0,  0.5,  2.0,  1.0,  1.0,  1.0,  2.0   }, // TIERRA
                        { 1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  1.0,  1.0,  0.5   }, // VOLADOR
                        { 1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  2.0,  1.0,  1.0,  0.5,  1.0,  1.0,  1.0,  1.0,  0.0,  0.5   }, // PSÍQUICO
                        { 1.0,  0.5,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  2.0,  1.0,  2.0,  1.0,  2.0,  1.0,  1.0,  1.0,  0.5   }, // BICHO
                        { 1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  0.5,  2.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.5   }, // ROCA
                        { 0.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  0.5,  1.0   }, // FANTASMA
                        { 1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.5,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  1.0   }, // DRAGÓN
                        { 1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  1.0,  1.0,  0.5,  0.5   }, // SINIESTRO
                        { 1.0,  0.5,  0.5,  0.5,  1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  0.5   }, // ACERO

            };


            int indiceAtaque = tipoAtaque.ordinal();
            int indicePokemon1 = tipoPok1.ordinal();
            int indicePokemon2 = tipoPok2 != null ? tipoPok2.ordinal() : -1;

            // Calcular el multiplicador de efectividad
            double multiplicador = 1.0;
            if (indicePokemon2 != -1) {
                // Si el Pokémon tiene un doble tipo, se calcula la efectividad considerando ambos tipos
                multiplicador = efectividad[indiceAtaque][indicePokemon1] * efectividad[indiceAtaque][indicePokemon2];
            } else {
                // Si el Pokémon tiene un solo tipo, se calcula la efectividad normalmente
                multiplicador = efectividad[indiceAtaque][indicePokemon1];
            }

            // Devolver el multiplicador de daño
            if (multiplicador == 0.0) {
                System.out.println("Ataque inmune" + 0.0);
                return 0.0;
            } else if (multiplicador == 2.0) {
                System.out.println("Ataque super eficaz" + 2.0);
                return 2.0;
            } else {
                System.out.println("Ataque normal" + 1.0);
                return 1.0;
            }
    }




    public int getPotenciaMov() {
        return potenciaMov;
    }

    public void setPotenciaMov(int potenciaMov) {
        this.potenciaMov = potenciaMov;
    }

    public Tipos getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(Tipos tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getCategoriaMov() {
        return categoriaMov;
    }

    public void setCategoriaMov(String categoriaMov) {
        this.categoriaMov = categoriaMov;
    }


    @Override
    public String toString() {
        return "AtaqueMov{" +
                "potenciaMov=" + potenciaMov +
                ", tipoMov=" + tipoMov +
                ", categoriaMov='" + categoriaMov + '\'' +
                ", nomMovimiento='" + nomMovimiento + '\'' +
                ", pp=" + pp +
                '}';
    }
}


