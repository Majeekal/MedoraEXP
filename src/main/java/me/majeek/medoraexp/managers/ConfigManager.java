package me.majeek.medoraexp.managers;

import me.majeek.medoraexp.MedoraEXP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    private MedoraEXP instance;

    public ConfigManager(MedoraEXP instance){
        this.instance = instance;
    }

    public int getExpPerBlock(){
        return instance.getConfig().getInt("exp-per-block");
    }

    public String getChatPrefix(){
        return ChatColor.translateAlternateColorCodes('&', instance.getConfig().getString("chat-prefix"));
    }

    public List<World> getWorlds(){
        List<World> worlds = new ArrayList<>();

        for(String world : instance.getConfig().getStringList("worlds")){
            if(Bukkit.getWorld(world) != null){
                worlds.add(Bukkit.getWorld(world));
            }
        }

        return worlds;
    }
}
