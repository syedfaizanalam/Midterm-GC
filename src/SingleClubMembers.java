
public class SingleClubMembers extends Members {
	private String clubName;
	

	public SingleClubMembers() {
		super();
	}


	public SingleClubMembers(int memberID,String memberName,String clubName) {
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
		return "Memeber[MemebrID="+getId()+"Member name="+getName()+"Club Name="+getClubName()+"]";
	}
	
	

}
