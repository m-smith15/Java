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

    /**
 * Reverses this list in-place without using any extra lists.
 * - Time: (?).
 * - Space: (?).
 * @returns {SinglyLinkedList} This list.
 */

//     let lag = null
//     let runner = this.head
//     let test = []
//     while(runner.next) {
//         lag = runner

//         test.push(lag.data)
//         console.log(runner.next) 

//         let current = runner.next

//         console.log(current + " going to " + lag)

//         current.next = lag

//         test.push(current.data)

//         console.log(current.next + " set to " + lag)

//         runner = runner.next
    
//         if(runner.next == null){
//             break;
//         }

// }
//     console.log(test)
//     return this.display();

reverse() {
    if(this.isEmpty() || !this.head.next){
        this.display()
        return this
    }//Edge cases of empty and 1 node
    var runner = this.head
    var stepDad;
    let nodeHolder = runner.next
    runner.next = null
    while(nodeHolder){
        stepDad = nodeHolder
        nodeHolder = nodeHolder.next
        stepDad.next = runner
        runner = stepDad
    }
    this.head = runner
    this.display()
    return this
}

/**
  * Determines whether the list has a loop in it which would result in
  * infinitely traversing unless otherwise avoided. A loop is when a node's
  * next points to a node that is behind it.
  * - Time: (?).
  * - Space: (?).
  * @returns {boolean} Whether the list has a loop or not.
  */
hasLoop() {

}

}

linkedList = new SinglyLinkedList
linkedList.seedFromArray([1,2,3,4,5])
//linkedList.display();

console.log(linkedList.reverse());