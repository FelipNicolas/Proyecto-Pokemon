package es.cesur.progprojectpok;

import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.managers.UserManager;
import es.cesur.progprojectpok.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Obtener conexion BD
        Connection connection = DBConnection.getConnection();


        //Preparar consulta
        String sql = "SELECT * FROM USUARIO";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { //mientras tenga siguiente va recorriendo
                int idUser = resultSet.getInt("ID_USER");
                String nombreUser = resultSet.getString("NOMBRE_USER");

                System.out.println(idUser + " " + nombreUser);
            }


        } catch (SQLException e) {
            System.err.println("HelloApplication error al preparar la sentencia sql");
        }


        //Ejecutar


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/equipo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}