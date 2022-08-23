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
}

let queue = new Queue();

queue.seed([1,2,3,4,5])
queue.display();