package com.javaee.toy_music;

import com.javaee.toy_music.Utils.BookUtils;
import com.javaee.toy_music.model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SongServlet", value = "/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = 0;
        try {
           i = Integer.parseInt(request.getParameter("id"));
           // Hint: what if this id is not found?
            Book book = BookUtils.getBookByID(i);
            request.setAttribute("book", book);
            request.getRequestDispatcher("book.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Hint: is it better to show a 404 page?
           request.getRequestDispatcher("/") .forward(request, response);
        }
    }
}
