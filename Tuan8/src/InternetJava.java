import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//Để đổi tên hàng loạt: chuột phải tại tên biến muốn đổi => Refacter => Rename => Continue
public class InternetJava {
	//Dừng chương trình khi gặp lỗi IOException
	public static void main(String[] args) throws IOException{
		//Lần lượt là tên miền, tài nguyên, cổng
		String host = "www.uow.edu.au";
		String resource = "/student/index.html";
		final int PORTHTML = 80;
		
		//Mở socket phía client
		Socket socket = new Socket(host, PORTHTML);
		//Lấy input stream và output stream
		InputStream inputStream = socket.getInputStream();
		OutputStream outputStream = socket.getOutputStream();
		
		//Wrap (bọc đối tượng) inputSream và outputSream
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		
		out.println("GET " +resource +" HTTP/1.1\r\n" + 
				"Host: " + host + "\r\n\n");
		
		//Xoá bộ đệm
		out.flush();
		
		//Xử lý thông tin nhận về
		//Chừng nào còn dòng tiếp theo
		while(in.hasNextLine()) {
			String input = in.nextLine();
			System.out.println(input);
		}
		
		socket.close();
	}
}
