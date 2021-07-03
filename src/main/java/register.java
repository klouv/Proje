import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class register implements CommandExecutor {


    private final Map<Integer, ItemStack> storage;
    private final Main main;
    private final ConfigFile config;

    public register(ConfigFile config, Main main) {
        this.main = main;
        this.config = config;

        this.storage = main.storage;

    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equals("registermenu")) {

            if (sender instanceof Player) {
                if (args.length != 0) {
                    int slot = Integer.parseInt(args[0]);
                    Player player = (Player) sender;
                    ItemStack item = player.getItemInHand();
                    storage.put(slot, item);
                    player.sendMessage("eşya: " + item.getType().name());
                    player.sendMessage("slot: " + slot);
                }
                if (args.length == 0) {
                    sender.sendMessage("you need argument");

                }

            }
        }
        return true;
    }
}