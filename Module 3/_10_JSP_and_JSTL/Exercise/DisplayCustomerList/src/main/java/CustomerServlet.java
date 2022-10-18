import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet" ,urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(
                new Customer("Binh", "10-10-1011", "Da Nang", "/image/image1.webp"));
        customerList.add(
                new Customer("Cuong", "10-10-1012", "Ho Chi Minh", "/image/image2.webp"));

//        getServletContext().setAttribute("customerList", customerList);
//        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(
                new Customer("An", "10-10-1010", "Ha Noi", "/image/image1.webp"));
        customerList.add(
                new Customer("Binh", "10-10-1011", "Da Nang", "/image/image2.webp"));
        customerList.add(
                new Customer("Cuong", "10-10-1012", "Ho Chi Minh", "/image/image3.webp"));

        getServletContext().setAttribute("customerList", customerList);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
