import java.util.InputMismatchException;

public  class SingleClubMembers extends Members {
	private String clubName;
	
	public SingleClubMembers() {
		super();
	}

	public SingleClubMembers(int memberID, String memberName, String clubName) {
		super(memberID, memberName);
		this.clubName = clubName;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String toString() {
		return "Memeber[MemebrID=" + getId() + "Member name=" + getName() + "Club Name=" + getClubName() + "]";
	}
	public void checkIn(Club club)   {
			if(club.clubName.equalsIgnoreCase(this.getClubName())){
				System.out.println("Check-in ok.\n");	
		} else {
			throw new InputMismatchException();
		}
	}

}
