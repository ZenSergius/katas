package patterns.state.age;

public class Age {
    private AgeState ageState;

    public Age()
    {
        this.ageState = new BabyAge();
    }

    public String getAge()
    {
        return this.ageState.getAge();
    }

    public void yearsLater()
    {
        this.ageState = this.ageState.nextAge();
    }
}
