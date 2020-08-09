import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClubDemo {
	private static Path filePath = Paths.get("members.txt");
	private static Path filePath2 = Paths.get("clubnames.txt");
	private static List<Members> members = new ArrayList<>();
	private static List<Club> clubs = new ArrayList<>();

	public static void main(String[] args) {
		String name, clubName, userName;
		SingleClubMembers scm = null;
		MultiClubMembers mcm = null;
		int id, points;
		boolean yesNo;
		System.out.println("Welcome to fitness center!");
		Scanner scnr = new Scanner(System.in);
		while (true) {
			System.out.println("1-See the list of members");
			System.out.println("2-Add a member");
			System.out.println("3-Remove a member");
			System.out.println("4-Display member information");
			System.out.println("5.Check-in");
			System.out.println("6-Generate Fees");
			System.out.println("7-Exit");
			System.out.println();
			System.out.println("Enter menu number: ");
			int userInput = scnr.nextInt();
			if (userInput == 1) {
				listMembers();
			} else if (userInput == 2) {
				System.out.println("Enter id: ");
				id = scnr.nextInt();
				scnr.nextLine();
				System.out.println("Enter name: ");
				name = scnr.nextLine();
				yesNo = Validator.getYesNo(scnr, "Is single club member?(y/n): ");
				if (yesNo) {
					clubs = readClubs();
					while (true) {
						System.out.println("Available Clubs:");
						System.out.printf("%-25s%-35s\n", "Club Name", "Address");
						System.out.printf("%-25s%-35s\n", "=========", "=======");

						for (Club club : clubs) {
							System.out.printf("%-25s%-35s\n", club.getClubName(), club.getAddress());
						}
						System.out.println("Choose a club name: ");
						clubName = scnr.nextLine();
						boolean clubValid = false;
						for (Club club : clubs) {
							if (club.getClubName().equalsIgnoreCase(clubName)) {
								clubValid = true;
								break;
							}
						}
						if (!clubValid) {
							System.out.println("Invalid Club Name.. Try again!");
						} else {
							scm = new SingleClubMembers(id, name, clubName);
							members.add(scm);
							appendLineToFile(scm);
							System.out.println("New member " + name + " added.\n");
							break;
						}
					} // while
				} else {
					System.out.println("Enter the points: ");
					points = scnr.nextInt();
					mcm = new MultiClubMembers(id, name, points);
					members.add(mcm);
					appendLineToFile(mcm);
					System.out.println("New member " + name + " added.\n");
				}
				Date date = java.util.Calendar.getInstance().getTime();
				SimpleDateFormat formatter = new SimpleDateFormat("HH");
				// System.out.println(formatter.format(date));
				if (formatter.format(date).equalsIgnoreCase("10") || formatter.format(date).equalsIgnoreCase("11")) {
					System.out.println("You have got 10% discount as you are joining between 10AM and Noon.\n");
				}
			} else if (userInput == 3) {
				listMembers();
				scnr.nextLine();
				System.out.println("Please enter the name for removing the membership: ");
				String choice = scnr.nextLine();
				boolean got = false;
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getName().equalsIgnoreCase(choice)) {
						System.out.println("Member " + members.get(i).getName() + " removed.\n");
						members.remove(i);
						writeToFile(members);
						got = true;
					}
				}
				if (!got) {
					System.out.println("This member is not in the list! Try again.\n");
				}
			} else if (userInput == 4) {
				scnr.nextLine();
				System.out.println("Enter the name please!");
				userName = scnr.nextLine();
				boolean boo = false;
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getName().equalsIgnoreCase(userName)) {

						if (members.get(i) instanceof SingleClubMembers) {
							System.out.printf("%-15d%-15s%-20s\n", members.get(i).getId(), members.get(i).getName(),
									((SingleClubMembers) members.get(i)).getClubName());
							boo = true;
						} else {
							System.out.printf("%-15d%-15s%-20s%-15d\n", members.get(i).getId(),
									members.get(i).getName(), " ", ((MultiClubMembers) members.get(i)).getPoints());
							boo = true;
						}
					}
				}
				if (!boo) {
					System.out.println("The member is not in the list! Try again.");
				}

			} else if (userInput == 5) {
				int id1;
				System.out.println("Enter your ID: ");
				id1 = scnr.nextInt();
				scnr.nextLine();
				//members = readFile();
				clubs = readClubs();
				boolean clubFound = false;
				for (int i = 0; i < members.size(); i++) {
					if ((members.get(i)).getId() == id1) {
						name = (members.get(i)).getName();
						if ((members.get(i)) instanceof SingleClubMembers) {
							System.out.println("Enter club name: ");
							String inputClubName = scnr.nextLine();
							for (int j = 0; j < clubs.size(); j++) {
								if ((clubs.get(j)).getClubName().equalsIgnoreCase(inputClubName)) {
									clubFound = true;
									try {
										members.get(i).checkIn(clubs.get(j));
									} catch (InputMismatchException e) {
										System.out.println("Check-in failed.");
									}
									break;
								}
							}
							if (!clubFound) {
								System.out.println("Invalid Club Name");
							}
						} else {
							members.get(i).checkIn(clubs.get(0));
							writeToFile(members);
						}
						break;
					}
				}
			} else if (userInput == 6) {
				int id2;
				System.out.println("Enter the ID: ");
				id2 = scnr.nextInt();
				scnr.nextLine();
				members = readFile();

				for (int i = 0; i < members.size(); i++) {
					if ((members.get(i)).getId() == id2) {
						name = (members.get(i)).getName();
						System.out.println("ID: " + id2);
						System.out.println("Name: " + name);
						System.out.println("Monthly Membership Fees: $10");
						if ((members.get(i)) instanceof MultiClubMembers) {
							System.out.println("Membership Points: " + ((MultiClubMembers) members.get(i)).getPoints());
						}
						System.out.println();
					}
				}
			} else if (userInput == 7) {
				System.out.println("Thanks for using this application.");
				break;
			} else {
				System.out.println("Invalid Option.. try again!");
			}
		}
	}

	public static List<Members> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
			List<Members> members = new ArrayList<>();
			boolean mcm = false;
			for (String line : lines) {
				String[] parts = line.split(",");
				try {
					if (Integer.parseInt(parts[2]) >= 0) {
						mcm = true;
					}
				} catch (Exception e) {
					mcm = false;
				}
				if (mcm) {
					int memberId = Integer.parseInt(parts[0]);
					String memberName = parts[1];
					int points = Integer.parseInt(parts[2]);
					members.add(new MultiClubMembers(memberId, memberName, points));
				} else {
					int memberId = Integer.parseInt(parts[0]);
					String memberName = parts[1];
					String clubName = parts[2];
					members.add(new SingleClubMembers(memberId, memberName, clubName));
				}
			}
			return members;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
	}

	public static List<Club> readClubs() {
		try {
			List<String> lines = Files.readAllLines(filePath2);
			Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
			List<Club> clubs = new ArrayList<>();
			Club club;
			for (String line : lines) {
				String[] parts = line.split(",");
				club = new Club(parts[0], parts[1]);
				clubs.add(club);
			}
			return clubs;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
	}

	public static void listMembers() {
		members = readFile();

		System.out.printf("%-15s%-15s%-20s%-15s\n", "Member Id", "Name", "Club Name", "Points");
		System.out.printf("%-15s%-15s%-20s%-15s\n", "=========", "====", "=========", "======");

		for (int i = 0; i < members.size(); i++) {

			if (members.get(i) instanceof SingleClubMembers) {
				System.out.printf("%-15d%-15s%-20s\n", members.get(i).getId(), members.get(i).getName(),
						((SingleClubMembers) members.get(i)).getClubName());
			} else {
				System.out.printf("%-15d%-15s%-20s%-15d\n", members.get(i).getId(), members.get(i).getName(), " ",
						((MultiClubMembers) members.get(i)).getPoints());
			}
		}
		System.out.println();

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
	}

	public static void appendLineToFile(MultiClubMembers thing) {

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
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i) instanceof SingleClubMembers) {
					bw.write(members.get(i).getId() + "," + members.get(i).getName() + ","
							+ ((SingleClubMembers) members.get(i)).getClubName());
					bw.newLine();
				} else {
					bw.write(members.get(i).getId() + "," + members.get(i).getName() + ","
							+ ((MultiClubMembers) members.get(i)).getPoints());
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