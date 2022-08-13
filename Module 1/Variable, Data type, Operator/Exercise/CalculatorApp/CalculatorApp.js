function calculator(operator) {
    let operand1 = Number(document.getElementById('operand1').value);
    let operand2 = Number(document.getElementById('operand2').value);
    let result;
    switch (operator) {
        case 'addition':
            result = operand1 + operand2;
            break;
        case 'subtraction':
            result = operand1 - operand2;
            break;
        case 'multiplication':
            result = operand1 * operand2;
            break;
        case 'division':
            result = operand1 / operand2;
            break;
    }
    document.getElementById('result').innerText = "Result " + operator + ": " + result;
}