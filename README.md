# CallLog-Facility-Using-Splay-Tree
## Using Splay tree as Data Structure, demonstration of CallLog facility of mobile phones

*************************************
### *Description*: 

*Designing Splay Tree as data structure to demonstrate the CALL LOG facility 
available in mobile phones. The tree will also demonstrate the total number of calls [incoming
+outgoing] made from the phone at the node. If the value of calls is greater than "x", the node
is colored "Black", otherwise, it is coloured "Red".*

*****************************************
### *Files*:
```
   * CallLog-Facility-Using-Splay-Tree
   
	|->src/Splaytree
	
		|->SplayTreeforCalllogFacility.java (splay tree as data structure and required functionalities)
		
		|->Utils.java (utilites file)
		
		|->demo.java (run file) 
   * trial_run_output.txt (sample output)
   * details.txt  
```
*******************************************
### *Technology stack*:

Java, Netbeans 
*****************************************

### *Functions*:

#### Function: *leftRotate*
```
  Role: perform left rotate operation in splay tree
  Arguments: node
  Returns: node

```
#### Function: *rightRotate* 
```
  Role: perform right rotate operation in splay tree
  Arguments: node 
  Returns: node 
```

#### Function: *splay* 
```
  Role: carrying out splay operation with zig-zig and zig-zag to bring the
        recently accessed node to the root based on count.
  Arguments: data(i.e. count for specific contact no.)
```
#### Function: *insert* 
```
  Role: inserts a node in the splay tree same as standard BST insertion, after insertion max node is at the root
  Arguments: data, phone no., node
  Returns: void
```

#### Function: *delete*
```  
  Role: Removes a node just like a search tree does, then rotates the
        removed node's parent to the top.
  Arguments: data to remove.
  Returns: boolean value true or false.
```

#### Function: *find* 
```
  Role: Find the data to be found.
	Rotates the node to the top(to the root) if found else the parent of last node accessed. 
  Arguments: data to find.
  Returns: boolean value true or false.
```

#### Utility Function: *displaySplayTree*
```
  Role: display splay tree in terminal in tree form using preorder of tree.
  Arguments: node, gap - for displaying in tree form.
  Returns: void.
```

#### Utility Function: *getCalldata*
```
  Role: used to get call data
        stores count and phone_no. as pair in ArrayList
  Arguments: void
  Returns: call_data (ArrayLsit<Pair>)
```

#### Utility Function: *find_count*
```
  Role: used to get count for specific given phone_no. from call_data
  Arguments: call_data, phone_no
  Returns: count (int)
```

***************************************

### *Key functionality*: 
```
1. The demonstration here shows the use of Splay tree in CALL LOG facility of mobile phones. 
2. The contact number which is most recently searched after accessing gets placed at the ROOT and the tree splays accordingly. 
3. For accessing we store the data in the form of a KEY_VALUE PAIR of COUNT(total calls) and CONTACT NUMBER.
4. The tree is formed using the count(total calls) as data upon which comparison takes place.
5. This helps in ACCESSING the NUMBER if needed again MORE QUICKLY and EFFICIENTLY based on COUNT(MAX is at root) or MOST RECENT SEARCHED node. 
6. Here, we have also used the incoming+outgoing calls count for node storing in the Splay Tree; in that for count greater than 50, the nodes show Black(B) color, else Red color(R).
```
**************************************

### *Running the code*:

```
1. Download the repository.
2. Open Netbeans IDE and go to Files menu and Select Import Project.
3. Choose "Import from ZIP", and search for the location where you saved the downloaded ZIP folder.
4. Select the folder and let it load.
5. Open the demo.java file and run the file using "Shift+F6".
```
***************************************
### *Author*:

- **Sarthak Baiswar** *Initial Work* [sarthakbaiswar](https://github.com/sarthakbaiswar)

***************************************
