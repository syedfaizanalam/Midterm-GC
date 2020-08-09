import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClubDemo {
	private static Path filePath = Paths.get("members.txt");
	private static Path filePath2 = Paths.get("clubnames.txt");
	private static List<Members> members = new ArrayList<>();
	public static void main(String[] args) {
		String name,clubName,userName;
		SingleClubMembers scm=null;
		MultiClubMembers mcm=null;
		int id,points;
		boolean yesNo;
		System.out.println("Welcome to fitness center!");
		Scanner scnr=new Scanner(System.in);
		while (true) {
			System.out.println("1-See the list of members");
			System.out.println("2-Add a member");
			System.out.println("3-Remove a member");
			System.out.println("4-Display member information");
			System.out.println("5.Check-in");
			System.out.println("6-Exit");
			System.out.println();
			System.out.println("Enter menu number: ");
			int userInput = scnr.nextInt();
			if(userInput==1) {
				listMembers();
			}
			else if (userInput == 2) {
				System.out.println("Enter id: ");
				id=scnr.nextInt();
				scnr.nextLine();
				System.out.println("Enter name: ");
				name=scnr.nextLine();
				yesNo=Validator.getYesNo(scnr,"Is single club member?(y/n): ");
				if(yesNo) {
					System.out.println("Enter club name: ");
					clubName=scnr.nextLine();
					scm=new SingleClubMembers();
					members.add(scm);
					appendLineToFile(scm);
				}else {
					System.out.println("Enter the points: ");
					points=scnr.nextInt();
					mcm=new MultiClubMembers(id,name,points);
					members.add(mcm);
					appendLineToFile(mcm);
					
				}
			} else if (userInput == 3) {
				listMembers();
				scnr.nextLine();
				System.out.println("Please tell your name for removing your membership from club: ");
				String choice = scnr.nextLine();
				boolean got = false;
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getName().equalsIgnoreCase(choice)) {
						System.out.println("Member " + members.get(i).getName() + " deleted.\n");
						members.remove(i);
						writeToFile(members);
						got = true;
					}
				}
				if (!got) {
					System.out.println("This member is not in the list! Try again.\n");
				}
			}
			else if (userInput == 4) {
				scnr.nextLine();
				System.out.println("Your name please!");
				userName=scnr.nextLine();
				boolean boo=false;
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getName().equalsIgnoreCase(userName)) {
						
						if (members.get(i) instanceof SingleClubMembers)
						{
							System.out.printf("%-15d%-15s%-20s\n",members.get(i).getId(),
							           members.get(i).getName(),
									           ((SingleClubMembers)members.get(i)).getClubName());
												boo=true;
												System.out.println(userName+" is removed\n");
						}
						else
						{
							System.out.printf("%-15d%-15s%-20s%-15d\n",members.get(i).getId(),
							           members.get(i).getName()," ",
							           ((MultiClubMembers)members.get(i)).getPoints());	
										boo=true;
										System.out.println(userName+" is removed\n");
						}
				
					}
			}
				if(!boo) {
					System.out.println("The member is not in the list! Try again.");
				}
				
			}
			else if(userInput==5) {
				Club club=new Club();
				//filePath2;
				boolean yesOrNo,clubChoice;
				String singleClubName;
				yesOrNo=Validator.getYesNo(scnr, "Do you want to check-in?(y/n)");
				if(yesOrNo) {
					clubChoice=Validator.getYesNo(scnr,"Is single club member?(y/n): ");
					if(clubChoice) {
						System.out.println("Your club name: ");
						singleClubName=scnr.nextLine();						
						Members mmbrs = null;
						mmbrs.checkIn() ;
					}
					
				}
				
			}
			else {
				break;
			}
		}
			
			

			}			
			 

	
	public static List<Members> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
			List<Members> members = new ArrayList<>();
			boolean mcm=false;
			for (String line : lines) {
				String[] parts = line.split(",");
				try {
					if (Integer.parseInt(parts[2]) >= 0) {
						mcm=true;
					}
				}catch (Exception e) {
					mcm = false;
				}
				if(mcm) {
					int memberId = Integer.parseInt(parts[0]);
					String memberName = parts[1];
					int points =Integer.parseInt(parts[2]);
					members.add(new MultiClubMembers(memberId, memberName, points));
				}else {
					int memberId = Integer.parseInt(parts[0]);
					String memberName = parts[1];
					String clubName = parts[2];
			//		members.add(new SingleClubMembers(memberId, memberName));
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
		
		System.out.printf("%-15s%-15s%-20s%-15s\n", "Member Id", "Name", "Club Name", "Points");
		System.out.printf("%-15s%-15s%-20s%-15s\n", "=========", "====", "=========","======");
		
		for (int i=0;i<members.size();i++){
			
			if (members.get(i) instanceof SingleClubMembers)
			{
				System.out.printf("%-15d%-15s%-20s\n",members.get(i).getId(),
				           members.get(i).getName(),
						           ((SingleClubMembers)members.get(i)).getClubName());
			}
			else
			{
				System.out.printf("%-15d%-15s%-20s%-15d\n",members.get(i).getId(),
				           members.get(i).getName()," ",
				           ((MultiClubMembers)members.get(i)).getPoints());	
			}
		} System.out.println();
			

		}
	public static void appendLineToFile(SingleClubMembers thing) {
		
		// String line = thing.getCountryName() + "," + thing.getPopulation() ;
		String line = String.format("%d,%s,%s", thing.getId(), thing.getName(), thing.getClubName());
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}
	}public static void appendLineToFile(MultiClubMembers thing) {
		
		// String line = thing.getCountryName() + "," + thing.getPopulation() ;
		String line = String.format("%d,%s,%d", thing.getId(), thing.getName(), thing.getPoints());
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}
	}
	public static void writeToFile(List<Members> members) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("members.txt"));
			for(int i=0;i<members.size();i++) {
				if (members.get(i) instanceof SingleClubMembers) {
				bw.write(members.get(i).getId() + "," + members.get(i).getName()+","+((SingleClubMembers)members.get(i)).getClubName());
				bw.newLine();
				} else {
						bw.write(members.get(i).getId() + "," + members.get(i).getName()+","+((MultiClubMembers)members.get(i)).getPoints());
						bw.newLine();
				}

				
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

