package lab109.helgesonaj;

import java.util.Random;;

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

        // Step 4

        final int MAX = 1000; // controls the size of the program.
        BinarySearchTree millionAcending = new BinarySearchTree();
        BinarySearchTree millionDecending = new BinarySearchTree();

        // Random Trees
        BinarySearchTree millionRandomOne = new BinarySearchTree();
        BinarySearchTree millionRandomTwo = new BinarySearchTree();
        BinarySearchTree millionRandomThree = new BinarySearchTree();
        BinarySearchTree millionRandomFour = new BinarySearchTree();
        BinarySearchTree millionRandomFive = new BinarySearchTree();

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
        for (int i = 0; i < MAX; i++) {
            millionAcending.insert(i);
            millionDecending.insert(-i);
            millionRandomOne.insert(uniqueRandomNumbersOne.get(i));
            millionRandomTwo.insert(uniqueRandomNumbersTwo.get(i));
            millionRandomThree.insert(uniqueRandomNumbersThree.get(i));
            millionRandomFour.insert(uniqueRandomNumbersFour.get(i));
            millionRandomFive.insert(uniqueRandomNumbersFive.get(i));

        }

        System.out.print("\n\nAcending Tree Height: " + millionAcending.height(millionAcending.root));
        System.out.print("\nDecending Tree Height: " + millionDecending.height(millionDecending.root));

        System.out.print("\n\nRandom Tree Height One: " + millionRandomOne.height(millionRandomOne.root));
        System.out.print("\nRandom Tree Height Two: " + millionRandomTwo.height(millionRandomTwo.root));
        System.out.print("\nRandom Tree Height Three: " + millionRandomThree.height(millionRandomThree.root));
        System.out.print("\nRandom Tree Height Four: " + millionRandomFour.height(millionRandomFour.root));
        System.out.print("\nRandom Tree Height Five: " + millionRandomFive.height(millionRandomFive.root));
        System.out.println();


        //step 5


        String[] data = new String[5];

        data[0] = "Condition";
        data[1] = "   N   ";
        data[2] = "Height";
        data[3] = "log(N)";
        data[4] = "A bunch of gobldy gok";
        Table tableOne = new Table();
        tableOne.buildHeader(data);

        tableOne.printTable();

    }

}
