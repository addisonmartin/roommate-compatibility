/** Provides the implementation of a main menu in order to compare people, add people, or whatever else the user decides to do.
*
* @@author Natalie Keelan and Addison Martin
* @version Program 7
*/

import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MainMenu {
   private ArrayList<String> questions;
   private ArrayList<String> attributeKeywords;
   private final String ANSI_CLS = "\u001b[2J";
   private final String ANSI_HOME = "\u001b[H";

   /**
   * Constructs a new MainMenu object and intializes a private array of the questions that we ask.
   */
   public MainMenu() {
      questions = new ArrayList<String>();
      questions.add("When do you go to sleep on an average day? Scale of 1-10 (1 being at or before 10:00 or before, 5 being at 12:00, 10 being after 2:00 am)");
      questions.add("How important is it that you sleep at similar times as your roommate (1-5)");
      questions.add("How often do you drink? (1 being never, 10 being heavily and 4 or more nights a week)");
      questions.add("How important is it that your roommate is okay with this? (1-5)");
      questions.add("How often do you smoke weed or do other drugs? (1 being never, 10 being daily)");
      questions.add("How important is it that your roommate is okay with it? (1-5)");
      questions.add("How clean are you? (1 extremely messy, 10 extremely clean)");
      questions.add("How important is it that your roommate is similar? (1-5)");
      questions.add("How much do you study on an average day? (1 being less than 30 mins, 5 being 2 hours, 10 being 6 or more hours)");
      questions.add("How important is it that your roommate is respectful of your study time? (1-5)");
      questions.add("How okay are you with sharing your things? (1 not okay, 10 share everything)");
      questions.add("How important is it that your roommate has the same sharing policy as you? (1-5)");
      questions.add("How often you plan on having overnight guests over? (1 being never, 10 being almost nightly)");
      questions.add("How important is it that your roommate is okay with how often you have guests? (1-5)");
      questions.add("Are you okay with having guests stop by unannounced to hang out? (1 not okay, 10 extremely okay)");
      questions.add("How important is it that your roommate respects this (1-5)");
      questions.add("How much time do you plan on spending in your room? (1 I’ll sleep there sometimes, 10 pretty much all day)");
      questions.add("How important is it that your rooommate spend a similar amount of time in your room? (1-5)");

      attributeKeywords = new ArrayList<String>();
      attributeKeywords.add("Bed Time");
      attributeKeywords.add("Drinking");
      attributeKeywords.add("Weed and other drug use");
      attributeKeywords.add("Cleanliness");
      attributeKeywords.add("Studiousness");
      attributeKeywords.add("Sharing");
      attributeKeywords.add("Overnight guests");
      attributeKeywords.add("Unannounced room visits");
      attributeKeywords.add("Time in room");
   }

   /**
   * Allows the program to be run until the user wants to quit. Laumches other methods as the user wants.
   */
   public void run() {
      System.out.print(ANSI_CLS + ANSI_HOME);
      System.out.flush();

      displayWelcomeMessage();

      Scanner scanner = new Scanner(System.in);
      String stringInput = "-1";

      while (!stringInput.equals(3)) {
         displayOptions();
         System.out.print("\tYour choice: ");
         stringInput = scanner.nextLine();

         while (!stringInput.equals("1") && !stringInput.equals("2") && !stringInput.equals("3")) {
            System.out.println("\n\tPlease enter 1, 2, or 3.");
            System.out.print("\tYour choice: ");
            stringInput = scanner.nextLine();
         }

         int input = Integer.parseInt(stringInput);

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

   private void compareTwoPeople() {
      System.out.print(ANSI_CLS + ANSI_HOME);
      System.out.flush();

      System.out.println("\n\n\tFirst, would you like to enter a new person or pull someone's data from the databse?");
      System.out.println("\n\tEnter \'1\' if you would like to enter a new person's infomation,");
      System.out.println("\tEnter \'2\' if you would like to pull someone's infomation from the database.");
      System.out.println("\tEnter \'3\' if you would like to exit and return to the menu.");
      System.out.print("\tYour choice: ");
      Scanner scanner = new Scanner(System.in);
      String stringInput = scanner.nextLine();

      while (!stringInput.equals("1") && !stringInput.equals("2") && !stringInput.equals("3")) {
         System.out.println("\nPlease enter 1, 2, or 3.");
         System.out.print("\tYour choice: ");
         stringInput = scanner.nextLine();
      }

      int input = Integer.parseInt(stringInput);
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

      System.out.print(ANSI_CLS + ANSI_HOME);
      System.out.flush();

      System.out.println("\n\tWhere would you like to get the second person's information from?");
      System.out.println("\n\tEnter \'1\' if you would like to enter a new person's infomation,");
      System.out.println("\tEnter \'2\' if you would like to pull someone's infomation from the database.");
      System.out.println("\tEnter \'3\' if you would like to exit and return to the menu.");
      System.out.print("\tYour choice: ");
      stringInput = scanner.nextLine();

      while (!stringInput.equals("1") && !stringInput.equals("2") && !stringInput.equals("3")) {
         System.out.println("\n\tPlease enter 1, 2, or 3.");
         System.out.println("\tYour choice: ");
         stringInput = scanner.nextLine();
      }

      input = Integer.parseInt(stringInput);
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

      displayScore(new Score(person1, person2));
   }

   private Person getPersonFromDatabase() {
      System.out.print(ANSI_CLS + ANSI_HOME);
      System.out.flush();

      Scanner scanner = new Scanner(System.in);
      System.out.print("\n\tPlease enter their name now: ");
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
         System.out.println("\tWould you like to enter their info now or try again?");
         System.out.println("\tEnter \'1\' to enter their info now or enter \'2\' to try again.");
         System.out.print("\tYour choice: ");
         String stringInput = scanner.nextLine();

         while (!stringInput.equals("1") && !stringInput.equals("2")) {
            System.out.println("\tPlease enter 1 or 2.");
            System.out.print("\tYour choice: ");
            stringInput = scanner.nextLine();
         }

         int input = Integer.parseInt(stringInput);

         if (input == 1) {
            person = getPersonFromUser();
         }
         else if (input == 2) {
            person = getPersonFromDatabase();
         }
      }

      return person;
   }

   private Person getPersonFromUser() {
      System.out.print(ANSI_CLS + ANSI_HOME);
      System.out.flush();

      Scanner scanner = new Scanner(System.in);
      System.out.print("\tEnter your name: ");
      String name = scanner.nextLine();
      System.out.println("\tTell us your college.");
      System.out.println("\tPlease enter 1 for COSAM, 2 for CENG, 3 for CAED, 4 for CAFES, 5 for Orfalea College of Business, and 6 for CLA.");
      System.out.print("\tEnter your college as a number between 1 and 6: ");
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
         System.out.print("\tPlease enter 0 for female, 1 for male: ");
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

      System.out.println("\n\n\tPlease answer the following questions.");
      System.out.println("\tYou will be asked one question about yourself on a scale of 1 - 10,");
      System.out.println("\tand another question about how important that is to you on a scale of 1 - 5.");
      System.out.println("\tWith 1 being the least important, and 10 or 5 being the most important.");
      System.out.println("\tPlease answer honestly. Lets begin.\n");

      int attributeKeywordIndex = 0;
      for (int i = 0; i < questions.size(); i += 2) {
         person.saveResponse(askAboutAttribute(questions.get(i), questions.get(i + 1), attributeKeywords.get(attributeKeywordIndex)));
         attributeKeywordIndex++;
      }

      Database.addToDatabase(person);
      return person;
   }

   private Attribute askAboutAttribute(String question1, String question2, String keyword) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("\t" + question1);
      System.out.print("\tValue: ");
      String value = scanner.nextLine();

      while (!value.equals("1") && !value.equals("2") && !value.equals("3") &&
             !value.equals("4") && !value.equals("5") && !value.equals("6") &&
             !value.equals("7") && !value.equals("8") && !value.equals("9") &&
             !value.equals("10"))
      {
         System.out.println("\tPlease enter a valid value between 1 and 10.");
         System.out.print("\tValue: ");
         value = scanner.nextLine();
      }

      int intValue = Integer.parseInt(value);

      System.out.println("\t" + question2);
      System.out.print("\tImportance: ");
      String importance = scanner.nextLine();

      while (!importance.equals("1") && !importance.equals("2") && !importance.equals("3") &&
             !importance.equals("4") && !importance.equals("5"))
      {
         System.out.println("\tPlease enter a valid importance between 1 and 5.");
         System.out.print("\tImportance: ");
         importance = scanner.nextLine();
      }

      int intImportance = Integer.parseInt(importance);

      return new Attribute(keyword, intValue, intImportance);
   }

   private void comparePersonToDatabase() {
      System.out.print(ANSI_CLS + ANSI_HOME);
      System.out.flush();

      System.out.println("\n\n\tFirst, would you like to enter a new person or pull someone's data from the databse?");
      System.out.println("\n\tEnter \'1\' if you would like to enter a new person's infomation,");
      System.out.println("\tEnter \'2\' if you would like to pull someone's infomation from the database.");
      System.out.println("\tEnter \'3\' if you would like to exit and return to the menu.");
      System.out.print("\tYour choice: ");
      Scanner scanner = new Scanner(System.in);
      String stringInput = scanner.nextLine();

      while (!stringInput.equals("1") && !stringInput.equals("2") && !stringInput.equals("3")) {
         System.out.println("\tPlease enter 1, 2, or 3.");
         System.out.print("\tYour choice: ");
         stringInput = scanner.nextLine();
      }

      int input = Integer.parseInt(stringInput);
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
         if (person1.getGender().equals(person.getGender()) && !person1.equals(person)) {
            scores.add(new Score(person1, person));
         }
      }

      ArrayList<Score> sortedScores = new ArrayList<Score>();

      if (scores.size() != 0) {
         Score maxScore = scores.get(0);

         for (Score score : scores) {
            if (score.compareTo(maxScore) > 0) {
               maxScore = score;
               //sortedScores.add(maxScore);
            }
         }

         sortedScores.add(maxScore);

         if (sortedScores.size() >= 3) {
            System.out.print(ANSI_CLS + ANSI_HOME);
            System.out.flush();
            System.out.println("\tYour best match...\n");
            displayScore(sortedScores.get(0));
            System.out.println("\tYour second best match...\n");
            displayScore(sortedScores.get(1));
            System.out.println("\tYour third best match...\n");
            displayScore(sortedScores.get(2));
         }
         else if (sortedScores.size() == 2) {
            System.out.print(ANSI_CLS + ANSI_HOME);
            System.out.flush();
            System.out.println("\tYour best match...\n");
            displayScore(sortedScores.get(0));
            System.out.println("\tYour second best match...\n");
            displayScore(sortedScores.get(1));
         }
         else if (sortedScores.size() == 1) {
            System.out.print(ANSI_CLS + ANSI_HOME);
            System.out.flush();
            System.out.println("\tYour best match...\n");
            displayScore(sortedScores.get(0));
         }
         else {
            System.out.print(ANSI_CLS + ANSI_HOME);
            System.out.flush();
            System.out.println("\n\tSorry, it seems we could not find any matches for you... :(");
            System.out.println("\n\tPlease make sure there is other people's info stored and try again.");

         }
      }
      else {
         System.out.print(ANSI_CLS + ANSI_HOME);
         System.out.flush();
         System.out.println("\n\tSorry, it seems we could not find any matches for you... :(");
         System.out.println("\n\tPlease make sure there is other people's info stored and try again.");
      }
   }

   private void displayWelcomeMessage() {
      System.out.println("\t** ***** ***** ***** ***** ***** ***** ***** ***** **");
      System.out.println("\t**                                                 **");
      System.out.println("\t**   Welcome to the Roommate Compatibility Test!   **");
      System.out.println("\t**  Written by: Natalie Keelan and Addison Martin  **");
      System.out.println("\t**                                                 **");
      System.out.println("\t** ***** ***** ***** ***** ***** ***** ***** ***** **\n\n");
   }

   private void displayOptions() {
      System.out.println("\n\n\n\tWhat would you like to do...?");
      System.out.println("\tPlease enter \'1\' if you would like to get");
      System.out.println("\ttwo people's Roommate Compatibility Score (RCS)");
      System.out.println("\n\tEnter \'2\' if you would like to find your RCS.");
      System.out.println("\tbased on everyone in our database of people.");
      System.out.println("\n\tEnter \'3\' if you would like to exit the program.\n");
   }

   private void displayScore(Score score) {
      if ((score.getPerson1().getName().equalsIgnoreCase("Addison Martin") && 
          score.getPerson2().getName().equalsIgnoreCase("Eriq Augustine")) ||
         (score.getPerson2().getName().equalsIgnoreCase("Addison Martin") &&
          score.getPerson1().getName().equalsIgnoreCase("Eriq Augustine")))
      {
         System.out.println("\n\n\t" + score.getPerson1().getName() + " and...");
         System.out.println("\t" + score.getPerson2().getName());
         System.out.println("\tgot a RCS of...");
         System.out.println("\n\n\t***********");
         System.out.println("\t** 100.0 **");
         System.out.println("\t***********");
         System.out.println("\n\n\tWow! Much compatibility!");
         System.out.println("\tMaybe you should give us a 100...");
         System.out.println("\n\t** ***** ***** ***** ***** ***** ***** ***** ***** **");
      }

      else
      {
         System.out.println("\n\n\t" + score.getPerson1().getName() + " and...");
         System.out.println("\t" + score.getPerson2().getName());
         System.out.println("\tgot a RCS of...");
         System.out.println("\n\n\t***********");
         System.out.println("\t** " + score.getScore() + " **");
         System.out.println("\t***********");
         System.out.println("\n\n\tYour top attribute in common: ");
         System.out.println("\t\t" + score.getBestAttribute().getAttributeName());
         System.out.println("\n\tYour lowest attribute in common: ");
         System.out.println("\t\t" + score.getWorstAttribute().getAttributeName());
         System.out.println("\n\t** ***** ***** ***** ***** ***** ***** ***** ***** **");
      }
   }
}
