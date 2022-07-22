package Week2;
/*
Write a program that reads the lines from the file at this URL location, http://www.dukelearntoprogram.com/course2/data/manylinks.html,
and prints each URL on the page that is a link to youtube.com. Assume that a link to youtube.com has no spaces in it and would be in the
format (where [stuff] represents characters that are not verbatim): “http:[stuff]youtube.com[stuff]”
 */

import java.io.*;
import java.net.*;

public class FindWebLinks {
    public static void main(String[] args) throws IOException {
        URL webpage = new URL("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(webpage.openStream()));
        String youtube = "youtube.com";
        String inputLine;
        String youtube_link;



        while ((inputLine = in.readLine()) != null) {
            // System.out.println(inputLine);
            int youtube_index = inputLine.toLowerCase().indexOf(youtube);
            // System.out.println(youtube_index);
            if (youtube_index != -1) {
                int suffix_index = inputLine.indexOf("\"", youtube_index+1);
                int prefix_index = inputLine.lastIndexOf("\"", youtube_index);

                youtube_link = inputLine.substring(prefix_index+1, suffix_index);
                System.out.println(youtube_link);
            }
        }
        in.close();
    }
}
        /*
        URL webpage = null;
        URLConnection conn = null;
        webpage = new URL("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        try {
            conn = webpage.openConnection();
            InputStreamReader reader = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = "";
            while(true) {
                line = buffer.readLine();
                if (line!= null) {
                    System.out.println(line);
                }
                else {
                    break;
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);

        }
         */