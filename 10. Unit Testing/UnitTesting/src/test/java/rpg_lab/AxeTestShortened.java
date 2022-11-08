package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTestShortened {
    private final static int ATTACK = 13;
    private final static int DURABILITY = 42;
    private final static int DESTROYED_DURABILITY = 0;
    private final static int HEALTH = 10;
    private final static int EXPERIENCE = 10;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    // Executes before every single test
    @Before
    public void setUp() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.brokenAxe = new Axe(ATTACK, DESTROYED_DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void test_AxeCreation_WillReturn_SameValues_AsCreated() {
        assertEquals(ATTACK, axe.getAttackPoints());
        assertEquals(DURABILITY, axe.getDurabilityPoints());
    }

    @Test
    public void test_WeaponAttacks_LosesDurability() {
        axe.attack(dummy);
        assertEquals(DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void test_BrokenWeapon_CantAttack() {
        assertEquals(DESTROYED_DURABILITY, axe.getDurabilityPoints());
        brokenAxe.attack(dummy);
    }
}
