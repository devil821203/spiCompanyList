package spider;

public class ContactInfo {

	private String phone=null;
	  private String add=null;
	  private String name=null;
	  public ContactInfo() {
	        this("�L�q��", "�L�a�}","�L���q�W");
	    }
	  public ContactInfo(String phone, String add ,String name ) {
			// TODO Auto-generated constructor stub
		  
		  this.phone=phone;
		  this.add=add;
		  this.name=name;
		}
	public String getPhone() {
		return phone;
	}
	public String getAdd() {
		return add;
	}
	public String getName() {
		return name;
	}
	
}
