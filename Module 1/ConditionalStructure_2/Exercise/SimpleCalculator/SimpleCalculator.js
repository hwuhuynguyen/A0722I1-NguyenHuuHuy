let operand1 = null;
let operand2 = null;
let operator = null;
let result = null;
function getDigit(char) {
    document.getElementById('screen').value += char;
}
function cancel() {
    document.getElementById('screen').value = null;
    operator = null;
    operand1 = null;
    operand2 = null;
}
function getOperator(char) {
    if (operator != null) {
        if (document.getElementById('screen').value != null) {
            operand2 = parseInt(document.getElementById('screen').value);
            solve();
        }
    } else {
        operator = char;
        operand1 = parseInt(document.getElementById('screen').value);
        document.getElementById('screen').value = null;
    }
}
function solve() {
    if (operator != null) {
        operand2 = parseInt(document.getElementById('screen').value);
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        document.getElementById('screen').value = result;
        operand1 = result;
        operand2 = null;
        operator = null;
        result = null;
    } else {
        operand1 = parseInt(document.getElementById('screen').value);
    }
}