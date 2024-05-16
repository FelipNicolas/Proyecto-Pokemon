package es.cesur.progprojectpok.clases;

import es.cesur.progprojectpok.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

public class Pokemon {


    private String motePok;

    private String nombrePok;

    private String urlImgPok;

    private int numPokedex;

    private int vitalidadPok;
    private int ptsAtaque;
    private int ptsDefensa;
    private int ptsAtaqueEsp;
    private int ptsDefensaEsp;
    private int velocidadPok;
    private int nivelPok = 1;
    private Movimiento[] setMovimientos = new Movimiento[4];
    private int fertilidad = 5;

    public Movimiento[] getSetMovimientos() {
        return setMovimientos;
    }

    public String getNombreMov(int num) {
        return setMovimientos[num].getNomMovimiento();
    }

    public void setSetMovimientos(Movimiento[] setMovimientos) {
        this.setMovimientos = setMovimientos;
    }

    private String sexoPok;
    private Objeto objeto;
    private Estado estadoPok;
    private int experiencia;
    private Tipos tipoPok1;
    private Tipos tipoPok2;

    private String nomPokRandom;
    private int vidaPokRandom;
    private String imgPokRandom;

    private String[] imgPok = new String[6];

    private int[] vidaPivote = new int[6];

    private String[] nomPok = new String[6];

    private int[] numPokedexRival = new int[6];

    private String[] nomPokemonRival = new String[6];
    private String[] imagenUrlPokemonGeneradoRival = new String[6];


    private Tipos[] tipo1Rival = new Tipos[6];

    private Tipos[] tipo2Rival = new Tipos[6];

    private int idPokRival;

    private int[] potenciaMov = new int[4];
    private int[] pp = new int[4];

    private String[] categoriaMov = new String[4];
    private Tipos[] tipoMov = new Tipos[4];

    private String[] estadoMov = new String[4];

    private int[] cantMejora = new int[4];
    private String[] statMejora = new String[4];
    private Movimiento[] movimientos;

    private String[] nombreMov = new String[4];

    private Estado[] estadoMovSaludable = new Estado[4];

    private boolean vivo = true;




    public Pokemon(String motePok, int vitalidadPok, int ptsAtaque, int ptsDefensa, int ptsAtaqueEsp, int ptsDefensaEsp, int velocidadPok,
                   int nivelPok, Movimiento[] setMovimientos, int fertilidad, String sexoPok, Objeto objeto, int experiencia, Tipos tipoPok1, Tipos tipoPok2, Estado estadoPok) {

        this.motePok = motePok;
        this.vitalidadPok = vitalidadPok;
        this.ptsAtaque = ptsAtaque;
        this.ptsDefensa = ptsDefensa;
        this.ptsAtaqueEsp = ptsAtaqueEsp;
        this.ptsDefensaEsp = ptsDefensaEsp;
        this.velocidadPok = velocidadPok;
        this.nivelPok = nivelPok;
        this.setMovimientos = setMovimientos;
        this.fertilidad = fertilidad;
        this.sexoPok = sexoPok;
        this.objeto = objeto;
        this.experiencia = experiencia;
        this.estadoPok = estadoPok;

        this.tipoPok1 = tipoPok1;
        this.tipoPok2 = tipoPok2;
    }

    public Pokemon() {

        this.motePok = "";
        this.vitalidadPok = 0;
        this.ptsAtaque = 0;
        this.ptsDefensa = 0;
        this.ptsAtaqueEsp = 0;
        this.ptsDefensaEsp = 0;
        this.velocidadPok = 0;
        this.nivelPok = 1;
        this.fertilidad = 5;
        this.sexoPok = "M";
        this.objeto = objeto;
        this.experiencia = 0;
        this.tipoPok1 = null;
        this.tipoPok2 = null;
        this.estadoPok = null;

    }



    public Pokemon(String nombrePok, Tipos tipoPok1, Tipos tipoPok2, int numPokedex, String urlImgPok) {

        this.nombrePok = nombrePok;
        this.numPokedex = numPokedex;
        this.urlImgPok = urlImgPok;
        this.vitalidadPok = 100;
        this.ptsAtaque = 0;
        this.ptsDefensa = 0;
        this.ptsAtaqueEsp = 0;
        this.ptsDefensaEsp = 0;
        this.velocidadPok = 0;
        this.nivelPok = 1;
        this.tipoPok1 = tipoPok1;
        this.tipoPok2 = tipoPok2;
        this.estadoPok = Estado.SALUDABLE;

    }

    public Pokemon(String nombrePok, Tipos tipoPok1, Tipos tipoPok2, int numPokedex, String urlImgPok, Movimiento[] setMovimientos) {

        this.nombrePok = nombrePok;
        this.numPokedex = numPokedex;
        this.urlImgPok = urlImgPok;
        this.vitalidadPok = 100;
        this.ptsAtaque = 0;
        this.ptsDefensa = 0;
        this.ptsAtaqueEsp = 0;
        this.ptsDefensaEsp = 0;
        this.velocidadPok = 0;
        this.nivelPok = 1;
        this.tipoPok1 = tipoPok1;
        this.tipoPok2 = tipoPok2;
        this.estadoPok = null;
        this.setMovimientos = setMovimientos;


    }

    public Pokemon(int ptsAtaque, int ptsDefensa, int ptsAtaqueEsp, int ptsDefensaEsp, int velocidadPok,
                   Objeto objeto, Estado estadoPok) {

        this.ptsAtaque = ptsAtaque;
        this.ptsDefensa = ptsDefensa;
        this.ptsAtaqueEsp = ptsAtaqueEsp;
        this.ptsDefensaEsp = ptsDefensaEsp;
        this.velocidadPok = velocidadPok;
        this.objeto = objeto;
        this.estadoPok = estadoPok;
    }

    public Pokemon(String nombrePok, int ptsAtaque, int ptsDefensa, int ptsAtaqueEsp,
                   int ptsDefensaEsp, int velocidadPok, int nivelPok, String sexoPok, Objeto objeto, Estado estadoPok,
                   int experiencia, Tipos tipoPok1, Tipos tipoPok2) {
        this.nombrePok = nombrePok;
        this.tipoPok1 = tipoPok1;
        this.tipoPok2 = tipoPok2;
        this.ptsAtaque = ptsAtaque;
        this.ptsAtaqueEsp = ptsAtaqueEsp;
        this.ptsDefensa = ptsDefensa;
        this.ptsDefensaEsp = ptsDefensaEsp;
        this.velocidadPok = velocidadPok;
        this.nivelPok = nivelPok;
        this.sexoPok = sexoPok;
        this.objeto = objeto;
        this.estadoPok = estadoPok;
        this.experiencia = experiencia;
    }


    public String getNombrePok() {
        return nombrePok;
    }

    public void setNombrePok(String nombrePok) {
        this.nombrePok = nombrePok;
    }

    public Estado getEstadoPok() {
        return estadoPok;
    }

    public void setEstadoPok(Estado estadoPok) {
        this.estadoPok = estadoPok;
    }

    public Tipos getTipoPok1() {
        return tipoPok1;
    }

    public void setTipoPok1(Tipos tipoPok1) {
        this.tipoPok1 = tipoPok1;
    }

    public Tipos getTipoPok2() {
        return tipoPok2;
    }

    public void setTipoPok2(Tipos tipoPok2) {
        this.tipoPok2 = tipoPok2;
    }

    public String getMotePok() {
        return motePok;
    }

    public void setMotePok(String motePok) {
        this.motePok = motePok;
    }

    public int getVitalidadPok() {
        return vitalidadPok;
    }

    public void setVitalidadPok(int vitalidadPok) {
        this.vitalidadPok = vitalidadPok;
    }

    public int getPtsAtaque() {
        return ptsAtaque;
    }

    public void setPtsAtaque(int ptsAtaque) {
        this.ptsAtaque = ptsAtaque;
    }

    public int getPtsDefensa() {
        return ptsDefensa;
    }

    public void setPtsDefensa(int ptsDefensa) {
        this.ptsDefensa = ptsDefensa;
    }

    public int getPtsAtaqueEsp() {
        return ptsAtaqueEsp;
    }

    public void setPtsAtaqueEsp(int ptsAtaqueEsp) {
        this.ptsAtaqueEsp = ptsAtaqueEsp;
    }

    public int getPtsDefensaEsp() {
        return ptsDefensaEsp;
    }

    public void setPtsDefensaEsp(int ptsDefensaEsp) {
        this.ptsDefensaEsp = ptsDefensaEsp;
    }

    public int getVelocidadPok() {
        return velocidadPok;
    }

    public void setVelocidadPok(int velocidadPok) {
        this.velocidadPok = velocidadPok;
    }

    public int getNivelPok() {
        return nivelPok;
    }

    public void setNivelPok(int nivelPok) {
        this.nivelPok = nivelPok;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public String getSexoPok() {
        return sexoPok;
    }

    public void setSexoPok(String sexoPok) {
        this.sexoPok = sexoPok;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }



    public float atacar(Pokemon pokObjetivo, Movimiento ataque) {


        if (ataque instanceof mejoraMov) {

            ataque.accionMov(this, ataque);

        } else if (ataque instanceof estadoMov) {

            ataque.accionMov(pokObjetivo, ataque);

        } else if (ataque instanceof AtaqueMov){

            if (((AtaqueMov) ataque).getCategoriaMov().equals("Físico")){

                int danioTotal = ((ataque.accionMov(pokObjetivo, ataque) + this.getPtsAtaque()) - pokObjetivo.getPtsDefensa() );

                pokObjetivo.setVitalidadPok(pokObjetivo.getVitalidadPok() - danioTotal);

            } else if (((AtaqueMov) ataque).getCategoriaMov().equals("Especial")) {

                int danioTotal = ((ataque.accionMov(pokObjetivo, ataque) + this.getPtsAtaqueEsp()) - pokObjetivo.getPtsDefensaEsp() );
                pokObjetivo.setVitalidadPok(pokObjetivo.getVitalidadPok() - danioTotal);
                System.out.println(this.getNombrePok() + " ataco a " + pokObjetivo.getNombrePok() + " con el movimiento: " + ataque.getNomMovimiento());

            }

        }
        return pokObjetivo.getVitalidadPok();
    }


    public void funcionalidadCombate(Pokemon pokRival, int contador) {


        if (this.getVelocidadPok() > pokRival.getVelocidadPok()) {

            this.atacar(pokRival, this.setMovimientos[contador]);
            pokRival.atacar(this, pokRival.setMovimientos[contador]);

        } else {

            pokRival.atacar(this, pokRival.setMovimientos[contador]);
            this.atacar(pokRival, this.setMovimientos[contador]);
        }


    }






    public void subirNivel(int expPok) {

         int subirNivel = 10 * nivelPok;

        while (expPok >= (subirNivel)) {
                nivelPok++;
                expPok -= subirNivel;
        }

    }



    public void aprenderMovimiento(Movimiento movAprender)
    {
    }

    public void capturar(Pokemon pokeCaptura)
    {
    }

    public void crearMovEquipoRival(Pokemon pokemon) {

        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        String sql = "SELECT * FROM movimientos WHERE tipo = ? ORDER BY RAND() LIMIT 1";
        Movimiento[] movPivote = new Movimiento[4];

        for (int i = 0; i < movPivote.length; i++) {

            try {
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, String.valueOf(pokemon.getTipoPok1()));

                resultSet = preparedStatement.executeQuery();


                    while (resultSet.next()) {

                        nombreMov[i] = resultSet.getString("NOM_MOVIMIENTO");
                        potenciaMov[i] = resultSet.getInt("potencia");
                        categoriaMov[i] = resultSet.getString("categoria");
                        estadoMov[i] = resultSet.getString("estado");
                        tipoMov[i] = Tipos.valueOf(resultSet.getString("tipo"));
                        pp[i] = resultSet.getInt("pp");
                        statMejora[i] = resultSet.getString("MEJORA");
                        cantMejora[i] = resultSet.getInt("CANT_MEJORA");

                        break;

                    }

                    switch (categoriaMov[i]) {
                        case "Ataque":
                            pokemon.setMovimientos[i] = new AtaqueMov(nombreMov[i], pp[i], potenciaMov[i],tipoMov[i],categoriaMov[i]);
                            break;
                        case "Mejora":
                            pokemon.setMovimientos[i] = new mejoraMov(nombreMov[i], pp[i], cantMejora[i], statMejora[i]);
                            break;
                        case "Estado":
                            pokemon.setMovimientos[i] = new estadoMov(nombreMov[i], pp[i], Estado.SALUDABLE);
                            break;
                    }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }





    public Pokemon[] cargarEquipoContrarioConStats(Pokemon pokReferencia) {

        Pokemon[] equipoRivalCompleto = new Pokemon[6];
        Random random = new Random();
        int indice;

        try {

            equipoRivalCompleto = pokReferencia.equipoRivalBD();


            for (int i = 0; i < equipoRivalCompleto.length; i++) {

                indice = random.nextInt(-10, 10);

                equipoRivalCompleto[i].setVitalidadPok(100);
                equipoRivalCompleto[i].setPtsAtaque(pokReferencia.getPtsAtaque() + indice);
                equipoRivalCompleto[i].setPtsAtaqueEsp(pokReferencia.getPtsAtaqueEsp() + indice);
                equipoRivalCompleto[i].setPtsDefensa(pokReferencia.getPtsDefensa() + indice);
                equipoRivalCompleto[i].setPtsDefensaEsp(pokReferencia.getPtsDefensaEsp() + indice);
                equipoRivalCompleto[i].setVelocidadPok(pokReferencia.getVelocidadPok() + indice);

                crearMovEquipoRival(equipoRivalCompleto[i]);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipoRivalCompleto;
    }



    public Pokemon[] equipoRivalBD() throws SQLException {

        Random random2 = new Random();
        int idPokRival;
        Pokemon[] equipoRival = new Pokemon[6];
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        String sql = "SELECT * FROM POKEDEX WHERE NUM_POKEDEX = ?";


        for (int i = 0; i < equipoRival.length; i++) {
            idPokRival = random2.nextInt(1, 10);

            System.out.println("id pok: " + idPokRival);


            try {
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1, idPokRival);

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    numPokedexRival[i] = resultSet.getInt("NUM_POKEDEX");
                    nomPokemonRival[i] = resultSet.getString("NOM_POKEMON");
                    tipo1Rival[i] = Tipos.valueOf(resultSet.getString("TIPO1"));
                    tipo2Rival[i] = Tipos.valueOf(resultSet.getString("TIPO2"));
                    imagenUrlPokemonGeneradoRival[i] = resultSet.getString("IMAGEN");

                    break;
                }


                equipoRival[i] = new Pokemon(nomPokemonRival[i],
                       tipo1Rival[i], tipo2Rival[i], numPokedexRival[i], imagenUrlPokemonGeneradoRival[i]);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {

            }
        }
        return equipoRival;

    }

    public void cargarMovimientos(Pokemon pokemon, int idEntrenador, int idPokemon) {


        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM MOVIMIENTOS_POKEMON M INNER JOIN POKEMON P ON P.ID_POKEMON = M.ID_POKEMON INNER JOIN MOVIMIENTOS MO ON M.ID_MOVIMIENTO = MO.ID_MOVIMIENTO WHERE P.ID_USER = ? AND P.ID_POKEMON = ?;";
         movimientos = new Movimiento[4];

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntrenador);
            preparedStatement.setInt(2, idPokemon);
            ResultSet resultSet = preparedStatement.executeQuery();


            for (int i = 0; i < movimientos.length; i++) {

            while (resultSet.next()) {

                nombreMov[i] = resultSet.getString("NOM_MOVIMIENTO");
                potenciaMov[i] = resultSet.getInt("potencia");
                categoriaMov[i] = resultSet.getString("categoria");
                estadoMov[i] = resultSet.getString("mo.estado");
                tipoMov[i] = Tipos.valueOf(resultSet.getString("tipo"));
                pp[i] = resultSet.getInt("pp");
                statMejora[i] = resultSet.getString("MEJORA");
                cantMejora[i] = resultSet.getInt("CANT_MEJORA");

                break;

            }

            switch (categoriaMov[i]) {
                case "Ataque":
                    pokemon.setMovimientos[i] = new AtaqueMov(nombreMov[i], pp[i], potenciaMov[i],tipoMov[i],categoriaMov[i]);
                    break;
                case "Mejora":
                    pokemon.setMovimientos[i] = new mejoraMov(nombreMov[i], pp[i], cantMejora[i], statMejora[i]);
                    break;
                case "Estado":
                    pokemon.setMovimientos[i] = new estadoMov(nombreMov[i], pp[i], Estado.SALUDABLE);
                    break;
            }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "nombrePok='" + nombrePok + '\'' +
                ", vitalidadPok=" + vitalidadPok +
                ", ptsAtaque=" + ptsAtaque +
                ", ptsDefensa=" + ptsDefensa +
                ", ptsAtaqueEsp=" + ptsAtaqueEsp +
                ", ptsDefensaEsp=" + ptsDefensaEsp +
                ", velocidadPok=" + velocidadPok +
                ", setMovimientos=" + Arrays.toString(setMovimientos) +
                ", sexoPok='" + sexoPok + '\'' +
                ", objeto=" + objeto +
                '}';
    }
}
