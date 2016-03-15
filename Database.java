/** This database class provides the framework for storing Person data to a text file, instead of having it initialized every time the code is run.
* It also provides the framework to add Persons data to the existing text file.
*
* @author Natalie Keelan and Addison Martin
* @version Program 7
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Database {
   private static final String filePath = "people.txt";
   private static final int PERSON_STRING_LENGTH = 30;
   private static ArrayList<String> responseNames;
   private static final String ANSI_CLS = "\u001b[2J";
   private static final String ANSI_HOME = "\u001b[H";

   /**
   * Returns an ArrayList of Person objects representing all of the Person data currently stored in the database.
   *
   * @return An ArayLIst of Person objects
   */
   public static ArrayList<Person> getPeople() {
      ArrayList<Person> people = new ArrayList<Person>();
      Scanner scanner;

      try {
         scanner = new Scanner(new File(filePath));
      } catch (IOException e) {
         System.out.print(ANSI_CLS + ANSI_HOME);
         System.out.flush();
         System.out.println("\tIt seems the text document storing people has been modified in");
         System.out.println("\tan unallowed way. Please restore the changes or completely");
         System.out.println("\treturn it to a blank state and try again.");
         System.out.println("\n\tClosing program now...");
         System.exit(1);
         return null;
      }

      try {
         String personString;
         String[] personData;
         Person person;

         while (scanner.hasNextLine()) {
            personString = scanner.nextLine();
            personData = personString.split(", ");
            person = new Person(personData[0], personData[1], personData[2]);

            for (int i = 3; i < PERSON_STRING_LENGTH; i += 3) {
               String attributeName = personData[i];
               int attributeValue = Integer.parseInt(personData[i + 1]);
               int attributeImportance = Integer.parseInt(personData[i + 2]);
               Attribute attribute = new Attribute(attributeName, attributeValue, attributeImportance);
               person.saveResponse(attribute);
            }

            people.add(person);
         }
      } catch (Exception e) {
         System.out.print(ANSI_CLS + ANSI_HOME);
         System.out.flush();
         System.out.println("\tIt seems the text document storing people has been modified in");
         System.out.println("\tan unallowed way. Please restore the changes or completely");
         System.out.println("\treturn it to a blank state and try again.");
         System.out.println("\n\tClosing program now...");
         System.exit(1);
         return null;
      }

      //people = Database.checkForDuplicates(people);
      return people;
   }

   private static ArrayList<Person> checkForDuplicates(ArrayList<Person> people) {
      for (int i = 0; i < people.size(); i++) {
         for (int j = 0; j < people.size(); j++) {
            if (people.get(i).equals(people.get(j))) {
               people.remove(j);
            }
         }
      }

      return people;
   }

   /**
   * Adds a Person object to the database of saved pepole for later retrieval.
   *
   * @param person The person object who you want to add to the database.
   */
   public static void addToDatabase(Person person) {
      BufferedWriter bw = null;

      try {
         bw = new BufferedWriter(new FileWriter(filePath, true));
         String personData = personDataToString(person);
         bw.write(personData);
         bw.newLine();
         bw.flush();
      } catch (IOException e) {
         System.out.print(ANSI_CLS + ANSI_HOME);
         System.out.flush();
         System.out.println("\tIt seems the text document storing people has been modified in");
         System.out.println("\tan unallowed way. Please restore the changes or completely");
         System.out.println("\treturn it to a blank state and try again.");
         System.out.println("\n\tClosing program now...");
         System.exit(1);
      } finally {
         if (bw != null) {
            try {
               bw.close();
            } catch (IOException e) {
               System.out.print(ANSI_CLS + ANSI_HOME);
               System.out.flush();
               System.out.println("\tIt seems the text document storing people has been modified in");
               System.out.println("\tan unallowed way. Please restore the changes or completely");
               System.out.println("\treturn it to a blank state and try again.");
               System.out.println("\n\tClosing program now...");
               System.exit(1);
            }
         }
      }
   }

   private static String personDataToString(Person person) {
      String personData = "";
      personData += person.getName() + ", ";
      personData += person.getCollege() + ", ";
      personData += person.getGender() + ", ";

      ArrayList<Attribute> responses = person.getResponses();

      try {
         for (int i = 0; i < responses.size(); i++) {
            if (i == responses.size() - 1) {
               String attributeToAdd = responses.get(i).getAttributeName() + ", "
                     + responses.get(i).getValue() + ", " + responses.get(i).getImportance();
               personData += attributeToAdd;
            }
            else {
               String attributeToAdd = responses.get(i).getAttributeName() + ", " +
                     responses.get(i).getValue() + ", " + responses.get(i).getImportance() + ", ";
               personData += attributeToAdd;
            }
         }
      } catch (Exception e) {
         System.out.print(ANSI_CLS + ANSI_HOME);
         System.out.flush();
         System.out.println("\tIt seems the text document storing people has been modified in");
         System.out.println("\tan unallowed way. Please restore the changes or completely");
         System.out.println("\treturn it to a blank state and try again.");
         System.out.println("\n\tClosing program now...");
         System.exit(1);
      }

      return personData;
   }
}
