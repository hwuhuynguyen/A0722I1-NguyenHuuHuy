let inputYear = prompt("Enter the year you want to check: ");
let year = parseInt(inputYear);
let isLeapYear = false;

if (year % 4 == 0) {
    if (year % 100 == 0) {
        if (year % 400 == 0) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }
    } else {
        isLeapYear = true;
    }
}

if (isLeapYear) {
    alert(year + " is a leap year");
} else {
    alert(year + ' is NOT a leap year');
}