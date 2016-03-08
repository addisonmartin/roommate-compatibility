import java.util.ArrayList;

public class Person
{
   private String name;
   private String college;
   private ArrayList<Attribute> responses;

   public Person(String name, String college)
   {
      this.name = name;
      this.college = college;
   }

   public ArrayList<Attribute> getRespones()
   {
      return responses;
   }

   public String getName()
   {
      return name;
   }

   public String getCollege()
   {
      return college;
   }
}
