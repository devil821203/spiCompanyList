package spider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class spiDataFromArchi {

	
	
	public static void spiData() {
	// ���ΨȬw�ؿv��
	String url = "https://www.archi.net.tw/tw/yelpage/company.asp?cate=39";
	String distant;

	Elements contact = null;
	Elements info = null;
	Document d = null;
	ArrayList<ContactInfo> AllMenber = new ArrayList<ContactInfo>();
	int page = 1;
	int all = 0;
	String tel = null;
	String add = null;
	String name=null;
	while(true)	{
		distant = url + "&page=" + page;
		try {
			d = Jsoup.connect(distant).userAgent("Mozilla").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact = d.getElementsByClass("contact");
		info = d.getElementsByClass("info");
		Element e1 = contact.first();
		Element e2 = info.first();
		if (contact.size() <= 0)
			break;
		for (int i = 0; i < contact.size(); i++) {

			e1 = contact.get(i);
			e2 = info.get(i);

			System.out.println("�����q��" + all);
			tel = numonly.takeNumOut(e1.child(0).childNode(0).childNode(1).attr("src"));
			System.out.println(tel);
			add = e1.childNode(0).childNode(1).childNode(1).toString();
			System.out.println(add);
			name = e2.childNode(1).attr("title");
			System.out.println(name);

			AllMenber.add(new ContactInfo(tel, add, name));

			System.out.println("�{�b��" + page + "��");
			System.out.println("�{�b��" + all + "����T");
			all++;
		}
		page++;

	}

	// ��������নJSON
	JSONObject AllMenberForJson = ConverContactInfoToJson(AllMenber);

	System.out.println("�নJSON");
	File folder = new File("C:\\Users\\user\\Desktop\\�Ȭw�M�~�ؿv�����");if(!folder.exists())
	{
		folder.mkdir(); // �إ߸�Ƨ�
	}
	File file = new File("C:\\Users\\user\\Desktop\\�Ȭw�M�~�ؿv�����\\Json.txt");

	try
	{
		System.out.println("�ǳƿ�X");
		PrintWriter printWriter = new PrintWriter(file);
		printWriter.write(AllMenberForJson.toString());
		printWriter.close();
		System.out.println("��X����");
	}catch(	FileNotFoundException e){
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

	
	
	
	public static class numonly {
	
	public static String takeNumOut(String str) {

		str.trim();
		String str2 = "";
		if (str != null && !"".equals(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					str2 = str2 + Character.toString(str.charAt(i));
				}
			}
		}
		return str2;
	}
	
}


	
	public static  JSONObject ConverContactInfoToJson(ArrayList<ContactInfo> allmenber) {
		
		JSONObject js=new JSONObject();
		JSONObject innerjs=new JSONObject();
		
		
		for(int i=0;i<allmenber.size();i++) {
			innerjs=new JSONObject();
			try {
				innerjs.put("tel",allmenber.get(i).getPhone());				
				innerjs.put("add",allmenber.get(i).getAdd());
				innerjs.put("name",allmenber.get(i).getName());
				js.put(String.valueOf(i+1), innerjs);					
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}										
			
		}
		return js;
	}


}
