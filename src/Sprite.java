
public class Sprite {
    // height x width -- x, y
    private boolean isBinaryLocked = true;
    private int spriteWidthPower, spriteHeightPower, spriteWidth, spriteHeight;
    final static int[] powers = {0, 2, 4, 8, 16, 32, 64, 124, 256, 512, 1024};

     public Sprite() {}
     public Sprite(int[] intArray) {
        this.setSpriteHeight(intArray[0]);
        this.setSpriteWidth(intArray[1]);
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

    public int getSpriteWidth() {
        return (int)Math.pow(2, this.spriteWidthPower);
    }

    public int getSpriteHeight() {
        return (int)Math.pow(2, this.spriteHeightPower);
    }

    public int getHalfWidth() {return getSpriteWidth()/2;}
    public int getHalfHeight() {return getSpriteHeight()/2;}
    public int getQuarterHeight() {
        return Math.min(this.getSpriteHeight(), this.getSpriteWidth())/4;
    }

    public String toString() {
         String outputText = "H: %d pixels x W: %d pixels";
         return outputText.formatted(getSpriteHeight(), getSpriteWidth());
    }


}
