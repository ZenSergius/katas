package patterns.state.worker.states;

import patterns.state.worker.Worker;

public class SleepingState extends WorkerState {
    public SleepingState(Worker worker) {
        super(worker);
    }

    public String getState() {
        return "sleeping";
    }

    public void afterOneHour() {
        worker.setFatigue(worker.getFatigue()+35);
        worker.setEnergy(worker.getEnergy()+35);
        worker.setHungry(worker.getHungry()-5);

        if (sleptWell()) {
            if ( ! setPrimaryState()) {
                worker.setState(new WorkingState(worker));
            }
        }
    }

    protected boolean sleptWell() {
        return worker.getFatigue() == 100 && worker.getEnergy() == 100;
    }
}
