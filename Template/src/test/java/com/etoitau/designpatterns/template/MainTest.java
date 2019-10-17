package com.etoitau.designpatterns.template;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void cardGameTest() {
        TemporaryCardDamageGame tcdg;
        PermanentCardDamageGame pcdg;
        Creature one, two;
        Creature[] creatures;
        int winner;

        one = new Creature(1, 3);
        two = new Creature(1, 2);
        creatures = new Creature[]{one, two};
        tcdg = new TemporaryCardDamageGame(creatures);
        winner = tcdg.combat(0, 1);
        winner = tcdg.combat(0, 1);
        winner = tcdg.combat(0, 1);
        winner = tcdg.combat(0, 1);
        assertEquals(-1, winner);

        one = new Creature(1, 3);
        two = new Creature(1, 2);
        creatures = new Creature[]{one, two};
        pcdg = new PermanentCardDamageGame(creatures);
        winner = pcdg.combat(0, 1);
        winner = pcdg.combat(0, 1);
        assertEquals(0, winner);

        one = new Creature(2, 2);
        two = new Creature(2, 2);
        creatures = new Creature[]{one, two};
        tcdg = new TemporaryCardDamageGame(creatures);
        winner = tcdg.combat(0, 1);
        assertEquals(-1, winner);

        one = new Creature(2, 2);
        two = new Creature(2, 2);
        creatures = new Creature[]{one, two};
        pcdg = new PermanentCardDamageGame(creatures);
        winner = pcdg.combat(0, 1);
        assertEquals(-1, winner);

    }
}