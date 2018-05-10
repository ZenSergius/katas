package patterns.state.age;

public class AdultAge implements AgeState {
    public String getAge() {
        return "adult";
    }

    public AgeState nextAge() {
        return new OldAge();
    }
}
