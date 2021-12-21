package me.lythox.main.util;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.material.Directional;
// import org.bukkit.material.MaterialData;


public class Stair extends MaterialData implements Directional {
    public Stair(Material type) {
        super(type);
    }


    public Stair(Material type, byte data) {
        super(type, data);
    }


    public BlockFace getAscendingDirection() {
        byte data = this.getData();

        switch(data & 3) {
            case 0:
            default:
                return BlockFace.EAST;

            case 1:
                return BlockFace.WEST;

            case 2:
                return BlockFace.SOUTH;

            case 3:
                return BlockFace.NORTH;
        }
    }




    public BlockFace getDescendingDirection() {
        return this.getAscendingDirection().getOppositeFace();
    }


    public BlockFace getFacing() {
        return this.getDescendingDirection();
    }






    public boolean isInverted() {
        return (this.getData() & 4) != 0;
    }


    public void setInverted(boolean inv) {
        int dat = this.getData() & 3;
        if (inv) {
           dat |= 4;
        }
        this.setData((byte)dat);
    }


    public String toString() {
        return super.toString() + " facing " + this.getFacing() + (this.isInverted() ? " inverted" : "");
    }


    public Stair clone() {
        return (Stair)super.clone();
    }


    public void setFacingDirection(BlockFace var1) {
        try {
            throw new Exception("This method does not work and is not supposed to be used");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
