package viktor.ui;

import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;
    @FXML
    private HBox headerBox;
    @FXML
    private Label headerLabel;

    private Viktor viktor;
    private boolean isFirstLaunch = true;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private List<Image> viktorImages = Arrays.asList(
            new Image(this.getClass().getResourceAsStream("/images/viktor1.png")),
            new Image(this.getClass().getResourceAsStream("/images/viktor2.png")),
            new Image(this.getClass().getResourceAsStream("/images/viktor3.png"))
    );

    private int currentImageIndex = 0; // Track which image is being used

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Viktor instance and shows appropriate messages */
    public void setViktor(Viktor v) {
        viktor = v;

        // Set the header label for the chatbot's name
        headerLabel.setText("viktor");

        if (isFirstLaunch) {
            // Show welcome message on first launch
            dialogContainer.getChildren().add(
                DialogBox.getViktorDialog(viktor.getWelcomeMessage(), viktorImages.get(0))
            );
            isFirstLaunch = false;
        }

        showStartMessage(); // Always show start message when GUI is opened
    }

    /** Displays the start message every time the GUI is opened */
    private void showStartMessage() {
        dialogContainer.getChildren().add(
            DialogBox.getViktorDialog(viktor.getStartMessage(), viktorImages.get(0))
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Viktor's reply, then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = viktor.getResponse(input);

        // Get the next image in cycle
        Image currentViktorImage = viktorImages.get(currentImageIndex);
        currentImageIndex = (currentImageIndex + 1) % viktorImages.size(); // Cycle to next image

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getViktorDialog(response, currentViktorImage)
        );
        userInput.clear();
    }
}
