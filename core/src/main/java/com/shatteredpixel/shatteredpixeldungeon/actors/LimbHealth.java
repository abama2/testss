package com.shatteredpixel.shatteredpixeldungeon.actors;

import com.watabou.utils.Bundle;

public class LimbHealth {
    public static class Limb {
        public int HP;  // Текущее здоровье конечности
        public int HT;  // Максимальное здоровье конечности

        public Limb(int maxHealth) {
            HT = maxHealth;
            HP = maxHealth;
        }
    }

    public Limb head;
    public Limb torso;
    public Limb leftArm;
    public Limb rightArm;
    public Limb legs;

    public LimbHealth(int headHT, int torsoHT, int armHT, int legHT) {
        head = new Limb(headHT);
        torso = new Limb(torsoHT);
        leftArm = new Limb(armHT);
        rightArm = new Limb(armHT);
        legs = new Limb(legHT);
    }

    // Проверка, жив ли персонаж (например, если торс или голова достигли 0)
    public boolean isAlive() {
        return torso.HP > 0 && head.HP > 0;
    }

    // Сохранение состояния в Bundle (для сохранения игры)
    public void storeInBundle(Bundle bundle) {
        bundle.put("head_hp", head.HP);
        bundle.put("torso_hp", torso.HP);
        bundle.put("left_arm_hp", leftArm.HP);
        bundle.put("right_arm_hp", rightArm.HP);
        bundle.put("legs_hp", legs.HP);
    }

    // Восстановление состояния из Bundle
    public void restoreFromBundle(Bundle bundle) {
        head.HP = bundle.getInt("head_hp");
        torso.HP = bundle.getInt("torso_hp");
        leftArm.HP = bundle.getInt("left_arm_hp");
        rightArm.HP = bundle.getInt("right_arm_hp");
        legs.HP = bundle.getInt("legs_hp");
    }
}