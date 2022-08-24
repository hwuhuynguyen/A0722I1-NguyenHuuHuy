function viewAllProducts() {
    let source;
    source = "<table>";
    for (let i = 0; i < arrProduct.length; i++) {
        source += '<tr>';
        source += '<td>' + (i+1) + '</td>' + '<td>' + arrProduct[i] + '</td>';
        source += "<td><button name='btnEdit' onclick='getProduct(" + i + ")'>Edit</button></td>";
        source += "<td><button name='btnDelete' onclick='deleteProduct(" + i + ")'>Delete</button></td>"
        source += '</tr>';
    }
    source += "</table>";
    document.getElementById('result').innerHTML = source;
}

function addNewProduct(arrProduct, newProduct) {
    if (newProduct == '') {
        alert('Please enter the new item');
    } else {
        let check = confirm('Do you want to add this item to the list?');
        if (check) {
            arrProduct.push(newProduct);
            viewAllProducts();
        }
        document.getElementById('newProduct').value = '';
    }
}

function getProduct(index) {
    ID = index;
    document.getElementById('editProduct').value = arrProduct[index];
    document.getElementById('editProduct').focus();
}

function updateProduct(arrProduct, update) {
    if (ID == -1) {
        alert('Please choose the item you want to update!');
    } else {
        let check = confirm('Do you want to update this item?');
        if (check) {
            arrProduct[ID] = update;
            console.log(update);
            viewAllProducts();
        } else {
            ID = -1;
            document.getElementById('editProduct').value = '';
        }
    }
}
function deleteProduct(index) {
    let check = confirm('Do you want to delete this item?');
    if (check) {
        arrProduct.splice(index, 1);
        document.getElementById('newProduct').value = '';
        document.getElementById('editProduct').value = '';
    }
    viewAllProducts();
}

let arrProduct = ['Sony', 'Samsung Galaxy', 'Nokia 6', 'Xiaomi 4', 'Apple iPhone 6', 'Xiaomi 5S', 'Fujitsu', 'MacBook','Oppo'];
let ID = -1;
