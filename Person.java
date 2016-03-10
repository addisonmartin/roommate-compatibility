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

<<<<<<< HEAD
   public ArrayList<Attribute> getResponses() {
=======
   public ArrayList<Attribute> getResponses()
   {
>>>>>>> cd1bb4dee93bd026030fd4962e38fc4a50c3779d
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
