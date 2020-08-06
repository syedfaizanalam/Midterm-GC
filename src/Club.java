import java.lang.Iterable;

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
	
//	public String addMember(String string) {
//		String newMember = null;
//		for(String thisMember : string) {
//			newMember += thisMember;
//		}
//		return newMember;
//	}

	
	

	
	
}
