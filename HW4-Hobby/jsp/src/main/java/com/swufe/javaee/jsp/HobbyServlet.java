package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, ArrayList<String>> userHobby;
    @Override
    public void init() {
        ArrayList<String> hb1=new ArrayList<>();
        hb1.add(0,"knitting");
        hb1.add(1,"skiing");
        ArrayList<String> hb2=new ArrayList<>();
        hb2.add(0,"scuba");
        hb2.add(1,"dating");
        ArrayList<String> hb3=new ArrayList<>();
        hb3.add(0,"badminton");
        hb3.add(1,"scuba");


       userHobby = new HashMap<>();
       userHobby.put("Bob", hb1);
       userHobby.put("Jim", hb1);
       userHobby.put("James", hb1);
       userHobby.put("Tom", hb2);
       userHobby.put("Fei", hb2);
       userHobby.put("Jone", hb2);
       userHobby.put("Fred", hb3);
       userHobby.put("Pradeep", hb3);
       userHobby.put("Philippe", hb3);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       userHobby.forEach((k, v) -> {
           if (v.contains(hobby)) {
               names.add(k);
           }
       });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
       //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}
