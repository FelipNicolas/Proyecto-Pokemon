package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.database.ConfigDB;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CentroPokController implements Initializable {

    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    @FXML
    private ImageView imgPok1;

    @FXML
    private ImageView imgPok2;

    @FXML
    private ImageView imgPok3;

    @FXML
    private ImageView imgPok4;

    @FXML
    private ImageView imgPok5;

    @FXML
    private ImageView imgPok6;

    @FXML
    private Label lblPok1;

    @FXML
    private Label lblPok2;

    @FXML
    private Label lblPok3;

    @FXML
    private Label lblPok4;

    @FXML
    private Label lblPok5;

    @FXML
    private Label lblPok6;

    @FXML
    private ProgressBar pgrsbar1;

    @FXML
    private ProgressBar pgrsbar2;

    @FXML
    private ProgressBar pgrsbar3;

    @FXML
    private ProgressBar pgrsbar4;

    @FXML
    private ProgressBar pgrsbar5;

    @FXML
    private ProgressBar pgrsbar6;

    @FXML
    private ImageView cerrarCurar;

    @FXML
    void realizarCura(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private Entrenador entrenadorCentroPK;

    public Entrenador getEntrenadorCentroPK() {
        return entrenadorCentroPK;
    }

    public void setEntrenadorCentroPK(Entrenador entrenadorCentroPK) {
        this.entrenadorCentroPK = entrenadorCentroPK;
    }

    String[] imgPok = new String[6];

    String ImagenUrlPokemonGenerado = "";

    String[] NOM_POKEMON = new String[6];

    String[] TIPO1 = new String[6];
    String[] TIPO2 = new String[6];

    @FXML
    void cargarEquipo(ActionEvent event) {
        System.out.println("id equipo" + entrenadorCentroPK);

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX PO INNER JOIN POKEMON P ON PO.NUM_POKEDEX = P.NUM_POKEDEX WHERE CAJA = 0 AND ID_USER = ?;";

        String[] imgPok = new String[6];
        String ImagenUrlPokemonGenerado = "";


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entrenadorCentroPK.getIdEntrenador());

            ResultSet resultSet = preparedStatement.executeQuery();



            for (int i = 0; i < imgPok.length; i++) {


                while (resultSet.next()) {

                    int NUM_POKEDEX = resultSet.getInt("NUM_POKEDEX");
                    NOM_POKEMON[i] = resultSet.getString("NOM_POKEMON");
                    TIPO1[i] = resultSet.getString("TIPO1");
                    TIPO2[i] = resultSet.getString("TIPO2");
                    ImagenUrlPokemonGenerado = resultSet.getString("IMAGEN");
                    String SONIDO = resultSet.getString("SONIDO");
                    int NIVEL_EVOLUCION = resultSet.getInt("NIVEL_EVOLUCION");
                    int NUM_POKEDEX_EVO = resultSet.getInt("NUM_POKEDEX_EVO");
                    String SEXO = resultSet.getString("SEXO");
                    int VIDA = resultSet.getInt("VITALIDAD");
                    int NIVEL = resultSet.getInt("NIVEL");



                    System.out.println(NUM_POKEDEX + " " + NOM_POKEMON + " " + TIPO1 + " " + TIPO2 + " " +
                            ImagenUrlPokemonGenerado + " " + SONIDO + " " + NIVEL_EVOLUCION + " " + NUM_POKEDEX_EVO + " " + SEXO);

                    //Cambio de imagen
                    break;


                }

                imgPok[i] = ConfigDB.URL_POK + ImagenUrlPokemonGenerado;

                System.out.println(imgPok[i]);


            }

            File fileImageFondo1 = new File(imgPok[0]);
            File fileImageFondo2 = new File(imgPok[1]);
            File fileImageFondo3 = new File(imgPok[2]);
            File fileImageFondo4 = new File(imgPok[3]);
            File fileImageFondo5 = new File(imgPok[4]);
            File fileImageFondo6 = new File(imgPok[5]);


            System.out.println("Posicion 1 = " + imgPok[0]);
            System.out.println("Posicion 2 = " + imgPok[1]);


            imgPok1.setImage(new Image(fileImageFondo1.getAbsolutePath()));
            imgPok2.setImage(new Image(fileImageFondo2.getAbsolutePath()));
            imgPok3.setImage(new Image(fileImageFondo3.getAbsolutePath()));
            imgPok4.setImage(new Image(fileImageFondo4.getAbsolutePath()));
            imgPok5.setImage(new Image(fileImageFondo5.getAbsolutePath()));
            imgPok6.setImage(new Image(fileImageFondo6.getAbsolutePath()));


        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void btnBACK(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-centropk.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-lucha-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCurar.getScene().getWindow();
        stageAnterior.close();
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */


}