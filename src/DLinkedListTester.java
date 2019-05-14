/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duane
 */
public class DLinkedListTester {
    public static void main (String[] args){
        DLinkedList list = new DLinkedList(); 
       
       System.out.println("Doubly Linked List Test\n"); 
       System.out.println("");
       System.out.println("List empty="+ list.isEmpty());
       System.out.println("");
       System.out.println("Adding to list...");
       System.out.println(" ");
       list.insertInFront("Duane");
       list.insertInFront("Duane");
       list.insertInFront("Brune");
       list.insertInFront("Amy");
       list.insertInFront("Allistair");
       list.insertInFront("Carley");
       list.insertInFront("Raylene");
       list.insertAtTail("Chante");
       list.insertAtTail("James");
       list.insertAtTail("Amy");
       list.insertAtTail("Kevin");
       list.insertInFront("Brune");
       list.insertAtTail("James");
       list.insertAtTail("Amy");
       System.out.println(list.toString());
       System.out.println("");
       
       System.out.println("Size="+ (list.getSize())) ;
       System.out.println("");System.out.println("");
       
       System.out.println("Add 'Luke' first: ");
       DNode p= new DNode("Luke", null, null);
       list.addFirst(p);
       System.out.println(list.toString());
       System.out.println("");
       System.out.println("Add 'Jamie' last: ");
       DNode q=new DNode("Jamie",null,null);
       list.addLast(q);
       System.out.println(list.toString());
       System.out.println("");
       
       System.out.println("Size="+ (list.getSize())) ;
       System.out.println("");System.out.println("");
       
       System.out.println("Replacing index 2 with 'Alen' ");
       list.replaceAtIndex(2, "Alen");
       System.out.println(list.toString());
       
       System.out.println("");
       System.out.println("Size="+ (list.getSize())) ;
       System.out.println("");System.out.println("");
       
       System.out.println("");
       System.out.println("Inserting 'Aron' at position 4");
       list.insertAtIndex("Aron", 4);
       System.out.println(list.toString());
       
       System.out.println("");
       System.out.println("Size="+ (list.getSize())) ;
       System.out.println("");System.out.println("");
       
       System.out.println("List empty="+ list.isEmpty());
       System.out.println(" ");System.out.println("");
       
       System.out.println("Delete first occurrence of 'Duane' from list");
       list.deleteFirstOccurrence("Duane");
       System.out.println(list.toString());
       System.out.println(" ");
       
       System.out.println("Delete all occurences of 'Amy' from list");
       list.deleteAllOccurrences("Amy");
       
       System.out.println("Size="+ (list.getSize())) ;
       System.out.println("");System.out.println("");
       System.out.println("Delete last:");
       list.deleteLast();
       System.out.println(list.toString());
       System.out.println("");
       
       System.out.println("Size="+ (list.getSize())) ;
       System.out.println("");System.out.println("");
       System.out.println("Does it contain 'Duane':");
       System.out.println(list.containsItem("Duane"));
       System.out.println("");
       System.out.println("Number of occurences of 'Brune':");
       System.out.println(list.noOfOccurrences("Brune"));
       System.out.println("");
       System.out.println("First position of item 'Allistair':");
       System.out.println(list.firstPositionOfItem("Allistair"));
       System.out.println("");
       System.out.println("All positions of item 'James':");
       list.allPositionsOfItem("James");
       System.out.println("");
       System.out.println("First item:");
       System.out.println(list.getFirst().getElement());
       System.out.println("");
       System.out.println("Last item:");
       System.out.println(list.getLast().getElement());
       System.out.println("");
       System.out.println(list.toString());

    }
}
