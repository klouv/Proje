import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class Menu implements CommandExecutor {


    private final Main main;
    private final ConfigFile config;
    private final Map<Integer, ItemStack> storage;

    public Menu(ConfigFile config, Main main) {
        this.config = config;
        this.main = main;

        this.storage = main.storage;
    }
    Inventory menu = Bukkit.createInventory(null, 27, "menu");
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equals("menu")) {
            if(sender instanceof Player) {

                Player player = (Player) sender;
                int size = menu.getSize();

                for (int i=0;i<size;i++) {
                    menu.setItem(i, storage.get(i));
                }

                player.openInventory(menu);


            }
        }





        return true;
    }
}
