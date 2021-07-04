package com.javaee.toy_music.Utils;

import static com.javaee.toy_music.Utils.CONSTANTS.USER_FILE;
import static java.nio.file.StandardOpenOption.APPEND;

import com.javaee.toy_music.model.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookUtils {

  /**
   * Load a list of Book from file.
   */
  public static List<Book> loadBooks() {
    List<Book> books = new ArrayList<>();
    try (Stream<String> stream = Files.lines(Paths.get(CONSTANTS.BOOK_FILE))) {
      books = stream.filter(it -> !it.equalsIgnoreCase(""))
          .map(line -> {
            String[] items = line.split("\\|");
            int id = Integer.parseInt(items[0]);
            String singer = items[1];
            String image = items[3];
            String title = items[2];
            Date date = new Date();
            try {
              date = new SimpleDateFormat(CONSTANTS.DATE_FORMAT).parse(items[4]);
            } catch (ParseException e) {
              e.printStackTrace();
            }
            String description = items[5];
            return new Book(id, title, image, date, singer, description);
          }).collect(Collectors.toList());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return books;
  }

  /**
   * Hint: any better way to obtain recent k songs
   */
  public static List<Book> recentBooks() {
    List<Book> books = BookUtils.loadBooks();
    Collections.sort(books, (song, t1) -> {
      if (song.getAddDate() == null || t1.getAddDate() == null) {
        return 0;
      }
      return t1.getAddDate().compareTo(song.getAddDate());
    });
    List<Book> recentBooks = new ArrayList<>();
    for (int i = 0; i < CONSTANTS.TOP_K; i++) {
      recentBooks.add(books.get(i));
    }
    return recentBooks;
  }

  /**
   * add a song by append file Hint: what about inserting into database? Hint: this method takes too
   * many arguments, so it is error-prone. Any good method to solve it?
   */
  public static boolean addBook(int id, String title, String author, String image,
      String description,String date) {
    List<String> data = Arrays.asList(String.valueOf(id), author, title, image, date, description);
    String song = System.lineSeparator() + String.join("|", data);
    try {
      Files.write(Paths.get(CONSTANTS.BOOK_FILE),
          song.getBytes(), APPEND);
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean signup(String name, String password) {
    List<String> data = Arrays.asList(name, password);
    String infor = System.lineSeparator() + String.join(" ", data);
    try {
      Files.write(Paths.get(USER_FILE), infor.getBytes(), APPEND);
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }

  }

  /**
   * Hint: any good way to get a song quickly when reading from file
   */
  public static Book getBookByID(int id) {
    List<Book> books = BookUtils.loadBooks();
    List<Book> results = books.stream().filter(s -> s.getId() == id).collect(Collectors.toList());
    if (results.size() == 0) {
      return null;
    } else {
      return results.get(0);
    }
  }

}
