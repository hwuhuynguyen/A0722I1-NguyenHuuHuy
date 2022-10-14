let SoTietKiem = function (MaSo, LoaiTietKiem, HoTen, CMND, NgayMoSo, SoTienGui) {
    this.MaSo = MaSo;
    this.LoaiTietKiem = LoaiTietKiem;
    this.HoTen = HoTen;
    this.CMND = CMND;
    this.NgayMoSo = NgayMoSo;
    this.SoTienGui = SoTienGui;

    this.setMaSo = function (MaSo) {
        this.MaSo = MaSo;
    };
    this.getMaSo = function () {
        return this.MaSo;
    };

    this.setLoaiTietKiem = function (LoaiTietKiem) {
        this.LoaiTietKiem = LoaiTietKiem;
    };
    this.getLoaiTietKiem = function () {
        return this.LoaiTietKiem;
    };

    this.setHoTen = function (HoTen) {
        this.HoTen = HoTen;
    };
    this.getHoTen = function () {
        return this.HoTen;
    };

    this.setCMND = function (CMND) {
        this.CMND = CMND;
    };
    this.getCMND = function () {
        return this.CMND;
    };

    this.setNgayMoSo = function (NgayMoSo) {
        this.NgayMoSo = NgayMoSo;
    };
    this.getNgayMoSo = function () {
        return this.NgayMoSo;
    };

    this.setSoTienGui = function (SoTienGui) {
        this.SoTienGui = SoTienGui;
    };
    this.getSoTienGui = function () {
        return this.SoTienGui;
    };
};

let stk1 = new SoTietKiem('1', '3 thang', 'Nguyen Huu Huy', 123456, '2002-12-12', 100000);
let stk2 = new SoTietKiem('2', '6 thang', 'Nguyen Huu Hung', 111111, '2002-11-11', 200000);

let arrCustomer = new Array();
arrCustomer.push(stk1);
arrCustomer.push(stk2);

function viewAllCustomers() {
    let source;
    source = "<table border='1px solid black'><tr>";
    source += '<th>Ma so</th><th>Loai tiet kiem</th><th>Ho ten</th><th>CMND</th><th>Ngay mo so</th><th>So tien</th>';
    source += '<th>Xoa</th></tr>'
    for (let i = 0; i < arrCustomer.length; i++) {
        source += '<tr>';
        source += '<td>' + arrCustomer[i].getMaSo() + '</td>';
        source += '<td>' + arrCustomer[i].getLoaiTietKiem() + '</td>';
        source += '<td>' + arrCustomer[i].getHoTen() + '</td>';
        source += '<td>' + arrCustomer[i].getCMND() + '</td>';
        source += '<td>' + arrCustomer[i].getNgayMoSo() + '</td>';
        source += '<td>' + arrCustomer[i].getSoTienGui() + '</td>';
        source += "<td><button name='btnDelete' onclick='removeCus()'>Delete</button></td>"
        source += '</tr>';
    }
    source += "</table>";
    document.getElementById('result').innerHTML = source;
}

function addNewCustomer(arrCustomer) {
    let maso, loaiTietKiem, hoTen, cmnd, ngayMoSo, soTienGui;
    do {
        maso = prompt('Ma so: ');
    } while (!validateMaSo(maso));
    do {
        loaiTietKiem = prompt('Loai tiet kiem');
    } while (!validateLoaiTK(loaiTietKiem));
    do {
        hoTen = prompt('ho ten khach hang');
    } while (!validateHoTen(hoTen));
    do {
        cmnd = prompt('cmnd');
    } while (!validateCMND(cmnd));
    do {
        ngayMoSo = prompt('ngay mo so');
    } while (!validateNgayMoSo(ngayMoSo));
    do {
        soTienGui = prompt('so tien gui');
    } while (!validateSoTienGui(soTienGui));

    let newCustomer = new SoTietKiem(maso, loaiTietKiem, hoTen, cmnd, ngayMoSo, soTienGui);
    let check = confirm('Do you want to add this customer to the list?');
    if (check) {
        arrCustomer.push(newCustomer);
        viewAllCustomers();
    }
}

function deleteCustomer(index) {
    let check = confirm('Do you want to delete this customer?');
    if (check) {
        arrCustomer.splice(index, 1);
    }
    viewAllCustomers();
}
function removeCus() {
    let flag = false;
    let index;
    do {
        index = parseInt(prompt('nhap ma so tiet kiem muon xoa'));
        for (let i = 0; i < arrCustomer.length; i++) {
            if (index == parseInt(arrCustomer[i].getMaSo()));
                flag = true;
            break;
        }
        if (!flag) alert('nhap lai di ');
    } while (!flag);
    let check = confirm('Do you want to delete this customer?');
    if (check) {
        for (let i = 0; i < arrCustomer.length; i++)
            if (arrCustomer[i].getMaSo() == index)
                arrCustomer.splice(i, 1);
    }
    viewAllCustomers();
}
function validateMaSo(maso) {
    if (maso.length <= 5 && maso.length > 0) return true;
    return false;
}
function validateLoaiTK(loaiTietKiem) {
    if (loaiTietKiem.length <= 10) return true;
    return false;
}
function validateHoTen(hoTen) {
    if (hoTen.length <= 30) return true;
    return false;
}
function validateCMND(cmnd) {
    if (isNaN(cmnd)) return false;
    return true;
}
function validateNgayMoSo(ngayMoSo) {
    return true;
}
function validateSoTienGui(soTienGui) {
    if (isNaN(soTienGui)) return false;
    return true;
}