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
		return "Club [clubName=" + clubName + ", address=" + address + "]";
	}
	

	
}
