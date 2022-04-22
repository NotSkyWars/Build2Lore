package de.byteroyal.main;

import de.byteroyal.commands.createLore;
import de.byteroyal.commands.getBlocks;
import de.byteroyal.commands.getTool;
import de.byteroyal.listeners.Interact;
import de.byteroyal.listeners.Join;
import de.byteroyal.logger.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Main extends JavaPlugin {

    private String prefix = "§5B2L §8| ";
    private HashMap<Player, List<Location>> positions;
    private static Main instance;


    @Override
    public void onEnable() {
        instance = this;
        this.positions = new HashMap<>();
        innit();
        for(Player player : Bukkit.getOnlinePlayers()){
            if(!getPositions().containsKey(player)){
                List<Location> list = new ArrayList<>();
                list.add(player.getLocation());
                list.add(player.getLocation());
                getPositions().put(player,list);
            }
        }
    }

    private void innit() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new Interact(),this);
        manager.registerEvents(new Join(),this);
        manager.registerEvents(new getBlocks(),this);

        getCommand("getTool").setExecutor(new getTool());
        getCommand("getTool").setDescription("Will give you the tools to mark your artwork!");

        getCommand("addLore").setExecutor(new createLore());
        getCommand("addLore").setDescription("Will set the current artwork as a lore onto your item!");

        getCommand("getBlocks").setExecutor(new getBlocks());

        System.out.println(Logger.OMLINE.getLogger());

    }

    @Override
    public void onDisable() {
        System.out.println(Logger.OFFLINE.getLogger());
    }

    public String getPrefix() {
        return prefix;
    }
    public static Main getInstance() {
        return instance;
    }

    public HashMap<Player, List<Location>> getPositions() {
        return positions;
    }
}
