package com.etoitau.designpatterns.observable;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Game
{
    private List<Rat> rats = new ArrayList<>();

    public void addRat(Rat rat) {
        if (rats.contains(rat)) return;
        rats.add(rat);
        updateRats();
    }

    public void removeRat(Rat rat) {
        if (rats.contains(rat)) {
            rats.remove(rat);
            updateRats();
        }
    }

    private void updateRats() {
        int n = rats.size();
        for (Rat r: rats) {
            r.attack = n;
        }
    }
}

class Rat implements Closeable
{
    private Game game;
    public int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        game.addRat(this);
    }

    @Override
    public void close() throws IOException
    {
        game.removeRat(this);
    }
}