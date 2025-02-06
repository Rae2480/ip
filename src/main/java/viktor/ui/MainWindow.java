package viktor.ui;

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
    private Image viktorImage = new Image(this.getClass().getResourceAsStream("/images/DaViktor.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Viktor instance and shows appropriate messages */
    public void setViktor(Viktor v) {
        viktor = v;

        // Set the header label for the chatbot's name
        headerLabel.setText("viktor"); // Assuming Viktor has a method getName() to retrieve the name

        if (isFirstLaunch) {
            // Show welcome message on first launch
            dialogContainer.getChildren().add(
                DialogBox.getViktorDialog(viktor.getWelcomeMessage(), viktorImage)
            );
            isFirstLaunch = false;
        }

        showStartMessage(); // Always show start message when GUI is opened
    }

    /** Displays the start message every time the GUI is opened */
    private void showStartMessage() {
        dialogContainer.getChildren().add(
            DialogBox.getViktorDialog(viktor.getStartMessage(), viktorImage)
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
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getViktorDialog(response, viktorImage)
        );
        userInput.clear();
    }
}
