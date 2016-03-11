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

   public Person(String name, String college) {
      this.name = name;
      this.college = college;
      responses = new ArrayList<Attribute>();
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

   public void saveResponse(Attribute a) {
      responses.add(a);
   }

   public String toString() {
      return name;
   }
}
