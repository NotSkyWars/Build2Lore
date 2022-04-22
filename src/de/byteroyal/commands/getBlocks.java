package de.byteroyal.commands;

import de.byteroyal.itembuilder.ItemBuilder;
import de.byteroyal.main.Main;
import de.byteroyal.utils.Block2Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class getBlocks implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("B2L.create")) {
                Inventory inventory = Bukkit.createInventory(null, 9 * 6, "§cLore Blocks");
                for (Block2Color block : Block2Color.values()) {
                    Material material;
                    Integer data;
                    if (block.name().contains("WOOL")) {
                        material = Material.WOOL;
                        data = Integer.valueOf(block.name().split("_")[1]);
                    } else {
                        material = Material.STAINED_CLAY;
                        data = Integer.valueOf(block.name().split("_")[2]);
                    }
                    inventory.addItem(new ItemBuilder(material, 1).setName(block.getCode() + "§l⬛").setSubid(data).build());
                }
                player.openInventory(inventory);
            }
        }
        return false;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory() != null && event.getCurrentItem() != null) {
            if(event.getInventory().getName().equalsIgnoreCase("§cLore Blocks")){
                event.getWhoClicked().getInventory().addItem(event.getCurrentItem());
                event.setCancelled(true);
            }
        }
    }
}
