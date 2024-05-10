package es.cesur.progprojectpok.clases;

public class ataqueMov extends Movimiento{

    private int potenciaMov;
    private Tipos tipoMov;

    public ataqueMov(String nomMovimiento, int pp, int precision, int prioridad, int potenciaMov, Tipos tipoMov) {
        super(nomMovimiento, pp, precision, prioridad);
        this.potenciaMov = potenciaMov;
        this.tipoMov = tipoMov;
    }

    public ataqueMov() {
        super();
        this.potenciaMov = 0;
        this.tipoMov = null;
    }

    @Override
    public void accionMov(Pokemon pokemonObjetivo) {



    }


    public void dañoAtaque(Pokemon pokemonObjetivo, Movimiento movimiento) {

        int valorAtaque;
        int valorDefensa;

    }

        public static double calcularMultiplicador(Tipos tipoAtaque, Tipos tipoPok ) {

            // Matriz de efectividad de los ataques
            double[][] efectividad = {

                    //   NOR   FUE   AGU   PLA   ELE   HIE   LUC   VEN   TIE   VOL   PSÍ   BIC   ROC   FAN   DRA   SIN   ACE
                        { 1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.0,  1.0,  1.0,  1.0   }, // NORMAL
                        { 1.0,  0.5,  0.5,  2.0,  1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  0.5,  1.0,  0.5   }, // FUEGO
                        { 1.0,  2.0,  0.5,  0.5,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  1.0,  1.0,  2.0,  1.0,  0.5,  1.0,  1.0   }, // AGUA
                        { 1.0,  0.5,  2.0,  0.5,  1.0,  1.0,  1.0,  1.0,  0.5,  2.0,  1.0,  1.0,  1.0,  1.0,  0.5,  1.0,  1.0   }, // PLANTA
                        { 1.0,  1.0,  2.0,  0.5,  0.5,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  1.0,  1.0,  1.0,  0.5,  1.0,  1.0   }, // ELÉCTRICO
                        { 1.0,  0.5,  0.5,  2.0,  1.0,  0.5,  1.0,  1.0,  2.0,  2.0,  1.0,  1.0,  2.0,  1.0,  0.5,  1.0,  1.0   }, // HIELO
                        { 2.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  0.5,  1.0,  0.5,  0.5,  0.5,  2.0,  0.0,  1.0,  2.0,  2.0   }, // LUCHA
                        { 1.0,  1.0,  1.0,  2.0,  1.0,  1.0,  1.0,  0.5,  0.5,  1.0,  1.0,  1.0,  1.0,  0.5,  1.0,  2.0,  1.0   }, // VENENO
                        { 1.0,  2.0,  1.0,  2.0,  0.0,  2.0,  1.0,  2.0,  1.0,  0.5,  1.0,  0.5,  2.0,  1.0,  1.0,  1.0,  2.0   }, // TIERRA
                        { 1.0,  1.0,  1.0,  0.5,  2.0,  1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  1.0,  1.0,  0.5   }, // VOLADOR
                        { 1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  2.0,  1.0,  1.0,  0.5,  1.0,  1.0,  1.0,  1.0,  0.0,  0.5   }, // PSÍQUICO
                        { 1.0,  0.5,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  2.0,  1.0,  2.0,  1.0,  2.0,  1.0,  1.0,  1.0,  0.5   }, // BICHO
                        { 1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  0.5,  2.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.5   }, // ROCA
                        { 0.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  0.5,  1.0   }, // FANTASMA
                        { 1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.5,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  1.0   }, // DRAGÓN
                        { 1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  0.5,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  1.0,  1.0,  0.5,  0.5   }, // SINIESTRO
                        { 1.0,  0.5,  0.5,  0.5,  1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  0.5   }, // ACERO

            };

            int indiceAtaque = tipoAtaque.ordinal();
            int indicePokemon = tipoPok.ordinal();

            double multiplicador = efectividad[indiceAtaque][indicePokemon];

            // Devolver el multiplicador de daño
            if (multiplicador == 0.0) {
                // Si es 0.0, el ataque no tiene efecto
                return 0.0;
            } else if (multiplicador == 0.5) {
                // Si es 0.5, el ataque es poco efectivo
                return 0.5;
            } else if (multiplicador == 2.0) {
                // Si es 2.0, el ataque es super efectivo
                return 2.0;
            } else {
                // De lo contrario, el ataque es normalmente efectivo
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
}
