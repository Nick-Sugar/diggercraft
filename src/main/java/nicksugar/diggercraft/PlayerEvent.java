package nicksugar.diggercraft;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

import static nicksugar.diggercraft.Item.NewPickaxe;
import static org.bukkit.Bukkit.getLogger;


public class PlayerEvent implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // ログインしたプレイヤーにようこそメッセージを表示する
        player.sendMessage("ようこそテストサーバーへ！");
        Inventory inv = player.getInventory();
        inv.addItem(NewPickaxe(1, ChatColor.GOLD + "少し平凡じゃないつるはし"));
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // event変数からプレイヤーを取得
        Player player = event.getPlayer();
        // プレイヤーの位置を取得
        Location location = player.getLocation();
        // 足元のブロックを取得(その位置からy座標をマイナス1)
        Block block = location.add(0, -1, 0).getBlock();
        // そのブロックが空気ブロックでなければ
        if (block.getType() != Material.AIR) {
            // 赤の羊毛に変える
            block.setType(Material.RED_WOOL);
        }
    }
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
    // 手持ちのアイテムを取得
        ItemStack i = event.getPlayer().getItemInHand();
        // クリックしたブロックを取得
        Block block = event.getClickedBlock();
        // ブロックに対する右クリックか？
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // 対象は羊毛ブロックか？
            if (block.getType() != Material.GREEN_WOOL) {
                // 赤の羊毛に変える
                block.setType(Material.DIAMOND_BLOCK);
            }
        }
    }
    @EventHandler
    public void onPlayerBlockBreakEvent(BlockBreakEvent event) {
        Block block =event.getBlock();
        ItemStack handitem = event.getPlayer().getItemInHand();
        Player player = event.getPlayer();
        World world = player.getWorld();
        if(block.getType() == Material.RED_WOOL){
            event.setCancelled(true);
            block.setType(Material.STONE);
        }
        if(handitem.getItemMeta().getDisplayName() == "§6少し平凡じゃないつるはし"){
            world.getBlockAt(block.getX()+1,block.getY()+0,block.getZ()+0).breakNaturally(handitem);
            getLogger().info("block is :"+event.getPlayer());
        }
    }
}
