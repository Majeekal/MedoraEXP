package me.majeek.medoraexp.events;

import me.majeek.medoraexp.MedoraEXP;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    private MedoraEXP instance;

    public BlockBreak(MedoraEXP instance){
        this.instance = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event){
        for(World world : instance.getConfigManager().getWorlds()){
            if(world == event.getPlayer().getWorld()){
                event.setExpToDrop(instance.getConfigManager().getExpPerBlock());
            }
        }
    }
}
