package com.javaee.toy_music;

import com.javaee.toy_music.Utils.BookUtils;
import com.javaee.toy_music.model.Book;

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
import java.util.stream.Stream;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String search = request.getParameter("Search");
        // 取出所有book数据
        List<Book> books = BookUtils.loadBooks();
        Integer id = null;

        // 按照title查找,匹配上的复制给id变量
        for (int i = 0; i < books.size(); i++) {
            Book it = books.get(i);
            // find book by title
            // id will not null
            if(it.getTitle().equalsIgnoreCase(search)){
                id = it.getId();
                break;
            }
        }


        // 如果id存在  表示找到book
        if(id != null){
            Book book = BookUtils.getBookByID(id);
            request.setAttribute("book", book);
            request.getRequestDispatcher("book.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("not-found.html");
        }
    }
}