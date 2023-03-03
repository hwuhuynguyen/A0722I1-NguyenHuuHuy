<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/24/2023
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Add new</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


    <link rel="stylesheet" href="../static/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/datatables/css/dataTables.bootstrap4.css">
</head>
<body>

<p>
    <c:if test="${requestScope['message'] != null}">
        <span>${requestScope['message']}</span>
    </c:if>
</p>
<h1 class="text-center">Thêm mới mặt bằng</h1>

<div align="center" class="row col-12 ">
    <form method="post" action="/matBangs?action=add-mat-bang">
        <%--            <input type="hidden" name="action" value="create">--%>
        <table class="table-success align-content-center">
            <tr class="form-group">
                <th>Mã mặt bằng:</th>
                <td>
                    <input type="text" name="maMatBang" id="maMatBang" size="25" required/>
                </td>
            </tr>
            <tr>
                <th>Diện tích:</th>
                <td>
                    <input type="text" name="dienTich" id="dienTich" size="25"required />
                </td>
            </tr>
            <tr>
                <th>Trạng thái:</th>
                <td>
                    <select name="trangThai" id="trangThai">
                        <option value=1>Trống</option>
                        <option value=2>Hạ tầng</option>
                        <option value=3>Đầy đủ</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Tầng:</th>
                <td>
                    <select name="tang" id="tang">
                        <option value=1>1</option>
                        <option value=2>2</option>
                        <option value=3>3</option>
                        <option value=4>4</option>
                        <option value=5>5</option>
                        <option value=6>6</option>
                        <option value=7>7</option>
                        <option value=8>8</option>
                        <option value=9>9</option>
                        <option value=10>10</option>
                        <option value=11>11</option>
                        <option value=12>12</option>
                        <option value=13>13</option>
                        <option value=14>14</option>
                        <option value=15>15</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Loại mặt bằng:</th>
                <td>
                    <select name="loaiMatBang" id="loaiMatBang">
                        <option value=1>Văn phòng chia sẻ</option>
                        <option value=2>Văn phòng trọn gói</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Giá tiền:</th>
                <td>
                    <input type="text" name="giaTien" id="giaTien" size="25" required />  VND
                </td>
            </tr>
            <tr>
                <th>Ngày bắt đầu:</th>
                <td>
                    <input type="date" name="ngayBatDau" id="ngayBatDau" size="25" required/>
                </td>
            </tr>
            <tr>
                <th>Ngày kết thúc:</th>
                <td>
                    <input type="date" name="ngayKetThuc" id="ngayKetThuc" size="25" required/>
                </td>
            </tr>

            <tr>
                <th>Mô tả:</th>
                <td>
                    <input type="text" name="moTa" id="moTa" size="45"/>
                </td>
            </tr>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="btn btn-success"value="Thêm mới"/>
                    <a class="btn btn-danger" href="/matBangs" role="button">Quay về danh sách mặt bằng</a>
                </td>
            </tr>
        </table>
    </form>
</div>


<script src="../static/js/jquery-3.5.1.min.js"></script>
<script src="../static/js/bootstrap.js"></script>
<script src="../static/datatables/js/jquery.dataTables.js"></script>
<script src="../static/datatables/js/dataTables.bootstrap4.js"></script>
</body>
</html>
