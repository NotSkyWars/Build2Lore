package de.byteroyal.listeners;

import de.byteroyal.main.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Join implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!Main.getInstance().getPositions().containsKey(player)){
            List<Location> list = new ArrayList<>();
            list.add(player.getLocation());
            list.add(player.getLocation());
            Main.getInstance().getPositions().put(player,list);
        }

    }
}
