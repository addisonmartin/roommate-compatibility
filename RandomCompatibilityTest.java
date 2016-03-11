public class RandomCompatibilityTest implements CompatibilityTest
{
   public double calculate(Person person1, Person person2) {
      return (double) (Math.round((Math.random() * 100) * 100) / 100);
   }
}
