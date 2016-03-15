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

   public static ArrayList<Person> getPeople() {
      ArrayList<Person> people = new ArrayList<Person>();
      Scanner scanner;

      try {
         scanner = new Scanner(new File(filePath));
      } catch (IOException e) {
         System.out.println("Error while reading from file: ");
         e.printStackTrace();
         return null;
      }

      try {
         String personString;
         String[] personData;
         Person person;

         while (scanner.hasNextLine()) {
            personString = scanner.nextLine();
            personData = personString.split(", ");
            person = new Person(personData[0], personData[1], personData[2]);//Check for valid input!

            for (int i = 3; i < PERSON_STRING_LENGTH; i += 3) {
               String attributeName = personData[i];
               int attributeValue = Integer.parseInt(personData[i + 1]);
               int attributeImportance = Integer.parseInt(personData[i + 2]);
               Attribute attribute = new Attribute(attributeName, attributeValue, attributeImportance);
               person.saveResponse(attribute); //Make sure to check for valid input
            }

            people.add(person);
         }
      } catch (Exception e) {
         System.out.println("Error while inputing people from file: ");
         e.printStackTrace();
      }//Do I need to close file?
      //Maybe keep tihs stored somewhere? Even if just in the driver.

      //people = Database.checkForDuplicates(people);
      return people;
   }

   public static ArrayList<Person> checkForDuplicates(ArrayList<Person> people) {
      for (int i = 0; i < people.size(); i++) {
         for (int j = 0; j < people.size(); j++) {
            if (people.get(i).equals(people.get(j))) {
               people.remove(j);
            }
         }
      }

      return people;
   }

   public static void addToDatabase(Person person) {
      BufferedWriter bw = null;

      try {
         bw = new BufferedWriter(new FileWriter(filePath, true));
         String personData = personDataToString(person);
         bw.write(personData);
         bw.newLine();
         bw.flush();
      } catch (IOException e) {
         System.out.println("Error while adding Person to database: ");
         e.printStackTrace();
      } finally {
         if (bw != null) {
            try {
               bw.close();
            } catch (IOException e) {
               System.out.println("Error while trying to close file writer: ");
               e.printStackTrace();
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
      }//IS this cooreect??

      return personData;
   }

   public static void main(String[] args) {//REMOVE WHEN DONE TESTING
      ArrayList<Person> people = getPeople();

      for (Person prsn : people) {
         System.out.println(prsn.getName());
         System.out.println(prsn.getGender());
         System.out.println(prsn.getCollege());
         ArrayList<Attribute> responses = prsn.getResponses();

         for (Attribute response : responses) {
            System.out.println(response.getAttributeName() + ", " + response.getValue() + ", " + response.getImportance());
         }
      }
   }
}
