import java.io.*;
import java.net.*;
import java.util.Scanner;

public class smtp {

    public static void main(String argv[]) {
		
		try {
		  
		Scanner reader = new Scanner(System.in);
		byte[] buf = new byte[1024];
		Socket socket = new Socket("mail-r.hw.ac.uk", 25);
		OutputStream output = socket.getOutputStream();
		InputStream input = socket.getInputStream();
		String s = "";
		int n = 0;
	
	
		//System.out.println(s);
        output.write(s.getBytes()); // send message
        output.flush();
        n = input.read(buf);
        s = new String(buf, 0, n);
        //System.out.println(s);

		if (!s.substring(0, 3).equals("220")) {
          System.out.println("220 not replied");
          System.exit(0);
        }

        s = "HELO hw.ac.uk\r\n";
       
        //System.out.println(s);
        output.write(s.getBytes()); // send message
        output.flush();
        n = input.read(buf);
        s = new String(buf, 0, n);
       // System.out.println(s);

		if (!s.substring(0, 3).equals("250")) {
          System.out.println("250 not replied");
          System.exit(0);
        }
        
        System.out.print("Enter Username: ");
        System.out.flush();
        String user = reader.nextLine();
        s = "MAIL FROM:<" + user + "@hw.ac.uk>\r\n";
        
        //System.out.println(s);
        output.write(s.getBytes()); // send message
        output.flush();
        n = input.read(buf);
        s = new String(buf, 0, n);
        //System.out.println(s);

		if (!s.substring(0, 3).equals("250")) {
          System.out.println("250 not replied");
          System.exit(0);
        }
        
        System.out.print("Enter Recipient Email Address: ");
        System.out.flush();
        String rec = reader.nextLine();
        s = "RCPT TO:<" + rec + ">\r\n";

		//System.out.println(s);
        output.write(s.getBytes()); // send message
        output.flush();
        n = input.read(buf);
        s = new String(buf, 0, n);
        //System.out.println(s);

		if (!s.substring(0, 3).equals("250")) {
          System.out.println("250 not replied");
          System.exit(0);
        }
        s = "DATA\r\n";

		//System.out.println(s);
        output.write(s.getBytes()); // send message
        output.flush();
        n = input.read(buf);
        s = new String(buf, 0, n);
        //System.out.println(s);

		if (!s.substring(0, 3).equals("354")) {
          System.out.println("354 not replied");
          System.exit(0);
        }
        
        System.out.print("Enter Subject: ");
        System.out.flush();
        String subject = reader.nextLine();
        
        System.out.print("Enter Message: ");
        System.out.flush();
        String message = reader.next();
        s = "Subject: " + subject + "\nFrom: " + user + "@hw.ac.uk\n" + message + "\n.\n";
        
        //System.out.println(s);
        output.write(s.getBytes()); // send message
        output.flush();
        n = input.read(buf);
        s = new String(buf, 0, n);
        //System.out.println(s);
        
        if (!s.substring(0, 3).equals("250")) {
          System.out.println("250 not replied");
          System.exit(0);
        }
        
        s = "QUIT\r\n";
        //System.out.println(s);
        output.write(s.getBytes()); // send message
        output.flush();
        n = input.read(buf);
        s = new String(buf, 0, n);
       // System.out.println(s);

		if (!s.substring(0, 3).equals("221")) {
          System.out.println("221 not replied");
          System.exit(0);
        }
        System.out.print("Message sent. \r\n");

      } catch (IOException e) { System.err.println(e.getMessage()); }
	}
}
