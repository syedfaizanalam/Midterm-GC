
public abstract class Members {

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

	public void setId(int memberID) {
		this.memberID = memberID;
	}

	public String getName() {
		return memberName;
	}

	public void setName(String memberName) {
		this.memberName = memberName;
	}

	public abstract void checkIn(Club club);
		
}		
		
		
	
	
	
	
