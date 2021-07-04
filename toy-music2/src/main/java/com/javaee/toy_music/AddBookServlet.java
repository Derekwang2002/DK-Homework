package com.javaee.toy_music;

import com.javaee.toy_music.Utils.BookUtils;
import com.javaee.toy_music.Utils.CONSTANTS;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddBookServlet", value = "/add-book")
public class AddBookServlet extends HttpServlet {


  /**
   * get will redirect to new html
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String log = (String) session.getAttribute("admin");
    // judge if has login or not
    if (log != null && log.equals("log")) {
      request.getRequestDispatcher("add-book.html").forward(request, response);
    } else {
      response.sendRedirect("admin-login.html");
      return;
    }
  }

  /**
   * post is will real add a book
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String title = request.getParameter("title").trim();
    String author = request.getParameter("author").trim();
    String image = request.getParameter("image").trim();
    String description = request.getParameter("description").trim();

    String today = new SimpleDateFormat(CONSTANTS.DATE_FORMAT).format(new Date());
    BookUtils.addBook(id, title, author, image, description, today);
    System.out.println("add a song");
    // Hint: what if error when adding?
    response.sendRedirect("add-success.html");
    return;
  }
}
