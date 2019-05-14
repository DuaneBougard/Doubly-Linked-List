/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DUANE BOUGARD 3566258
 */
public class DLinkedList {
    public DNode head;
    public DNode tail ;
    public int size;
    public DNode prevP, currP;

    public DLinkedList()
      {
          head = null;
          tail = null;
          size = 0;
      }

    // A - returns the first node of the list
    public DNode getFirst(){return head;}
    // B - returns the last node of the list
    public DNode getLast(){return tail;}
    // C - inserts node v before the node z in the list
    public void addBefore(DNode z, DNode v){
        //z before v
        DNode node=z.getPrev();
        v.setPrev(node);
        v.setNext(z);
        node.setNext(v);
        z.setPrev(v);
    }
    // D - inserts the node z after node v in the list
    public void addAfter(DNode v, DNode z){
        //insert z after v / v before z
        DNode node=z.getPrev();
        v.setPrev(node);
        v.setNext(z);
        z.setPrev(v);
        node.setNext(v);
    }
    // E - inserts node v at the head of the list – new node becomes new head
    public void addFirst(DNode v){
        DNode temp=head;
        //DNode afterHead=head.getNext();
        head=v;
        v.setNext(temp);
        v.setPrev(null);
        //temp.setNext(afterHead);
        temp.setPrev(v);
        size++;
    }
    // F - Inserts node v at the tail of the list – new node becomes new tail
    public void addLast(DNode v){
        DNode temp=tail;
        tail=v;
        v.setNext(null);
        v.setPrev(temp);
        temp.setNext(v);
        size++;
    }
    // G - removes node v from list
    public void remove(DNode v){
        DNode u=v.getPrev();
        DNode w=v.getNext();
        w.setPrev(u);
        u.setNext(w);
        v.setPrev(null);
        v.setNext(null);
    }
    // H - returns whether node v has a node in front of it
    public boolean hasPrev(DNode v){return v.getPrev() != null;}
    // I - returns whether node v has a node immediately after it
    public boolean hasNext(DNode v){return v.getNext() != null;}
    /* Function to check if list is empty */
    // J - returns the boolean value ‘true’ if the linked list does not contain any nodes, otherwise false is ‘returned’.
    public boolean isEmpty(){return head == null;}
    // K - returns a single String that is constructed by concatenating all the string data of all nodes in 
    // the doubly linked list, in order of traversal. e.g. For a linked list with data “a”, “b”, “c”, “d”,
    // “e”, toString should return the String “[a, b, c, d, e]”.
    public String toString()
    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {System.out.print("empty\n");}
            if (head.getNext() == null){System.out.println(head.getElement());}
            DNode tempHead = head;
            System.out.print("["+head.getElement()+ " , ");
            tempHead = head.getNext();
            while (tempHead.getNext() != null)
            {
                System.out.print(tempHead.getElement()+ " , ");
                tempHead = tempHead.getNext();
            }
            System.out.print(tempHead.getElement()+ "]\n");
            return "";
    }
    // L - inserts a newly constructed node at the front of the linked list. The node inserted should
    // contain ‘item’ as data component
    public void insertInFront(String val)
    {
        DNode temp = new DNode(val, null, null);        
        if(head == null)
        {
            head = temp;
            tail = head;
        }
        else
        {
            head.setPrev(temp);
            temp.setNext(head);
            head = temp;
        }
        size++;
    }
    // M - inserts a newly constructed node as the new last node of the linked list. The node inserted
    // should contain ‘item’ as data component.
    public void insertAtTail(String val)
    {
        DNode temp = new DNode(val, null, null);        
        if(head == null)
        {
            head = temp;
            tail = head;
        }
        else
        {
            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }
    // N - inserts a newly constructed node at position ‘indx’ of the linked list. Note, do not replace the
    // current node at ‘indx’. After the operation the length of the linked list should have increased by 1.
    /* Function to insert element at position */
    public void insertAtIndex(String val , int pos)
    {
        DNode temp = new DNode(val, null, null);    
        if (pos == 1)
        {
            insertInFront(val);
            return;
        }            
        DNode tempHead = head;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
            DNode tmp = tempHead.getNext();
            tempHead.setNext(temp);
            temp.setPrev(tempHead);
            temp.setNext(tmp);
            tmp.setPrev(temp);
            }
            tempHead =tempHead.getNext();
        }
        size++ ;
    }
    // O - replaces the node that occurs at position ‘indx’ of the linked list with a newly constructed
    // node that contains ‘item’ as data.
    public void replaceAtIndex(int indx, String item){
        boolean f=false; int c=1;
        DNode mid = new DNode(item, null,null);  //a-nptr              
        DNode te = new DNode (item, null,null);//b-ptr
        DNode pos=head;
        while ((pos != null)&& !f){
            if (c==indx)
            {
               f=true;
               te=pos.getNext();
               pos.setNext(mid);
               mid.setNext(te.getNext());
            }
            else
            {
                pos=pos.getNext();
                c++;
            }
        }
    }
    // P - deletes the first occurrence of ‘item’ from the linked list. e.g. If the item is “c” and the linked
    // list is [a, c, f, h, j, c], the result should be [a, f, h, j, c].
    public void deleteFirstOccurrence(String item){
        prevP = null;
        for (currP = head.next;currP != null;prevP = currP, currP = currP.getNext()) {
        if (currP.getElement() == item) {  /* Found it. */
            if (prevP == null) {head.next= currP.getNext();} 
            else {prevP.setNext(currP.getNext());}
            size--;
       }
     }
  }
    // Q - deletes all occurrences of ‘item’ from the linked list. e.g. If the item is “c” and the linked
    // list is [a, c, f, h, j, c], the result should be [a, f, h, j].
    public void deleteAllOccurrences(String item){
        DNode tmpNode = head;
        DNode prevNode = null;
        boolean deletedANode = false;
        while (tmpNode != null) {
            if (tmpNode.element== item) 
            {
                if (tmpNode == head) {head = head.next;} 
                else {prevNode.next = tmpNode.next;}
               // fixed indenting
                deletedANode = true; size--;
            } 
            else {prevNode = tmpNode;}
            tmpNode = tmpNode.next;
       }

    }
    // R - deletes the last occurrence of ‘item’ from the linked list. e.g. If the item is “c” and the list is
    // [a, c, f, h, j, c], the result should be [a, c, f, h, j].
    public void deleteLast(){
        if (tail == null){return;} 
        else
        { 
            if (head == tail)
            { 
                head = null; 
                tail = null; 
            } 
            else{ 
                DNode previousToTail = head; 
                while (previousToTail.next != tail) 
                previousToTail = previousToTail.next; 
                tail = previousToTail; 
                tail.next = null; 
                size--;
                } 
        }
    }
    // R - 
    public void deleteLastOccurrence(String item){
        if (tail == null) 
        return; 
        else { 
            if (head == tail) { 
                head = null; 
                tail = null; 
            } 
            else { 
                DNode previousToTail = head; 
                while (previousToTail.next != tail) 
                previousToTail = previousToTail.next; 
                tail = previousToTail; 
                tail.next = null; 
                } 
    }
       }
    // S - checks whether ‘item’ occurs in the linked list. e.g. If the item is “c” and the list is [a,
    // c, f, h, j, c], the method should return the boolean value ‘true’; for the same linked list, if the
    // item is “b”, the method should return ‘false’.
    public boolean containsItem(String item){
        DNode current = head;
        Boolean found=false;
        while ((current!= null) && (found == false)) 
        {
            if (current.getElement().equalsIgnoreCase(item)) {
                found= true;
            } else {current = current.getNext();}
        }
        return found; 
    }
    // T - counts the number of times ‘item’ occurs in the linked list. e.g. If the item is “c” and the list
    // is [a, c, f, h, j, c], then the method should return the value 2.
    public int noOfOccurrences(String item){
        DNode current = head;
        //Node prev=null;
        int count = 0;
        while (current != null)
        {
            if (current.getElement().equalsIgnoreCase(item))
            {
                current = current.getNext();
                count++; 
            }
            else{current = current.getNext();}
        }
        return count;
    }
    // U - returns the position of the first occurrence of ‘item’ in the linked list. If ‘item’ does not
    // occur in the linked list, -1 should be returned. e.g. If the item is “c” and the list is [a, c, f, h,
    // j, c], the method should return 1.
    public int firstPositionOfItem(String item){
        DNode current = head;
        int count = 0;
        while (current != null)
        {
            if (current.getElement().equalsIgnoreCase(item)){break;}
            else
            {
                current = current.getNext();}
                count++;
            }
            return count;
        }
    // V - returns an array that contains all the positions that correspond to the subscripts where ‘item’
    // occurs in the linked list. If ‘item’ does not occur in the linked list then null should be
    // returned by the method. e.g. If the item is “c” and the list is [a, c, f, h, j, c], the method
    // should return the integer array [1, 5].
    public int[] allPositionsOfItem(String item){
        int[] Array = new int[this.noOfOccurrences(item)];
        DNode tmpNode = head;
        DNode prevNode = null;
        boolean deletedANode = false;
        int count=0;
        int i =0;
        while (tmpNode != null) {
            if (tmpNode.getElement()== item) 
            {
                Array[i] = count;
                i++;
                count++;
            } 
            else
            {
                // only advance the prevNode when there's no match.
                prevNode = tmpNode;
                count++;
            }
            tmpNode = tmpNode.next;
       }
            for (int m=0; m<Array.length; m++){System.out.println(Array[m]);}
            return Array;
    }

    public int getSize(){return size;}

    /* Function to delete node at position */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1){
            if (size == 1)
            {
                head = null;
                tail = null;
                size = 0;
                return; 
            }
                head = head.getNext();
                head.setPrev(null);
                size--; 
                return ;
            }
           if (pos == size)
           {
               tail = tail.getPrev();
               tail.setNext(null);
               size-- ;
           }
           DNode temp = head.getNext();
           for (int i = 2; i <= size; i++)
           {
                if (i == pos)
                {
                    DNode p = temp.getPrev();
                    DNode n = temp.getNext();
                    p.setNext(n);
                    n.setPrev(p);
                    size-- ;
                    return;
                }
                temp = temp.getNext();
           }        
       }   
 }
