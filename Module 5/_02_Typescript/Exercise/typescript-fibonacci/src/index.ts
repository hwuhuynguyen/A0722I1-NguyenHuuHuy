let fibonacciNumberList : number[] = [1,1];

function getFibonacciSum(n: number) : number {
    let firstNumber = 1;
    let secondNumber = 1;
    let sum = 2;
    for (let i = 3; i <= n; i++) {
        let temp = firstNumber + secondNumber;
        fibonacciNumberList.push(temp);
        sum += temp;
        firstNumber = secondNumber;
        secondNumber = temp;
    }
    return sum;
}

console.log(getFibonacciSum(9));
console.log(fibonacciNumberList);
