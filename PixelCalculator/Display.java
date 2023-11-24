package PixelCalculator ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame
         {
    private JLabel labelPixelSheetCalculatorLabel;
    private JRadioButton binaryRadioButton;
    private JRadioButton anyRadioButton;
    private JTextField widthInput;
    private JTextField rowInput;
    private JTextField heightInput;
    private JTextField paddingInput;
    private JTextField columnInput;
    private JComboBox inputFrameIndex;
    private JButton calculateButton;
    private JLabel pageWidthDisplay;
    private JLabel pageHeightDisplay;
    private JLabel labelMode;
    private JLabel labelSprite;
    private JLabel labelSheet;
    private JLabel labelSpriteWidth;
    private JLabel labelSpriteHeight;
    private JLabel labelSheetRows;
    private JLabel labelSheetColumns;
    private JLabel labelModeHelperText;
    private JLabel output50Height;
    private JLabel output50Width;
    private JLabel output25;
    private JLabel label25;
    private JLabel labelX;
    private JLabel labelPaddedX;
    private JLabel outputPaddedX;
    private JLabel outputX;
    private JLabel labelY;
    private JLabel labelPaddedY;
    private JLabel labelPageDimensions;
    private JLabel labelPageWidth;
    private JPanel panelPixelForm;
    private JLabel labelFocusFrame;
    private JLabel labelWithoutPadding;
    private JLabel labelWithPadding;
    private JLabel labelPadding;
    private JLabel labelHeight;
    private JLabel labelGuideLines;
    private JLabel label50Width;
    private JLabel label50Height;
    private JLabel outputY;
    private JLabel outputPaddedY;
    private JLabel e;
    private JLabel ee;
    private JLabel eee;
    private JLabel eeee;
    private JLabel eeeee;
    private JLabel eeeeee;
    private final String title = "SpriteSheet Pixel Calculator";
    //private SpriteSheet spriteSheet = new SpriteSheet();

     public static void main(String[] args) {

     }
    public Display() {
        System.out.println("Display.Display test a");

        this.setContentPane(this.panelPixelForm);
        this.setTitle(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //labelModeHelperText.setText(spriteSheet.modeHelperText());
        //createUIComponents() ;



        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(calculateButton, labelPixelSheetCalculatorLabel.getText() + "Test 10");
            }
        });
        inputFrameIndex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        binaryRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        anyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
