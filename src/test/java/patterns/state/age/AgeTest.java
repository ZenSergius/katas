package patterns.state.age;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgeTest {
    @Test
    public void testAges()
    {
        Age age = new Age();
        assertEquals("baby", age.getAge());

        age.yearsLater();
        assertEquals("child", age.getAge());

        age.yearsLater();
        assertEquals("teenager", age.getAge());

        age.yearsLater();
        assertEquals("adult", age.getAge());

        age.yearsLater();
        assertEquals("old", age.getAge());

        age.yearsLater();
        assertEquals("old", age.getAge());
    }

    @Test
    public void testBabyAge()
    {
        AgeState babyAge = new BabyAge();
        assertEquals("baby", babyAge.getAge());
        assertTrue(babyAge.nextAge() instanceof ChildAge);
    }

    @Test
    public void testChildAge()
    {
        AgeState childAge = new ChildAge();
        assertEquals("child", childAge.getAge());
        assertTrue(childAge.nextAge() instanceof TeenagerAge);
    }

    @Test
    public void testTeenagerAge()
    {
        AgeState teenagerAge = new TeenagerAge();
        assertEquals("teenager", teenagerAge.getAge());
        assertTrue(teenagerAge.nextAge() instanceof AdultAge);
    }

    @Test
    public void testManAge()
    {
        AgeState adultAge = new AdultAge();
        assertEquals("adult", adultAge.getAge());
        assertTrue(adultAge.nextAge() instanceof OldAge);
    }

    @Test
    public void testOldAge()
    {
        AgeState oldAge = new OldAge();
        assertEquals("old", oldAge.getAge());
        assertTrue(oldAge.nextAge() instanceof OldAge);
    }
}
