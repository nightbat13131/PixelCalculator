import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class SpriteSheet {
    // height x width -- x, y -- rows, columns
    public Sprite thisSprite;
    final private Scanner input = new Scanner(System.in);
    private int rowCount = 1, columnCount = 1;



    public SpriteSheet() {
        this.thisSprite = new Sprite();
    }
    public SpriteSheet(Sprite sprite) {
        this.setThisSprite(sprite);
    }

    public SpriteSheet(int[] intArray) {
        if (intArray.length >= 2) {
            Sprite newSprite = new Sprite(intArray[0], intArray[1]);
            this.setThisSprite(newSprite);
        }
        if (intArray.length >= 4) {
            this.setRowCount(intArray[3]);
            this.setColumnCount(intArray[4]);
        }
        if (intArray.length >4) {
            for (int i = 4; i < intArray.length; i ++ ) {
                // get frame for each int here

            }
        }
    }

    public void setThisSprite(Sprite thisSprite) {
        this.thisSprite = thisSprite;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
    /*
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

    public void setRowCount(int newInt) {if (newInt > 0) this.rowCount = newInt;}
    public void setColumnCount(int newInt) {if (newInt > 0) this.columnCount = newInt;}

    public int getSheetWidth() {return this.columnCount*this.get_spriteWidth();}
    public int getSheetHeight() {return this.rowCount*this.get_spriteHeight();}
    public int calculateFrameNum(int rowNum, int columnNum) {
        // input is count not index, just like rowCount & columnCount, but output is index
        return (this.columnCount*(rowNum-1) + (columnNum-1));
    }

    public int[] calculateRowColumnFromFrame(int frameNum) {
        int[] pair = {0, 0}; // row , col
        pair[1] = frameNum % this.columnCount;
        pair[0] = (frameNum - pair[1]) % this.columnCount;
        return pair;

    }


     */
}
