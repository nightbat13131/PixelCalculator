package PixelCalculator;

import java.util.stream.IntStream;
import java.util.List;

public class SpriteSheet extends Sprite{

    private int rowCount = 2, columnCount = 2;

    public void setColumnCount(int columnCount) {
        if (columnCount > 0) {
            this.columnCount = columnCount;
        }
    }

    public void setRowCount(int rowCount) {
        if (rowCount > 0) {
            this.rowCount = rowCount;
        }
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getXFromRow (int rowNum) {
        return (rowNum * this.getSpriteWidth());
    }

    public int getYFromColumn (int columnNum) {
        return (columnNum * this.getSpriteHeight());
    }

    public int getYFromFrame(int frame) {
        return getYFromColumn(calculateColumnFromFrame(frame));
    }
    public int getXFromFrame(int frame) {
        return getXFromRow(calculateRowFromFrame(frame));
    }

    public int getSheetWidth() {
        return this.columnCount*(this.getSpriteWidth());}
    public int getSheetHeight() {
        return this.rowCount*(this.getSpriteHeight());}

    public int calculateFrameNum(int rowNum, int columnNum) {
        // input is count not index, just like rowCount & columnCount, but output is index
        return (this.columnCount*(rowNum-1) + (columnNum-1));
    }
    public int calculateRowFromFrame(int frameNum) {
        return frameNum / this.rowCount;
    }
    public int calculateColumnFromFrame(int frameNum) {
        return frameNum % this.columnCount;
    }

    public int getFrameMax() {
        return -1 + (this.getColumnCount() * this.getRowCount());
    }

    public String drawFrame(int frame) {
        if (frame > this.getFrameMax()){ return " "; }
        String[] outputArray = new String[10];
        String rowHat = "   |          |    ",
                colRim0 = " - +-----", colRim1 = "   +-----",
                colRim2 = "-----+ - ", colRim3 = "-----+   ";


        if (this.calculateRowFromFrame(frame) == 0) { // no rows above
            outputArray[0] = " ".repeat(10);
        } else { // yes rows above
            outputArray[0] = rowHat;
        }

        if (this.calculateRowFromFrame(frame) == (this.rowCount-1)) { // no rows below
            outputArray[9] = " ".repeat(10);
        } else { // yes rows below
            outputArray[9] = rowHat;
        }

        if (this.calculateColumnFromFrame(frame) == 0) { // no columns left
            outputArray[1] = colRim1;
            outputArray[8] = colRim1;
        } else { // yes columns left
            outputArray[1] = colRim0;
            outputArray[8] = colRim0;
        }
        if (this.calculateColumnFromFrame(frame) == (this.rowCount-1)) { // no columns right
            outputArray[1] += colRim3;
            outputArray[8] += colRim3;
        } else { // yes columns right
            outputArray[1] += colRim2;
            outputArray[8] += colRim2;
        }





        return String.join("%n", outputArray);
    }
}
