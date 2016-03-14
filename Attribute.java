/**
*The Attribute class saves Attribute information such as the name, numeric
* answer, and importance.
*@author Natalie Keelan and Addison Martin
*@version Roommate Compatibility Program
*
*/
public class Attribute
{
   private String name;
   private int importance;
   private int value;

   /**
   *Constructs an Attribute object with a specified name, value, and level of importance.
   *
   *@param name The name of the Attribute
   *@param value The numeric answer given about the Attribute
   *@param importance The level of importance the person gave this Attribute
   */
   public Attribute(String name, int value, int importance) {
      this.name = name;
      this.value = value;
      this.importance = importance;
   }

   /**
   *Gets the Attribute name.
   *
   *@return The name of the Attribute
   */
   public String getAttributeName() {
      return name;
   }

   /**
   *Gets the importance level of the Attribute.
   *
   *@return The importance level of the Attribute
   */
   public int getImportance() {
      return importance;
   }

   /**
   *Gets the numeric answer that the Attribute was given.
   *
   *@return The numeric answer that the Attribute was given.
   */
   public int getValue() {
      return value;
   }
}
