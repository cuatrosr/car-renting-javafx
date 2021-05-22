package controller;

import java.io.IOException;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

public class FXSplashScreen extends Preloader{
    
    @SuppressWarnings("FieldMayBeFinal")
    private RentingCar rc;
    @SuppressWarnings("FieldMayBeFinal")
    private FXMainController fxGUI;
    private Stage preloaderStage;
    private Scene scene;

    public FXSplashScreen() throws IOException {
        rc = new RentingCar();
        fxGUI = new FXMainController(rc);
    }  
    
    @Override
    public void init() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Welcome.fxml"));
        fxmlLoader.setController(fxGUI);
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        /*
        Image img = new Image("image/CasaDoradaNew.png");
        FXControllerGUI.imageView.setImage(img);
        */
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.preloaderStage = primaryStage;
        preloaderStage.setScene(scene);
        preloaderStage.setResizable(false);
        preloaderStage.setTitle("RentingCar");
        preloaderStage.show();
    }

    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification info) {
        if (info instanceof Preloader.ProgressNotification) {
        }
    }
    
    @Override
    public void handleStateChangeNotification(Preloader.StateChangeNotification info) {
        Preloader.StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_START:
                preloaderStage.hide();
                break;
        }
    }
}
