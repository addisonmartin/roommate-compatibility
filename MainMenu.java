import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MainMenu {

   public void run() {
      displayWelcomeMessage();

      Scanner scanner = new Scanner(System.in);
      int input = -1;

      while (input != 3) {
         displayOptions();
         System.out.print("\tYour choice: ");
         input = scanner.nextInt();

         while (input != 1 && input != 2 && input != 3) {
            System.out.println("\n\tPlease enter a valid input: 1, 2, or 3.");
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
         scanner.nextLine();
         System.out.print("\n\tPlease enter their name now: ");
         String name = scanner.nextLine();
         person1 = getPersonFromDatabase(name);

         if (person1 == null) {
            System.out.println("\tSorry, it seems we don't have that person's info store already!");
            System.out.println("\tWhy dont you enter their info.");
            person1 = getPersonFromUser();
         }
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
         input = scanner.nextInt();
      }

      Person person2 = null;

      if (input == 1) {
         person2 = getPersonFromUser();
      }
      else if (input == 2) {
         scanner.nextLine();
         System.out.print("\n\tPlease enter their name now: ");
         String name = scanner.nextLine();
         person2 = getPersonFromDatabase(name);

         if (person2 == null) {
            System.out.println("\tSorry, it seems we don't have that person's info store already!");
            System.out.println("\tWhy dont you enter their info.");
            person2 = getPersonFromUser();
         }
      }
      else {
         return;
      }

      displayScore(new Score(person1, person2));
   }

   public Person getPersonFromUser() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("\tEnter your name: ");
      String name = scanner.nextLine();
      System.out.print("\tEnter your college: ");
      String college = scanner.nextLine(); //Make this a number thing!!!
      System.out.print("\tEnter your gender: "); //This should also be a number thing
      int gender = scanner.nextInt();
      Person person = new Person(name, college, gender);

      System.out.println("\tOn a scale of 1 - 10, how early do you go to bed?");
      System.out.print("\t1 being very early, 10 being very late: ");
      int bedTime = scanner.nextInt();
      System.out.println("\tAnd on a scale of 1 - 5, how important is this to you?");
      System.out.println("\t1 being not important at all, 5 being very important: ");
      int bedTimeImportance = scanner.nextInt();
      person.saveResponse(new Attribute("Bed Time", bedTime, bedTimeImportance));

      Database.addToDatabase(person);
      return person;
   }

   public int[] askAboutAttribute(String name) {
      String lowerCaseName = name.toLowerCase();
      int[] responses = new int[2];

      System.out.println("\tOn a scale of 1 - 10,");
      System.out.println("\tWith 1 being the earliest/least, and 10 being the latest/most");
      System.out.print("\tWhen/how okay are you with " + lowerCaseName + ": ");
      Scanner scanner = new Scanner(System.in);
      responses[0] = scanner.nextInt();

      System.out.println("\tOn a scale of 1 - 5");
      System.out.println("\tWith 1 being the least and 10 being the most");
      System.out.print("\tHow important is this to you: ");
      responses[1] = scanner.nextInt();

      return responses;
   }

   public Person getPersonFromDatabase(String name) {
      List<Person> people = Database.getPeople();

      for (Person person : people) {
         if (person.getName().equalsIgnoreCase(name)) {
            return person;
         }
      }

      return null;
   }

   public void comparePersonToDatabase() {
      System.out.println("\tFirst, please enter your infomation.\n");
      Person person1 = getPersonFromUser();
      List<Person> people = Database.getPeople();
      List<Score> scores = new ArrayList<Score>();

      for (Person person : people) {
         if (person1.getGender() == person.getGender()) {
            scores.add(new Score(person1, person));
         }
      }

      Score maxScore = scores.get(0);

      for (Score score : scores) {
         if (score.compareTo(maxScore) > 0) {
            maxScore = score;
         }
      }

      displayScore(maxScore);
   }

   public void displayWelcomeMessage() {
      System.out.println("** ***** ***** ***** ***** ***** ***** ***** ***** **");
      System.out.println("** Welcome to the Roommate Compatibility Test!     **");
      System.out.println("** Written by: Natalie Keelan and Addison Martin   **");
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
      System.out.println("\t\nYour top three attributes: ");
      System.out.println("\t\t" + score.getTop3Attributes().get(0));
      System.out.println("\t\t" + score.getTop3Attributes().get(1));
      System.out.println("\t\t" + score.getTop3Attributes().get(2));
   }
}
