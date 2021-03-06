package view;
import main.Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the first window that the player will see when running the game.
 * From here the player is able to enter a game mode.
 */
public class MainMenuWindow extends JPanel {

    private static final String SET = "Welcome to the Game of Set";
    private static final String Solitaire_BUTTON_LABEL = "Solitaire Mode";
    private static final String TUTORIAL_BUTTON_LABEL = "Tutorial Mode";
    private static final String QUIT_BUTTON_LABEL = "Quit";

    private Editor mainListener;
    private JButton tutorial;
    private JButton Solitaire;
    private JButton quit;
    private JPanel mode;

    /**
     * Constructor for creating a new main.Editor Menu.
     * @param mainListener Listener callbacks for the main.Editor.
     */
    public MainMenuWindow(Editor mainListener) {
        this.mainListener = mainListener;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initGUI();
    }

    /**
     * Initializes the GUI
     */
    private void initGUI() {

        JLabel set = new JLabel(SET);
        set.setFont(new Font(getFont().getName(), Font.BOLD, 30));
        set.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(set);

        tutorial = new JButton(TUTORIAL_BUTTON_LABEL);
        tutorial.addActionListener(new TutorialButtonListener());

        Solitaire = new JButton(Solitaire_BUTTON_LABEL);
        Solitaire.addActionListener(new SolitaireButtonListener());

        quit = new JButton(QUIT_BUTTON_LABEL);
        quit.addActionListener(new QuitButtonListener());

        mode = new JPanel();
        mode.setAlignmentX(Component.CENTER_ALIGNMENT);
        mode.setLayout(new GridLayout(1,3));
        mode.add(tutorial);
        mode.add(Solitaire);
        mode.add(quit);
        add(mode);
    }

    /**
     * Solitaire button is pressed.
     */
    private class SolitaireButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainListener.goToGame(Editor.GameMode.Solitaire);
        }
    }

    /**
     * Tutorial button is pressed.
     */
    private class TutorialButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainListener.goToGame(Editor.GameMode.TUTORIAL);
        }
    }

    /**
     * Quit button is pressed.
     */
    private class QuitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
