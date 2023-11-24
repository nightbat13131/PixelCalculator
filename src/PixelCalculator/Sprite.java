package PixelCalculator;

import java.util.Scanner;
public class Sprite {
    // height x width -- x, y
    private boolean isBinaryLocked = true;
    private int spriteWidthPower, spriteHeightPower, spriteWidth, spriteHeight, padding = 0;
    final static int[] powers = {0, 2, 4, 8, 16, 32, 64, 124, 256, 512, 1024};
    final private Scanner input = new Scanner(System.in);
     public Sprite() {
         new Sprite(6,6);
     }
     public Sprite(int[] intArray) {
        new Sprite(intArray[0], intArray[1]);
    }
    public Sprite(int HeightPower, int WidthPower) {
        this.setSpriteHeight(HeightPower);
        this.setSpriteWidth(WidthPower);
    }

    public void swapMode() {
         this.isBinaryLocked = !this.isBinaryLocked;
    }
    public void setMode(boolean isBinaryLocked) {
        this.isBinaryLocked = isBinaryLocked;
    }

    public void setSpriteWidth(int newInt) {
        if (this.isBinaryLocked) {
            this.spriteWidthPower = newInt;
        } else {this.spriteWidth = newInt;
        }
    }

    public void setSpriteHeight(int newInt) {
        if (this.isBinaryLocked) {
            this.spriteHeightPower = newInt;
        } else { this.spriteHeight = newInt;
        }
    }
    public void setPadding(int padding) {
        this.padding = padding;
    }
    public int getSpriteWidth() {
        if (this.isBinaryLocked) {
            return (int) Math.pow(2, this.spriteWidthPower);
        } else return this.spriteWidth;
    }

    public int getSpriteHeight() {
         if (this.isBinaryLocked) {
             return (int) Math.pow(2, this.spriteHeightPower);
         } else {
             return this.spriteHeight;
         }
    }

    public int getPadding() { return this.padding;   }

    public int getHalfWidth() {return getSpriteWidth()/2;}
    public int getHalfHeight() {return getSpriteHeight()/2;}
    public int getQuarterHeight() {
        return Math.min(this.getSpriteHeight(), this.getSpriteWidth())/4;
    }

    @Override
    public String toString() {
         String outputText = "H: %d pixels x W: %d pixels";
         return outputText.formatted(getSpriteHeight(), getSpriteWidth());
    }

    public String modeHelperText() {
        String baseText = "*Enter Sprite HxW values %s.";
        String mod = "as raw sizes";
        if (this.isBinaryLocked) { mod = "as Binary Powers";
        }
        return baseText.formatted(mod);
    }

}
