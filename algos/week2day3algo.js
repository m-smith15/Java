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

    secondToLast() {
        if ( this.isEmpty() ){
            return "SLL is Empty!";
        } else {
            let runner = this.head;
            while( runner.next ){
                let nxtElement = runner.next
                if (nxtElement.next == null){
                    console.log(runner);
                    return runner;
                }
                runner = runner.next;
            }
        }
        return;
    }

    removeVal(val) { //copied from contains
        if ( this.isEmpty() ){
            return "SLL is Empty!";
        } else {
            let runner = this.head;
            while( runner.next ){
                if(runner.next.data == val){
                    runner.next = runner.next.next;
                    return true;
                }
                runner = runner.next;
            }
            return false;
        }
    }

    prepend(value, target){
        let newNode = new ListNode(value)
        if(this.isEmpty()){
            return false;
        }
        else if(this.head.data == target){
            newNode.next = this.head;
            this.head = newNode;
            return true;
        }
        let runner = this.head;
        while(runner.next != null){
            if(runner.next.data == target){
                newNode.next = runner.next;
                runner.next = newNode;
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    moveMinToFront(){
        if(this.isEmpty() || this.head.next == null){
        return this;
        }
        let minNodePrev = this.head;
        let runner = this.head;
        while(runner.next != null){
        if(minNodePrev.next.data > runner.next.data){
            minNodePrev = runner;
        }
        runner = runner.next;
        }
        let minNode = new ListNode(minNodePrev.next.data);
        minNode.next = this.head; 
        this.head = minNode;
        minNodePrev.next = minNodePrev.next.next;
        return this
    }

    concat(addList){ //add lists nodes to exsiting list. So if you have SLL 1, 2, 3 and you call this with SLL 4 5 6 result = 1 2 3 4 5 6
        //console.log(addList);
        //console.log(addList.head);
        if ( this.isEmpty() ){
            return "SLL is Empty!";
        } else {
            let endNode = this.head; //endNode = first list
            let runner = addList.head //runner = second list (6 in list 2)
            while( endNode.next ){
                if(endNode.next != null){
                    endNode = endNode.next;
                }
            }
            if (runner.next == null){ //runner.next == null means end of list
                endNode.next = null;
                //endNode = endNode.next;
                
            }
            else{
                endNode.next = runner
            }
            return;
        }
    }

    splitOnVal(val){ //move to value in list and split into 2 lists. Split on 3 list 1 2 3 4 5 > 1 2 and 3 4 5
        if ( this.isEmpty() ){ //contains
            return "SLL is Empty!";
        } else {
            let runner = this.head;
            let lag = null;
            while( runner.next ){
                if(runner.data == val){
                    let newArr = [];//split here
                    let list2Runner = runner;
                    while (list2Runner) {
                        newArr.push(list2Runner.data);
                        list2Runner = list2Runner.next;
                        //console.log(newArr)
                    }
                    lag.next = null;
                    let list2 = new SinglyLinkedList(); //creating & display list2
                    list2.seedFromArray(newArr);
                    list2.display();
                }
                lag = runner;
                //console.log(lag)
                runner = runner.next;
            }
            return
        }
    }

    recursiveMax(runner = this.head, maxNode = this.head){ //maxNode set as greatest
    //     if(this.isEmpty()){
    //         return null
    //     }
    //     if(runner == null){ //edge case 0 in SLL
    //         return maxNode.value;
    //     }
    //     if(runner.data > maxNode){
    //         return this.recursiveMax(runner.next,runner);
    //     }
    //     else return this.recursiveMax(runner.next, maxNode);
    // }
    if(this.isEmpty()){
        return null
    }
    if(runner == null){
        return maxNode.value
    }
    if(maxNode.value < runner.value){
        return this.recursiveMax(runner.next, runner)
    }
    else return this.recursiveMax(runner.next, maxNode)
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

// console.log("-------------------")

// list1.display();

list1.seedFromArray([1,2,3,4,5]);
list1.display();

//list1.toArr();
// list1.display();
// console.log("remove from back changes ------------")
// list1.removeFromBack();
// list1.display();

// console.log("contains ---------------")
// console.log(list1.contains(2));
// console.log(list1.contains(15));

// console.log("contains recursive -------");
// console.log(list1.containsRecursive(12));

// console.log(" 2nd to last -----------");
// list1.secondToLast();
// list1.display();

// console.log("remove val -----------");
// list1.removeVal(3);
// list1.display();

// console.log("concat changes ----------------")
// let list2 = new SinglyLinkedList();
// list2.seedFromArray([6,7,8]);
// list1.concat(list2);
// list1.display();

console.log("split on val ----(list2)-----")
list1.splitOnVal(3);
console.log("list1")
list1.display();

// console.log("recursive max ------------")
// console.log(list1.recursiveMax());
