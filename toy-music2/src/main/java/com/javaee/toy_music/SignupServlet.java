package com.javaee.toy_music;

import com.javaee.toy_music.Utils.BookUtils;
import com.javaee.toy_music.Utils.GetUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "SignupServlet", value = "/Sign-up")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signup.html").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Map<String,String> m0 = GetUser.getID();

        if(m0.containsKey(name)){
            response.sendRedirect("user-exist.html");
        }else {
            BookUtils.signup(name, password);
            response.sendRedirect("signup-success.html");
        }


}
}
