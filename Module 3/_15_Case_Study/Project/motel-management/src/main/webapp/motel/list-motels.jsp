<%@ page import="com.example.service.IMotelService" %>
<%@ page import="com.example.service.MotelService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/24/2023
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <title>List all motels</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="../static/css/bootstrap.css">
  <link rel="stylesheet" href="../static/css/bootstrap.min.css">
  <link rel="stylesheet" href="../static/datatables/css/dataTables.bootstrap4.css">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<a href="/motels?action=insert-motel">
  <button class="btn btn-primary">Thêm mới phòng trọ</button>
</a>
<h1 class="text-center">Danh sách phòng trọ</h1>
<table class="table" id="motelListTable">
  <thead>
  <tr>
    <th>Mã phòng</th>
    <th>Tên khách hàng</th>
    <th>Số điện thoại</th>
    <th>Ngày bắt đầu thuê</th>
    <th>Hình thức thanh toán</th>
    <th>Ghi chú</th>
    <th>Lựa chọn</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="motel" items="${motelList}">
  <tr>
    <td>${motel.getRoomId()}</td>
    <td>${motel.getCustomerName()}</td>
    <td>${motel.getPhoneNumber()}</td>
    <td>${motel.getStartDayFormatted()}</td>
    <c:choose>
      <c:when test="${motel.getPaymentMethod() == 1}">
        <td>Theo tháng</td>
      </c:when>
      <c:when test="${motel.getPaymentMethod() == 2}">
        <td>Theo quý</td>
      </c:when>
      <c:otherwise>
        <td>Theo năm</td>
      </c:otherwise>
    </c:choose>
    <td>${motel.getNote()}</td>
    <td>
      <a href="/motels?action=update-motel&id=${motel.getRoomId()}">
        <button class="btn btn-info">Cập nhật</button>
      </a>      <!-- Button trigger modal -->
      <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modelId${motel.getRoomId()}">
        Xóa
      </button>
      <!-- Modal -->
      <div class="modal fade" id="modelId${motel.getRoomId()}" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Modal title</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              Bạn có muốn xóa phòng trọ có mã <strong>${motel.getRoomId()}</strong> không?
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
              <a href="/motels?action=delete-motel&id=${motel.getRoomId()}">
                <button type="button" class="btn btn-primary">Xóa</button>
              </a>
            </div>
          </div>
        </div>
      </div>
    </td>
  </tr>
  </c:forEach>
  </tbody>
</table>





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

<script src="../static/js/jquery-3.5.1.min.js"></script>
<script src="../static/js/bootstrap.js"></script>
<script src="../static/datatables/js/jquery.dataTables.js"></script>
<script src="../static/datatables/js/dataTables.bootstrap4.js"></script>

<script>
  $(document).ready(function () {
    $('#motelListTable').dataTable({
      'searching': true,
      'pageLength' : 5
    })
  })

  function onDelete(id) {
    console.log(id);
    document.getElementById("idDelete").value = id;
  }
</script>
</body>
</html>