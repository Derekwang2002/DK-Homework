package com.javaee.toy_music.Utils;

/**
 * Constants, such as admin email, password.
 *
 * Hint: What about putting them into web.xml as Parameters?
 */
public class CONSTANTS {
    public final static String ADMIN_EMAIL = "admin@book.com";
    public final static String ADMIN_PWD = "123";

    public final static String DATE_FORMAT = "yyyy-MM-dd";
    // for Windows, it can be something like: C:\\User\\yourname\\Desktop\\books.txt
    public final static String BOOK_FILE = "/Users/derekedkwangxingen/Desktop/toy-music2/books.txt";
    // refactor path to constant
    public final static String USER_FILE = "/Users/derekedkwangxingen/Desktop/toy-music2/password.txt";
    public final static int TOP_K = 5;
}
