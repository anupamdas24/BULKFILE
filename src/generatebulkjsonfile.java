
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class generatebulkjsonfile {
	
	public static long getSize(){
		
		System.out.println("Please enter the size in numerics");
		Scanner snum=new Scanner(System.in);
		int num=snum.nextInt();
		System.out.println("Please enter the format of Size in B, KB , MB or GB");
		Scanner stype=new Scanner(System.in);
		long sizeinBytes = 0 ;
		switch(stype.nextLine()){
		case "GB" : sizeinBytes=num*1024*1024*1024 ; break;
		case "MB" : sizeinBytes=num*1024*1024 ;break;
		case "KB" : sizeinBytes= num*1024; break;
		default :
			sizeinBytes=sizeinBytes;
		
		}
		return sizeinBytes;
		
	}

	public static void main(String args[]) throws IOException {
		
		long ressizeinBytes=getSize();
		System.out.println(ressizeinBytes);
		JSONObject ob = new JSONObject();
		ob.put("name", "dap");
		ob.put("sprint#", "30_New");
		JSONArray list = new JSONArray();
		list.add("name1");
		list.add("name2");
		ob.put("messages", list);
		File f = new File(System.getProperty("user.dir") + File.separator + "FilePlace.json");
		try (BufferedWriter wr = Files.newBufferedWriter(f.toPath())) {
			while (f.length() < ressizeinBytes) {
				wr.write(ob.toJSONString());
				wr.flush();
			}
			System.out.println("2 MB data written");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
