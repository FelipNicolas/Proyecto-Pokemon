package es.cesur.progprojectpok.clases;

import es.cesur.progprojectpok.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Entrenador {

    //Atributos
    private String nombreEntrenador;
    private String pass;
    private int idEntrenador;
    private Pokemon[] equipo;
    private int pokedollars;
    private Objeto[] listObjetos;


    //Constructores
    public Entrenador() {
        this.nombreEntrenador = "";
        this.pass = "";
        this.idEntrenador = idEntrenador;
        this.equipo = null;
        this.pokedollars = 500;
        this.listObjetos = null;
    }

    public Entrenador(String nombreEntrenador, String pass, int idEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
        this.pass = pass;
        this.idEntrenador = idEntrenador;
        this.equipo = null;
        this.pokedollars = 500;
        this.listObjetos = null;
    }

    //Getter & Setters
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


    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    /**
     *      * @param pokemonCaptura Metodo captura pokemon
     */
    public void capturar(Pokemon pokemonCaptura){

        for (int i = 0; i < equipo.length; i++) {

            if (equipo[i] == null) {

                equipo[i] = pokemonCaptura;
            }
        }
    }

    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement = null;


    /**
     *      * @param idEntrenadorLogin //Obtiene informacion sobre el entrenador
     * @return
     */
    public int infoEntrenador(int idEntrenadorLogin){

        connection = DBConnection.getConnection();

        String sql = "SELECT * FROM ENTRENADOR WHERE ID_USER = ?";

        try {
            assert connection != null;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            preparedStatement.setInt(1, idEntrenadorLogin);

            idEntrenador = resultSet.getInt("ID_USER");
            nombreEntrenador = resultSet.getString("NOM_POKEMON");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }

        }

        return idEntrenador;

    }










}
