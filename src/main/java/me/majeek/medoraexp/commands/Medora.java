package me.majeek.medoraexp.commands;

import me.majeek.medoraexp.MedoraEXP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Medora implements CommandExecutor {
    private MedoraEXP instance;

    public Medora(MedoraEXP instance){
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 0 || args[0].equalsIgnoreCase("help") && (player.hasPermission("medora.help") || player.isOp())){
                new Help(instance).execute(player);
            } else if(args[0].equalsIgnoreCase("reload") && (player.hasPermission("medora.reload") || player.isOp())){
                new Reload(instance).execute(player);
            } else{
                player.sendMessage("Unknown command. Type \"/help\" for help.");
            }
        }

        return false;
    }
}
