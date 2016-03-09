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

public class Database {
   private static final String filePath = "people.txt";
   private static final int personStringLength = 29;

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
            person = new Person(personData[0], personData[1]);

            for (int i = 2; i < personData.length - 3; i += 3) {
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
      }
      //Maybe keep tihs stored somewhere? Even if just in the driver...
      return people;
   }

   public static void addToDatabase(Person person) {

   }

   public static void main(String[] args) {
      ArrayList<Person> myPeople = Database.getPeople();

      for (int i = 0; i < myPeople.size(); i++)
      {
         System.out.println(myPeople.get(i) + " ");
         System.out.print(myPeople.get(i).getCollege()+ " ");
         ArrayList<Attribute> atrs = myPeople.get(i).getResponses();

         for (int j = 0; j < atrs.size(); j++)
         {
            System.out.print(atrs.get(j) + " ");
         }

         System.out.println();
      }
   }
}
