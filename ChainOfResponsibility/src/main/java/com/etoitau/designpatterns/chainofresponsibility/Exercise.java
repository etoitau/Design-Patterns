package com.etoitau.designpatterns.chainofresponsibility;


import java.util.ArrayList;
import java.util.List;

class Game {
    public List<Creature> creatures;

    public Game() {
        creatures = new ArrayList<>();
    }
}

class Creature {
    protected Game game;
    private int baseAttack, baseDefense;
    protected String name;
    protected List<Buff> buffs;

    public Creature(Game game, String name, int baseAttack, int baseDefense) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        buffs = new ArrayList<>();
    }

    public int getAttack() {
        int result = baseAttack;
        for (Buff buff: buffs) {
            result += buff.attackDelta();
        }
        return result;
    }

    public int getDefense() {
        int result = baseDefense;
        for (Buff buff: buffs) {
            result += buff.defenseDelta();
        }
        return result;
    }
}

class Goblin extends Creature {

    protected Goblin(Game game, String name, int baseAttack, int baseDefense) {
        super(game, name, baseAttack, baseDefense);
        buffs.add(new GoblinParty(game, this));
        buffs.add(new GoblinKingParty(game, this));
    }
    public Goblin(Game game) {
        this(game, "goblin", 1, 1);
    }
}

class GoblinKing extends Goblin {

    protected GoblinKing(Game game, String name, int baseAttack, int baseDefense) {
        super(game, name, baseAttack, baseDefense);
    }

    public GoblinKing(Game game) {
        this(game, "Goblin King", 3, 3);
    }
}

class Buff {
    protected Game game;
    protected Creature creature;

    public Buff(Game game, Creature creature) {
        this.game = game;
        this.creature = creature;
    }

    public int attackDelta() {
        return 0;
    }

    public int defenseDelta() {
        return 0;
    }
}

class GoblinParty extends Buff {
    public GoblinParty(Game game, Creature creature) {
        super(game, creature);
    }

    @Override
    public int defenseDelta() {
        if (!(creature instanceof Goblin)) { return 0; }

        int count = 0;
        for (Creature mob: game.creatures) {
            if (mob instanceof Goblin && mob != this.creature) {
                count++;
            }
        }
        return count;
    }
}

class GoblinKingParty extends Buff {
    public GoblinKingParty(Game game, Creature creature) {
        super(game, creature);
    }

    @Override
    public int attackDelta() {
        if (!(creature instanceof Goblin)) { return 0; }

        int count = 0;
        for (Creature mob: game.creatures) {
            if (mob instanceof GoblinKing && mob != this.creature) {
                count++;
            }
        }
        return count;
    }
}


public class Exercise {
    public static void main(String[] args) {

    }
}
