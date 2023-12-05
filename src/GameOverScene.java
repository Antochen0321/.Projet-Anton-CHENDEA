import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class GameOverScene extends Scene {
    public GameOverScene(Group root, int windowWidth, int windowHeight) {
        super(root, windowWidth, windowHeight);

        VBox gameOverLayout = new VBox(20);
        gameOverLayout.setStyle("-fx-background-color: #CCCCCC;");

        javafx.scene.control.Label gameOverLabel = new javafx.scene.control.Label("Game Over");
        gameOverLabel.setStyle("-fx-font-size: 24;");
        Button restartButton = new Button("Restart");
        restartButton.setOnAction(e -> {
            ((Stage) restartButton.getScene().getWindow()).close();
        });
        gameOverLayout.getChildren().addAll(gameOverLabel, restartButton);
        root.getChildren().add(gameOverLayout);
    }
}

