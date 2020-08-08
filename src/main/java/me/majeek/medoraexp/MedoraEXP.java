package me.majeek.medoraexp;

import me.majeek.medoraexp.listeners.CommandListener;
import me.majeek.medoraexp.listeners.EventListener;
import me.majeek.medoraexp.managers.ConfigManager;
import me.majeek.medoraexp.managers.ExpManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MedoraEXP extends JavaPlugin {
    private MedoraEXP instance;

    private ConfigManager configManager;
    private ExpManager expManager;

    private CommandListener commandListener;
    private EventListener eventListener;

    @Override
    public void onEnable() {
        // Initialize
        this.instance = this;

        // Configs
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        // Managers
        this.configManager = new ConfigManager(this);
        this.expManager = new ExpManager(this);

        // Listeners
        this.commandListener = new CommandListener(this);
        this.eventListener = new EventListener(this);

        // Register Listeners
        this.commandListener.register();
        this.eventListener.register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public MedoraEXP getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public ExpManager getExpManager() {
        return expManager;
    }
}
