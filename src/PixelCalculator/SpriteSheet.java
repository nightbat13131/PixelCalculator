package PixelCalculator;

public class SpriteSheet {
    // height x width -- x, y -- rows, columns
    public Sprite sprite = new Sprite();
    // final private Scanner input = new Scanner(System.in);
    private int rowCount = 2, columnCount = 2;

    public SpriteSheet() {
        this.setSprite(new Sprite());
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
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

    public Sprite getSprite() {
        return sprite;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getXFromRow (int rowNum) {
        return 1 + ((rowNum-1) * this.sprite.getSpriteWidth());
    }
    public int getPaddedXFromRow (int rowNum) {
        return this.sprite.getPadding() + this.getXFromRow(rowNum);
    }
    public int getYFromColumn (int columnNum) {
        return 1 + ((columnNum-1) * this.sprite.getSpriteHeight());
    }
    public int getPaddedYFromColumn (int columnNum) {
        return this.sprite.getPadding() + this.getYFromColumn(columnNum);
    }

    public String modeHelperText() {return this.sprite.modeHelperText();}


    public int getSheetWidth() {
        return this.columnCount*(this.sprite.getHalfWidth() + (2*this.sprite.getPadding() ));}
    public int getSheetHeight() {
        return this.rowCount*(this.getSheetHeight() + (2*this.sprite.getPadding()) );}

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

}
