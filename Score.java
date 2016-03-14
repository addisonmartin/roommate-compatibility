import java.util.*;
/**
*The Score track keeps track of 2 peoples total scores, and scores
* for each Attribute individually.
*
*@author Natalie Keelan and Addison Martin
*@version Roommate Compatibility Program
*/
public class Score implements Comparable<Score>{
   private Person p1;
   private Person p2;
   private ArrayList<Integer> all;

   /**
   *Constructs a Score object for 2 people from the Person class.
   *
   *@param person1 The 1st person we compared.
   *@param person2 The 2nd person we compared.
   */
   public Score(Person person1, Person person2) {
      p1 = person1;
      p2 = person2;
      ArrayList<Attribute> p1List = p1.getResponses();
      ArrayList<Attribute> p2List = p2.getResponses();
      int sum = 0;
      int diff = 0;
      for(int i =0; i<p1List.size(); i++) {
         diff = p1List.get(i).getValue() - p2List.get(i).getValue();
         diff = Math.abs(diff);
         all.add(diff*p1List.get(i).getImportance());
      }
   }

   /**
   *Finds the top 3 Attributes that the people had most in common in order of
   * most agreed on to least and then returns them in an ArrayList of Attributes
   *
   *@return an ArrayList of the top 3 Attributes that the 2 people agreed on most in order.
   */
   public ArrayList<Attribute> getTop3Attributes() {
      ArrayList<Attribute> ordered = selectionSortScore(p1.getResponses(), p2.getResponses());
      ArrayList<Attribute> top3 = new ArrayList<Attribute>();
      for(int i=0; i<3; i++) {
         top3.add(ordered.get(i));
      }
      return top3;
   }

   /**
   *Gets the score of the 2 peoples's Attribute Compatibility Test.
   *
   *@return the score of the 2 people's Attribute Compatibility Test.
   */
   public double getScore() {
      CompatibilityTest test = new AttributeCompatibilityTest(p1, p2);
      return test.calculate();
   }

   private static ArrayList<Attribute> selectionSortScore(ArrayList<Attribute> list1,
         ArrayList<Attribute> list2) {
      int min;
      ArrayList<Attribute> toSort = list1;
      ArrayList<Attribute> sortedAttributes = new ArrayList<Attribute>();
      for(int i=0; i<list2.size()-1; i++) {
         min = i;
         for(int k=i+1; k<list2.size(); k++) {
            double valK = Math.abs(toSort.get(k).getValue() - list2.get(k).getValue());
            double weightedAvgK = (valK*toSort.get(k).getImportance()
                  + valK*list2.get(k).getImportance())/2.0;
            double valMin = Math.abs(toSort.get(min).getValue() - list2.get(min).getValue());
            double weightedAvgMin = (valMin*toSort.get(min).getImportance()
                  + valMin*list2.get(min).getImportance())/2.0;
            if(weightedAvgMin>weightedAvgK) {
               min = k;
            }
         }
      Attribute temp = toSort.get(min);
      toSort.set(min, toSort.get(i));
      toSort.set(i, temp);
      }
      return toSort;
   }

   /**
   *Compares 2 Scores to eachother, and returns a positive number if the score we are
   * comparing to is smaller than this score, returns a negative number if the score
   * we are comparing to is larger than this score, and zero if they have the same score.
   *
   *@param other The other score to compare to.
   *@return a positive number if the score we are comparing to is smaller than this score,
   * a negative number if the score we are comparing to is larger than this score,
   * and zero if they have the same score.
   */
   public int compareTo(Score other) {
      return (int)(this.getScore() - other.getScore());
   }

   /**
   *Gets the first Person.
   *
   *@return The first Person.
   */
   public Person getPerson1() {
      return p1;
   }

   /**
   *Gets the second Person.
   *
   *@return The second Person.
   */
   public Person getPerson2() {
      return p2;
   }
}
