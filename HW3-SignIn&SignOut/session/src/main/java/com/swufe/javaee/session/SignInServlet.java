package com.swufe.javaee.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String password= req.getParameter("inputPassword");
        Map<String, String> m = new HashMap<>();


        try(Stream<String> str= Files.lines(Paths.get("/Users/derekedkwangxingen/Desktop/session(HW).txt"))) {

            str.forEach(line -> {
                String[] name_pwd = line.split(" ");
                m.put(name_pwd[0], name_pwd[1]);
            });

            if(m.containsKey(name) && m.get(name).equals(password)){
                req.getSession().setAttribute("user", name);
                resp.sendRedirect("index");

            }else
                resp.sendRedirect("notFind.html");


        }
    }


}
