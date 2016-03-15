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
   private String gender;

   /**
   *Constructs a Person with the specified name, college, and gender.
   *
   *@param name The Person's name
   *@param college The Person's college (such as College of Engineering)
   *@param gender The Person's gender.
   */
   public Person(String name, String college, String gender) {
      this.name = new String(name);
      this.college = new String(college);
      this.gender = new String(gender);
      responses = new ArrayList<Attribute>();
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
   public String getGender() {
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
      boolean test1 = this.name.equals(per.name);
      boolean test2 = this.college.equals(per.college);
      boolean test3 = this.gender.equals(per.gender);

      return (test1 && test2 && test3);
   }
}
