// client
package client1;

import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client1
{

	public static void main(String[] Args)
	{
            Scanner sc = new Scanner(System.in);
            
            String url = sc.nextLine();
            int num = sc.nextInt();
            
            recur(url,num);
            


	}

        protected static void recur(String url, int num){
             if(num<=0){
                connect(url,num);
            }else{
                connect(url,num);
                num-=1;
                recur(url,num);
            }
        }
	protected static void connect(String URL, int x)
	{
            

		try
		{

			String CRLF = "\r\n";
		
			Socket s = new Socket(URL,x);

			BufferedReader br;
			PrintStream ps;

			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			ps = new PrintStream(s.getOutputStream());


			// send request

			ps.print("GET / HTTP/1.0" +  CRLF);
			ps.print("Accept:text/html" + CRLF);
			ps.print(CRLF + CRLF);
		

			String data = br.readLine();

			while(data != null)
			{

				System.out.println(data);
				data = br.readLine();
			}


		} catch (Exception E) {System.out.println(E); }



	}



} 