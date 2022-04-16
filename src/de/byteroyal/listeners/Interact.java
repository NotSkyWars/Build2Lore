package de.byteroyal.listeners;

import de.byteroyal.itembuilder.ItemBuilder;
import de.byteroyal.main.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Interact implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getClickedBlock() != null) {
            if (event.getItem().isSimilar(new ItemBuilder(Material.PRISMARINE_SHARD, 1).setName("§cLore Tool").addLore("§cLEFT-CLICK §8| §7Adds first position!").addLore("§cRIGHT-CLICK §8| §7Adds second position!").build())) {
                Player player = event.getPlayer();
                HashMap<Player, List<Location>> positions = Main.getInstance().getPositions();

                if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    List<Location> locations = positions.get(player);
                    locations.set(0, event.getClickedBlock().getLocation());
                    positions.put(player, locations);
                    player.sendMessage(Main.getInstance().getPrefix() + "§7Set position 1!");
                } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    List<Location> locations = positions.get(player);
                    locations.set(1, event.getClickedBlock().getLocation());
                    positions.put(player, locations);
                    player.sendMessage(Main.getInstance().getPrefix() + "§7Set position 2!");
                }
                event.setCancelled(true);
            }
        }
    }
}
