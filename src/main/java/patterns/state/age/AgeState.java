package patterns.state.age;

public interface AgeState {
    String getAge();
    AgeState nextAge();
}
