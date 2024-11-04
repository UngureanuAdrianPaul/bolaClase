import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage escenario) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource(".\\vista\\vista.fxml"));

        escenario.setTitle("Juego Bola");
        escenario.setScene(new Scene(root, 800, 600));
        escenario.setResizable(true);
        escenario.show();

    }
}
