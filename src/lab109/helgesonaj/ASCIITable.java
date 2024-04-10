package lab109.helgesonaj;

public class ASCIITable {
    private String [] tableRows;


    private class Header{
        private String topRow;
        private String dataRow;
        private String bottomRow;
        private int collumWidth = 0;

        Header(String... data){
            findLargestString(data);
            buildHeader(data);

        }

        private void findLargestString(String... data){
            int currentMax = 0;
            for(String s : data){
                if(currentMax <= s.length()){currentMax = s.length();}
            }
            collumWidth += currentMax + 4;// +4 to add 2 spaces on either side of biggest string.
        }

        private void buildHeader(String... data){
            String padding = "";
            for(int i = 0; i < collumWidth; i++){
                padding += "-";
            }

            for(String s : data){
                topRow += String.format("+%s", padding);
                dataRow += String.format("|  %s  ", s);
                bottomRow += String.format("+%s", padding);
            }
            topRow += "+";
            dataRow += "|";
            bottomRow += "+";

            tableRows[0] = topRow;
            tableRows[1] = dataRow;
            tableRows[2] = bottomRow;
        }

    }


    ASCIITable(){}

    
}
