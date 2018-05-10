package patterns.state.age;

public class TeenagerAge implements AgeState {
    public String getAge() {
        return "teenager";
    }

    public AgeState nextAge() {
        return new AdultAge();
    }
}
