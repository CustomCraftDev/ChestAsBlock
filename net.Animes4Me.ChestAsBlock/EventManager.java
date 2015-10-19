package net.Animes4Me.ChestAsBlock;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.player.PlayerInteractEvent;

	public class EventManager implements Listener {
		private Plugin plugin;
		
		public EventManager(Plugin plugin) {
			this.plugin = plugin;
			plugin.getServer().getPluginManager().registerEvents(this, plugin);
		}
		
		@EventHandler
		public void onRightClick(PlayerInteractEvent e){
			
		}
		
	
	}
