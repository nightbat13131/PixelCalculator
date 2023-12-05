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
     private JLabel outputFrameArt;
     private final SpriteSheet sheet = new SpriteSheet();;

     public static void main(String[] args) {

     }
    public Display() {
        String title = "SpriteSheet Pixel Calculator";
        System.out.println("Display.Display test a");

        this.setContentPane(this.panelPixelForm);
        updateFrameSelector();
        updateModeHelperText();
        updateUIValues();


        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 200, 1000, 500);



        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInputs();
                updateUIValues();
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
                sheet.setMode(true);
                updateModeHelperText();
            }
        });
        anyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sheet.setMode(false);
                updateModeHelperText();

            }
        });

        inputFrameIndex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    private void updateUIValues() {
        System.err.println("Display.updateUIValues");
        updateModeHelperText();
        widthInput.setText(String.valueOf(this.sheet.getSpriteWidth()));
        heightInput.setText(String.valueOf(this.sheet.getSpriteHeight()));
        paddingInput.setText(String.valueOf(this.sheet.getSpritePadding()));
        rowInput.setText(String.valueOf(this.sheet.getRowCount()));
        columnInput.setText(String.valueOf(this.sheet.getColumnCount()));

        pageWidthDisplay.setText(String.valueOf(this.sheet.getSheetWidth()));
        pageHeightDisplay.setText(String.valueOf(this.sheet.getSheetHeight()));

        output50Height.setText(String.valueOf(this.sheet.getSpriteHalfHeight()));
        output50Width.setText(String.valueOf(this.sheet.getSpriteHalfWidth()));
        output25.setText(String.valueOf(this.sheet.getSpriteQuarterHeight()));

        outputFrameArt.setText(String.valueOf(this.sheet.getFrameMax()));

        outputFrameArt.setText(String.valueOf(getFocusFrame()));

        updateFrameSelector();

    }
    private void processInputs() {
         try {
             this.sheet.setSpriteWidth(Integer.parseInt(this.widthInput.getText()));
             this.sheet.setSpriteHeight(Integer.parseInt(this.heightInput.getText()));
             this.sheet.setPadding(Integer.parseInt(this.paddingInput.getText()));

             this.sheet.setRowCount(Integer.parseInt(this.rowInput.getText()));
             this.sheet.setColumnCount(Integer.parseInt(this.columnInput.getText()));
         } catch (Exception e) {System.err.println("processInputs failed");}


    }

    private void updateModeHelperText() {
        labelModeHelperText.setText(this.sheet.modeHelperText());

    }

    private void updateFrameSelector() {
        int targetValue = this.sheet.getFrameMax();
        inputFrameIndex.removeAllItems();
        for (int value = 0; value <= targetValue; value ++){
            inputFrameIndex.addItem(String.valueOf(value));
        }
    }
    private int getFocusFrame() { // to be used with calculateRowFromFrame, ext
         String raw = inputFrameIndex.getSelectedItem().toString();
         return Integer.parseInt(raw);
    }
}
