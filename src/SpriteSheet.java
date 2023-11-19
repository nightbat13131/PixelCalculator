import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class SpriteSheet {
    // height x width -- x, y
    final static int[] powers = {0, 2, 4, 8, 16, 32, 64, 124, 256, 512, 1024};
    private int spriteWidthPower, spriteHeightPower, rowCount, columnCount;
    final private Scanner input = new Scanner(System.in);
    private boolean isBinaryLocked = true;
    public SpriteSheet() {
        promptPowers();
        verifySpriteSheetSizes();
    }
    public SpriteSheet(int[] intArgs) {
        set_spriteHeight(intArgs[0]);
        set_spriteWidth(intArgs[1]);
        System.out.println("Test A");
        verifySpriteSheetSizes();
    }
    public void verifySpriteSheetSizes() {
        final String verityText = "Height Power %d x Width Power %d translates to%n" +
                "Height %d pixels x Width: %d pixels. Is this correct?%n 1: Yes%n 2: No, swap numbers%n 3: No, new numbers%nChoice: ";
        boolean repeat = true;
        do {
            System.out.printf(verityText, this.spriteHeightPower, this.spriteWidthPower, get_spriteHeight(), get_spriteWidth());
            switch (this.input.nextInt()) {
                case 1: {//no change needed
                    repeat = false;
                    break;
                }

                case 2: { //swap
                    int holder = this.spriteHeightPower;
                    this.spriteHeightPower = this.spriteWidthPower;
                    this.spriteWidthPower = holder;
                    break;
                }
                case 3: { //new numbers
                    promptPowers();
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please input 1-3.");
                }
            }
        } while (repeat);

        System.out.println("How many rows?");
        this.set_rowCount(this.input.nextInt());
        System.out.println("How many columns?");
        this.set_columnCount(this.input.nextInt());

        outputSheetDetails();

        }

    public void outputSheetDetails() {
        final String pageSizeText = "Your full sheet will be %d pixels high by %d pixels wide.%n",
                halfTextDual = "Your 50%% height is %d and your 50%% width is %d.%n",
                halfTextSingle ="Your 50%% is %d pixels in both directions.%n",
                quarterTextSingle ="Your 25%% is %d pixels.%n";
        System.out.printf(pageSizeText, this.get_sheetHeight(), this.get_sheetWidth());
        if (this.get_spriteHeight() == this.get_spriteWidth()) {
            System.out.printf(halfTextSingle, this.get_halfHeight() );
        } else {
        System.out.printf(halfTextDual, this.get_halfHeight(), this.get_halfWidth());}
        System.out.printf(quarterTextSingle, this.get_quarterHeight());
        this.outputSingleFrame(this.rowCount,this.columnCount);
    }

    public void outputSingleFrame() {
        int inRow = -1;
        int inColumn = -1;
        do {
            System.out.printf("Enter Row number (1-%d): ", this.rowCount);
            inRow = input.nextInt();
        } while ((inRow <= 0) || (inRow > this.rowCount));
        do {
            System.out.printf("Enter Column number (1-%d): ", this.columnCount);
            inColumn = input.nextInt();
        } while ((inColumn <= 0) || (inColumn > this.columnCount));
        this.outputSingleFrame(inRow, inColumn);

    }

    private void outputSingleFrame(int rowNum, int columnNum, int frameNum) {
        String outputText = "Region of Row %d, Column %d is Frame %d%n"+
                "x: %d    y: %d%n" +
                "w: %d    h: %d%n";

        try { // I don't think this can currently fail
            int[] x_y = this.getX_Y(rowNum, columnNum);
            System.out.printf(outputText, rowNum, columnNum, frameNum, x_y[0], x_y[1], this.get_spriteWidth(), this.get_spriteHeight());
        }
        catch (Exception e){
            System.err.println("Invalid entry.");
            this.outputSingleFrame();
        }
        System.out.println("Would you like information for another frame? y/n: ");
        if ("y".equalsIgnoreCase(input.next())) {this.outputSingleFrame();}
    }
    public void outputSingleFrame(int frameNum) {
        int[] rowCol = this.get_rowColumnFromFrame(frameNum);
        this.outputSingleFrame(rowCol[0], rowCol[1], frameNum);
    }

    public void outputSingleFrame(int rowNum, int columnNum) {
        int frameNum = this.get_frameNum(rowNum, columnNum);
        this.outputSingleFrame(rowNum, columnNum, frameNum);
    }


    public int[] getX_Y (int rowNum, int columnNum) {
        int[] outputArray = {1, 1};
        outputArray[1] += ((rowNum-1) * this.get_spriteWidth());
        outputArray[0] += ((columnNum-1) * this.get_spriteHeight());
        return outputArray;
    }

    public void promptPowers() {
        int holder;
        System.out.println("Values are saved by binary powers: 3 = 8, 6 = 64, 8 = 256");
        System.out.println("enter Height power");
        holder = input.nextInt();
        set_spriteHeight(holder);
        System.out.println("enter Width power");
        holder = input.nextInt();
        set_spriteWidth(holder);
    }

    static int[] validatePower(int testInt) {
        // return format {true or false as an int, the correct power or -1}
        int[] returnArray = {0, -1};

        if (testInt < powers.length) {
            returnArray[0] = 1; returnArray[1] = testInt;}
        else {
            for (int i = 0; i < powers.length; i++) {
                if (testInt == powers[i]) { returnArray[0] = 1; returnArray[1] = powers[i];};
                    break; }
            }
            return returnArray;
        }

    public void set_spriteWidth(int newInt) {
        int[] result = validatePower(newInt);
        if (1 == result[0]) this.spriteWidthPower = result[1];
    }

    public int get_spriteWidth() {
        return (int)Math.pow(2, this.spriteWidthPower);
    }
    public void set_spriteHeight(int newInt) {
        int[] result = validatePower(newInt);
        if (1 == result[0]) this.spriteHeightPower= result[1];
    }

    public int get_spriteHeight() {
        return (int)Math.pow(2, this.spriteHeightPower);
    }
    public void set_rowCount(int newInt) {if (newInt > 0) this.rowCount = newInt;}
    public void set_columnCount(int newInt) {if (newInt > 0) this.columnCount = newInt;}

    public int get_halfWidth() {return get_spriteWidth()/2;}
    public int get_halfHeight() {return get_spriteHeight()/2;}
    public int get_quarterHeight() {
        return Math.min(this.get_halfHeight(), this.get_halfWidth())/2;
    }
    public int get_sheetWidth() {return this.columnCount*this.get_spriteWidth();}
    public int get_sheetHeight() {return this.rowCount*this.get_spriteHeight();}
    public int get_frameNum(int rowNum, int columnNum) {
        // input is count not index, just like rowCount & columnCount, but output is index
        return (this.columnCount*(rowNum-1) + (columnNum-1));
    }

    public int[] get_rowColumnFromFrame(int frameNum) {
        int[] pair = {0, 0}; // row , col
        pair[1] = frameNum % this.columnCount;
        pair[0] = (frameNum - pair[1]) % this.columnCount;
        return pair;

    }
}
