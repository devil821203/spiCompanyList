package spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class jsoup {

	public static void main(String[] args)  {
		
	
		
		String oriduc="C:\\Users\\user\\Desktop\\亞洲專業建築網資料\\Json-utf-8.txt";
		
		File inputfile=new File(oriduc);
		System.out.println(inputfile);		
		InputStream is = null;
		InputStreamReader isr=null;
		BufferedReader br =null;
		JSONObject js = null;
		JSONObject js2 = null;
		String tempInput="";				
		int i=0;
		try {
			
			is=new FileInputStream(inputfile);
			isr=new InputStreamReader(is,"UTF-8");
			br = new BufferedReader(isr);
			while((i=isr.read())!=-1) {
				tempInput+=(char)i;
				System.out.println(i);
			}			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println("tempInput="+tempInput);
			char[] ch=tempInput.toCharArray();
			
			System.out.println("CH="+ch[0]);
			ch[0]=" ".charAt(0);
			tempInput=String.valueOf(ch);
			tempInput.trim();
			System.out.println(tempInput);
			js=new JSONObject(tempInput);
			js2=js.getJSONObject("1").getString("add");
			System.out.println(js2);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
		
}

	
	
	
	
	
	