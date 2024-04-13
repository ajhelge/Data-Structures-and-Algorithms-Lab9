package lab109.helgesonaj;

import java.util.Random;

/**
 *
 * @author ajhel
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Step 3

        final int CONTROL = 10;
        Random randomizer = new Random(161);
        BinarySearchTree bt = new BinarySearchTree();

        System.out.printf("%-20s", "\nInsertion order: ");
        for (int i = 0; i < CONTROL; i++) {
            int someRandomizedNumber = randomizer.nextInt(100);
            bt.insert(someRandomizedNumber);
            System.out.printf("%d ", someRandomizedNumber);
        }
        System.out.println();

        System.out.printf("%-20s", "\npreOrder: ");
        bt.preOrderTraversal(bt.root);

        System.out.printf("%-20s", "\nPostOrder: ");
        bt.postOrderTraversal(bt.root);

        System.out.printf("%-20s", "\nInOrder: ");
        bt.inorderTraversal(bt.root);

        System.out.print("\nTree height: " + bt.height(bt.root));

        // Step 4 & 5

        String[] data = new String[4];//to hold header contents
        data[0] = "Condition";
        data[1] = "N";
        data[2] = "Height";
        data[3] = "log(N)";

        for(int i = 0; i < 4; i++){
            int MAX = 1000; // controls the size of the program.
            if(i == 1){
                MAX = 10000;
            }
            if(i == 2){
                MAX = 50000;
            }
            if(i == 3){
                MAX = 100000;
            }
            if(i == 4){
                MAX = 1000000;
            }
            
            //initaltize a table.
            Table table = new Table();
            //build headers for each table.
            table.buildHeader(data);

            //Start building trees for tables
            BinarySearchTree Acending = new BinarySearchTree();
            BinarySearchTree Decending = new BinarySearchTree();

            // Random Trees
            BinarySearchTree RandomOne = new BinarySearchTree();
            BinarySearchTree RandomTwo = new BinarySearchTree();
            BinarySearchTree RandomThree = new BinarySearchTree();
            BinarySearchTree RandomFour = new BinarySearchTree();
            BinarySearchTree RandomFive = new BinarySearchTree();

            // Random Numbers for each random tree
            Set<Integer> uniqueRandomNumbersOne = new Set<>(MAX);
            Set<Integer> uniqueRandomNumbersTwo = new Set<>(MAX);
            Set<Integer> uniqueRandomNumbersThree = new Set<>(MAX);
            Set<Integer> uniqueRandomNumbersFour = new Set<>(MAX);
            Set<Integer> uniqueRandomNumbersFive = new Set<>(MAX);

            // Unique Randomizer for random trees
            Random randomizerTwo = new Random();

            // create a set of random numbers for million Random tree 1.
            while (uniqueRandomNumbersOne.size() < MAX) {
                uniqueRandomNumbersOne.add(randomizerTwo.nextInt(MAX));
            }
            // create a set of random numbers for million Random tree 2.
            while (uniqueRandomNumbersTwo.size() < MAX) {
                uniqueRandomNumbersTwo.add(randomizerTwo.nextInt(MAX));
            }
            // create a set of random numbers for million Random tree 3.
            while (uniqueRandomNumbersThree.size() < MAX) {
                uniqueRandomNumbersThree.add(randomizerTwo.nextInt(MAX));
            }
            // create a set of random numbers for million Random tree 4.
            while (uniqueRandomNumbersFour.size() < MAX) {
                uniqueRandomNumbersFour.add(randomizerTwo.nextInt(MAX));
            }
            // create a set of random numbers for million Random tree 5.
            while (uniqueRandomNumbersFive.size() < MAX) {
                uniqueRandomNumbersFive.add(randomizerTwo.nextInt(MAX));
            }

            //insert all values into their respective tables
            for (int j = 0; j < MAX; j++) {
                Acending.insert(j);
                Decending.insert(-j);
                RandomOne.insert(uniqueRandomNumbersOne.get(j));
                RandomTwo.insert(uniqueRandomNumbersTwo.get(j));
                RandomThree.insert(uniqueRandomNumbersThree.get(j));
                RandomFour.insert(uniqueRandomNumbersFour.get(j));
                RandomFive.insert(uniqueRandomNumbersFive.get(j));

            }


            int AHeight = Acending.height(Acending.root);
            int DHeight = Decending.height(Decending.root);
            int R1Height = RandomOne.height(RandomOne.root);
            int R2Height = RandomTwo.height(RandomTwo.root);
            int R3Height = RandomThree.height(RandomThree.root);
            int R4Height = RandomFour.height(RandomFour.root);
            int R5Height = RandomFive.height(RandomFive.root);

            if(i == 0){// So this only happens one time per program run.
            System.out.print("\n\nAcending Tree Height: " + AHeight);
            System.out.print("\nDecending Tree Height: " + DHeight);
            System.out.print("\n\nRandom Tree Height One: " + R1Height);
            System.out.print("\nRandom Tree Height Two: " + R2Height);
            System.out.print("\nRandom Tree Height Three: " + R3Height);
            System.out.print("\nRandom Tree Height Four: " + R4Height);
            System.out.print("\nRandom Tree Height Five: " + R5Height);
            }
            System.out.println();

            //Convert height int's to strings.
            String MAXS = String.format("%,d", MAX);
            String AHS = String.format("%,d", AHeight);
            String DHS = String.format("%,d", DHeight);
            String R1HS = String.format("%,d", R1Height);
            String R2HS = String.format("%,d", R2Height);
            String R3HS = String.format("%,d", R3Height);
            String R4HS = String.format("%,d", R4Height);
            String R5HS = String.format("%,d", R5Height);
  
            String log = String.format("%.2f", (Math.log(MAX) / Math.log(2)));//Log base 2
            //Add all table contents.
            table.addRow("Acending", MAXS, AHS, log);
            table.addRow("Decending", MAXS, DHS, log);
            table.addRow("Random", MAXS, R1HS, log);
            table.addRow("Random", MAXS, R2HS, log);
            table.addRow("Random", MAXS, R3HS, log);
            table.addRow("Random", MAXS, R4HS, log);
            table.addRow("Random", MAXS, R5HS, log);

            table.printTable();
            System.out.println();
        }

    }

}
