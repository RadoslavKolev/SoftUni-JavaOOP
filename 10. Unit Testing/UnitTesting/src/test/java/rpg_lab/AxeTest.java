package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

// 3A Pattern - Arrange, Act, Assert
public class AxeTest {
    @Test
    public void test_AxeCreation_WillReturn_SameValues_AsCreated() {
        // Arrange
        int expectedAttack = 13;
        int expectedDurability = 42;

        // Act
        Axe axe = new Axe(expectedAttack, expectedDurability);

        // Assert
        assertEquals(expectedAttack, axe.getAttackPoints());
        assertEquals(expectedDurability, axe.getDurabilityPoints());
    }

    @Test
    public void test_WeaponAttacks_LosesDurability() {
        // Arrange
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);

        // Act
        axe.attack(dummy);

        // Assert
        // assertTrue(axe.getDurabilityPoints() == 9);
        assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class) // Assert
    public void test_BrokenWeapon_CantAttack() {
        // Arrange
        Axe axe = new Axe(10, 0);
        Dummy dummy = new Dummy(20, 10);

        // Assert that the axe is broken
        assertEquals(0, axe.getDurabilityPoints());

        // Act
        axe.attack(dummy);
    }
}