import java.util.Scanner;
import java.io.IOException;

public class MainMenu {
   public MainMenu() {

   }

   public void run() {
      displayWelcomeMessage();

      Scanner scanner = new Scanner(System.in);
      int input = -1;

      while (input != 3) {
         displayOptions();
         input = scanner.nextInt();

         while (input != 1 && input != 2 && input != 3) {
            System.out.println("\nPlease enter a valid input: 1, 2, or 3.");
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

      Scanner scanner = new Scanner(System.in);
      int input = scanner.nextInt(); //Remeber check for valid input!

      while (input != 1 && input != 2 && input != 3) {
         System.out.println("\nPlease enter 1, 2, or 3.");
         input = scanner.nextInt();
      }

      Person person1;

      if (input == 1) {
         person1 = getPersonFromUser();
      }
      else if (input == 2) {
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

      input = scanner.nextInt(); //Remeber check for valid input!

      while (input != 1 && input != 2 && input != 3) {
         System.out.println("\nPlease enter 1, 2, or 3.");
         input = scanner.nextInt();
      }

      Person person2;

      if (input == 1) {
         person2 = getPersonFromUser();
      }
      else if (input == 2) {
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

      AttributeCompatibilityTest test = new AttributeCompatibilityTest(person1, person2);
      double score = test.calculate();

      displayScore(person1, person2, score);
   }

   public Person getPersonFromUser() {
      return null;
   }

   public Person getPersonFromDatabase(String name) {
      return null;
   }

   public void comparePersonToDatabase() {

   }

   public void displayWelcomeMessage() {
      System.out.println("// ***** ***** ***** ***** ***** ***** ***** *****");
      System.out.println("// Welcome to the Roommate Compatibility Test!");
      System.out.println("// Written by: Natalie Keelan and Addison Martin");
      System.out.println("// ***** ***** ***** ***** ***** ***** ***** *****\n\n");
   }

   public  void displayOptions() {
      System.out.println("\tWhat would you like to do...?");
      System.out.println("\tPlease enter \'1\' if you would like to get");
      System.out.println("\ttwo people's Roommate Compatibility Score (RCS)");
      System.out.println("\n\tEnter \'2\' if you would like to find your RCS.");
      System.out.println("\tbased on everyone in our database of people.");
      System.out.println("\n\tPress \'3\' if you would like to exit the program.\n");
   }

   public void displayScore(Person person1, Person person2, double score) {

   }
}
