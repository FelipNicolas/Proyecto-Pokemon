package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.SplashApplication;
import es.cesur.progprojectpok.clases.Entrenador;
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

public class LoginController implements Initializable {



    @FXML
    private ProgressBar progressBar;

    @FXML
    private PasswordField passUser;


    @FXML
    private CheckBox rememberBtn;

    @FXML
    private TextField userId;

    @FXML
    private Label usuarioCorrecto;

    protected Entrenador entrenadorLogin;

    ResultSet resultSet;





    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }


    @FXML
     void loginUser()  {

        Connection connection = DBConnection.getConnection();

        String sql = "SELECT NOMBRE_USER, PASS_USER, ID_USER FROM ENTRENADOR";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();





        String nomEntrenador;
        String passEntrenador;
        int idEntrenador;

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = null;



        while (resultSet.next()) {

            nomEntrenador = resultSet.getString("NOMBRE_USER");
            passEntrenador = resultSet.getString("PASS_USER");
            idEntrenador = resultSet.getInt("ID_USER");


            if (userId.getText().equals(nomEntrenador) && passUser.getText().equals(passEntrenador)) {


                entrenadorLogin = new Entrenador(nomEntrenador, passEntrenador, idEntrenador);


                System.out.println(" entrenador login" + entrenadorLogin.getIdEntrenador());


                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-principal.fxml"));

                Scene scene = new Scene(fxmlLoader.load(), 715, 700);

                // Enviar el id de entrenador a la siguente pantalla (equipo controller)

                stage.setTitle("Login");
                stage.setScene(scene);
                MenuMainController menuMainController = fxmlLoader.getController();
                menuMainController.setEntrenadorMenuPrincipal(entrenadorLogin);
                stage.show();


                System.out.println(entrenadorLogin.getIdEntrenador());

                Stage stageAnterior = (Stage) usuarioCorrecto.getScene().getWindow();
                stageAnterior.close();





            }else usuarioCorrecto.setText("Incorrecto");
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


    }





    @FXML
    void registerUser(ActionEvent event) {

        Connection connection = DBConnection.getConnection();

        String nomEntrenador;
        String passEntrenador;

        nomEntrenador = userId.getText();
        passEntrenador = passUser.getText();


        String sql = "INSERT INTO ENTRENADOR (NOMBRE_USER, PASS_USER, POKEDOLLAR) VALUES (" + "'" +
                nomEntrenador + "' " + ", '" + passEntrenador + "', " + "500" + ")";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }




    @FXML
    void btnExit(ActionEvent event) {
        System.exit(0);
    }




}