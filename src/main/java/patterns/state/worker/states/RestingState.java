package patterns.state.worker.states;

import patterns.state.worker.Worker;

public class RestingState extends WorkerState {
    public RestingState(Worker worker) {
        super(worker);
    }

    public String getState() {
        return "resting";
    }

    public void afterOneHour() {
        worker.setFatigue(worker.getFatigue()-5);
        worker.setHungry(worker.getHungry()-15);

        setPrimaryState();
    }
}
