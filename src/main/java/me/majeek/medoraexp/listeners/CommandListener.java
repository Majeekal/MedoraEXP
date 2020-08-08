package me.majeek.medoraexp.listeners;

import me.majeek.medoraexp.MedoraEXP;
import me.majeek.medoraexp.commands.Medora;

public class CommandListener implements Listener {
    private MedoraEXP instance;

    public CommandListener(MedoraEXP instance){
        this.instance = instance;
    }

    public void register(){
        instance.getCommand("medora").setExecutor(new Medora(instance));
    }
}
