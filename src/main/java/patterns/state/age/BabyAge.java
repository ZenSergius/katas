package patterns.state.age;

public class BabyAge implements AgeState {
    public String getAge() {
        return "baby";
    }

    public AgeState nextAge() {
        return new ChildAge();
    }
}
