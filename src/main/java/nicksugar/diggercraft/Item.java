package nicksugar.diggercraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
    public static ItemStack NewPickaxe(int count,String name){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE,count);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}
