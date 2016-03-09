public class Attribute
{
   private String name;
   private int importance;
   private int value;

   public Attribute(String name, int value, int importance) {
      this.name = name;
      this.value = value;
      this.importance = importance;
   }

   public String getAttributeName()
   {
      return name;
   }

   public int getImportance()
   {
      return importance;
   }

   public int getValue()
   {
      return value;
   }
}
