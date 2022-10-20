package controller;

import model.Customer;
import service.CustomerServiceImplement;
import service.ICustomerService;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService customerService = new CustomerServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                listCustomers(request, response);
                break;
        }
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findCustomerById(id);
        RequestDispatcher dispatcher;
        if (customer != null) {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/error.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findCustomerById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/error.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/customer/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findCustomerById(id);
        RequestDispatcher dispatcher;
        if (customer != null) {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/customer/view.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/error.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = this.customerService.findAllCustomers();
        request.setAttribute("customerList", customerList);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/customers-list.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }


    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        int id = (int) (Math.random() * 1000);
        this.customerService.addNewCustomer(new Customer(id, name, email, address));
        request.setAttribute("message", "Successfully add new customer");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = this.customerService.findCustomerById(id);
        RequestDispatcher dispatcher;

        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/error.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);

            this.customerService.updateCustomer(id, customer);
            request.setAttribute("message", "Successfully update customer");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findCustomerById(id);
        RequestDispatcher dispatcher;
        if (customer != null) {
            this.customerService.removeCustomer(id);
            request.setAttribute("message", "Successfully delete customer");
            try {
                response.sendRedirect("/customers");
//                dispatcher.forward(request, response);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            dispatcher = request.getRequestDispatcher("/error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException exception) {
                exception.printStackTrace();
            }
        }

    }

}
