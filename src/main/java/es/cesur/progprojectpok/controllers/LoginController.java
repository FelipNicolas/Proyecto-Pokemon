package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.SplashApplication;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void loginUser() throws SQLException, IOException {

        Connection connection = DBConnection.getConnection();

        String sql = "SELECT NOMBRE_USER, PASS_USER FROM ENTRENADOR";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();


        String nomEntrenador;
        String passEntrenador;

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = null;



        while (resultSet.next()) {
            nomEntrenador = resultSet.getString("NOMBRE_USER");
            passEntrenador = resultSet.getString("PASS_USER");


            if (userId.getText().equals(nomEntrenador) && passUser.getText().equals(passEntrenador)) {

                fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/equipo-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                stage.setTitle("Login");
                stage.setScene(scene);
                stage.show();

                Stage stageAnterior = (Stage) usuarioCorrecto.getScene().getWindow();
                stageAnterior.close();

                resultSet.close();
                preparedStatement.close();
                connection.close();

            }else usuarioCorrecto.setText("Incorrecto");



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

    @FXML
    protected void onHelloButtonClick() {

    }


}