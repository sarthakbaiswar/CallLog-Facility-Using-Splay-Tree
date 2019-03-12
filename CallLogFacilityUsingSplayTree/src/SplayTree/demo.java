package SplayTree;

import static SplayTree.SplayTreeforCalllogFacility.displaySplayTree;
import static SplayTree.SplayTreeforCalllogFacility.find_count;
import static SplayTree.SplayTreeforCalllogFacility.getCalldata;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.util.Pair;

/**
 * @Aim: Design a Splay tree as data structure to demonstrate the CALL LOG 
 * facility available in mobile phones.
 * 
 * @Demonstration: The tree demonstrates the total number of calls made from 
 * phone at the node for a specific contact number. If the value of calls is 
 * greater than 'x', here 50, the node is colored "Black" else "Red".
 * 
 * @author Sarthak Baiswar
 */

/**
 * @class:demo
 * Enter 0 to end the loop
 * Search through phone number in call_data (static for now)
 */
public class demo {
    public static void main(String[] args) {
        SplayTreeforCalllogFacility spt = new SplayTreeforCalllogFacility();

        ArrayList<Pair> call_log;
        call_log = getCalldata();
        
        //formation of the tree through call_data
        for (Pair p: call_log){
            int count = (int) p.getKey();
            String phone_no = (String) p.getValue();
            spt.insert(count, phone_no);
        }

        System.out.println("CALL LOG data loaded and tree is formed");
        System.out.println("Preorder after insert :"+spt+"\n");
        displaySplayTree(spt.getRoot(), 0);
        System.out.println("***New Root node Count: " + spt.getRootValue() + " Contact no. " + spt.getRoot().phno + "***");
        
        System.out.println("----------------------------------------------------------------------");

        //search with some phone number
        String phone_no;
        do{
            System.out.println("Enter contact no. to be found: ");
            Scanner sc = new Scanner(System.in);
            phone_no = sc.next();

            if(!phone_no.equals("0")){
                System.out.println("----------------------------------------------------------------------");
                int count = 0;
                count = find_count(call_log, phone_no);
                // root node is the node which was searched 
                System.out.println("***Node found or not:"+spt.find(count)+"***");
                System.out.println("Preorder after search:"+spt+"\n");
                displaySplayTree(spt.getRoot(), 0);
                
                if(spt.find(count) == false){
                    System.out.println("Check if you have entered the contact no. correctly and it is in the dataset");
                    System.out.println("Data not found so, last traversed node brought to root");
                }
                System.out.println("***New Root node Count: " + spt.getRootValue() + " Contact no. " + spt.getRoot().phno + "***");
                System.out.println("----------------------------------------------------------------------");
            }  
        }while(!phone_no.equals("0"));
    }
}

/**
 * @OUTPUT:
 * @run:
    CALL LOG data loaded and tree is formed
    Preorder after insert :99 -> 84 -> 70 -> 64 -> 42 -> 39 -> 22 -> 17 -> 

    Count: 99 Contact No.7122260603(B)

         Count: 84 Contact No.7122231110(B)

              Count: 70 Contact No.9096387292(B)

                   Count: 64 Contact No.7122277110(B)

                        Count: 42 Contact No.8149077639(R)

                             Count: 39 Contact No.8600297789(R)

                                  Count: 22 Contact No.9096384797(R)

                                       Count: 17 Contact No.9850302107(R)

    ***New Root node Count: 99 Contact no. 7122260603***
    ----------------------------------------------------------------------
    Enter contact no. to be found: 
    8600297789
    ----------------------------------------------------------------------
    Count:39
    ***Node found or not:true***
    Preorder after search:39 -> 22 -> 17 -> 99 -> 70 -> 42 -> 64 -> 84 -> 

         Count: 99 Contact No.7122260603(B)

                   Count: 84 Contact No.7122231110(B)

              Count: 70 Contact No.9096387292(B)

                        Count: 64 Contact No.7122277110(B)

                   Count: 42 Contact No.8149077639(R)

    Count: 39 Contact No.8600297789(R)

         Count: 22 Contact No.9096384797(R)

              Count: 17 Contact No.9850302107(R)

    ***New Root node Count: 39 Contact no. 8600297789***
    ----------------------------------------------------------------------
    Enter contact no. to be found: 
    9096384797
    ----------------------------------------------------------------------
    Count:22
    ***Node found or not:true***
    Preorder after search:22 -> 17 -> 39 -> 99 -> 70 -> 42 -> 64 -> 84 -> 

              Count: 99 Contact No.7122260603(B)

                        Count: 84 Contact No.7122231110(B)

                   Count: 70 Contact No.9096387292(B)

                             Count: 64 Contact No.7122277110(B)

                        Count: 42 Contact No.8149077639(R)

         Count: 39 Contact No.8600297789(R)

    Count: 22 Contact No.9096384797(R)

         Count: 17 Contact No.9850302107(R)

    ***New Root node Count: 22 Contact no. 9096384797***
    ----------------------------------------------------------------------
    Enter contact no. to be found: 
    7122260603
    ----------------------------------------------------------------------
    Count:99
    ***Node found or not:true***
    Preorder after search:99 -> 39 -> 22 -> 17 -> 70 -> 42 -> 64 -> 84 -> 

    Count: 99 Contact No.7122260603(B)

                   Count: 84 Contact No.7122231110(B)

              Count: 70 Contact No.9096387292(B)

                        Count: 64 Contact No.7122277110(B)

                   Count: 42 Contact No.8149077639(R)

         Count: 39 Contact No.8600297789(R)

              Count: 22 Contact No.9096384797(R)

                   Count: 17 Contact No.9850302107(R)

    ***New Root node Count: 99 Contact no. 7122260603***
    ----------------------------------------------------------------------
    Enter contact no. to be found: 
    7896131
    ----------------------------------------------------------------------
    Count:0
    ***Node found or not:false***
    Preorder after search:17 -> 99 -> 22 -> 39 -> 70 -> 42 -> 64 -> 84 -> 

         Count: 99 Contact No.7122260603(B)

                             Count: 84 Contact No.7122231110(B)

                        Count: 70 Contact No.9096387292(B)

                                  Count: 64 Contact No.7122277110(B)

                             Count: 42 Contact No.8149077639(R)

                   Count: 39 Contact No.8600297789(R)

              Count: 22 Contact No.9096384797(R)

    Count: 17 Contact No.9850302107(R)

    Check if you have entered the contact no. correctly and it is in the dataset
    Data not found so, last traversed node brought to root
    ***New Root node Count: 17 Contact no. 9850302107***
    ----------------------------------------------------------------------
    Enter contact no. to be found: 
    0
*/
