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
public class MySpecialLinkedListUtils {
    
    LinkedListNode head;
    LinkedListNode tail;
    // for test
//    public void add(int element) {
//        LinkedListNode input=new LinkedListNode(element);
//        if(head==null) {
//          head=tail=input;
//        }else{
//            tail.setNext(input);
//            tail=input;
//            tail.setNext(null);
//            
//        }
//    }
    
    public static void swapNodes(LinkedListNode currentNode, LinkedListNode nextNode) {
        int temp = currentNode.getValue();
        currentNode.setValue(nextNode.getValue());
        nextNode.setValue(temp);
    }
    
    public static LinkedListNode sort(LinkedListNode head){
        if(head==null) return null;
        
        LinkedListNode current=null,temp=null;
        
        for(current=head;current.getNext()!=null;current=current.getNext()){
            for(temp=current.getNext();temp!=null;temp=temp.getNext()){
                if(current.getValue()>temp.getValue()){
                    swapNodes(current,temp);
                }
            }
        }
        
        
        return head;
    }
    
    public static double[] summary(LinkedListNode head){
        if(head==null) return null;
        //{sum, average, median, maximum and minimum}
        double[] result=new double[5];  //default is zero
        int counter=0;
        int size=0; //size of the of list
        result[3]=result[0]; //max
        result[4]=result[0];//min
        LinkedListNode current = sort(head);
        while(current!=null){  //to caculate the size
            size++;
            current=current.getNext();
        }
        current=head;
        while(current!=null){
            result[0]+=current.getValue();
            counter++;   //for average and to fond ths size to take the median
            if(size%2!=0&&counter==size/2+1) result[2]=current.getValue(); //median if the size is odd
            if(size%2==0&&counter==size/2) result[2]=(current.getValue()+current.getNext().getValue())/2; //median if the size is even
            if(current.getValue()>result[3]){
                result[3]=current.getValue();
            }
            if(current.getValue()<result[3]){
                result[4]=current.getValue();
            }
            current=current.getNext();
        }
        result[1]=result[0]/counter; //average
        
        return result;
    }
    
    public static LinkedListNode reverse(LinkedListNode head){
        if(head==null) return null;
        LinkedListNode current=head,pre=null,next=null;
        while(current!=null){
            next=current.getNext();
            current.setNext(pre);
            pre=current;
            current=next;
        
        }
        head=pre;
        
        return head;
    }
    
    
    
    public static LinkedListNode evenIndexedElements(LinkedListNode head){
        if(head==null) return null;
        LinkedListNode current=head;
        
        LinkedListNode output=new LinkedListNode(current.getValue());
        LinkedListNode cu_out=output;
        current=current.getNext();
        int i=0;
        while(current!=null){
            i++;
            if(i%2==0){
                cu_out.setNext(new LinkedListNode(current.getValue()));
                cu_out=cu_out.getNext();
            }
            current=current.getNext();
            
            
        }

        
        
        return output;
    }
    
    
    
    public static LinkedListNode insertionSort(LinkedListNode head){
        if(head==null) return null;
        
        LinkedListNode current=null,temp=null;
        LinkedListNode min=new LinkedListNode();
        
        for(current=head;current.getNext()!=null;current=current.getNext()){
            min=current;
            for(temp=current.getNext();temp!=null;temp=temp.getNext()){
                if(temp.getValue()<min.getValue()){
                    min=temp;
                }
            }
            swapNodes(current,min);
        }
        return head;
    }
    
    //start of the merge sort
    public static LinkedListNode getMiddle(LinkedListNode head){
        if(head==null) return head;
        LinkedListNode current=head,temp=head;
        while(current.getNext()!=null&&current.getNext().getNext()!=null){
            temp=temp.getNext();
            current=current.getNext().getNext();
        }
        return temp;
    }
    public static LinkedListNode sorted(LinkedListNode a,LinkedListNode b){
        LinkedListNode result=null;
        if(a==null) return b;
        if(b==null) return a;
        if(a.getValue()<=b.getValue()){
            result=a;
            result.setNext(sorted(a.getNext(),b));
        }else{
            result=b;
            result.setNext(sorted(a,b.getNext()));
            
        }
        return result;
    }
    
    
    public static LinkedListNode mergeSort(LinkedListNode head){
        if(head==null||head.getNext()==null) return head;
        
        LinkedListNode middle=getMiddle(head);
        LinkedListNode nextMiddle=middle.getNext();
        middle.setNext(null);
        LinkedListNode left=mergeSort(head);
        LinkedListNode right=mergeSort(nextMiddle);
        LinkedListNode sortedlist=sorted(left,right);
        return sortedlist;
    }
    
    
    
    
    //end of merge sort 
    
    
    
    
    public static LinkedListNode removeCentralNode(LinkedListNode head){
        int size=0;
        LinkedListNode current=head;
        LinkedListNode pre=null;
        while(current!=null){
            size++;
            current=current.getNext();
        }
        current=head; //reset the node to the start of the list
        int i=0;
        if(size%2==0) size=size/2-1;
        else if(size%2!=0) size=size/2;
        while(i<size){
            pre=current;
            current=current.getNext();
            i++;
            
        }
        pre.setNext(current.getNext());
        return head;
    }
    
    
    
    public static boolean palindrome(LinkedListNode head){
        int size=0;
        boolean pld=true;
        LinkedListNode current=head;
        LinkedListNode tail=null;
        while(current!=null){
            size++;
            current=current.getNext();
        }
        current=head;
        if(size%2==0) size=size/2;
        else if(size%2!=0) size=size/2+1;
        for (int i=0;i<size;i++){
            current=current.getNext();
            tail=current;
            
        }
        current=head;
        tail=reverse(tail);
        while(current!=null&&tail!=null){
            if(current.getValue()!=tail.getValue()){
                pld=false;
                break;
            }
            current=current.getNext();
            tail=tail.getNext();
        }
        return pld;
    }
    
    
    
}
