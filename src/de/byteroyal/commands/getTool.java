package de.byteroyal.commands;

import de.byteroyal.itembuilder.ItemBuilder;
import de.byteroyal.main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getTool implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("B2L.create")){
                player.getInventory().addItem(new ItemBuilder(Material.PRISMARINE_SHARD,1).setName("§cLore Tool").addLore("§cLEFT-CLICK §8| §7Adds first position!").addLore("§cRIGHT-CLICK §8| §7Adds second position!").build());
                player.sendMessage(Main.getInstance().getPrefix()+ "§cYou got the tool read its lore for more explanation!");
            }
        }
        return false;
    }
}
