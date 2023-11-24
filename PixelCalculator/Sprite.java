package PixelCalculator;

import java.util.Scanner;
public class Sprite {
    // height x width -- x, y
    private boolean isBinaryLocked = true;
    private int spriteWidthPower = 6, spriteHeightPower = 6, spriteWidth = 1, spriteHeight= 1, padding = 0;

    public void swapMode() {
        this.isBinaryLocked = !this.isBinaryLocked;
    }
    public void setMode(boolean isBinaryLocked) {
        System.err.println("sprite.setMode");
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

    public int getPaddedWidth() {
        return (this.padding*2) + this.getSpriteWidth();
    }
    public int getPaddedHeight() {
        return (this.padding*2) + this.getSpriteHeight();
    }

    public int getSpritePadding() { return this.padding;   }

    public int getSpriteHalfWidth() {return getSpriteWidth()/2;}
    public int getSpriteHalfHeight() {return getSpriteHeight()/2;}
    public int getSpriteQuarterHeight() {
        return Math.min(this.getSpriteHeight(), this.getSpriteWidth())/4;
    }

    @Override
    public String toString() {
        String outputText = "H: %d pixels x W: %d pixels +P: %d";
        return outputText.formatted(getSpriteHeight(), getSpriteWidth(), getSpritePadding());
    }

    public String modeHelperText() {
        String baseText = "*Enter Sprite HxW values %s.";
        String mod = "as raw sizes";
        if (this.isBinaryLocked) { mod = "as Binary Powers";
        }
        return baseText.formatted(mod);
    }

}
