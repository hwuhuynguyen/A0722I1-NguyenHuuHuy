function upArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.top = parseInt(element.style.top) - 50 + 'px';
}

function downArrowPressed() {
    let element = document.getElementById('nobita');
    element.style.top = parseInt(element.style.top) + 50 + 'px';
}

function leftArrowPressed() {
    let element = document.getElementById('nobita');
    element.style.left = parseInt(element.style.left) - 50 + 'px';
}

function rightArrowPressed() {
    let element = document.getElementById('nobita');
    element.style.left = parseInt(element.style.left) + 50 + 'px';
}

function moveSelection(evt) {
    switch (evt.key) {
        case 'ArrowLeft':
            leftArrowPressed();
            break;
        case 'ArrowRight':
            rightArrowPressed();
            break;
        case 'ArrowUp':
            upArrowPressed();
            break;
        case 'ArrowDown':
            downArrowPressed();
            break;
    }
}

function docReady() {
    window.addEventListener('keydown', moveSelection);
}