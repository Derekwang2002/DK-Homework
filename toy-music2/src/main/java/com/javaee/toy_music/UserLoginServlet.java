package com.javaee.toy_music;

import com.javaee.toy_music.Utils.GetUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserLoginServlet", value = "/user-login")
public class UserLoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user-login.html") .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("inputName");
        String password = request.getParameter("inputPassword");
        Map<String,String> m = GetUser.getID();

        boolean status = (m.containsKey(name)&&m.get(name).equals(password));
        if(status){
            request.getSession().setAttribute("user", name);
            response.sendRedirect("index");
        }
        else{
            response.sendRedirect("error.html");
        }

    }
}