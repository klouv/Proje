import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin implements Listener {

    public final Map<Integer, ItemStack> storage = new HashMap<>();
    private ConfigFile config;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("menu").setExecutor(new Menu(config, this));
        getCommand("registermenu").setExecutor(new register(config, this));

        config = new ConfigFile(this, "config");
        config.getKeys(false).forEach((key) -> {
            int slot = Integer.parseInt(key);
            storage.put(slot, config.getItemStack(key));
        });

    }

    @Override
    public void onDisable() {
        storage.forEach((slot, item) -> config.set(slot.toString(), item));

        config.save();
    }


}
