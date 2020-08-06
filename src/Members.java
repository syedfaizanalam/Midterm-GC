
public class Members {

	
	
	private int memberID;
	private String memberName;
	
	
	
	public int getId() {
		return memberID;
	}

	


	public Members() {
		super();
	}




	public Members(int memberID, String memberName) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
	}



	public void setId(int id) {
		this.memberID = memberID;
	}



	public String getName() {
		return memberName;
	}



	public void setName(String name) {
		this.memberName = memberName;
	}



	public void checkIn(Club club) {
		
		
		
		System.out.println();
	}
	
	
	
	
}
