package patterns.state.age;

public class OldAge implements AgeState {
    public String getAge() {
        return "old";
    }

    public AgeState nextAge() {
        return this;
    }
}
