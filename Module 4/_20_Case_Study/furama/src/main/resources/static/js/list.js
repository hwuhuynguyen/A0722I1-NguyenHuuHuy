function search() {
    let name = $("#name").val();
    let email = $("#email").val();
    $.ajax({
       url: "http://localhost:8080/api/v2/student/searchNameOrEmail",
       data: {
           name: name,
           email: email
       },
        type: "get",
        dataType: "json",
        success: function (res) {
            let result = '';
            for (let i = 0; i < res.length; i++) {
                result +=
                    `
                      <tr>
                        <td><input type="checkbox" value="${res[i].id}" name="ids"></td>
                        <td>${res[i].id}</td>
                        <td>${res[i].name}</td>
                        <td>${res[i].className.className}</td>
                        <td>${res[i].email}</td>
                        <td>${res[i].phoneNumber}</td>
                        <!--<td th:text="*{birthdate}"></td>-->
                        <td></td>
                        <td></td>
                        <td>
                            <a href="/student/view?id=${res[i].id}">View</a>
                        </td>
                        <td>
                            <a href="@{/student/update/${res[i].id}}">Update</a>
                        </td>
                        <td>
                            <a href="@{/student/delete/${res[i].id}">Delete</a>
                        </td>
                      </tr>
                    `
            }

            $("#result").html(result);
        }
        
    });
}