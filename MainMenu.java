import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MainMenu {
   private ArrayList<String> questions;

   public MainMenu() {
      questions = new ArrayList<String>();
      //questions.add(
   }

   public void run() {
      displayWelcomeMessage();

      Scanner scanner = new Scanner(System.in);
      int input = -1;

      while (input != 3) {
         displayOptions();
         System.out.print("\tYour choice: ");
         input = scanner.nextInt();

         while (input != 1 && input != 2 && input != 3) {
            System.out.println("\n\tPlease enter 1, 2, or 3.");
            System.out.print("\tYour choice: ");
            input = scanner.nextInt();
         }
         //Check input for validity
         if (input == 1) {
            compareTwoPeople();
         }
         else if (input == 2) {
            comparePersonToDatabase();
         }
         else {
            System.out.println("\nThanks for using our program!");
            return;
         }
      }
   }

   public void compareTwoPeople() {
      System.out.println("\n\n\tFirst, would you like to enter a new person or pull someone's data from the databse?");
      System.out.println("\n\tEnter \'1\' if you would like to enter a new person's infomation,");
      System.out.println("\tEnter \'2\' if you would like to pull someone's infomation from the database.");
      System.out.println("\tEnter \'3\' if you would like to exit and return to the menu.");
      System.out.print("\tYour choice: ");
      Scanner scanner = new Scanner(System.in);
      int input = scanner.nextInt(); //Remeber check for valid input!

      while (input != 1 && input != 2 && input != 3) {
         System.out.println("\nPlease enter 1, 2, or 3.");
         System.out.print("\tYour choice: ");
         input = scanner.nextInt();
      }

      Person person1 = null;

      if (input == 1) {
         person1 = getPersonFromUser();
      }
      else if (input == 2) {
         person1 = getPersonFromDatabase();
      }
      else {
         return;
      }

      System.out.println("\n\tWhere would you like to get the second person's information from?");
      System.out.println("\n\tEnter \'1\' if you would like to enter a new person's infomation,");
      System.out.println("\tEnter \'2\' if you would like to pull someone's infomation from the database.");
      System.out.println("\tEnter \'3\' if you would like to exit and return to the menu.");
      System.out.print("\tYour choice: ");
      input = scanner.nextInt(); //Remeber check for valid input!

      while (input != 1 && input != 2 && input != 3) {
         System.out.println("\n\tPlease enter 1, 2, or 3.");
         System.out.println("\tYour choice: ");
         input = scanner.nextInt();
      }

      Person person2 = null;

      if (input == 1) {
         person2 = getPersonFromUser();
      }
      else if (input == 2) {
         person2 = getPersonFromDatabase();
      }
      else {
         return;
      }
      //Check to make sure not the same gender!!!
      displayScore(new Score(person1, person2));
   }

   public Person getPersonFromDatabase() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("\n\tPlease enter their name now: ");//Check for valid input
      String name = scanner.nextLine();
      Person person = null;

      List<Person> people = Database.getPeople();

      for (Person prsn : people) {
         if (prsn.getName().equalsIgnoreCase(name)) {
            person = prsn;
            break;
         }
      }

      if (person == null) {
         System.out.println("\tSorry, it seems we don't have that person's info stored already!");
         System.out.println("\tWhy don't you enter their info.");//Try again or enter their info?? Or maybe exit.
         person = getPersonFromUser();
      }

      return person;

   }

   public Person getPersonFromUser() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("\tEnter your name: ");
      String name = scanner.nextLine();
      System.out.println("\tTell us your college.");
      System.out.println("\tPlease enter 1 for COSAM, 2 for CENG, 3 for CAED, 4 for CAFES, 5 for Orfalea College of Business, and 6 for CLA.");
      System.out.print("\tEnter your college: ");
      String stringCollege = scanner.nextLine();

      while (!stringCollege.equals("1") && !stringCollege.equals("2") && !stringCollege.equals("3") && !stringCollege.equals("4") && !stringCollege.equals("5") && !stringCollege.equals("6")) {
         System.out.println("\tPlease enter a valid number between 1 and 6.");
         System.out.print("\tEnter your college: ");
         stringCollege = scanner.nextLine();
      }

      int college = Integer.parseInt(stringCollege);

      if (college == 1) {
         stringCollege = "COSAM";
      } else if (college == 2) {
         stringCollege = "CENG";
      } else if (college == 3) {
         stringCollege = "CAED";
      } else if (college == 4) {
         stringCollege = "CAFES";
      } else if (college == 5) {
         stringCollege = "Orfalea College of Business";
      } else if (college == 6) {
         stringCollege = "CLA";
      }

      System.out.println("\tTell us your gender.");
      System.out.println("\tPlease enter 0 for female, 1 for male.");
      System.out.print("\tEnter your gender: ");
      String stringGender = scanner.nextLine();

      while (!stringGender.equals("0") && !stringGender.equals("1")) {
         System.out.println("\n\tPlease enter 0 for female, 1 for male: ");
         stringGender = scanner.nextLine();
      }

      int gender = Integer.parseInt(stringGender);

      if (gender == 0) {
         stringGender = "Female";
      }
      else {
         stringGender = "Male";
      }

      Person person = new Person(name, stringCollege, stringGender);
      Database.addToDatabase(person);

      return person;
   }

   public Attribute askAboutAttribute(String name) {
      Scanner scanner = new Scanner(System.in);

      for (int i = 0; i < questions.size(); i++) {
         System.out.println(questions.get(i));
         String value = scanner.nextLine();

         while (!value.equals("1") && !value.equals("2") && !value.equals("3") &&
                !value.equals("4") && !value.equals("5") && !value.equals("6") &&
                !value.equals("7") && !value.equals("8") && !value.equals("9") &&
                !value.equals("10"))
         {
            System.out.println("Please enter a valid value between 1 and 10");
            System.out.print("Value: ");
            value = scanner.nextLine();
         }
      }

      return null;
   }

   public void comparePersonToDatabase() {
      System.out.println("\n\n\tFirst, would you like to enter a new person or pull someone's data from the databse?");
      System.out.println("\n\tEnter \'1\' if you would like to enter a new person's infomation,");
      System.out.println("\tEnter \'2\' if you would like to pull someone's infomation from the database.");
      System.out.println("\tEnter \'3\' if you would like to exit and return to the menu.");
      System.out.print("\tYour choice: ");
      Scanner scanner = new Scanner(System.in);
      int input = scanner.nextInt(); //Remeber check for valid input!

      while (input != 1 && input != 2 && input != 3) {
         System.out.println("\nPlease enter 1, 2, or 3.");
         System.out.print("\tYour choice: ");
         input = scanner.nextInt();
      }

      Person person1 = null;

      if (input == 1) {
         person1 = getPersonFromUser();
      }
      else if (input == 2) {
         person1 = getPersonFromDatabase();
      }
      else {
         return;
      }

      List<Person> people = Database.getPeople();
      List<Score> scores = new ArrayList<Score>();

      for (Person person : people) {
         if (person1.getGender() == person.getGender() && !person1.equals(person)) {
            scores.add(new Score(person1, person));
         }
      }

      Score maxScore = scores.get(0);

      for (Score score : scores) {
         if (score.compareTo(maxScore) > 0) {
            maxScore = score;
         }
      }

      System.out.println("Your best match: ");
      displayScore(maxScore);
      //System.out.println("Your second best match: ");
      //displayScore(scores.get(1));
      //System.out.println("Your third best match: ");
      //displayScore(scores.get(2));
   }

   public void displayWelcomeMessage() {
      System.out.println("** ***** ***** ***** ***** ***** ***** ***** ***** **");
      System.out.println("**                                                 **");
      System.out.println("**   Welcome to the Roommate Compatibility Test!   **");
      System.out.println("**  Written by: Natalie Keelan and Addison Martin  **");
      System.out.println("**                                                 **");
      System.out.println("** ***** ***** ***** ***** ***** ***** ***** ***** **\n\n");
   }

   public void displayOptions() {
      System.out.println("\tWhat would you like to do...?");
      System.out.println("\tPlease enter \'1\' if you would like to get");
      System.out.println("\ttwo people's Roommate Compatibility Score (RCS)");
      System.out.println("\n\tEnter \'2\' if you would like to find your RCS.");
      System.out.println("\tbased on everyone in our database of people.");
      System.out.println("\n\tEnter \'3\' if you would like to exit the program.\n");
   }

   public void displayScore(Score score) {
      System.out.println("\n\n\tYour score with " + score.getPerson2().getName() + "...");
      System.out.println("\tCalculating...");
      System.out.println("\t**********");
      System.out.println("\t***" + score.getScore() + "***");
      System.out.println("\t**********");
      System.out.println("\tYour top three attributes: ");
      System.out.println("\t\t" + score.getTop3Attributes().get(0));
      System.out.println("\t\t" + score.getTop3Attributes().get(1));
      System.out.println("\t\t" + score.getTop3Attributes().get(2));
   }
}
