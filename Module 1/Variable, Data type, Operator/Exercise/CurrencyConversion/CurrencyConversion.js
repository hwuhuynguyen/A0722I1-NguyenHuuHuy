function convertCurrency() {
    let money = Number(document.getElementById("amount").value);
    let fromC = document.getElementById("fromCurrency").value;
    let toC = document.getElementById("toCurrency").value;

    let exchangeRate;
    if (fromC === toC)
        exchangeRate = 1;
    else {
        if (fromC == "USD") {
            switch (toC) {
                case "VND":
                    exchangeRate = 23397;
                    break;
                case "GBP":
                    exchangeRate = 0.82;
                    break;
                case "KRW":
                    exchangeRate = 1302.38;
                    break;
                case "EUR":
                    exchangeRate = 0.97;
                    break;
                case "JPY":
                    exchangeRate = 133.44;
                    break;
            }
        }
        if (fromC == "VND") {
            switch (toC) {
                case "USD":
                    exchangeRate = 0.000043;
                    break;
                case "GBP":
                    exchangeRate = 0.000035;
                    break;
                case "KRW":
                    exchangeRate = 0.056;
                    break;
                case "EUR":
                    exchangeRate = 0.000042;
                    break;
                case "JPY":
                    exchangeRate = 0.0057;
                    break;
            }
        }
        if (fromC == "GBP") {
            switch (toC) {
                case "USD":
                    exchangeRate = 1.21;
                    break;
                case "VND":
                    exchangeRate = 28408.05;
                    break;
                case "KRW":
                    exchangeRate = 1581.32;
                    break;
                case "EUR":
                    exchangeRate = 1.18;
                    break;
                case "JPY":
                    exchangeRate = 162.03;
                    break;
            }
        }
        if (fromC == "KRW") {
            switch (toC) {
                case "USD":
                    exchangeRate = 0.00077;
                    break;
                case "VND":
                    exchangeRate = 17.96;
                    break;
                case "GBP":
                    exchangeRate = 0.00063;
                    break;
                case "EUR":
                    exchangeRate = 0.00075;
                    break;
                case "JPY":
                    exchangeRate = 0.1;
                    break;
            }
        }
        if (fromC == "EUR") {
            switch (toC) {
                case "VND":
                    exchangeRate = 24011.29;
                    break;
                case "GBP":
                    exchangeRate = 0.85;
                    break;
                case "KRW":
                    exchangeRate = 1336.57;
                    break;
                case "USD":
                    exchangeRate = 1.03;
                    break;
                case "JPY":
                    exchangeRate = 136.96;
                    break;
            }
        }
        if (fromC == "JPY") {
            switch (toC) {
                case "VND":
                    exchangeRate = 175.33;
                    break;
                case "GBP":
                    exchangeRate = 0.0062;
                    break;
                case "KRW":
                    exchangeRate = 9.76;
                    break;
                case "EUR":
                    exchangeRate = 0.0073;
                    break;
                case "USD":
                    exchangeRate = 0.0075;
                    break;
            }
        }
    }

    let result = money * exchangeRate;
        document.getElementById('result').innerText = result.toLocaleString() + ' ' +toC;
}