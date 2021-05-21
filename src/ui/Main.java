package ui;

import com.sun.javafx.application.LauncherImpl;
import model.*;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @SuppressWarnings("FieldMayBeFinal")
    private RentingCar rc;
    @SuppressWarnings("FieldMayBeFinal")
    private FXMainController fxController;

    private static final int COUNT_LIMIT = 30000;

    public Main() {
        rc = new RentingCar();
        fxController = new FXMainController(rc);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Login.fxml"));
        fxmlLoader.setController(fxController);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Renting Car");
        primaryStage.show();
    }
    
    @Override
    public void init() throws Exception {
        for (int i = 0; i < COUNT_LIMIT; i++) {
            double progress = (100 * i) / COUNT_LIMIT;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
        }
    }


    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class, FXSplashScreen.class, args);
    }
}
