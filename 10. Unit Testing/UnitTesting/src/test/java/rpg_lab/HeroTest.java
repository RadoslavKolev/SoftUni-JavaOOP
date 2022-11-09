package rpg_lab;

import org.junit.Test;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import static org.junit.Assert.*;

public class HeroTest {
    private static final int INITIAL_XP = 0;
    private static final int TARGET_XP = 10;
    private static final int ATTACK_POINTS = 10;
    private static final String HERO_NAME = "Ivan";

    // Anonymous class instance of target, just to fake giveExperience() and isDead()
    Target fakeTarget = new Target() {
        @Override
        public int getHealth() { return 0; }

        @Override
        public void takeAttack(int attackPoints) {}

        @Override
        public int giveExperience() {
            return 10;
        }

        @Override
        public boolean isDead() {
            return true;
        }
    };

    // Anonymous class instance of weapon
    Weapon fakeWeapon = new Weapon() {
        @Override
        public int getAttackPoints() {
            return ATTACK_POINTS;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {

        }
    };

    @Test
    public void test_HeroGainsXP_WhenKillingTarget() {
        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        assertEquals(INITIAL_XP, hero.getExperience());

        hero.attack(fakeTarget);
        assertEquals(TARGET_XP, hero.getExperience());
    }
}