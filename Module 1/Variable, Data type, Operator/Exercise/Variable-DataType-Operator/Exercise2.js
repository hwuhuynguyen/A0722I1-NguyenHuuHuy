let inputCelsius = prompt("Enter the value of Celsius degree: ")

let Celsius = parseFloat(inputCelsius)
let Fahrenheit = ((Celsius/5)* 9) + 32

document.write("Fahrenheit degree: " + Fahrenheit)
document.write('<br/>')