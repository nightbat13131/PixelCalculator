package PixelCalculator;

import java.lang.Integer;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] strArgs) {
        // take tile size, rows count , colum count and return
        //full sheet width and height
        // also return 50% (even if not square)
        // also return 25%, bases on smaller 50%
        // take row number and column number and return (inclusive) top left cord and bottom right cord
        // also return top left cord with width and height (used in godot to identify region

        SpriteSheet sheet = new SpriteSheet();
        System.out.println(sheet.modeHelperText());
        sheet.swapMode();
        System.out.println(sheet.modeHelperText());
        sheet.swapMode();
        System.err.println(sheet);
        System.out.println(sheet.calculateRowFromFrame(3));
        System.out.println(sheet.calculateColumnFromFrame(3));
        System.out.printf(sheet.drawFrame(0));
        System.out.printf("%n@%n");
        System.out.printf(sheet.drawFrame(1));
        System.out.printf("%n@%n");
        System.out.printf(sheet.drawFrame(2));
        System.out.printf("%n@%n");
        System.out.printf(sheet.drawFrame(3));
         //Display d = new Display();
        /* This where moved into the Display() initiation code and it works so far with initial testing
        d.setContentPane(d.panelPixelForm);
        d.setTitle("Hello");
        d.setSize();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        //d.setVisible(true);

    }

    public static int[] toIntArray(String[] inputArray ) {
        int length = inputArray.length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = Integer.parseInt(inputArray[i]);
        }
        return newArray;
    }
}