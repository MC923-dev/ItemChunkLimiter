package itemlimiter;

import org.bukkit.configuration.ConfigurationSection;

public class ItemLimiterConfig {

    private int maxItemCount;

    public ItemLimiterConfig(ConfigurationSection cs) {
        maxItemCount = cs.getInt("maxItemCount");
    }

    public int getMaxItemCount() {
        return maxItemCount;
    }
}
