package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImplement();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showUpdateForm(request, response);
                break;
            case "search":
                showSearchForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showProductInformation(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/error.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/product/update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("/error.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void showProductInformation(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/error.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.productService.findAllProducts();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/products-list.jsp");
        request.setAttribute("productList", productList);
        try {
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
        switch (action) {
            case "add":
                addNewProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("name");
        double productPrice = Double.parseDouble(request.getParameter("price"));
        String productDescription = request.getParameter("description");
        String productManufacture = request.getParameter("manufacture");

        int id = (int) (Math.random() * 10000);
        Product product = new Product(id, productName, productPrice, productDescription, productManufacture);
        this.productService.addNewProduct(product);
        request.setAttribute("message", "Successfully add new product");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacture = request.getParameter("manufacture");

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductManufacture(manufacture);

        this.productService.updateProduct(id, product);
        request.setAttribute("message", "Successfully update product");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> productList = this.productService.searchProductByName(name);
        RequestDispatcher dispatcher;
        if (productList.size() == 0) {
            request.setAttribute("message", "Dont have any product having that name");
        } else {
            request.setAttribute("productList", productList);
        }
        dispatcher = request.getRequestDispatcher("/product/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;

        if (product != null) {
            this.productService.removeProduct(id);
            try {
                response.sendRedirect("/products");
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
