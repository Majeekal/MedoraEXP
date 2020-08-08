package me.majeek.medoraexp.commands;

import me.majeek.medoraexp.MedoraEXP;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Reload implements Command {
    private MedoraEXP instance;

    public Reload(MedoraEXP instance){
        this.instance = instance;
    }

    public void execute(Player player) {
        instance.reloadConfig();
        player.sendMessage(instance.getConfigManager().getChatPrefix() + " " + ChatColor.GREEN + "Config reloaded.");
    }
}
