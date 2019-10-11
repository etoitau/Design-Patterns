package com.etoitau.designpatterns.mediator;

import java.util.ArrayList;
import java.util.List;

class Participant
{
    int value = 0;
    Mediator mediator;

    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        mediator.join(this);
    }

    public void say(int n)
    {
        mediator.broadcast(this, n);
    }
}

class Mediator
{
    private List<Participant> users = new ArrayList<>();

    /**
     * user sends value for every other user to add to their personal value
     * @param sender - Participant sending value, they don't add it themselves
     * @param value - value for all users in Mediator to add
     */
    public void broadcast(Participant sender, int value) {
        for (Participant user: users) {
            if (user != sender)
                user.value += value;
        }
    }

    public void join(Participant p) {
        users.add(p);
    }

    public boolean leave(Participant p) {
        if (users.contains(p)) {
            users.remove(p);
            return true;
        } else {
            return false;
        }
    }
}