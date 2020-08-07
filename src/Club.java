<<<<<<< HEAD
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
=======

>>>>>>> ad9a339d00c157fabf2fbff508c75c97eca83ed5

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
		return "Club [memberName=" + memberName + ", address=" + address + "]";
	} 
	
	public List<String> addMember(List<String> string) {
		List<String> newMember = new ArrayList<>();;
		for(String thisMember : string) {
			newMember.add(thisMember);
		}
		return newMember;
	}

	public List<Integer> addID(List<Integer> id) {
		List<Integer> newID = new ArrayList<>();;
		for(int thisID : id) {
			newID.add(thisID);
		}
		return newID;
	}
=======

		return "Club [memberName=" + clubName + ", address=" + address + "]";
	} 
>>>>>>> ad9a339d00c157fabf2fbff508c75c97eca83ed5
	
	

	

	
}
