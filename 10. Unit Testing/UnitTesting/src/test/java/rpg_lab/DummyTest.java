package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int HEALTH = 10;
    private static final int HEALTH_WHEN_DEAD = 0;
    private static final int EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 5;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.aliveDummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(HEALTH_WHEN_DEAD, EXPERIENCE);
    }

    @Test
    public void test_DummyLosesHealth_WhenAttacked() {
        int expectedResult = HEALTH - ATTACK_POINTS;
        aliveDummy.takeAttack(ATTACK_POINTS);
        assertEquals(expectedResult, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void test_DeadDummy_ThrowsException_WhenAttacked() {
        assertEquals(HEALTH_WHEN_DEAD, deadDummy.getHealth());
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void test_DeadDummy_GivesExperience() {
        deadDummy.giveExperience();
        assertEquals(EXPERIENCE, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void test_AliveDummy_ThrowsException_WhenTriesToGiveExperience() {
        assertEquals(HEALTH, aliveDummy.getHealth());
        aliveDummy.giveExperience();
    }

    @Test
    public void test_AliveDummy_IsAlive() {
        assertFalse(aliveDummy.isDead());
    }

    @Test
    public void test_DeadDummy_IsDead() {
        assertTrue(deadDummy.isDead());
    }
}