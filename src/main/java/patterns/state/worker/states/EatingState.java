package patterns.state.worker.states;

import patterns.state.worker.Worker;

public class EatingState extends WorkerState {
    public EatingState(Worker worker) {
        super(worker);
    }

    public String getState() {
        return "eating";
    }

    public void afterOneHour() {
        worker.setFatigue(worker.getFatigue()-5);
        worker.setHungry(worker.getHungry()+50);

        if (satisfied()) {
            if ( ! setPrimaryState()) {
                worker.setState(new WorkingState(worker));
            }
        }
    }

    protected boolean satisfied() {
        return worker.getHungry() == 100;
    }
}
