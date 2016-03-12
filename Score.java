import java.util.*;
public class Score {
   private Person p1;
   private Person p2;
   private ArrayList<Integer> all;

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

   public ArrayList<Attribute> getTop3Attributes() {
      ArrayList<Attribute> ordered = selectionSortScore(p1.getResponses(), p2.getResponses());
      ArrayList<Attribute> top3 = new ArrayList<Attribute>();
      for(int i=0; i<3; i++) {
         top3.add(ordered.get(i));
      }
      return top3;
   }

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

}
