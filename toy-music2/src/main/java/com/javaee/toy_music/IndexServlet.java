package com.javaee.toy_music;

import com.javaee.toy_music.Utils.BookUtils;
import com.javaee.toy_music.model.Book;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Book> books = BookUtils.recentBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}