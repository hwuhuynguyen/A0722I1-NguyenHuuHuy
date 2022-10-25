package controller;

import dao.IUserDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;
    public void init() {
        userDAO = new UserDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    showAddForm(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "view":
                    showUserInformation(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "permission":
                    addUserPermission(request, response);
                    break;
                default:
                    listUsers(request, response);
                    break;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        int[] permission = {1, 2, 4};
        userDAO.addUserTransaction(user, permission);
    }


    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/add-user.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/update-user.jsp");
        int id = Integer.parseInt(request.getParameter("id"));

        User user = userDAO.selectUser(id);

        try {
            request.setAttribute("user", user);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void showUserInformation(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/view-user.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
//        User user = userDAO.selectUser(id);
        User user = userDAO.getUserById(id);

        try {
            request.setAttribute("user", user);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.userDAO.deleteUser(id);

        List<User> userList = this.userDAO.selectAllUsers();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list-user.jsp");
        dispatcher.forward(request, response);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list-user.jsp");
        List<User> userList = userDAO.selectAllUsers();

        try {
            request.setAttribute("userList", userList);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    addUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User newUser = new User(name, email, country);
//        userDAO.insertUser(newUser);
        userDAO.insertUserStore(newUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/add-user.jsp");
        request.setAttribute("message", "Successfully add new user");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User(id, name, email, country);

        this.userDAO.updateUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/update-user.jsp");
        request.setAttribute("message", "Successfully update user");
        dispatcher.forward(request, response);
    }
}
