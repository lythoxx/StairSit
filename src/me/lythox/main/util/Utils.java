package me.lythox.main.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String decolor(String s) {
        return ChatColor.stripColor(color(s));
    }

    public static void msgPlayer(Player p, String... strings) {
        for (String s : strings) {
            p.sendMessage(color(s));
        }
    }

}