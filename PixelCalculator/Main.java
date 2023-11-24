package PixelCalculator;

import javax.swing.*;
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

        SpriteSheet a = new SpriteSheet();
        System.out.println(a.sprite.modeHelperText());
        a.sprite.swapMode();
        System.out.println(a.sprite.modeHelperText());


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