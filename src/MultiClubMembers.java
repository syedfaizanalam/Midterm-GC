
public class MultiClubMembers extends Memebrs {

	private int points;
	

	public MultiClubMembers() {
		super();
	}


	public MultiClubMembers(String memberID,String memberName,int points) {
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
		return "Memeber[MemebrID="+getMemebrID()+"Memebr name="+getMemberName()+"Points="+points+"]";
	}
	
	
}
