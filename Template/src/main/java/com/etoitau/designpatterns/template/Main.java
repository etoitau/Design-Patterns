package com.etoitau.designpatterns.template;

class Creature
{
    public int attack, health;

    public Creature(int attack, int health)
    {
        this.attack = attack;
        this.health = health;
    }

    public boolean isDead() {
        return health < 1;
    }
}

abstract class CardGame
{
    public Creature [] creatures;

    public CardGame(Creature[] creatures)
    {
        this.creatures = creatures;
    }

    // returns -1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2)
    {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second);
        hit(second, first);

        if (first.isDead()) {
            if (second.isDead()) {
                return -1;
            } else {
                return creature2;
            }
        } else if (second.isDead()) {
            return creature1;
        } else {
            return -1;
        }
    }

    // attacker hits other creature
    protected abstract void hit(Creature attacker, Creature other);
}

class TemporaryCardDamageGame extends CardGame
{
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        if (other.health <= attacker.attack) {
            other.health = 0;
        }
    }

}

class PermanentCardDamageGame extends CardGame
{
    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        if (other.health <= attacker.attack) {
            other.health = 0;
        } else {
            other.health -= attacker.attack;
        }
    }
}