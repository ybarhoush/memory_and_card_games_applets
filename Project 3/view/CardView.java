package view;

import model.CardModel;
import shape.Shape;
import shape.ShapeFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CardView.java
 * Represents a card that the user sees on the game screen.
 */
public class CardView extends JPanel {

    private static final Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
    private static JLabel image;

    private CardModel cardModel;
    private List<Shape> shapeViewList;

    /**
     * Creates a new set of cards.
     *
     * @param cardModel CardModel data to display as view.
     */
    public CardView(CardModel cardModel) {
        super();
        this.cardModel = cardModel;
        this.shapeViewList = new ArrayList<>();

        setLayout(new GridLayout(1, 3));
        setBackground(Color.white);
        //addShapes();
        toggleSelection();
    }

    /**
     * Adds shapes to the card.
     */
    public void addShapes() {
        for (int i = 0; i < cardModel.getShapeNum(); i++) {
            Shape shape = ShapeFactory.buildShape(cardModel);
            add(shape);
            shape.setVisible(true);
            shapeViewList.add(shape);
        }
    }


    /**
     * Getter method for a card.
     *
     * @return cardModel
     */
    public CardModel getCardModel() {
        return cardModel;
    }

    /**
     * Sets the back of the card to the designated image. When a card is not selected,
     * it returns the corresponding shape to the card.
     */
    private void toggleSelection() {
        if (cardModel.isSelected() == false) {

            image = new JLabel(new ImageIcon("Images/card3.jpg"));
            add(image);
        } else {
            setBorder(loweredBevelBorder);
            addShapes();
        }
    }

    /**
     * Changes the background of a card to green when still in play.
     */
    public void greenBackground() {
        if (cardModel.isSelected() == true && cardModel.getShapeNum() != 0) {
            setBackground(Color.green);
        }
    }

    /**
     * Changes the background of a card to red when still in play.
     */
    public void redBackground() {
        if (cardModel.isSelected() == true && cardModel.getShapeNum() != 0) {
            setBackground(Color.red);
        }
    }

}

