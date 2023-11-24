package PixelCalculator;

import java.util.Arrays;
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
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Test clone setup");
        if (strArgs.length != 0) {
            System.err.println("!strArgs.length != 0 - true");
            int[] intArgs = toIntArray(strArgs);
            ideArgsCall(intArgs);}
    }

    public static int[] toIntArray(String[] inputArray ) {
        int length = inputArray.length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = Integer.parseInt(inputArray[i]);
        }
        return newArray;
    }

    static void ideArgsCall(int[] intArray) {
        Sprite sprite = new Sprite(intArray);
        System.err.println(sprite);
        SpriteSheet spriteSheet = new SpriteSheet(sprite);
        System.err.println(spriteSheet);


    }
}