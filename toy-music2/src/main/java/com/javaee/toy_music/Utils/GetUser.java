package com.javaee.toy_music.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUser {

    public static Map<String,String> getID() throws IOException {

        String v = "/Users/derekedkwangxingen/Desktop/toy-music2/password.txt";
        List<String> lines = Files.readAllLines(Paths.get(v));
        Map<String, String> m = new HashMap<>();
        lines.forEach(line->{
            String[] name_pwd = line.split(" ");
            m.put(name_pwd[0], name_pwd[1]);
        });

        return m;

    };

}
