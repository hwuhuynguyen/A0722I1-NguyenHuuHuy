let a = prompt("Enter the value of A: ")
let b = prompt("Enter the value of B: ")

if (Number(a) % Number(b) === 0 && Number(a) >= Number(b))
    alert("A is a multiple of B")
else
    alert('A is not a multiple of B')