package me.lythox.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.lythox.main.events.ClickEvents;
import me.lythox.main.util.Utils;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(Utils.color("[&aStairSit&r] Welcome to the StairSit plugin!"));

        this.getServer().getPluginManager().registerEvents(this,this);
        new ClickEvents(this);
    }

}
