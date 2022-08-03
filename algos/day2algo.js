class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    constructor() {
        this.head = null;
    }

    isEmpty() {
        if(this.head){
            return false;
        }
        else{
            return true;
        }
    }
    insertAtBack(data) {
        let exampleNode = new ListNode(data);
        if(this.isEmpty()){ //isEmpty will return "empty" if head == null
            this.head = exampleNode; //checking if the head of first value is empty. If it is, add first node.
        }
        else{
            let currentnode = this.head;
            while(currentnode.next != null){
                currentnode = currentnode.next;
            }
            currentnode = exampleNode;
        }
    }
}

//intro to SLL - simple and less memory intensive than arrays
// ran out of time; Need to do some extra work to get this down. Basically use the isEmpty method to see if next node is empty, if so drop node in
//group memebers - David, Ohjay, Kendra


const exampleList = new SinglyLinkedList();
console.log(exampleList); // SinglyLinkedList { head: null }

const exampleNode = new ListNode(8);
exampleList.insertAtBack(exampleNode);
console.log(exampleList); // ListNode { data: 8, next: null }
const exampleNode2 = new ListNode(18);
exampleList.insertAtBack(exampleNode2);
console.log(exampleList); // ListNode { data: 8, next: null }
const exampleNode3 = new ListNode(28);
exampleList.insertAtBack(exampleNode3);
console.log(exampleList); // ListNode { data: 8, next: null }

//idea is to find node that is empty and insert there.
exampleList.insertAtBack(exampleNode);
exampleList.insertAtBack(exampleNode2);
exampleList.insertAtBack(exampleNode3);
console.log(exampleList);

