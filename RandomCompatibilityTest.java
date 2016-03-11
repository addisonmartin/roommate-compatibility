public class RandomCompatibilityTest implements CompatibilityTest
{
   private Person person1;
   private Person person2;

   public RandomCompatibilityTest(Person person1, Person person2) {
      this.person1 = person1;
      this.person2 = person2;
   }
   public double calculate() {
      return (double) (Math.round((Math.random() * 100) * 100) / 100);
   }
}
