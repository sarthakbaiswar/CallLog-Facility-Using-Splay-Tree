/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SplayTree;

import java.util.ArrayList;
import javafx.util.Pair;


/**
 * File Description: This file consists of the necessary utility functions for 
 * displaying, getting data and finding count for specific contact number.
 * 
 * @author Sarthak Baiswar 
 */ 
public class Utils {

    /**
     * @utilityfunction: displaySplayTree
     * @purpose: display splay tree in tree form
     * @arguments: node, gap - for displaying in tree form
     * @return: void
     */
    public static void displaySplayTree(SplayTreeforCalllogFacility.Node root , int gap){
        if(root == null){
            return;
        }
        displaySplayTree(root.right, gap+5);
        for(int i=0; i<gap; i++)
            System.out.print(" ");
        System.out.println("Count: " + root.data + " "+ "Contact No." + root.phno + (root.data > 50 ? "(B)" : "(R)"));
        System.out.print("\n");
        displaySplayTree(root.left, gap+5);
    }
    
    
    /**
     * @utilityfunction: getCalldata
     * @purpose: used to get call data
     * stores count and phone_no. as pair in ArrayList
     * @arguments: void
     * @return: call_data (ArrayLsit<Pair>)
     */
    public static ArrayList<Pair> getCalldata(){
        
        ArrayList<Pair> call_data = new ArrayList<>();
        // storing data in key-value pair form as key-count and value-String(Contact no.)
        // data can be retreived from CALL LOG of smartphones to store in same form
        // for now data this is used as static dataset only
        call_data.add(new Pair(17, "9850302107"));
        call_data.add(new Pair(39, "8600297789"));
        call_data.add(new Pair(22, "9096384797"));
        call_data.add(new Pair(42, "8149077639"));
        call_data.add(new Pair(70, "9096387292"));
        call_data.add(new Pair(64, "7122277110"));
        call_data.add(new Pair(84, "7122231110"));
        call_data.add(new Pair(99, "7122260603"));
        
        return call_data;
    }
    
    /**
     * @utilityfunction: find_count
     * @purpose: used to get count for specific given phone_no. from call_data
     * @arguments: call_data, phone_no
     * @return: count (int)
     */
    public static int find_count(ArrayList<Pair> call_data, String phone_no){
        int count = 0;
        for (Pair p: call_data){
            if(p.getValue().equals(phone_no))
                count = (int) p.getKey();
        }
        System.out.println("Count:" + count);
        return count;
    }
}
