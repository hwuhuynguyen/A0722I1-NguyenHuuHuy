import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        if (username.equals("admin") && password.equals("admin"))
            printWriter.println("<h1>Welcome " + username + " to this website!!! </h1>");
        else
            printWriter.println("<h1>Login error</h1>");
        printWriter.println("</html>");
    }
}
