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
list1.display();

list1.toArr();
list1.display();