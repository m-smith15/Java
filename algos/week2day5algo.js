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

//Calebs display
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

determineStartIndent(node = this.root, maxIndent = 0){
    let leftIndent = maxIndent;
    let rightIndent = maxIndent;

    if( node.left ){
        leftIndent = this.determineStartIndent( node.left, maxIndent + 1 );
    }
    if( node.right ){
        rightIndent = this.determineStartIndent( node.right, maxIndent -1 );
    }

    if( leftIndent > rightIndent ){
        return leftIndent;
    }
    return rightIndent;
}

determineLongestBranchLength( node = this.root, maxHeight = 1){
    let leftMaxHeight = maxHeight;
    let rightMaxHeight = maxHeight;

    if(node.left){
        leftMaxHeight = this.determineLongestBranchLength( node.left, maxHeight + 1);
    }
    if(node.right){
        rightMaxHeight = this.determineLongestBranchLength( node.right, maxHeight + 1);
    }

    if( leftMaxHeight > rightMaxHeight ){
        return leftMaxHeight;
    }
    return rightMaxHeight;
}
//end display

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

minRecursive(current = this.root) { 
    if(this.isEmpty()){
        return null;
    }
    if(current.left){
        return this.minRecursive(current.left)
    }
    return current.data;
}

max(current = this.root) { 
    if(this.isEmpty()){
        return null;
    }
    while(current){
        if (current.right){
            current = current.right
        } else {
            return current.data;
        }
    }
}

maxRecurisve(current = this.root){
    if(this.isEmpty()){
        return null;
    }
    if(current.right){
        return this.maxRecurisve(current.right)
    }
    return current.data;
}


contains(searchVal) { 
    if(this.isEmpty()){
        return false;
    }
    var runner = this.root;
    while(runner){
        if(searchVal > runner.data && !runner.right){
            return false;//
        } else if(searchVal > runner.data && runner.right){
            runner = runner.right;
        } else if(searchVal < runner.data && !runner.left){
            return false;
        } else if(searchVal < runner.data && runner.left){
            runner = runner.left;
        } else 
            return true;
    }
}

containsRecursive(searchVal, current = this.root) { 
    if(this.isEmpty()){
        return false;
    } else if(searchVal > current.data && !current.right){
        return false;
    } else if(searchVal > current.data && current.right){
        return this.containsRecursive(searchVal,current.right)
    } else if(searchVal < current.data && !current.left){
        return false;
    } else if(searchVal < current.data && current.left){
        return this.containsRecursive(searchVal,current.left)
    } else if(searchVal == current.data){
        return true;
    }
}

//end
}

var tree = new BinarySearchTree
tree.insert(1);
tree.insert(12);
tree.insert(14);
tree.insert(11);
tree.insert(13);
tree.display();
tree.maxRecurisve();