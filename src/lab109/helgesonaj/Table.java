package lab109.helgesonaj;

/**
 * A class that can be used to create ASCII tables.
 * @version 4/12/2024
 * @author Alec Helgeson
 */

public class Table {
    private String[] tableRows;
    private int addRowIndex = 0;
    private int columnWidth = 0;
    private int numberOfColumns = 0;
    private int tableLength = 3; // starts as three to acomadate a header

    /**
     * Constructor
     */
    Table() {
        tableRows = new String[tableLength];
    }

    /**
     * Builds the header for the table.
     * The number of arguments determines the number of columns.
     * column width is set by the largest string in the given arguments.
     * @param data
     */
    public void buildHeader(String... data) {
        columnWidth = 0;//Reset in case someone wants to overwrite the table header.
        numberOfColumns = data.length;
        findLargestString(data);
        String topRow = "";
        String dataRow = "";
        String bottomRow = "";

        for (String s : data) {
            String padding = getSeparatorPadding(s);
            topRow += padding;
            dataRow += getDataRowPadding(s);
            bottomRow += padding;
        }
        addRowIndex += 3;//So the rest of the program inserts after the header
        tableRows[0] = topRow + "+";
        tableRows[1] = dataRow + "|";
        tableRows[2] = bottomRow + "+";
    }
    /**
     * Adds a row to the table.
     * @param data
     */
    public void addRow(String... data) {
        String newDataRow = "";
        String bottomCap = "";
        for (int i = 0; i < numberOfColumns; i++) {
            if (i < data.length) {
                newDataRow += getDataRowPadding(data[i]);
                bottomCap += getSeparatorPadding(data[i]);
            } else {
                newDataRow += getSpaceing(i);
                bottomCap += getSeparatorPadding(data[i]);
            }
        }
        isTableBig();
        tableRows[addRowIndex++] = newDataRow + "|";
        isTableBig();
        tableRows[addRowIndex++] = bottomCap + "+";
    }
    /**
     * Finds the largest string in an array of strings
     * @param data
     */
    private void findLargestString(String data[]) {
        int currentMax = 0;
        for (String s : data) {
            if ((s != null) && (currentMax <= s.length())) {
                currentMax = s.length();
            }
        }
        columnWidth += currentMax + 4;
    }
    /**
     * Prints all of the non-null strings in the table.
     */
    public void printTable() {
        for (String s : tableRows) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    // This function replaces String.format because it was not working properly.
    /**
     * Ensures equal spacing of data rows. based on the largest column.
     * @param s
     * @return
     */
    public String getDataRowPadding(String s) {
        if(s == null){
            return null;
        }
        double spaces = ((double)columnWidth - (double)s.length()) / 2.0;
        String dataRow = "";

        if (spaces % 1.0 == 0) {//check for trunkation
            dataRow += "|";
            for (int i = 0; i < spaces; i++) {
                dataRow += " ";
            }
            dataRow += s;
            for (int i = 0; i < spaces; i++) {
                dataRow += " ";
            }
        } else {//if trunkation exists remove on space from left padding.
             dataRow += "|";
             for (int i = 0; i < spaces; i++) {
                 dataRow += " ";
             }
             dataRow += s;
             for (int i = 0; i < spaces - 1; i++) {
                 dataRow += " ";
             }
        }

        return dataRow;
    }
    /**
     * Checks to be sure the table is big enough to insert a new row.
     */
    private void isTableBig() {
        if (addRowIndex >= tableLength) {
            String[] newTable = new String[tableLength * 2];
            tableLength += 2;
            for (int i = 0; i < tableRows.length; i++) {
                newTable[i] = tableRows[i];
            }
            tableRows = newTable;
        }
    }
    /**
     * Ensures proper spacing between column delimiters of the row dividers.
     * @param s
     * @return
     */
    private String getSeparatorPadding(String s) {
        if(s == null){
            return null;
        }
        String padding = "+";
        for (int i = 0; i < columnWidth; i++) {
            padding += "-";
        }
        return padding;
    }
    /**
     * pads empty cells to ensure equal column spacing.
     * @param counter
     * @return
     */
    private String getSpaceing(int counter) {
        String padding = "|";
        for (int i = 0; i < columnWidth; i++) {
            padding += " ";
        }
        return padding;
    }
}
