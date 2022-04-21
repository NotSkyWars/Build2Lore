package de.byteroyal.commands;

import de.byteroyal.itembuilder.ItemBuilder;
import de.byteroyal.main.Main;
import de.byteroyal.utils.Block2Color;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class createLore implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("B2L.create")) {
                if (player.getItemInHand() != null) {
                    HashMap<Player, List<Location>> positions = Main.getInstance().getPositions();
                    List<Location> locations = positions.get(player);
                    Location pos1 = locations.get(0);
                    Location pos2 = locations.get(1);

                    int xmax;
                    int xmin;

                    int zmax;
                    int zmin;
                    if (pos1.getBlockX() > pos2.getX()) {
                        xmax = pos1.getBlockX();
                        xmin = pos2.getBlockX();
                    } else {
                        xmax = pos2.getBlockX();
                        xmin = pos1.getBlockX();
                    }
                    if (pos1.getBlockZ() > pos2.getZ()) {
                        zmax = pos1.getBlockZ();
                        zmin = pos2.getBlockZ();
                    } else {
                        zmax = pos2.getBlockZ();
                        zmin = pos1.getBlockZ();
                    }

                    List<String> lore = new ArrayList<>();
                    for (int x = xmin; x <= xmax; x++) {
                        String line = "";
                        for (int z = zmax; z >= zmin; z--) {
                            Block block = player.getWorld().getBlockAt(x, pos1.getBlockY(), z);
                            line += Block2Color.valueOf(block.getType().name() + "_" + block.getData()).getCode() + "§l⬛";
                        }
                        lore.add(line);
                    }

                    ItemStack itemStack = player.getItemInHand();
                    ItemMeta meta = itemStack.getItemMeta();

                    if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore()) {
                        List<String> lr = meta.getLore();
                        for (String s1 : lore) {
                            lr.add(s1);
                        }
                        meta.setLore(lr);
                    } else {
                        meta.setLore(lore);
                    }

                    itemStack.setItemMeta(meta);

                }
            }
        }
        return false;
    }
}
