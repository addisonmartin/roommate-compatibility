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

   public Person(String name, String college, int gender) {
      this.name = name;
      this.college = college;
      this.gender = gender;
      responses = new ArrayList<Attribute>();
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
}
