/** Provides the implementation to store a person's name, college, and responses to the questions. To be used for testing different people.
*
* @author Natalie Keelan and Addison Martin
* @version Program 7
*/

import java.util.ArrayList;

public class Person
{
   private String name;
   private String college;
   private ArrayList<Attribute> responses;
   private int gender; //0 is female, 1 is male
   private static ArrayList<String> responseNames;

   public Person(String name, String college, int gender) {
      this.name = name;
      this.college = college;
      this.gender = gender;
      responses = new ArrayList<Attribute>();

      if (Person.responseNames.size() == 0) {
         Person.responseNames = new ArrayList<String>();
         Person.responseNames.add("Bed Time");
         Person.responseNames.add("Cleanliness");
         Person.responseNames.add("Okay with Alcohol");
         Person.responseNames.add("Okay with weed and other drugs");
         Person.responseNames.add("Studiousness");
         Person.responseNames.add("Sharing");
         Person.responseNames.add("Overnight guests");
         Person.responseNames.add("Friends over");
         Person.responseNames.add("Time in room");
      }
   }

   public Person(String name, String college) {
      this(name, college, 0);
   }

   public ArrayList<Attribute> getResponses() {
      return responses;
   }

   public String getName() {
      return name;
   }

   public String getCollege() {
      return college;
   }

   public int getGender() {
      return gender;
   }

   public void saveResponse(Attribute a) {
      responses.add(a);
   }

   public String toString() {
      return name;
   }

   public boolean equals(Person other) {
      if (other == null) {
         return false;
      }

      boolean equals = this.name.equals(other.name);
      equals &= this.college.equals(other.college);
      equals &= this.responses.equals(other.responses);
      equals &= this.gender == other.gender;

      return equals;
   }
}
