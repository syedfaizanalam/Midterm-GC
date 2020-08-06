
public class MultiClubMembers extends Members {

	private int points;
	

	public MultiClubMembers() {
		super();
	}


	public MultiClubMembers(int memberID,String memberName,int points) {
		super(memberID,memberName);
		this.points = points;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}
	public String toString() {
		return "Memeber[MemebrID="+getId()+"Memebr name="+getName()+"Points="+points+"]";
	}
	
	
}
