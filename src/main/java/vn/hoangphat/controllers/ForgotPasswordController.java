package vn.hoangphat.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.hoangphat.models.UserModel;
import vn.hoangphat.service.IUserService;
import vn.hoangphat.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/forgotpassword"})
public class ForgotPasswordController extends HttpServlet{
		IUserService service = new UserServiceImpl();
		private static final long serialVersionUID = -5239443831057636103L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/view/forgotpassword.jsp").forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    resp.setContentType("text/html");
		    resp.setCharacterEncoding("UTF-8");
		    req.setCharacterEncoding("UTF-8");
		    
		    String username = req.getParameter("username");
		    String email = req.getParameter("email");

		    UserModel user = service.findByUsername(username);

		    if (user != null && user.getEmail().equals(email)) {
//		        String sm = user.getEmail();
//		        boolean test = sm.EmailSend(user);
//		        
//		        if (test) {
//		            req.setAttribute("message", "Vui lòng kiểm tra email để nhận mật khẩu mới nhé.");
//		        } else {
//		            req.setAttribute("error", "Lỗi khi gửi email!");
//		        }
//		    } else {
//		        req.setAttribute("error", "Tên đăng nhập hoặc email không đúng!");
//		    }

		    req.getRequestDispatcher("/view/forgotpassword.jsp").forward(req, resp);
		    }
		}
}
