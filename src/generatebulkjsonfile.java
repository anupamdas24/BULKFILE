
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class generatebulkjsonfile {
	
//	static Scanner sc=new Scanner(System.in);
//	
//	static int size=sc.nextInt();
//	static String sizeFormat=sc.nextLine();
//	final static long sizeinBytes = 524288000;
	final static long sizeinBytes=2048;

	public static void main(String args[]) throws IOException {
		JSONObject ob = new JSONObject();
		ob.put("name", "dap");
		ob.put("sprint#", "30_New");
		JSONArray list = new JSONArray();
		list.add("name1");
		list.add("name2");
		ob.put("messages", list);
		// find out the difference between FileWriter and BufferedWriter
		File f = new File(System.getProperty("user.dir") + File.separator + "FilePlace.json");
//		switch(sizeFormat){
//		
//		case "MB" : sizeinBytes=1024*1024*size; 
//		case "KB" : sizeinBytes=1024*size; 
//		case "GB" : sizeinBytes=1024*1024*1024*size; 
//		
//		}
		try (BufferedWriter wr = Files.newBufferedWriter(f.toPath())) {
			while (f.length() < sizeinBytes) {
				wr.write(ob.toJSONString());
				wr.flush();
			}
			System.out.println("2 MB data written");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
