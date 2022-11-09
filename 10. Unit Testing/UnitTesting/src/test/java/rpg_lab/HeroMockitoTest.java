package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import static org.junit.Assert.assertEquals;

public class HeroMockitoTest {
    private static final int INITIAL_XP = 0;
    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "Ivan";

    @Test
    public void test_HeroGainsXP_WhenKillingTarget() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        assertEquals(INITIAL_XP, hero.getExperience());

        hero.attack(targetMock);
        assertEquals(TARGET_XP, hero.getExperience());
    }
}
