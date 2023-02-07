package nicksugar.diggercraft;

import org.bukkit.plugin.java.JavaPlugin;

public final class Diggercraft extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Hello World!");
        getServer().getPluginManager().registerEvents(new PlayerEvent(),this);
        getServer().getPluginManager().registerEvents(new WorldEvent(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
