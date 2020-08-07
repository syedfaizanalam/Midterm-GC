import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ClubDemo {
	//private static Path filePath = Paths.get("C:\\Users\\Kavitha\\eclipse-workspace\\lab17\\.settings\\country.txt");
	private static List<Members> members = new ArrayList<>();
	//private static List<Members> list=new ArrayList<>();
	public static void main(String[] args) {
		String name,clubName;
		SingleClubMembers scm=null;
		MultiClubMembers mcm=null;
		int id,points;
		boolean yesNo;
		System.out.println("Welcome to fitness center!");
		Scanner scnr=new Scanner(System.in);
		while (true) {
			System.out.println("1-See the list of members");
			System.out.println("2-Add a member");
			System.out.println("3-Remove a memeber");
			System.out.println("4-Display memebr information");
			System.out.println("5-Exit");
			System.out.println();
			System.out.println("Enter menu number: ");
			int userInput = scnr.nextInt();
			if (userInput == 2) {
				System.out.println("Enter id: ");
				id=scnr.nextInt();
				scnr.nextLine();
				System.out.println("Enter name: ");
				name=scnr.nextLine();
				yesNo=Validator.getYesNo(scnr,"Is single club member?(y/n): ");
				if(yesNo) {
					System.out.println("Enter club name: ");
					clubName=scnr.nextLine();
					scm=new SingleClubMembers(id,name,clubName);
					members.add(scm);
				}else {
					System.out.println("Enter the points: ");
					points=scnr.nextInt();
					mcm=new MultiClubMembers(id,name,points);
					members.add(mcm);
				}
			}
			else if (userInput == 4) {
				for (int i=0;i<members.size();i++){
					
					if (members.get(i) instanceof SingleClubMembers)
					{
						System.out.println(members.get(i).getId()+
						           members.get(i).getName()+
								           ((SingleClubMembers)members.get(i)).getClubName());
					}
					else
					{
						System.out.println(members.get(i).getId()+
						           members.get(i).getName()+
						           ((MultiClubMembers)members.get(i)).getPoints());	
					}
				}
			}
			
			} 
	}
	

}
