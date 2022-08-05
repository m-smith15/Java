class ListNode {
    constructor( data ) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    constructor() {
        this.head = null;
    }

    isEmpty() {
        if ( this.head ) {
            return false;
        }
        return true;
    }
    
    insertAtFront( data ) {
        let newNode = new ListNode( data );
        newNode.next = this.head;
        this.head = newNode;
        return;
    }


    removeFromFront() {
        if( !this.isEmpty){
            this.head = this.head.next;
        }
        return;
    }

    insertAtBack( data ) {
        let newNode = new ListNode( data );
        if ( this.isEmpty() ){
            this.head = newNode;
        } else {
            let runner = this.head;
            while( runner.next ){
                runner = runner.next;
            }
            runner.next = newNode;
        }
        return;
    }

    display(){
        if( this.isEmpty() ){
            console.log("This list is empty!")
        } else {
            let n = 0;
            let runner = this.head;
            console.log('node ' + n + ': '+runner.data);
            while( runner.next ){
                runner = runner.next;
                n++;
                console.log('node ' + n + ': '+runner.data);
            }
        }
        return;
    }

    seedFromArray(values){
        this.head = null;
        for (let value of values){
        this.insertAtBack(value);
        }
    }
    toArr() {
        var newArr = [];
        let runner = this.head;
        while (runner) {
            newArr.push(runner.value);
            runner = runner.next;
        }
        return newArr;
    }

    insertAtBackRecursive(data, runner = this.head) {
        if(runner == null){
            runner = new ListNode(data);
            return runner;
        }
        else if(runner.next == null){
            runner.next = new ListNode(data)
            return runner.next;
        }
        this.insertAtBackRecursive(data, runner.next);
    }

    removeFromBack() {
        if ( this.isEmpty() ){
            return "SLL is Empty!";
        } else {
            let runner = this.head;
            while( runner.next ){
                let nxtElement = runner.next
                if (nxtElement.next == null){
                    runner.next = null;
                    break;
                }
                runner = runner.next;
            }
        }
        return;
    }

    contains(val) {
        if ( this.isEmpty() ){
            return "SLL is Empty!";
        } else {
            let runner = this.head;
            while( runner.next ){
                if(runner.data == val){
                    return true;
                }
                runner = runner.next;
            }
            return false;
        }
    }
        //array [1,2,3,4,5] | val = 2
    containsRecursive(val, current = this.head) {
        if(current == null){ //edge case 0 in SLL
            return false;
        }
        if(current.data == val){
            return true;
        }
        return this.containsRecursive(val, current.next);
    }
}

let list1 = new SinglyLinkedList();
// list1.removeFromFront();
// console.log(list1.isEmpty());
// list1.insertAtBack("all");
// list1.insertAtBack("my");
// list1.insertAtBack("life");
// list1.insertAtBack("I");
// list1.insertAtBack("was");
// list1.insertAtBack("waiting");
// console.log(list1.isEmpty());

// list1.removeFromFront();
// list1.removeFromFront();
// list1.removeFromFront();
// list1.insertAtFront("grumpy")
// list1.insertAtFront("bumpy")
// list1.insertAtFront("mklumpy")
// list1.insertAtFront("dumpy")

console.log("-------------------")

// list1.display();

list1.seedFromArray([1,2,3,4,5]);
// list1.display();

//list1.toArr();
list1.display();
console.log("remove from back changes ------------")
list1.removeFromBack();
list1.display();

console.log("contains ---------------")
console.log(list1.contains(2));
console.log(list1.contains(15));

console.log("contains recursive -------");
console.log(list1.containsRecursive(12));