package com.etoitau.designpatterns.chainofresponsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class ExerciseTest {

    @Test
    void main() {
        Game game = new Game();

        // one Goblin
        Goblin goblin = new Goblin(game);
        game.creatures.add(goblin);
        assertEquals(1, goblin.getAttack());
        assertEquals(1, goblin.getDefense());

        // + Goblin
        Goblin goblin2 = new Goblin(game);
        game.creatures.add(goblin2);
        assertEquals(1, goblin.getAttack());
        assertEquals(2, goblin.getDefense());
        assertEquals(1, goblin2.getAttack());
        assertEquals(2, goblin2.getDefense());

        // + GoblinKing
        GoblinKing gk = new GoblinKing(game);
        game.creatures.add(gk);
        assertEquals(2, goblin.getAttack());
        assertEquals(3, goblin.getDefense());

        // + other Creature
        Creature mob = new Creature(game, "dummy", 1, 1);
        game.creatures.add(mob);
        assertEquals(2, goblin.getAttack());
        assertEquals(3, goblin.getDefense());
        assertEquals(1, mob.getDefense());

        // - Goblin
        game.creatures.remove(goblin);
        assertEquals(3, gk.getAttack());
        assertEquals(4, gk.getDefense());
    }
}