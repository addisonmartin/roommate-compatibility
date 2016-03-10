import java.util.*;
/**
*Calculates the percent compatibility for two people
*
*@author Natalie Keelan and Addison Martin
*@version Program 7
*/
public class AttributeCompatibilityTest implements CompatibilityTest
{
   private Person person1;
   private Person person2;
   private static final int MAX_POSSIBLE_SCORE = 485;

   public AttributeCompatibilityTest(Person person1, Person person2) {
      this.person1 = person1;
      this.person2 = person2;
   }

   public double calculate(Person person1, Person person2) {
      int score1 = calcScoreP1ToP2(person1, person2);
      int score2 = calcScoreP2ToP1(person1, person2);
      double nonCompat = calcNonCompatibility(score1, score2, person1, person2);
      return calcCompatibility(nonCompat);
   }

   private static double calcCompatibility(double nonCompDecimal) {
      return 100*(1.0 - nonCompDecimal);
   }

   private static int calcScoreP1ToP2(Person p1, Person p2) {
      ArrayList<Attribute> p1List = p1.getResponses();
      ArrayList<Attribute> p2List = p2.getResponses();
      int sum = 0;
      int diff = 0;
      for(int i =0; i<p1List.size(); i++) {
         diff = p1List.get(i).getValue() - p2List.get(i).getValue();
         diff = Math.abs(diff);
         sum += diff*p1List.get(i).getImportance();
      }
      return sum;
   }

   private static int calcScoreP2ToP1(Person p1, Person p2) {
      ArrayList<Attribute> p1List = p1.getResponses();
      ArrayList<Attribute> p2List = p2.getResponses();
      int sum = 0;
      int diff = 0;
      for(int i =0; i<p1List.size(); i++) {
         diff = p1List.get(i).getValue() - p2List.get(i).getValue();
         diff = Math.abs(diff);
         sum += diff*p2List.get(i).getImportance();
      }
      return sum;
   }

   private static double calcNonCompatibility(int score1, int score2, Person p1, Person p2) {
      double total = score1 + score2;
      if(!p1.getCollege().equals(p2.getCollege())) {
         total+=70;
      }
      double average = total/2.0;
      return average/MAX_POSSIBLE_SCORE;
   }
}
