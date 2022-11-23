package customer_management.servlet;

import customer_management.model.Customer;
import customer_management.service.CustomerServiceFactory;
import customer_management.service.ICustomerService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = CustomerServiceFactory.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));

        Long id = Long.valueOf(request.getParameter("id"));
        customer.setId(id);
        customerService.save(customer);

        response.sendRedirect("/customers/list.jsp");
    }
}
