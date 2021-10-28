public class linkedListManager {

    private node head; // used to navigate to beginning of list
    public node tail; // used to track end of list
    public int length; // used to track length of list
    public int loc; // used in a few methods to track index of a located name

    public linkedListManager(){
        head = new node();
        tail = new node();
        head.data=null;
        head.next=null;
        tail.data=null;
        tail.next=null;
        length=0;
    }

    public void newHead(student nH){ // creates a new head of the list as needed
        node n = new node(); 
        n.next=head; // points new head to old head
        head=n; //reassigns head to new head
        n.data = nH.deepCopy(); // adds data to the node
        if(length==0) 
            tail=n; // assigns tail to new node if its the only node in the list
        length++;
    }

    public void append(student nT){ // extends linked list as needed
        node n = new node();
        node p = tail; // retrieves the previous last node in the list
        p.next=n; // points last node in list to the new node
        tail=n; // reassigns tail to new end of the list
        n.data = nT.deepCopy(); // adds data to the node
        length++;
    }

    public boolean insertAt(student newStudent, int index){
        
        if (index<0||index>length){ //verifies index is in bounds before attempting operation
            System.out.println("invalid index");
            return false;
        }
        if (index==0){
            newHead(newStudent); //creates a new head if needed
        }
        else if (index==length){ //creates a new tail if needed
            append(newStudent);
        }
        else{                       // if neither at the begginning nor end of the list
            node n = new node();
            node p = getNode(index-1);  // retrieves node just before desired index
            n.next=p.next; // new node points to whatever old node was pointing to
            p.next=n; // old node now points to new node
            n.data = newStudent.deepCopy(); // adds data to the node
            length++;
        } 
        return true; 
    }

    public student fetch(String target){

        node p = head; // starts at begginning of list

        while(p !=null && !(p.data.compareTo(target)==0)){ //moves to next item until a student name matches input
            p=p.next;
        }
        if(p!=null) 
            return p.data.deepCopy(); // returns student as long as node has been initialized
        else
            return null; 

    }

    public boolean delete(String target){

        node q = head; // starts scanning from head
        node p = head;
        loc=0; // resets location to 0

        while(p !=null && !(p.data.compareTo(target)==0)){ //moves to next until a match is found, ticking location variable up with it
            q=p;
            p=p.next; //keeps q one position behind p as they move along
            loc++;
        }
        if(p!=null){    //if loop is broken and p didnt reach end of list (null)
            if(loc==0){
                head=head.next; // deletes head if loc is 0
                return true;
                }
            else{   
                q.next=p.next; // otherwise deletes found node and decreases length accordingly
                length--;
            if(loc==length)
                tail=q; // if deleted node was at the end of the list, reassigns tail
            return true;
            }
        }
        else
            return false;

    }

    public boolean update(String target,student newStudent){

        if (delete(target)==false) // attempts to delete old copy of student data
            return false;

        insertAt(newStudent, loc); // inserts new student at location old student was deleted
        return true;

    }

    public node getNode(int index){ // retrieves nodes from specific indexes as needed
        node temp = head;
        loc=0; 
        for(int i=0;i<index;i++){
            temp = temp.next; //increments node until index is hit
            loc++;
        }
        return temp; 
    }

    public void showAll(){
        node p =head; // prints data from all nodes, starting from head node
        int i=0;
        while (p !=null){
            System.out.printf(i+": ");
            System.out.println(p.data.toString());
            p=p.next;
            i++;
        }
    }
}

