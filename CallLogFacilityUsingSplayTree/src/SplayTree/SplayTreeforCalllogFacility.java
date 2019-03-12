package SplayTree;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 * @FileDescription: Splay tree data structure for demonstrating CALL LOG 
 * facility in mobile phones.
 * This file consists of splay tree functions and other required
 * utility functions for demonstration.
 * 
 * @author Sarthak Baiswar
 */
public class SplayTreeforCalllogFacility {
    private Node root;
    private String string;
    
    /**
    * @class: Node
    * @purpose: define node for object creation
    * @params: data, phno, left, right
    */  
    public class Node{
        /*
        * data contains the count for a specific contact no.
        * phno contains the string for the contact no.       
        */
        public int data;
        public String phno;
        public Node left, right;
        
        /* With each node the above details are saved*/
        public Node(int count, String phone_no){
            this.data = count;
            this.phno = phone_no;
            left = null;
            right = null;
        }
    }
    
    public SplayTreeforCalllogFacility(){
        root = null;
    }
    
    /**
    * @function: leftRotate
    * @purpose: perform left rotate operation
    * @arguments: node
    * @return: node
    */  
    private Node leftRotate(Node node){
        Node newT = node.left;
        node.left = newT.right;
        newT.right = node;
        return newT;
    }
    
    /**
    * @function: rightRotate
    * @purpose: perform right rotate operation
    * @arguments: node
    * @return: node
    */    
    private Node rightRotate(Node node){
        Node newT = node.right;
        node.right = newT.left;
        newT.left = node;
        return newT;
    }
    
    /**
    * @function: splay
    * @purpose: carrying out splay operation with zig-zig and zig-zag to bring the
    * recently accessed contact no. to root based on count.
    * @arguments: data(i.e. count for specific contact no.)
    */
    private void splay(int data){
        boolean flag = true;
        Node node = root;
        Node P, GP, GGP;
        P = null;
        GP = null;
        GGP = null;
        
        while(true){
            if(node == null || data == node.data)
                break;
            //left side
            else if(node.left != null && data < node.data){
                // if left child data matches do left rotate
                if(data == node.left.data){
                    node = leftRotate(node);
                }
                //zig-zig
                // the node has grandchild and data asked for is in it. Perform [LL]
                else if(node.left.left != null && data == node.left.left.data){
                    GP = node;
                    P = node.left;
                    node = leftRotate(GP);
                    node = leftRotate(P);
                    flag = true;
                }
                //zig-zag
                // the node has grandchild and data asked for is in it. Perform [RL]
                else if(node.left.right != null && data == node.left.right.data){
                    GP = node;
                    P = node.left;
                    GP.left = rightRotate(P);
                    node = leftRotate(GP);
                    flag = true;
                }
                
                else if (data < node.data){
                    GGP = node;
                    node = node.left;
                }
            }
            //right side
            else if(node.right != null && data > node.data){
                //right child data match perform right rotate
                if(data == node.right.data)
                    node = rightRotate(node);
                // zig-zig operation
                // the node has grandchild and data asked for is in it. Perform [RR]
                else if(node.right.right != null && data == node.right.right.data){
                        GP = node;
                        P = node.right;
                        node = rightRotate(GP);
                        node = rightRotate(P);
                        flag = true;
                }
                //zig-zag operation
                // the node has grandchild and data asked for is in it. Perform [LR]
                else if(node.right.left != null && data == node.right.left.data){
                    GP = node;
                    P = node.right;
                    GP.right = leftRotate(P);
                    node = rightRotate(GP);
                    flag = true;
                }

                else if (data > node.data){
                    GGP = node;
                    node = node.right;
                }
            }
            else if((node.left == null && data <node.data) || (node.right == null && data > node.data)){
                data = node.data;
                node = root;
                GGP = null;
            }
            
            // link node after zig-zig and zig-zag
            // set root to node
            if (flag && GGP != null){
                if(node.data < GGP.data)
                    GGP.left = node;
                else if(node.data > GGP.data)
                    GGP.right = node;
                node = root;
                //reset
                GGP = null;
                flag = false;
            }
        }
        
        root = node;
        
    }
    
    /**
    * @utilityfunction: isNull
    * @arguments: void
    * @purpose: checks whether root is null or not
    * @return: boolean value true or false
    */
    public boolean isNull(){
        return root == null;
    }
    
    /**
     * @function: insert
     * @purpose:inserts a node
     * @arguments: data, phone no.
     * @return: void
     */
    public void insert(int data, String phone_no){
        root = insert(data, phone_no, root);
        splay(data);
    }
    
    /**
     * @function: insert- private function
     * @purpose:inserts a node
     * @arguments: data, phone no., node
     * @return: void
     */
    private Node insert(int data,String phone_no, Node node){
        if(node == null)
            return new Node(data, phone_no);
        else{
            if(data < node.data)
                node.left = insert(data, phone_no, node.left);
            else if(data > node.data)
                node.right = insert(data, phone_no, node.right);
            return node;
        }
    }
    
    /**
     * @utilityfunction: getRootValue
     * @purpose: returns root data
     * @arguments: void
     * @return: Integer data
     */
    public Integer getRootValue(){
        if(root != null)
            return root.data;
        else
            return null;
    }
    
    /**
     * @utilityfunction: getRoot
     * @purpose: returns root
     * @arguments: void
     * @return: node(root)
     */
    public Node getRoot(){
        return root;
    }

    /**
     * @function: delete
     * @purpose:Removes a node just like a search tree does, then rotates the
     * removed node's parent to the top.
     * @arguments data - data to remove
     * @return - boolean value true or false.
     */
    public boolean delete(int data) {
        if (!isNull()) {
            splay(data);
            if (root != null && root.data == data) {
                if (root.left != null) {
                    Node tmp = root.right;
                    root = root.left;
                    splay(data);
                    root.right = tmp;
                } else
                    root = root.right;
                return true;
            }
        }
        return false;
    }

    /**
     * @function: find 
     * @purpose: Find the data to be found 
     * Rotates the node to the top if found or the last node
     * accessed if not found 
     * @arguments: data to find
     * @return: boolean value true or false
     */
    public boolean find(int data) {
        if (isNull())
                return false;
        splay(data);
        if (root.data == data) {
                return true;
        } else {
                return false;
        }
    }
    
    /**
     * @utilityfunction: preOrder
     * @purpose: preorder traversal of splay tree 
     * @arguments: node
     * @return: void
     */
    void preOrder(Node node) {
        if (node == null)
                return;
        string += node.data + " -> ";
        preOrder(node.left);
        preOrder(node.right);
    }
    
    @Override
    public String toString() {
            string = "";
            preOrder(getRoot());
            return string;
    }

    /**
     * @utilityfunction: displaySplayTree
     * @purpose: display splay tree in tree form
     * @arguments: node, gap - for displaying in tree form
     * @return: void
     */
    public static void displaySplayTree(Node root , int gap){
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
