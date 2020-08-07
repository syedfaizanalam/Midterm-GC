import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClubDemo {
	private static Path filePath = Paths.get("members.txt");
	//private static Path filePath2 = Paths.get("clubnames.txt");
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
			System.out.println("4-Display member information");
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
			else if(userInput==1) {
				listMembers();
			}			
			} 
	}
	public static List<Members> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
			List<Members> members = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split(",");
				if(line.contains()) {
				int memberId = Integer.parseInt(parts[0]);
				String memberName = parts[1];
				String clubName = parts[2];
				members.add(new SingleClubMembers(memberId, memberName, clubName));
			}else {
				int memberId = Integer.parseInt(parts[0]);
				String memberName = parts[1];
				int points =Integer.parseInt(parts[2]);
				members.add(new MultiClubMembers(memberId, memberName, points));
			}
				
			}

			return members;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
	}
	public static void listMembers() {
		members = readFile();
		System.out.printf("%-15s%-15s%-15s\n", "Member Id", "Name", "Club Name/Points");
		System.out.printf("%-15s%-15s%-15s\n", "=========", "====", "================");
		for (int i=0;i<members.size();i++){
			
			if (members.get(i) instanceof SingleClubMembers)
			{
				System.out.printf("%-15d%-15s%-15s",members.get(i).getId(),
				           members.get(i).getName(),
						           ((SingleClubMembers)members.get(i)).getClubName());
			}
			else
			{
				System.out.printf("%-15d%-15s%-15d",members.get(i).getId(),
				           members.get(i).getName(),
				           ((MultiClubMembers)members.get(i)).getPoints());	
			}
		}
			

		}
		
	
	

}
