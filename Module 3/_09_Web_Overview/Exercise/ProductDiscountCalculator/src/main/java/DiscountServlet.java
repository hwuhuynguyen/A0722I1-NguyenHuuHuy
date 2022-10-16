import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/calculator-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("productDescription");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));

        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount;

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<table>");
        writer.println("<tr><th>Product description</th>");
        writer.println("<td>" + description + "</td></tr>");

        writer.println("<tr><th>Price</th>");
        writer.println("<td>" + price + "</td></tr>");

        writer.println("<tr><th>Discount</th>");
        writer.println("<td>" + discount + "</td></tr>");

        writer.println("<tr><th>Discount amount</th>");
        writer.println("<td>" + discountAmount + "</td></tr>");

        writer.println("<tr><th>Discount price</th>");
        writer.println("<td>" + discountPrice + "</td></tr>");

        writer.println("</table>");
        writer.println("</html>");
    }
}
