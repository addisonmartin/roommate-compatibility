/**
*RandomCompatibilityTest gives 2 people a completely randomized percent compatibility.
*
*@author Natalie Keelan and Addison Martin
*@version Roommate Compatibility Program
*/
public class RandomCompatibilityTest implements CompatibilityTest
{
   private Person person1;
   private Person person2;

   /**
   *Constructs a RandomCompatibilityTest for 2 people from the Person class.
   *
   *@param person1 1st Person in the test
   *@param person2 2nd Person in the test
   */
   public RandomCompatibilityTest(Person person1, Person person2) {
      this.person1 = person1;
      this.person2 = person2;
   }

   /**
   *Calculates and returns a random percent compatibility for the 2 people
   * from the Person class.
   *
   *@return A random percent compatibility for the 2 people.
   */
   public double calculate() {
      return (double) (Math.round((Math.random() * 100) * 100) / 100);
   }
}
