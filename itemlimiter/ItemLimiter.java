package itemlimiter;

import itemlimiter.handler.InternalListener;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemLimiter extends JavaPlugin {

    private ItemLimiterConfig c;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        c = new ItemLimiterConfig(getConfig());
        getServer().getPluginManager().registerEvents(new InternalListener(c), this);
    }
}
