
public class MultiClubMembers extends Members {

	private int points;
	

	public MultiClubMembers() {
		super();
	}


	public MultiClubMembers(int memberID,String memberName,int points) {
		super(memberID,memberName);
		this.points = points;
		points+=5;
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

	public void checkIn(Club club)   {
		System.out.println("Check-in Ok. Points updated.\n");
		this.points+=5;
	}
}

