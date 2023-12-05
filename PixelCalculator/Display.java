package PixelCalculator ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame
         {
    private JLabel labelPixelSheetCalculatorLabel;
    private JRadioButton binaryRadioButton;
    private JRadioButton anyRadioButton;
    private JTextField widthInputRaw;
    private JTextField rowInput;
    private JTextField heightInputRaw;
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
    private JLabel output25Width;
    private JLabel label25;
    private JLabel labelX;
             private JLabel outputFrameX;
    private JLabel labelY;
             private JLabel labelPageDimensions;
    private JLabel labelPageWidth;
    private JPanel panelPixelForm;
    private JLabel labelFocusFrame;
             private JLabel labelHeight;
    private JLabel labelGuideLines;
    private JLabel label50;
             private JLabel outputFrameY;
             private JLabel label100;
             private JLabel outputSpriteWidth;
             private JLabel outputFrameArt;
             private JTextField widthPowerInput;
             private JTextField heightPowerInput;
             private JLabel output25Height;
             private JLabel outputSpriteHeight;
             private JLabel labelRowFrame;
             private JLabel labelColumnFrame;
             private JLabel outputRowFrame;
             private JLabel outputColumnFrame;
             private final SpriteSheet sheet = new SpriteSheet();;

     public static void main(String[] args) {

     }
    public Display() {
        String title = "SpriteSheet Pixel Calculator";
        System.out.println("Display.Display test a");

        this.setContentPane(this.panelPixelForm);
        updateFrameSelector();
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
                     }
        });
        anyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sheet.setMode(false);

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

        widthInputRaw.setText(String.valueOf(this.sheet.getSpriteWidthRaw()));
        heightInputRaw.setText(String.valueOf(this.sheet.getSpriteHeightRaw()));
        widthPowerInput.setText(String.valueOf(this.sheet.getSpriteWidthPower()));
        heightPowerInput.setText(String.valueOf(this.sheet.getSpriteHeightPower()));
        rowInput.setText(String.valueOf(this.sheet.getRowCount()));
        columnInput.setText(String.valueOf(this.sheet.getColumnCount()));
        // page dimensions
        pageWidthDisplay.setText(String.valueOf(this.sheet.getSheetWidth()));
        pageHeightDisplay.setText(String.valueOf(this.sheet.getSheetHeight()));
        //100%
        outputSpriteHeight.setText(String.valueOf(this.sheet.getSpriteHeight()));
        outputSpriteWidth.setText(String.valueOf(this.sheet.getSpriteWidth()));
        //50%
        output50Height.setText(String.valueOf(this.sheet.getSpriteHalfHeight()));
        output50Width.setText(String.valueOf(this.sheet.getSpriteHalfWidth()));
        //25%
        output25Width.setText(String.valueOf(this.sheet.getSpriteQuarterWidth()));
        output25Height.setText(String.valueOf(this.sheet.getSpriteQuarterHeight()));
        // frame
        int frame = getFocusFrame();
        outputFrameX.setText(String.valueOf(this.sheet.getXFromFrame(frame)));
        outputFrameY.setText(String.valueOf(this.sheet.getYFromFrame(frame)));
        outputColumnFrame.setText(String.valueOf(this.sheet.calculateColumnFromFrame(frame)));
        outputRowFrame.setText(String.valueOf(this.sheet.calculateRowFromFrame(frame)));

        outputFrameArt.setText(String.valueOf(getFocusFrame()));  // eventually replaced with art

        updateFrameSelector();
    }
    private void processInputs() {
         try {
             this.sheet.setSpriteWidthRaw(Integer.parseInt(this.widthInputRaw.getText()));
             this.sheet.setSpriteHeightRaw(Integer.parseInt(this.heightInputRaw.getText()));
             this.sheet.setSpriteWidthPower(Integer.parseInt(this.widthPowerInput.getText()));
             this.sheet.setSpriteHeightPower(Integer.parseInt(this.heightPowerInput.getText()));

             this.sheet.setRowCount(Integer.parseInt(this.rowInput.getText()));
             this.sheet.setColumnCount(Integer.parseInt(this.columnInput.getText()));
         } catch (Exception e) {System.err.println("processInputs failed");}
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

             private void createUIComponents() {
                 // TODO: place custom component creation code here
             }
         }
