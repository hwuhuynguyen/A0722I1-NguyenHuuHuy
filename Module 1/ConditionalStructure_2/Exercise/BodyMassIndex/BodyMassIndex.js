let inputWeight = prompt('Enter your weight (kg): ');
let inputHeight = prompt('Enter your height (m): ');

let weight = Number(inputWeight);
let height = Number(inputHeight);

let bmi = weight / ( height ^ 2 );

if (bmi < 18)
    document.write("Underweight");
else if (bmi < 25.0)
    document.write("Normal");
else if (bmi < 30.0)
    document.write("Overweight");
else
    document.write("Obese");

