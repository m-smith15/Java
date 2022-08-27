// stack node
class StackNode{
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

// stack
class Stack {

    constructor(){
        this.top = null;
        this.length = 0;
    }

    isEmpty(){
        if(this.top == null){ return true; }
        return false;
    }

    push(item){
        let newNode = new StackNode(item);
        newNode.next = this.top;
        this.top = newNode;
        this.length++;
        return this.length;
    }
    pop(){
        if(this.isEmpty()){ return undefined; }
        let oldTop = this.top;
        this.top = oldTop.next;
        this.length--;
        return oldTop;
    }
    
    peek(){
        return this.top;
    }

    peekAtIndex(index){
        if(this.size() < index){
            return null;
        }

        let thisNode = this.top;
        for(var i = 0; i < index; i++){
            thisNode = thisNode.next;
        }
        return thisNode;
    }

    peekAtValue(value){
        let thisNode = this.top;

        for(var i = 0; i < this.length; i++){
            if(thisNode.data == value){
                return "True at position " + i
            }
            thisNode = thisNode.next
        }
            return false;
        }

    size(){
        return this.length;
    }

    display(){
        let nextNode = this.top;
        let itemIndex = 0
        while(nextNode){
            console.log("Item " + itemIndex + ": "+nextNode.data)
            nextNode = nextNode.next;
            itemIndex++;
        }
    }

    
//end
}


var lookAtThisStack = new Stack;

lookAtThisStack.push(1);
lookAtThisStack.push(2);
lookAtThisStack.push(3);
lookAtThisStack.push(4);
lookAtThisStack.push(5);

lookAtThisStack.isEmpty();
lookAtThisStack.display();
console.log(lookAtThisStack.peekAtValue(3));


console.log(test());