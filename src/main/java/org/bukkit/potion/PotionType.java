package org.bukkit.potion;

public enum PotionType {
    WATER(0, null, 0),
    REGEN(1, PotionEffectType.REGENERATION, 2),
    SPEED(2, PotionEffectType.SPEED, 2),
    FIRE_RESISTANCE(3, PotionEffectType.FIRE_RESISTANCE, 1),
    POISON(4, PotionEffectType.POISON, 2),
    INSTANT_HEAL(5, PotionEffectType.HEAL, 2),
    NIGHT_VISION(6, PotionEffectType.NIGHT_VISION, 1),
    WEAKNESS(8, PotionEffectType.WEAKNESS, 1),
    STRENGTH(9, PotionEffectType.INCREASE_DAMAGE, 2),
    SLOWNESS(10, PotionEffectType.SLOW, 1),
    //JUMP(11, PotionEffectType.JUMP, 2),
    //INSTANT_DAMAGE(12, PotionEffectType.HARM, 2),
    WATER_BREATHING(11, PotionEffectType.WATER_BREATHING, 1),
    INVISIBILITY(12, PotionEffectType.INVISIBILITY, 1),
    FAST_DIGGING(13, PotionEffectType.FAST_DIGGING, 1),
    RESISTANCE(14, PotionEffectType.DAMAGE_RESISTANCE, 1),
    FALL(15, PotionEffectType.FALL, 1),
    ANVIL(16, PotionEffectType.ANVIL, 1),
    ABSORPTION(17, PotionEffectType.ABSORPTION, 1),
   // ANVIL(18, PotionEffectType.ANVIL, 1),
    ;

    private final int damageValue, maxLevel;
    private final PotionEffectType effect;

    PotionType(int damageValue, PotionEffectType effect, int maxLevel) {
        this.damageValue = damageValue;
        this.effect = effect;
        this.maxLevel = maxLevel;
    }

    public PotionEffectType getEffectType() {
        return effect;
    }

    /**
     *
     * @return the damage value
     * @deprecated Magic value
     */
    @Deprecated
    public int getDamageValue() {
        return damageValue;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public boolean isInstant() {
        return effect == null ? true : effect.isInstant();
    }

    /**
     *
     * @param damage the damage value
     * @return the matching potion type or null
     * @deprecated Magic value
     */
    @Deprecated
    public static PotionType getByDamageValue(int damage) {
        for (PotionType type : PotionType.values()) {
            if (type.damageValue == damage)
                return type;
        }
        return null;
    }

    public static PotionType getByEffect(PotionEffectType effectType) {
        if (effectType == null)
            return WATER;
        for (PotionType type : PotionType.values()) {
            if (effectType.equals(type.effect))
                return type;
        }
        return null;
    }
}
