package lab109.helgesonaj;

public class Table {
    private String[] tableRows;
    private int addRowIndex = 0;
    private int columnWidth = 0;
    private int numberOfColumns = 0;
    private int tableLength = 3; // starts as three to acomadate a header

    Table() {
        tableRows = new String[tableLength];
    }

    public void buildHeader(String... data) {
        columnWidth = 0;
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
        addRowIndex += 3;
        tableRows[0] = topRow + "+";
        tableRows[1] = dataRow + "|";
        tableRows[2] = bottomRow + "+";
    }

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

    private void findLargestString(String data[]) {
        int currentMax = 0;
        for (String s : data) {
            if (currentMax <= s.length()) {
                currentMax = s.length();
            }
        }
        columnWidth += currentMax + 4;
    }

    public void printTable() {
        for (String s : tableRows) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    // This function replaces String.format because it was not working properly.
    public String getDataRowPadding(String s) {
        int spaces = (columnWidth - s.length()) / 2;
        String dataRow = "";

        if (s.length() % 2 == 0) {
            dataRow += "|";
            for (int i = 0; i < spaces; i++) {
                dataRow += " ";
            }
            dataRow += s;
            for (int i = 0; i < spaces; i++) {
                dataRow += " ";
            }
        }// else {
        //     dataRow += "|";
        //     for (int i = 0; i < spaces; i++) {
        //         dataRow += " ";
        //     }
        //     dataRow += s;
        //     for (int i = 0; i < spaces; i++) {
        //         dataRow += " ";
        //     }
        // }

        return dataRow;
    }

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

    private String getSeparatorPadding(String s) {
        String padding = "+";
        if (s.length() % 2 == 0) {
            for (int i = 0; i < columnWidth; i++) {
                padding += "-";
            }
        }
        else{
            for (int i = 0; i < columnWidth; i++) {
                padding += "-";
            }
        }
        return padding;
    }

    private String getSpaceing(int counter) {
        String padding = "|";
        for (int i = 0; i < columnWidth; i++) {
            padding += " ";
        }
        return padding;
    }
}
