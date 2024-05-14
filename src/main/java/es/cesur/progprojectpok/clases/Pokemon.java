package es.cesur.progprojectpok.clases;

import es.cesur.progprojectpok.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Movimiento[] setMoviminetos;
    private int fertilidad = 5;
    private boolean sexoPok;
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


    public Pokemon(String motePok, int vitalidadPok, int ptsAtaque, int ptsDefensa, int ptsAtaqueEsp, int ptsDefensaEsp, int velocidadPok,
                   int nivelPok, Movimiento[] setMoviminetos, int fertilidad, boolean sexoPok, Objeto objeto, int experiencia, Tipos tipoPok1, Tipos tipoPok2, Estado estadoPok) {

        this.motePok = motePok;
        this.vitalidadPok = vitalidadPok;
        this.ptsAtaque = ptsAtaque;
        this.ptsDefensa = ptsDefensa;
        this.ptsAtaqueEsp = ptsAtaqueEsp;
        this.ptsDefensaEsp = ptsDefensaEsp;
        this.velocidadPok = velocidadPok;
        this.nivelPok = nivelPok;
        this.setMoviminetos = setMoviminetos;
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
        this.sexoPok = true;
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
        this.estadoPok = null;


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

    public Movimiento[] getSetMoviminetos() {
        return setMoviminetos;
    }

    public void setSetMoviminetos(Movimiento[] setMoviminetos) {
        this.setMoviminetos = setMoviminetos;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public boolean isSexoPok() {
        return sexoPok;
    }

    public void setSexoPok(boolean sexoPok) {
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



    public void combate(Pokemon pokObjetivo, Movimiento ataque) {

        if (ataque instanceof mejoraMov) {

            ataque.accionMov(this, ataque);

        } else if (ataque instanceof estadoMov) {

            ataque.accionMov(pokObjetivo, ataque);

        } else if (ataque instanceof AtaqueMov){

            ataque.accionMov(pokObjetivo, ataque);

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

    public Pokemon[] cargarEquipoContrarioSinStats()  {

        Pokemon pok = new Pokemon();

        Pokemon[] equipoPivote = new Pokemon[0];
        try {

            equipoPivote = pok.equipoRivalBD();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        for (int i = 0; i < equipoPivote.length; i++) {
            System.out.println(equipoPivote[i].toString());

        }


        return equipoPivote;
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

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            while (resultSet.next()) {

                numPokedexRival[i] = resultSet.getInt("NUM_POKEDEX");
                nomPokemonRival[i] = resultSet.getString("NOM_POKEMON");
                tipo1Rival[i] = Tipos.valueOf(resultSet.getString("TIPO1").toUpperCase());
                tipo2Rival[i] = Tipos.valueOf(resultSet.getString("TIPO2").toUpperCase());
                imagenUrlPokemonGeneradoRival[i] = resultSet.getString("IMAGEN");


            }


            equipoRival[i] = new Pokemon(nomPokemonRival[i],
                    tipo1Rival[i], tipo2Rival[i], numPokedexRival[i], imagenUrlPokemonGeneradoRival[i]);

        }
        return equipoRival;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "nombrePok='" + nombrePok + '\'' +
                ", urlImgPok='" + urlImgPok + '\'' +
                ", numPokedex=" + numPokedex +
                ", tipoPok1=" + tipoPok1 +
                ", tipoPok2=" + tipoPok2 +
                '}';
    }
}
