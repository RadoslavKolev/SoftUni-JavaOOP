package exercise.playersAndMonsters;

import exercise.playersAndMonsters.elfs.Elf;
import exercise.playersAndMonsters.elfs.MuseElf;
import exercise.playersAndMonsters.knights.BladeKnight;
import exercise.playersAndMonsters.knights.DarkKnight;
import exercise.playersAndMonsters.knights.Knight;
import exercise.playersAndMonsters.wizards.DarkWizard;
import exercise.playersAndMonsters.wizards.SoulMaster;
import exercise.playersAndMonsters.wizards.Wizard;

public class Main {
    public static void main(String[] args) {
        Elf elf = new Elf("Elf", 10);
        Wizard wizard = new Wizard("Wizard", 15);
        Knight knight = new Knight("Knight", 25);

        MuseElf museElf = new MuseElf("MuseElf", 14);
        DarkWizard darkWizard = new DarkWizard("DarkWizard", 34);
        DarkKnight darkKnight = new DarkKnight("DarkKnight", 50);

        SoulMaster soulMaster = new SoulMaster("SoulMaster", 90);
        BladeKnight bladeKnight = new BladeKnight("BladeKnight", 90);

        System.out.println(elf);
        System.out.println(wizard);
        System.out.println(knight);
        System.out.println(museElf);
        System.out.println(darkWizard);
        System.out.println(darkKnight);
        System.out.println(soulMaster);
        System.out.println(bladeKnight);
    }
}
