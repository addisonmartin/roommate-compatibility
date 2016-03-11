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

   public NameCompatibilityTest(Person person1, Person person2) {
      this.person1 = person1;
      this.person2 = person2;
   }

   public double calculate() {
      String name1 = person1.getName();
      //changed this line to say person2.getName() not sure if thats what you wanted but I thought it
      //might have been a tiny mistake. it said name2 = person1.getName() before.
      String name2 = person2.getName(); //Do we need to make deep copies? Probably should to fend off Eriq.

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
