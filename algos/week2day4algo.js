class BSTNode {
    constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
    }
}

class BinarySearchTree {
    constructor() {
    this.root = null;
    }

    isEmpty() {
        if (this.root == null) {
            return true;
        }
        else return false;
    }


insert( newVal ){
    let newNode = new BSTNode( newVal )
    if( this.isEmpty() ){
        this.root = newNode;
        return this;
    }
    let runner = this.root;
    while( runner ) {
        if( newVal === runner.data ){
            runner.count++;
            return this;
        }
        if ( newVal > runner.data ){
            if( runner.right ){
                runner = runner.right;
            } else {
                runner.right = newNode;
                return this;
            }
        } else {
            if( runner.left ){
                runner = runner.left;
            } else {
                runner.left = newNode;
                return this;
            }
        }
    }
}

min(current = this.root) { 
    if(this.isEmpty()){
        return null;
    }
    while(current){
        if (current.left){
            current = current.left
        } else {
            return current.data;
        }
    }
}

display(){
    if( this.isEmpty() ){
        console.log("Your Binary Search Tree is empty!");
        return null; 
    }
    
    let rowsToDisplay = this.generateDisplayByRow();

    for (let row of Object.values(rowsToDisplay)) {
        console.log(row);
    }
    
}

generateDisplayByRow( node = this.root, memo = {}, layer = 1, height = this.determineLongestBranchLength()+2, currentIndent = this.determineStartIndent()*height*2, previousIndent = 0 ){
    if( !(layer in memo )) {
        memo[layer] = "";
        memo[layer] += " ".repeat(currentIndent);
        memo[layer] += node.data;
    }
    else {
        memo[layer] += " ".repeat( 0 < currentIndent - memo[layer].length ? currentIndent - memo[layer].length : 1 );
        memo[layer] += node.data;
    }
    let leftNextIndent = currentIndent;
    let rightNextIndent = currentIndent;
    if( node.left ) {
        leftNextIndent -= (height - layer)*2 - (height/2);
        this.generateDisplayByRow( node.left, memo, layer + 1, height, leftNextIndent, currentIndent );
    }
    if( node.right ) {
        rightNextIndent += (height - layer)*2 - (height/2);
        this.generateDisplayByRow( node.right, memo, layer + 1, height, rightNextIndent, currentIndent );
    }
    return memo;
}

minRecursive(current = this.root) {

}
contains(searchVal){

}

containsRecursive(seearchVal, current = this.root){

}

}
