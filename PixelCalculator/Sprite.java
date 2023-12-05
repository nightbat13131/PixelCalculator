package PixelCalculator;

public class Sprite {
    // height x width -- x, y
    private boolean isBinaryLocked = false;

    private int spriteWidthPower = 6, spriteHeightPower = 6, spriteWidthRaw = 64, spriteHeightRaw = 64;

    public void swapMode() {
        this.isBinaryLocked = !this.isBinaryLocked;
    }
    public void setMode(boolean isBinaryLocked) {
        System.err.println("sprite.setMode");
        this.isBinaryLocked = isBinaryLocked;
    }

    public void setSpriteWidthPower(int newInt) {
        // can only update with the correct mode on
        if (this.isBinaryLocked) {
            this.spriteWidthPower = newInt;
        }
    }
    public void setSpriteWidthRaw(int newInt) {
        // can only update with the correct mode on
        if (! this.isBinaryLocked) {
            this.spriteWidthRaw = newInt;
        }
    }
    public void setSpriteHeightPower(int newInt) {
        if (this.isBinaryLocked) {
            this.spriteHeightPower = newInt;
        }
    }
    public void setSpriteHeightRaw(int newInt) {
        if (! this.isBinaryLocked) {
            this.spriteHeightRaw = newInt;
        }
    }
    public int getSpriteWidth() {
        if (this.isBinaryLocked) {
            return (int) Math.pow(2, this.spriteWidthPower);
        } else return this.spriteWidthRaw;
    }

    public int getSpriteHeight() {
        if (this.isBinaryLocked) {
            return (int) Math.pow(2, this.spriteHeightPower);
        } else {
            return this.spriteHeightRaw;
        }
    }

    public int getSpriteHeightPower() {
        return spriteHeightPower;
    }

    public int getSpriteHeightRaw() {
        return spriteHeightRaw;
    }

    public int getSpriteWidthPower() {
        return spriteWidthPower;
    }

    public int getSpriteWidthRaw() {
        return spriteWidthRaw;
    }
    public int getSpriteHalfWidth() {return getSpriteWidth()/2;}
    public int getSpriteHalfHeight() {return getSpriteHeight()/2;}
    public int getSpriteQuarterHeight() {return getSpriteHeight()/4;}
    public int getSpriteQuarterWidth() {return getSpriteWidth()/4;}
    @Override
    public String toString() {
        String outputText = "H: %d pixels x W: %d pixels ";
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
