package me.majeek.medoraexp.commands;

import me.majeek.medoraexp.MedoraEXP;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help implements Command {
    private MedoraEXP instance;

    public Help(MedoraEXP instance){
        this.instance = instance;
    }

    public void execute(Player player) {
        player.sendMessage(ChatColor.GRAY + "--------------" + " " + instance.getConfigManager().getChatPrefix() + " " + ChatColor.GRAY +  "-------------------");
        player.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/medora help" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Displays this.");
        player.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/medora reload" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Reloads the config file.");
    }
}
