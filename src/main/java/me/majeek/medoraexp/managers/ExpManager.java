package me.majeek.medoraexp.managers;

import me.majeek.medoraexp.MedoraEXP;
import org.bukkit.entity.Player;

public class ExpManager {
    private MedoraEXP instance;

    public ExpManager(MedoraEXP instance){
        this.instance = instance;
    }

    // Essentials code for handling xp

    public int getTotalExperience(Player player) {
        int exp = Math.round(getExpAtLevel(player) * player.getExp());
        int currentLevel = player.getLevel();

        while (currentLevel > 0) {
            currentLevel--;
            exp += getExpAtLevel(currentLevel);
        }
        if (exp < 0) {
            exp = Integer.MAX_VALUE;
        }
        return exp;
    }

    public void setTotalExperience(Player player, int xp) {
        player.setExp(0);
        player.setLevel(0);
        player.setTotalExperience(0);

        int amount = xp;
        while (amount > 0) {
            final int expToLevel = getExpAtLevel(player);

            amount -= expToLevel;
            if (amount >= 0) {
                player.giveExp(expToLevel);
            } else {
                amount += expToLevel;
                player.giveExp(amount);
                amount = 0;
            }
        }
    }

    private int getExpAtLevel(final Player player) {
        return getExpAtLevel(player.getLevel());
    }

    public int getExpAtLevel(final int level) {
        if (level <= 15) {
            return (2 * level) + 7;
        }
        if ((level >= 16) && (level <= 30)) {
            return (5 * level) - 38;
        }
        return (9 * level) - 158;
    }
}
