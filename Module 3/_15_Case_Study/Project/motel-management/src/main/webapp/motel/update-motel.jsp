<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/24/2023
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Update motel</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%--    <form method="post" action="/motels?action=update">--%>
<%--        <div class="form-group">--%>
<%--            <label for="roomId">Mã phòng trọ</label>--%>
<%--            <input type="text" name="" id="roomId" class="form-control" placeholder="${newId}" aria-describedby="helpId">--%>
<%--        </div>--%>
<%--    </form>--%>
<p>
    <c:if test="${requestScope['message'] != null}">
        <span>${requestScope['message']}</span>
    </c:if>
</p>
<h1 class="text-center">Cập nhật phòng trọ</h1>

<div align="center" class="row col-12 ">
    <form method="post" action="/motels?action=update-motel">
        <%--            <input type="hidden" name="action" value="create">--%>
        <table class="table-success">
            <tr class="form-group">
                <th>Mã phòng trọ:</th>
                <td>
                    <input type="text" name="roomId" id="roomId" size="25" value="${motel.getRoomId()}" readonly/>
                </td>
            </tr>
            <tr>
                <th>Tên khách hàng:</th>
                <td>
                    <input type="text" name="customerName" id="customerName" value="${motel.getCustomerName()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" value="${motel.getPhoneNumber()}" size="25"/>
                </td>
            </tr>
            <tr>
                <th>Ngày bắt đầu thuê trọ:</th>
                <td>
                    <input type="date" name="startDay" id="startDay" value="${motel.getStartDay()}"size="25"/>
                </td>
            </tr>
            <tr>
                <th>Hình thức thanh toán:</th>
                <td>
                    <select name="paymentMethod">
                        <c:if test="${motel.getPaymentMethod() == 1}">
                            <option selected value=1>Theo tháng</option>
                            <option value=2>Theo quý</option>
                            <option value=3>Theo năm</option>
                        </c:if>
                        <c:if test="${motel.getPaymentMethod() == 2}">
                            <option value=1>Theo tháng</option>
                            <option selected value=2>Theo quý</option>
                            <option value=3>Theo năm</option>
                        </c:if>
                        <c:if test="${motel.getPaymentMethod() == 3}">
                            <option value=1>Theo tháng</option>
                            <option value=2>Theo quý</option>
                            <option selected value=3>Theo năm</option>
                        </c:if>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Ghi chú:</th>
                <td>
                    <input type="text" name="note" id="note" value="${motel.getNote()}" size="45"/>
                </td>
            </tr>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="btn btn-success"value="Cập nhật"/>
                    <a class="btn btn-danger" href="/motels" role="button">Quay về danh sách phòng trọ</a>
                </td>
            </tr>
        </table>
    </form>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>