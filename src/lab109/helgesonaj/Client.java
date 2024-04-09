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

        //Step 3

        final int CONTROL = 10;
        Random randomizer = new Random();
        BinarySearchTree bt = new BinarySearchTree();  
        
        System.out.printf("%-20s","\nInsertion order: ");
        for(int i = 0; i < CONTROL; i++){
            int someRandomizedNumber = randomizer.nextInt(100);
            bt.insert(someRandomizedNumber);
            System.out.printf("%d ", someRandomizedNumber);
        }
        System.out.println();

        System.out.printf("%-20s","\npreOrder: ");
        bt.preOrderTraversal(bt.root);

        System.out.printf("%-20s","\nPostOrder: ");
        bt.postOrderTraversal(bt.root);

        System.out.printf("%-20s","\nInOrder: ");
        bt.inorderTraversal(bt.root);

        System.out.print("\nTree height: " + bt.height(bt.root));


        //Step 4

        final int MAX = 7500; //8325 is the limit, will crash at 8326, unreliable past 7500.
        BinarySearchTree millionAcending = new BinarySearchTree();
        BinarySearchTree millionDecending = new BinarySearchTree();
        BinarySearchTree millionRandom = new BinarySearchTree();
        Set<Integer> uniqueRandomNumbers = new Set<>(MAX);

        
        //create a set of random numbers for the million Random tree.
        while(uniqueRandomNumbers.size() < MAX){
            uniqueRandomNumbers.add(randomizer.nextInt(MAX * 10));
        }

        for(int i = 0; i < MAX; i++){
            millionAcending.insert(i);
            millionDecending.insert(-i);
            millionRandom.insert(uniqueRandomNumbers.get(i));
        }
        System.out.print("\nAcending Tree Height: " + millionAcending.height(millionAcending.root));
        System.out.print("\nDecending Tree Height: " + millionDecending.height(millionDecending.root));
        System.out.print("\nRandom Tree Height: " + millionRandom.height(millionRandom.root));
    }
    
}
