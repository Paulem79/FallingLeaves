package ovh.paulem.fallingleaves;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ovh.paulem.nms.NMSHandler;

public final class FallingLeaves extends JavaPlugin implements Listener {
  @Override
  public void onEnable() {
    getLogger().info("FallingLeaves has been enabled!");
    System.out.println(NMSHandler.getNmsImpl().getColor(Bukkit.getWorlds().get(0).getSpawnLocation()));
  }
}
