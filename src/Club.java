import java.lang.Iterable;

public class Club {

	String clubName;
	String address;
	
	public Club() {
		super();
	}

	public Club(String clubName, String address) {
		super();
		this.clubName = clubName;
		this.address = address;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Club [clubName=" + clubName + ", address=" + address + "]";
	}
=======
		return "Club [memberName=" + memberName + ", address=" + address + "]";
	} 
	
	public String addMember(String[] string) {
		String newMember = null;
		for(String thisMember : string) {
			newMember += thisMember;
		}
		return newMember;
	}

	
>>>>>>> 46c3c36d85c6192e98b1586bebe11b2a680aef61
	

	
}
