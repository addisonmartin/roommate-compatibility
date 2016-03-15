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
   }

   /**
   *Finds the Attribute that the 2 people have least in common and returns it.
   *
   *@return The Attribute that they have least in common.
   */
   public Attribute getWorstAttribute() {
       ArrayList<Attribute> list1 = p1.getResponses();
      ArrayList<Attribute> list2 = p2.getResponses();
      ArrayList<Double> attributeScores = new ArrayList<Double>();
      for(int i=0; i<list1.size(); i++) {
         double val = Math.abs(list1.get(i).getValue() - list2.get(i).getValue());
         double weightedAvg = (val*list1.get(i).getImportance()
               + val*list2.get(i).getImportance())/2.0;
         attributeScores.add(weightedAvg);
      }
      int max = 0;
      for(int k =0; k<list2.size(); k++) {
         if(attributeScores.get(max)<attributeScores.get(k)) {
            max = k;
         }
      }
      return list1.get(max);
   }

   /**
   *Finds the Attribute that the 2 people have most in common and returns it.
   *
   *@return The Attribute that they have most in common.
   */
   public Attribute getBestAttribute() {
      ArrayList<Attribute> list1 = p1.getResponses();
      ArrayList<Attribute> list2 = p2.getResponses();
      ArrayList<Double> attributeScores = new ArrayList<Double>();
      for(int i=0; i<list1.size(); i++) {
         double val = Math.abs(list1.get(i).getValue() - list2.get(i).getValue());
         double weightedAvg = (val*list1.get(i).getImportance()
               + val*list2.get(i).getImportance())/2.0;
         attributeScores.add(weightedAvg);
      }
      int min = 0;
      for(int k =0; k<list2.size(); k++) {
         if(attributeScores.get(min)>attributeScores.get(k)) {
            min = k;
         }
      }
      return list1.get(min);
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

/*
   private static ArrayList<Attribute> selectionSortScore(ArrayList<Attribute> list1,
         ArrayList<Attribute> list2) {
      int min;
      ArrayList<Attribute> toSort1 = new ArrayList<Attribute>(list1);
      ArrayList<Attribute> toSort2 = new ArrayList<Attribute>(list2);
      ArrayList<Attribute> sorted = new ArrayList<Attribute>();
      for(int i=0; i<toSort1.size()-1; i++) {
         min = i;
         for(int k=i+1; k<toSort1.size(); k++) {
            double valK = Math.abs(toSort1.get(k).getValue() - toSort2.get(k).getValue());
            double weightedAvgK = (valK*toSort1.get(k).getImportance()
                  + valK*toSort2.get(k).getImportance())/2.0;
            double valMin = Math.abs(toSort1.get(min).getValue() - toSort2.get(min).getValue());
            double weightedAvgMin = (valMin*toSort1.get(min).getImportance()
                  + valMin*toSort2.get(min).getImportance())/2.0;

            if(weightedAvgMin>weightedAvgK) {
               min = k;
            }
         }
      sorted.add(list1.get(min));
      toSort1.remove(min);
      toSort2.remove(min);
      }
      return sorted;
   }
*/

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
