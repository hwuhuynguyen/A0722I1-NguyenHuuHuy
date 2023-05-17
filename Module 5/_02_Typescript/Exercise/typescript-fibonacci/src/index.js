var fibonacciNumberList = [1, 1];
function getFibonacciSum(n) {
    var firstNumber = 1;
    var secondNumber = 1;
    var sum = 2;
    for (var i = 3; i <= n; i++) {
        var temp = firstNumber + secondNumber;
        fibonacciNumberList.push(temp);
        sum += temp;
        firstNumber = secondNumber;
        secondNumber = temp;
    }
    return sum;
}
console.log(getFibonacciSum(9));
console.log(fibonacciNumberList);
