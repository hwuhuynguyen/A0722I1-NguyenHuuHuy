<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/24/2023
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>List all</title>
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

<a href="/matBangs?action=add-mat-bang">
    <button class="btn btn-primary">Thêm mới mặt bằng</button>
</a>

<a href="/matBangs?action=search-mat-bang">
    <button class="btn btn-primary">Tìm kiếm mặt bằng</button>
</a>

<h1 class="text-center">Danh sách mặt bằng</h1>
<table class="table" id="matBangListTable">
    <thead>
    <tr>
        <th>Mã mặt bằng</th>
        <th>Diện tích</th>
        <th>Trạng thái</th>
        <th>Tầng</th>
        <th>Loại mặt bằng</th>
        <th>Giá tiền</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Mô tả</th>
        <th>Xóa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="matBang" items="${matBangList}">
        <tr>
            <td>${matBang.getMaMatBang()}</td>
            <td>${matBang.getDienTich()}</td>

            <c:choose>
                <c:when test="${matBang.getTrangThai() == 1}">
                    <td>Trống</td>
                </c:when>
                <c:when test="${matBang.getTrangThai() == 2}">
                    <td>Hạ tầng</td>
                </c:when>
                <c:otherwise>
                    <td>Đầy đủ</td>
                </c:otherwise>
            </c:choose>

            <td>${matBang.getTang()}</td>
            <c:choose>
                <c:when test="${matBang.getLoaiMatBang() == 1}">
                    <td>Văn phòng chia sẻ</td>
                </c:when>
                <c:when test="${matBang.getLoaiMatBang() == 2}">
                    <td>Văn phòng trọn gói</td>
                </c:when>
            </c:choose>

            <td>${matBang.getGiaTien()}</td>
            <td>${matBang.formatDate(matBang.getNgayBatDau())}</td>
            <td>${matBang.formatDate(matBang.getNgayKetThuc())}</td>
            <td>${matBang.getMoTa()}</td>

            <td>
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modelId${matBang.getMaMatBang()}">
                    Xóa
                </button>
                <!-- Modal -->
                <div class="modal fade" id="modelId${matBang.getMaMatBang()}" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Bạn có chắc chắn muốn xóa mặt bằng với mã số <strong>${matBang.getMaMatBang()}</strong> không?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                                <a href="/matBangs?action=delete-mat-bang&id=${matBang.getMaMatBang()}">
                                    <button type="button" class="btn btn-primary">Xóa</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
<%--            <td>--%>
<%--                <a href="/motels?action=update-motel&id=${motel.getRoomId()}">--%>
<%--                    <button class="btn btn-info">Cập nhật</button>--%>
<%--                </a>      <!-- Button trigger modal -->--%>
<%--                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modelId${motel.getRoomId()}">--%>
<%--                    Xóa--%>
<%--                </button>--%>
<%--                <!-- Modal -->--%>
<%--                <div class="modal fade" id="modelId${motel.getRoomId()}" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">--%>
<%--                    <div class="modal-dialog" role="document">--%>
<%--                        <div class="modal-content">--%>
<%--                            <div class="modal-header">--%>
<%--                                <h5 class="modal-title">Modal title</h5>--%>
<%--                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                                    <span aria-hidden="true">&times;</span>--%>
<%--                                </button>--%>
<%--                            </div>--%>
<%--                            <div class="modal-body">--%>
<%--                                Bạn có muốn xóa phòng trọ có mã <strong>${motel.getRoomId()}</strong> không?--%>
<%--                            </div>--%>
<%--                            <div class="modal-footer">--%>
<%--                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>--%>
<%--                                <a href="/motels?action=delete-motel&id=${motel.getRoomId()}">--%>
<%--                                    <button type="button" class="btn btn-primary">Xóa</button>--%>
<%--                                </a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </td>--%>
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
</body>
</html>