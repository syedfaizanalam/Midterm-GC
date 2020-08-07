import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;

public class Club {

	String memberName;
	String address;
	
	public Club() {
		super();
	}
	
	public Club(String memberName, String address) {
		super();
		this.memberName = memberName;
		this.address = address;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
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
	
	

	
	
}
