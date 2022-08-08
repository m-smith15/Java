function min(arr, toReturn) {
    if(toReturn == 'value'){
        return (Math.min(...arr));
    }
    else {
        return arr.indexOf(Math.min(...arr), arr);
    }
}
min([1,2,3,4,5], 'value') // => 1
min([1,2,3,4,5], 'index') // => 0
// additional testing
min([5,4,3,4,5], 'value') // => 3
min([5,4,3,4,5], 'index') // => 2