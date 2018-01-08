package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author chamith
 */
public class ReadDataTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadDataTest.class);

    public static void main(String[] args) throws IOException {
        method3();

    }

    private static void method1() {
        try {
            // Make a URL to the web page
            URL url = new URL("http://www.nlb.lk/results-more.php?id=2");

            // Get the input stream through URL Connection
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();

            // Once you have the Input Stream, it's just plain old Java IO stuff.

            // For this case, since you are interested in getting plain-text web page
            // I'll use a reader and output the text content to System.out.

            // For binary content, it's better to directly read the bytes from stream and write
            // to the target file.


            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;

            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    private static void method2() {
        String generate_URL = "http://www.nlb.lk/results-more.php?id=2";
        String inputLine;
        try {
            URL data = new URL(generate_URL);
            /**
             * Proxy code start
             * If you are working behind firewall uncomment below lines.
             * Set your proxy server
             */

            /* Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.0.202", 8080)); */
            /* HttpURLConnection con = (HttpURLConnection) data.openConnection(proxy); */

            /* Proxy code end */

            /* Open connection */
            /* comment below line in case of Proxy */
            HttpURLConnection con = (HttpURLConnection) data.openConnection();
            /* Read webpage coontent */
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            /* Read line by line */
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            /* close BufferedReader */
            in.close();
            /* close HttpURLConnection */
            con.disconnect();
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    private static void method3() {
        try {
            Document doc = Jsoup.connect("http://www.nlb.lk/results-more.php?id=2").get();
            Elements titles = doc.select(".lottery-numbers");

            //print all titles in main page
            for (Element e : titles) {
                System.out.println("text: " + e.text());
            }


        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
}
