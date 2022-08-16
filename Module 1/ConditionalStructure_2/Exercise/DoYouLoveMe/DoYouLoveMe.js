let buttonNo = document.getElementById('no');
function clickYes() {
    alert('<3');
    console.log(window.innerHeight + " " + window.innerWidth);
}
function clickNo() {
    document.getElementById('no').style.left = (getRandomArbitrary(0, window.innerWidth)) + 'px';
    document.getElementById('no').style.top = (getRandomArbitrary(0, window.innerHeight)) + "px";

    console.log(document.getElementById('no').style.top + " " + document.getElementById('no').style.left);
}
function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
}
