import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class instanceGeneration {
	
	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) {
		
		JSONArray mainarry=new JSONArray();
		JSONObject attrObj = new JSONObject();
				
		System.out.println("Please enter the number of instances, you need to generate");
		Scanner scSize=new Scanner(System.in);
		int instanceSize=scSize.nextInt();
		
		System.out.println("Please enter the Template ID, which will be TAXONOMY ID");
		Scanner scTemplateID=new Scanner(System.in);
		Long templateID=scTemplateID.nextLong();
		
		System.out.println("Please enter the Tenant ID of the Template");
		Scanner scTenant=new Scanner(System.in);
		String tenantID=scTenant.next();
		
		Random rand=new Random();
		for(Integer i=1;i <= instanceSize;i++) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("name", templateID.toString()+"_"+i.toString());
			jsonObj.put("taxonomyId", templateID);
			jsonObj.put("source_key", rand.nextInt()+"_"+i);
			jsonObj.put("hasChildren", false);
			jsonObj.put("owner", tenantID);
			jsonObj.put("type", "instance");
			JSONArray list = new JSONArray();
//			attrObj.put("id" , 2000002154);
//			attrObj.put("value", "PITCH DRIVE MOTOR 600000056");
//			list.add(attrObj);
			jsonObj.put("attributes", list);
			mainarry.add(jsonObj);
		}
		
		System.out.println("Completed!!!");
		
		File f = new File(System.getProperty("user.dir") + File.separator + "FP_Instance.json");
		try (BufferedWriter wr = Files.newBufferedWriter(f.toPath())) {
				wr.write(mainarry.toJSONString());
				wr.flush();
			}
			catch (IOException e) {
			e.printStackTrace();
		}

	}

}
