/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheet.pkg2.b;

/**
 *
 * @author User
 */
public class LinkedListNode {
    private int value;
    private LinkedListNode next;
    
    public LinkedListNode(){
        
    }
    
    public LinkedListNode(int value){
        this.value=value;
    }
    
    public void setValue(int value){
        this.value=value;
        
    }
    
    public void setNext(LinkedListNode next){
        this.next=next;
        
    }
    
    public int getValue(){
        return this.value;
        
    }
    public LinkedListNode getNext(){
        return this.next;
        
    }
    
}
