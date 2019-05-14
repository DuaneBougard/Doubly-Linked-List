/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duane
 */
public class DNode {
    public String element;
    public DNode next,prev;
   
   public DNode(String e, DNode n, DNode p){
       element=e;
       prev=p;
       next=n;
   }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }
}
