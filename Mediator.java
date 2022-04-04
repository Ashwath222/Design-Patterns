package dp;

import java.util.ArrayList;
import java.util.List;

class Participant
{
    private Mediator mediator;
    public int value = 0;
    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        mediator.add(this);
    }

    public void say(int n)
    {
        mediator.broadcast(this, n);
    }
}

class Mediator
{
    private List<Participant> participants = new ArrayList<>();

    public void add(Participant participant) {
        participants.add(participant);
    }

    public void broadcast(Participant p, int n) {
        for(Participant participant : participants) {
            if(participant != p) {
                participant.value += n;
            }
        }
    }
}
