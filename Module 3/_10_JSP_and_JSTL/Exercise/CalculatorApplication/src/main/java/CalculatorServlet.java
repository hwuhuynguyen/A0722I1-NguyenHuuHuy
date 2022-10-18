import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",  urlPatterns = {"/calculator"})
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double firstOperand = Double.valueOf(request.getParameter("firstOperand"));
        Double secondOperand = Double.valueOf(request.getParameter("secondOperand"));

        char operator = request.getParameter("operator").charAt(0);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result</h1>");
        try {
            double result = Calculator.calculate(firstOperand, secondOperand, operator);
            writer.println("<label>" + firstOperand + " " +  operator + " " + secondOperand + " = " + result + "</label>");
        } catch (Exception e) {
            writer.println(e.getMessage());
        }
        writer.println("</html>");
    }
}
