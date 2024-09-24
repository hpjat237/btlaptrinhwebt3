package vn.hoangphat.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.hoangphat.models.UserModel;
import vn.hoangphat.service.IUserService;
import vn.hoangphat.service.impl.UserServiceImpl;

@WebServlet(name = "ProfileController", value = "/profile")
public class ProfileController extends HttpServlet {

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username from cookie
        Cookie[] cookies = request.getCookies();
        String username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        UserModel user = userService.findByUsername(username);

        // Set attributes in the request
        request.setAttribute("username", username);
        request.setAttribute("phone", user.getPhone()); // Example phone number
        request.setAttribute("fullname", user.getFullname()); // Example full name
        request.setAttribute("email", user.getEmail()); // Example email
        request.setAttribute("message", request.getParameter("message"));
        request.getRequestDispatcher("/view/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get parameters from the request
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");

        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        // Check if the passwords match
        if (!password.equals(confirmPassword)) {
            response.sendRedirect(request.getContextPath() + "/profile?error=Passwords do not match");
            return;
        }

        // Update user information
        UserModel user = userService.findByUsername(username);
        user.setPhone(phone);
        user.setFullname(fullname);
        user.setEmail(email);
        userService.update(user);

        userService.updatePassword(username, password);

        // Redirect to the profile page
        response.sendRedirect(request.getContextPath() + "/profile");
    }
}
