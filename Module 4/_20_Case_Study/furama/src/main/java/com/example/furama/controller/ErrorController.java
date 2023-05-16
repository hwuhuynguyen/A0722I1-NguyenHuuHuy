//package codegym.vn.springboot.controller;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.sql.SQLException;
//
//@ControllerAdvice
//public class ErrorController {
//    @ExceptionHandler(Exception.class)
//    public String error(Exception e, Model model) {
//        String message = null;
//        if (e instanceof SQLException) {
//            message = "Lỗi kết nối database";
//        } else {
//            message = e.getClass().getName() + "|Lỗi bất thường";
//        }
//        model.addAttribute("errorMessage", message);
//        return "error/error";
//    }
//}
