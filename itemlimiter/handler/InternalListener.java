package itemlimiter.handler;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import itemlimiter.ItemLimiterConfig;
import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InternalListener implements Listener {

    private ItemLimiterConfig c;

    public InternalListener(ItemLimiterConfig c) {
        this.c = c;
    }

    @EventHandler
    public void itemSpawn(EntityAddToWorldEvent e) {
        EntityType type = e.getEntityType();
        if (type != EntityType.DROPPED_ITEM) {
            return;
        }
        Entity item = e.getEntity();
        Chunk itemChunk = item.getChunk();
        int itemCount = getItemsCount(itemChunk);
        if (itemCount >= c.getMaxItemCount()) {
            item.remove();
        }
    }

    private int getItemsCount(Chunk chunk) {
        int count = 0;
        for (Entity entity : chunk.getEntities()) {
            if (entity.getType() == EntityType.DROPPED_ITEM) {
                count++;
            }
        }
        return count;
    }
}
