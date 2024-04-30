package es.cesur.progprojectpok.clases;

import es.cesur.progprojectpok.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Entrenador {

    private String nombreEntrenador;

    private String pass;
    private int idEntrenador;
    private Pokemon[] equipo;
    private Pc caja;
    private int pokedollars;
    private Objeto[] listObjetos;

    public Entrenador() {
        this.nombreEntrenador = "";
        this.pass = "";
        this.idEntrenador = idEntrenador;
        this.equipo = null;
        this.caja = null;
        this.pokedollars = 500;
        this.listObjetos = null;
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

    public void capturar(){

    }










}
