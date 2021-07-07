package CalcRumata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/myCalc.fxml"));



        primaryStage.setTitle("MyCalc");
        primaryStage.setScene(new Scene(root, 320, 500));
        primaryStage.setResizable(false);
        primaryStage.show();

    }



    public static void main(String[] args) {
        Application.launch(args);
    }


}
