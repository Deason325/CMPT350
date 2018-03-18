
package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Server
{
    
        public static void server(URL url) throws IOException{
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setInstanceFollowRedirects(true);
            System.out.println(String.valueOf(http.getResponseCode()));
            System.out.println(http.getResponseMessage());
        }
    public static String html="";
        public static void server1(String u){
             ArrayList<String> urls = new ArrayList<String>();
        URL url;
        InputStream is = null;
        DataInputStream dis;
        String line;

        try {
            url = new URL(u);
            is = url.openStream(); 
            dis = new DataInputStream(new BufferedInputStream(is));
            while ((line = dis.readLine()) != null) {
                html = html + "\n" + line;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
            }
            
        }
        System.out.println(html);
        
        }
    
      public static void main(String[] args) throws Exception {
          
          
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        URL url = new URL(st);
        server(url);
        //server1(url);
        
        //http://usask.ca
        
    }
}






		