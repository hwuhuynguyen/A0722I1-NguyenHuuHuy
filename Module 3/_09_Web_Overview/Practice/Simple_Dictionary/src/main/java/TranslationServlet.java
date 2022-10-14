import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet", value = "/translate")
public class TranslationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("book", "quyen sach");
        dictionary.put("notebook", "quyen vo");
        dictionary.put("computer", "may tinh");

        String search = request.getParameter("txtSearch");
        PrintWriter writer = response.getWriter();

        String result = dictionary.get(search);

        writer.println("<html>");
        if(result != null) {
            writer.println("Word: " + search + "<br/>");
            writer.println("Result: " + result);
        } else {
            writer.println("Not found in this dictionary");
        }
        writer.println("</html>");
    }
}
