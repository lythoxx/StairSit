package me.lythox.main.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import me.lythox.main.Main;
import me.lythox.main.util.Stair;

public class ClickEvents implements Listener {
    private Main plugin;

    public ClickEvents(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onStairClick(PlayerInteractEvent e) {

        Material[] stairs = { Material.STONE_STAIRS, Material.SPRUCE_STAIRS, Material.OAK_STAIRS, Material.BIRCH_STAIRS,
                Material.BRICK_STAIRS, Material.ACACIA_STAIRS, Material.JUNGLE_STAIRS, Material.PURPUR_STAIRS,
                Material.QUARTZ_STAIRS, Material.WARPED_STAIRS, Material.STONE_BRICK_STAIRS, Material.CRIMSON_STAIRS,
                Material.DIORITE_STAIRS, Material.GRANITE_STAIRS, Material.ANDESITE_STAIRS, Material.DARK_OAK_STAIRS,
                Material.COBBLESTONE_STAIRS, Material.SANDSTONE_STAIRS, Material.BLACKSTONE_STAIRS,
                Material.CUT_COPPER_STAIRS, Material.PRISMARINE_STAIRS, Material.NETHER_BRICK_STAIRS,
                Material.RED_SANDSTONE_STAIRS, Material.SMOOTH_QUARTZ_STAIRS, Material.DEEPSLATE_TILE_STAIRS,
                Material.END_STONE_BRICK_STAIRS, Material.DARK_PRISMARINE_STAIRS, Material.DEEPSLATE_BRICK_STAIRS,
                Material.END_STONE_BRICK_STAIRS, Material.SMOOTH_SANDSTONE_STAIRS, Material.POLISHED_DIORITE_STAIRS,
                Material.POLISHED_GRANITE_STAIRS, Material.PRISMARINE_BRICK_STAIRS, Material.RED_NETHER_BRICK_STAIRS,
                Material.WAXED_CUT_COPPER_STAIRS, Material.MOSSY_STONE_BRICK_STAIRS, Material.COBBLED_DEEPSLATE_STAIRS,
                Material.MOSSY_COBBLESTONE_STAIRS, Material.POLISHED_ANDESITE_STAIRS,
                Material.EXPOSED_CUT_COPPER_STAIRS, Material.POLISHED_DEEPSLATE_STAIRS,
                Material.OXIDIZED_CUT_COPPER_STAIRS, Material.POLISHED_BLACKSTONE_STAIRS,
                Material.SMOOTH_RED_SANDSTONE_STAIRS, Material.WEATHERED_CUT_COPPER_STAIRS,
                Material.WAXED_EXPOSED_CUT_COPPER_STAIRS, Material.POLISHED_BLACKSTONE_BRICK_STAIRS,
                Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS, Material.WAXED_WEATHERED_CUT_COPPER_STAIRS };

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && !e.getPlayer().isSneaking() && !(e.getBlockFace() == BlockFace.DOWN)) {
            for (Material block : stairs) {
                if (e.getClickedBlock().getType() == block) {
                    Stair stair = new Stair(e.getClickedBlock().getType());
                    Location pLocation = e.getPlayer().getLocation();
                    Arrow arrow;
                    switch (stair.getDescendingDirection()) {
                        case DOWN:
                            break;
                        case EAST:
                            arrow = e.getPlayer().getWorld().spawnArrow(e.getClickedBlock().getLocation().add(0.5,0,0.5), new Vector(1,1,1), 0, 0);
                            arrow.setSilent(true);
                            arrow.addPassenger(e.getPlayer());
                            pLocation.setYaw(180);
                            break;
                        case NORTH:
                            arrow = e.getPlayer().getWorld().spawnArrow(e.getClickedBlock().getLocation().add(0.5,0,0.5), new Vector(1,1,1), 0, 0);
                            arrow.setSilent(true);
                            arrow.addPassenger(e.getPlayer());
                            pLocation.setYaw(90);
                            break;
                        case SOUTH:
                            arrow = e.getPlayer().getWorld().spawnArrow(e.getClickedBlock().getLocation().add(0.5,0,0.5), new Vector(1,1,1), 0, 0);
                            arrow.setSilent(true);
                            arrow.addPassenger(e.getPlayer());
                            pLocation.setYaw(270);
                            break;
                        case WEST:
                            arrow = e.getPlayer().getWorld().spawnArrow(e.getClickedBlock().getLocation().add(0.5,0,0.5), new Vector(1,1,1), 0, 0);
                            arrow.setSilent(true);
                            arrow.addPassenger(e.getPlayer());
                            pLocation.setYaw(0);
                            break;
                        default:
                            break;

                    }

                } else {
                    continue;
                }
            }
        } else {
            System.out.println("nop");
        }
    }

}