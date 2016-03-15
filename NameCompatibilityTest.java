/** The compatibility test that calculates how compatible two people are based on the letters of their name.
*
* @author Natalie Keelan and Addison Martin
* @version Program 7
*
*/

public class NameCompatibilityTest implements CompatibilityTest
{
   private Person person1;
   private Person person2;

   /**
   *Constructs a NameCompatibilityTest for the two given people from the Person class.
   *
   *@param person1 1st Person in the test
   *@param person2 2nd Person in the test
   */
   public NameCompatibilityTest(Person person1, Person person2) {
      this.person1 = person1;
      this.person2 = person2;
   }

   /**
   *Calculates and returns the percent compatibility for the 2
   * people based on the letters in their names.
   *
   *@return The percent compatibility for the 2 people based on the letters in their names
   */
   public double calculate() {
      String name1 = new String(person1.getName());
      String name2 = new String(person2.getName());

      if (name1.compareTo(name2) > 0) {
         String temp = name1;
         name1 = name2;
         name2 = temp;
      }

      int range;

      if (name1.length() < name2.length()) {
         range = name1.length();
      }
      else {
         range = name2.length();
      }

      double score = 0;

      for (int i = 0; i < range; i++) {
         score += (name1.charAt(i) - name2.charAt(i));
      }

      score = 100 - score;

      if (score > 100) {
         score -= 100;
      }
      else if (score < 0) {
         score += 100;
      }

      return score;
   }
}
