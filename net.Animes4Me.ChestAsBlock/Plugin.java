package net.Animes4Me.ChestAsBlock;
	import java.util.Arrays;
	import java.util.List;
	import org.bukkit.ChatColor;
	import org.bukkit.command.Command;
	import org.bukkit.command.CommandSender;
	import org.bukkit.configuration.file.FileConfiguration;
	import org.bukkit.plugin.java.JavaPlugin;
	
	public class Plugin extends JavaPlugin {
		protected FileConfiguration config;
		protected CmdExecutor cmd_executor;
		protected EventManager event_manager;
		
		public void onEnable(){
			loadConfig();		
			cmd_executor = new CmdExecutor(this);
			event_manager = new EventManager(this);
		}
		
		@Override
	    	public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	        	if (args.length == 1 && sender.hasPermission("cab.cmd.help")) {
	        		return Arrays.asList("help","create","open","info","remove","random","reload","reset","disable");
	        	}
			return null;
		}
		
		protected void loadConfig(){
			config = getConfig();
			config.options().copyDefaults(true);
			saveConfig();
		}
		
		protected String getMessage(String path) {
			return ChatColor.translateAlternateColorCodes('&', config.getString("messages.prefix") + config.getString(path));
		}

		public void disable() {
			setEnabled(false);
		}		

	}
