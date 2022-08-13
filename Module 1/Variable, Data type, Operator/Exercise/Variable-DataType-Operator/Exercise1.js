let inputPhysics = prompt("Enter the score of physics: ")
let inputChemistry = prompt("Enter the value of chemistry: ")
let inputBiology = prompt("Enter the value of biology: ")

let physics = parseInt(inputPhysics)
let chemistry = parseInt(inputChemistry)
let biology = parseInt(inputBiology)

let average = (physics + chemistry + biology) / 3;
let sum = (physics + chemistry + biology)

document.write("Average score of 3 subjects is: " + average + '<br/>')
document.write('Total score of 3 subjects is: ' + sum)
document.write('<br/>')