package com.javaee.toy_music;

import static com.javaee.toy_music.Utils.CONSTANTS.BOOK_FILE;

import com.javaee.toy_music.Utils.BookUtils;
import com.javaee.toy_music.Utils.CONSTANTS;
import com.javaee.toy_music.model.Book;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DelBookServlet", value = "/del-book")
public class DelBookServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    int id = Integer.parseInt(request.getParameter("id"));
    String log = (String) session.getAttribute("admin");
    if (log != null && log.equals("log")) {
      // 登陆状态分支进入
      List<Book> books = BookUtils.loadBooks();
      // 查询全部book,根据id剔除删除的
      List<Book> collect = books.stream().filter(it -> !Objects.equals(id, it.getId()))
          .collect(Collectors.toList());
      // 清空books文件
      Files.deleteIfExists(Paths.get(BOOK_FILE));
      Files.createFile(Paths.get(BOOK_FILE));
      // 重新将书本数据写入文件
      for (Book book : collect) {
        String date = new SimpleDateFormat(CONSTANTS.DATE_FORMAT).format(book.getAddDate());
        BookUtils.addBook(book.getId(),book.getTitle(), book.getAuthor(), book.getImageURL(),
            book.getDescription(),date);
      }
      // 回到admin页面
      response.sendRedirect("admin");
    } else {
      // 如果没登陆 先跳转admin登陆页面
      response.sendRedirect("admin-login.html");
      return;
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }
}
