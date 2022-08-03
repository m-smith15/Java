//A data structure that represents a list. The list is made out of "nodes". Each node will have a value and a .next. The .next of a node will point to the address of the node "behind" it in "line"

// let nums = [4,5,7,9];
//idx          0 1 2 3

//metaphor: SLL === the line at chipotle
class SLL{
    constructor(){
        this.head = null;
    }

    isEmpty(){
        if(this.head === null){
            return true;
        }else{
            return false;
        }
    }

    insertAtFront(valueInput){
        //create a person/node with that valueInput
        let newPerson = new Node(valueInput);
        if (this.isEmpty()){
            this.head = newPerson;
        }
        else{
            newPerson.next = this.head;
            this.head = newPerson;
        }
    }
    removeFromFront(valueInput){
        this.head = this.head.next;
        //console.log("replaced");
    }

    display(){
        let currentnode = this.head;
        while(currentnode){
            console.log("Display " + currentnode.value);
            currentnode = currentnode.next;
        }
        console.log("display ran");
    }

}

//metaphor: node === each person in chipotle line
class Node{
    constructor(valueInput){
        this.value = valueInput;
        this.next = null;
    }
}

//insert at Front
//display method

let chipotleLine = new SLL();

chipotleLine.insertAtFront("David");
chipotleLine.insertAtFront("Mack");
chipotleLine.insertAtFront("Erik");
chipotleLine.insertAtFront("Kendra");
chipotleLine.insertAtFront("Caleb");
chipotleLine.display();
console.log(chipotleLine);

chipotleLine.removeFromFront("Caleb");
chipotleLine.display();
console.log(chipotleLine);