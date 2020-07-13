class MyLinkedList {

    public int val;
    public MyLinkedList next;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.val=-1;
        this.next=null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        MyLinkedList nextNode=this;
        
        for(int i=0;i<index;i++){
            if(nextNode!=null){
            nextNode = nextNode.next;
                }
        }
        if(nextNode != null){
            return nextNode.val;
        }
        else{
            return -1;
        }
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
        if(this.val==-1 && this.next==null){
            this.val = val;
            return;
        }
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = this.val;
        newNode.next = this.next;
        this.val = val;
        this.next = newNode;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        if(this.val==-1 && this.next==null){
            this.val = val;
            return;
        }
        
        MyLinkedList nextNode = this;
        
        while(nextNode.next != null){
            nextNode = nextNode.next;
        }
        
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        newNode.next = null;
        
        nextNode.next = newNode;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        MyLinkedList nextNode = this;
        
        if(index==0){
            this.addAtHead(val);
            return;
        }
    
        int i=0;
        while(i<index-1 && nextNode.next != null){
            nextNode = nextNode.next;
            i++;
        }
        
        if(i < index-1){
            return;
        }
        
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        newNode.next = nextNode.next;
        
        nextNode.next = newNode;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        MyLinkedList nextNode = this;
        
        if(index==0){
            if(this.next==null){
                   this.val=-1;
                   return;
               } 
                else{
                    this.val = this.next.val;
                    this.next = this.next.next;
                    return;
                }
        }
    
        int i=0;
        while(i<index-1 && nextNode.next != null){
            nextNode = nextNode.next;
            i++;
        }
        
        if(i == index-1){
            if(nextNode.next != null){
                MyLinkedList delList = nextNode.next;
                nextNode.next = nextNode.next.next;
                delList = null;
            }
            
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */