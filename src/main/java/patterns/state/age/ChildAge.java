package patterns.state.age;

public class ChildAge implements AgeState {
    public String getAge() {
        return "child";
    }

    public AgeState nextAge() {
        return new TeenagerAge();
    }
}
