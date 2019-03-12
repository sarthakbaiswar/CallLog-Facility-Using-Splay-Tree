# CallLog-Facility-Using-Splay-Tree
Using Splay tree as Data Structure, demonstration of CallLog facility of mobile phones

*************************************
## ** Description **: 

Designing Splay Tree as data structure to demonstrate the CALL LOG facility 
available in mobile phones. The tree will also demonstrate the total number of calls [incoming
+outgoing] made from the phone at the node. If the value of calls is greater than "x", the node
is colored "Black", otherwise, it is coloured "Red".

*******************************************
## ** Technology stack **:

Java, Netbeans
*****************************************

## ** Functions **:
 
- Function: leftRotate

  Role: perform left rotate operation

  Arguments: node

  Returns: node

- Function: rightRotate 

  Role: perform right rotate operation 

  Arguments: node 

  Returns: node 

- Function: splay 

  Role: carrying out splay operation with zig-zig and zig-zag to bring the
        recently accessed contact no. to root based on count.

  Arguments: data(i.e. count for specific contact no.)

- Function: insert 

  Role: inserts a node in the splay tree, after insertion new node at the root
  
  Arguments: data, phone no., node

  Returns: void

- Function: delete

  Role: Removes a node just like a search tree does, then rotates the
        removed node's parent to the top.

  Arguments: data to remove.

  Returns: boolean value true or false.

- Function: find 

  Role: Find the data to be found 
	      Rotates the node to the top if found or the last node accessed if not found 

  Arguments: data to find

  Returns: boolean value true or false

- Utility Function: displaySplayTree

  Role: display splay tree in terminal in tree form

  Arguments: node, gap - for displaying in tree form
  
  Returns: void

- Utility Function: getCalldata

  Role: used to get call data
        stores count and phone_no. as pair in ArrayList

  Arguments: void

  Returns: call_data (ArrayLsit<Pair>)

- Utility Function: find_count

  Role: used to get count for specific given phone_no. from call_data

  Arguments: call_data, phone_no

  Returns: count (int)
  
***************************************

## ** Key functionality **: 

The demonstration here shows the use of Splay tree in CALL LOG facility
of mobile phones. The contact number which is most recently searched after accessing gets
placed at the root and the tree splays accordingly. This helps in accessing the number if 
needed again more quickly and efficiently. Here, we have also used the incoming+outgoing calls
count for node storing in the Splay Tree. Also, for count greater than 50, the nodes show Black(B)
color, else Red color(R).

**************************************
