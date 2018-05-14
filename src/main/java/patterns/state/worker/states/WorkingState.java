package patterns.state.worker.states;

import patterns.state.worker.Worker;

public class WorkingState extends WorkerState {
    public WorkingState(Worker worker) {
        super(worker);
    }

    public String getState() {
        return "working";
    }

    public void afterOneHour() {
        worker.setHungry(worker.getHungry()-25);
        worker.setEnergy(worker.getEnergy()-15);
        worker.setFatigue(worker.getFatigue()-10);

        setPrimaryState();
    }
}
