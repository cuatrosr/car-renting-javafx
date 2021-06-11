package ui;

import java.io.IOException;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

public class FxSplash extends Preloader {

    //---------------------------- Attributes of FxSplash class ----------------------------\\
    private RentingCar rc;
    private FXController fxGUI;
    private Stage preloaderStage;
    private Scene scene;

    //-------------------------- Constructor class --------------------------\\
    /**
     * FXSplash class constructor, initialize all relations.
     *
     * @throws IOException
     */
    public FxSplash() throws IOException {
        rc = new RentingCar();
        fxGUI = new FXController(rc);
    }

    /**
     * Configure the FXGUI
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI/Welcome.fxml"));
        fxmlLoader.setController(fxGUI);
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
    }

    /**
     * Start to show the GUI
     *
     * @throws Exception
     */
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
