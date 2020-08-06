
public class SingleClubMembers extends Members {
	private String clubName;
	

	public SingleClubMembers() {
		super();
	}


	public SingleClubMembers(String memberID,String memberName,String clubName) {
		super(memberID,memberName);
		this.clubName = clubName;
	}


	public String getClubName() {
		return clubName;
	}


	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String toString() {
		return "Memeber[MemebrID="+getMemebrID()+"Memebr name="+getMemberName()+"Club Name="+getClubName()+"]";
	}
	
	

}
