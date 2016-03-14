/** Provides the implementation to store a person's name, college, and responses to the questions.
* To be used for testing different people.
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

   /**
   *Constructs a Person with the specified name, college, and gender.
   *
   *@param name The Person's name
   *@param college The Person's college (such as College of Engineering)
   *@param gender The Person's gender. (0- female, 1-male)
   */
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

   /**
   *Gets the Person's responses to the questionnaire as an ArrayList of Attributes.
   *
   *@return an ArrayList of Attributes that correspond to the Person's responses
   * to the questionnaire
   */
   public ArrayList<Attribute> getResponses() {
      return responses;
   }

   /**
   *Gets the Person's name.
   *
   *@return the Person's name
   */
   public String getName() {
      return name;
   }

   /**
   *Gets the name of the college that the Person's major is in.
   *
   *@return the name of the college that the Person's major is in.
   */
   public String getCollege() {
      return college;
   }

   /**
   *Gets the gender of the person as an integer- 0 being female and 1 being male.
   *
   *@return The gender of the person as an integer- 0 being female and 1 being male.
   */
   public int getGender() {
      return gender;
   }

   /**
   *Saves an Attribute from the questionnaire and adds it to the list of responses.
   *
   *@param a Attribute that you want to add to the Person's list of responses.
   */
   public void saveResponse(Attribute a) {
      responses.add(a);
   }

   /**
   *Checks if a Person equals another Object based on all their qualities.
   *
   *@param other The Object to see if this Person is equal to.
   *@return True if the Object has the same name, gender, and college , false if not.
   */
   public boolean equals(Object other) {
      if (other == null) {
         return false;
      }
      if(!other.getClass().equals(this.getClass())) {
         return false;
      }

      Person per = (Person)other;
      boolean equals = this.name.equals(per.name);
      equals &= this.college.equals(per.college);
      equals &= this.gender == per.gender;

      return equals;
   }
}
