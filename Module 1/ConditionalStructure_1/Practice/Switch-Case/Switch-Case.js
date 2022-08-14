let value = Number(prompt('Type a number', 0));

switch (value > 0) {
    case true:
        alert(1);
        break;
    case false:
        switch (value) {
            case 0:
                alert(0);
                break;
            default:
                alert(-1);
                break;
        }
}