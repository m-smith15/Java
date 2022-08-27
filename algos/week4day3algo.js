class QueueNode {
    constructor(data) {
    this.data = data;
    this.next = null;
    }
}

class Queue {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    isEmpty() {
        if (this.head === null){
            return true;
        }
        return false;
    }

    enqueue(val) {
        let newNode = new QueueNode(val)
        if (this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size ++;
        return this.size;
    }

    dequeue() {
        if(this.isEmpty()){
            return false;
        }
        let removed = this.head;
        this.head = this.head.next;
        this.size --;
        return removed;
    }

    front() {
        if (this.isEmpty()){
            return null;
        }
        return this.head;
    }

    contains(searchVal) {
        let thisNode = this.head;
        for (let i = 0; i<this.size; i++){
            if(thisNode.data===searchVal){
                return true;
            }
            thisNode = thisNode.next;
        }
        return false;
    }

    seed(vals) {
        for(let i = 0; i<vals.length;i++){
            this.enqueue(vals[i]);
        }
    }

    display(){
        let nextNode = this.head;
        let itemIndex = 0;
        while(nextNode){
            console.log("Item " + itemIndex + ": "+nextNode.data)
            nextNode = nextNode.next;
            itemIndex++;
        }
    }

    /**
   * Compares this queue to another given queue to see if they are equal.
   * Avoid indexing the queue items directly via bracket notation, use the
   * queue methods instead for practice.
   * Use no extra array or objects.
   * The queues should be returned to their original order when done.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Queue} q2 The queue to be compared against this queue.
   * @returns {boolean} Whether all the items of the two queues are equal and
   *    in the same order.
   */
compareQueues(q2) {
    
}

/**
    * Determines if the queue is a palindrome (same items forward and backwards).
    * Avoid indexing queue items directly via bracket notation, instead use the
    * queue methods for practice.
    * Use only 1 stack as additional storage, no other arrays or objects.
    * The queue should be returned to its original order when done.
    * - Time: O(?).
    * - Space: O(?).
    * @returns {boolean}
    */
isPalindrome() {}

/**
    * Find the intersection in between 2 queues
    * If there is no intersection return a null value
    * If the is an intersection return the node where the queues intersect
    * - Time: O(?).
    * - Space: O(?).
    * @param {Queue} q2 The queue to be compared against this queue to find intersection.
    * @returns {QueueNode} Null in case of no intersection
    */
findIntersection(q2) {}
}

let queue = new Queue();

queue.seed([1,2,3,4,5])
queue.display();