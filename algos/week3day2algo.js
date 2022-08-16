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

range(){
    return this.max()-this.min();
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

insertRecursive(newVal, curr = this.root) {
    if(this.isEmpty()){
        this.root = new BSTNode(newVal);
        return this;
    } else if(newVal > current.data && !current.right){
        current.right = new BSTNode(newVal);
        return this;
    } else if(newVal > current.data && current.right){
        return this.insertRecursive(newVal,current.right);
    } else if(newVal < current.data && !current.left){
        current.left = new BSTNode(newVal);
        return this;
    } else if(newVal < current.data && current.left){
        return this.insertRecursive(newVal,current.left)
    }
}

// removeEnd(searchVal){ //WIP
//     if(this.isEmpty()){
//         return false;
//     }
//     var runner = this.root;
//     var lagRight = null;
//     var lagLeft = null;
//     while(runner){
//         if(searchVal > runner.data && !runner.right){
//             return false;
//         } else if(searchVal > runner.data && runner.right){
//             lagLeft = runner.data;
//             lagRight = null;
//             runner = runner.right;
//         } else if(searchVal < runner.data && !runner.left){
//             return false;
//         } else if(searchVal < runner.data && runner.left){
//             lagRight = runner.data;
//             lagLeft = null;
//             runner = runner.left;
//         } else 
//             // if(lagRight != null){
//             //     lagRight.left = null
//             // }
//             // else if(lagLeft != null){
//             //     lagLeft.right = null
//             // }
//             return console.log("found value " + searchVal + " with lagLeft " + lagLeft + " and lagRight " + lagRight +" runner: " + runner.data);
//     }
// }
/**
 * DFS Inorder: (Left, CurrNode, Right)
 * Converts this BST into an array following Depth First Search inorder.
 * See debugger call stack to help understand the recursion.
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
toArrInorder(node = this.root, vals = []) {
    if(this.isEmpty()){
        return vals;
    }
    if(node.left){ //move left
        this.toArrInorder(node.left, vals)
    }
    vals.push(node.data);
    if(node.right){ //move right

        this.toArrInorder(node.right, vals);
    }
    return vals;
}

/**
 * DFS Preorder: (CurrNode, Left, Right)
 * Converts this BST into an array following Depth First Search preorder.
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
toArrPreorder(node = this.root, vals = []) {
    if(this.isEmpty()){
        return vals;
    }
    if(node.left){ //move left
        this.toArrInorder(node.left, vals)
    }
    vals.push(node.data);
    if(node.right){ //move right
        this.toArrInorder(node.right, vals);
    }
    return vals;
}

/**
 * DFS Postorder (Left, Right, CurrNode)
 * Converts this BST into an array following Depth First Search postorder.
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
toArrPostorder(node = this.root, vals = []) {
    if(this.isEmpty()){
        return vals;
    }
    if(node.left){ //move left
        this.toArrInorder(node.left, vals)
    }
    vals.push(node.data);
    if(node.right){ //move right
        this.toArrInorder(node.right, vals);
    }
    return vals;
}


//end
}

var tree = new BinarySearchTree
tree.insert(50);
tree.insert(25);
tree.insert(10);
tree.insert(40);
tree.insert(75);
tree.insert(60);
tree.insert(90);
tree.display();

console.log(tree.toArrInorder());
console.log("-----------")
console.log(tree.toArrPreorder());
console.log("-----------")
console.log(tree.toArrPostorder());

//console.log(tree.range());
//tree.maxRecurisve();

// tree.removeEnd(13);
// tree.display();