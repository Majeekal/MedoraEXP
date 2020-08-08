package me.majeek.medoraexp.listeners;

import me.majeek.medoraexp.MedoraEXP;
import me.majeek.medoraexp.events.BlockBreak;

public class EventListener implements Listener {
    private MedoraEXP instance;

    public EventListener(MedoraEXP instance){
        this.instance = instance;
    }

    public void register(){
        instance.getServer().getPluginManager().registerEvents(new BlockBreak(instance), instance);
    }
}
