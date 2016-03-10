public class RandomCompatibilityTest implements CompatibilityTest
{
   public double calculate(Person person1, Person person2) {
      return (Math.random() * 100);
   }
}
