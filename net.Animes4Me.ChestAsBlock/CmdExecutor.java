package net.Animes4Me.ChestAsBlock;
	import java.io.File;
	import org.bukkit.command.Command;
	import org.bukkit.command.CommandExecutor;
	import org.bukkit.command.CommandSender;
	import org.bukkit.command.ConsoleCommandSender;
	
	public class CmdExecutor implements CommandExecutor {
		private Plugin plugin;
		
		public CmdExecutor(Plugin plugin) {
			this.plugin = plugin;
			plugin.getCommand("cab").setExecutor(this);
		}
	
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
			if(args.length != 0){
				if(args[0].toLowerCase().equals("help")){
					if(sender.hasPermission("cab.cmd.help") || sender instanceof ConsoleCommandSender){
						help(sender);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}else if(args[0].toLowerCase().equals("create")){
					if(sender.hasPermission("cab.cmd.create") || sender instanceof ConsoleCommandSender){
						create(sender);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}else if(args[0].toLowerCase().equals("open")){
					if(sender.hasPermission("cab.cmd.open") || sender instanceof ConsoleCommandSender){
						open(sender, args);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}else if(args[0].toLowerCase().equals("info")){
					if(sender.hasPermission("cab.cmd.info") || sender instanceof ConsoleCommandSender){
						info(sender);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}else if(args[0].toLowerCase().equals("remove")){
					if(sender.hasPermission("cab.cmd.remove") || sender instanceof ConsoleCommandSender){
						remove(sender);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}else if(args[0].toLowerCase().equals("random")){
					if(sender.hasPermission("cab.cmd.random") || sender instanceof ConsoleCommandSender){
						random(sender);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}else if(args[0].toLowerCase().equals("reload")){
					if(sender.hasPermission("cab.cmd.reload") || sender instanceof ConsoleCommandSender){
						reload(sender);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}else if(args[0].toLowerCase().equals("reset")){
					if(sender.hasPermission("cab.cmd.reset") || sender instanceof ConsoleCommandSender){
						reset(sender);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}else if(args[0].toLowerCase().equals("disable")){
					if(sender.hasPermission("cab.cmd.disable") || sender instanceof ConsoleCommandSender){
						disable(sender);
					}else{
						sender.sendMessage(plugin.getMessage("messages.no_permission"));
					}
					return true;
				}
			}
			
			if(sender.hasPermission("cab.cmd.help") || sender instanceof ConsoleCommandSender){
				help(sender);
			}else{
				sender.sendMessage(plugin.getMessage("messages.no_permission"));
			}
			
			return true;
		}
		
		protected void create(CommandSender sender) {
			
		}
		
		protected void open(CommandSender sender, String[] args) {

		}
		
		protected void info(CommandSender sender) {

		}
		
		protected void remove(CommandSender sender) {

		}
		
		protected void random(CommandSender sender) {

		}
		
		protected void help(CommandSender sender) {

		}
	
		private void reload(CommandSender sender) {
			plugin.reloadConfig();
			plugin.loadConfig();
			
			sender.sendMessage(plugin.getMessage("messages.reload_config"));
		}
	
		private void reset(CommandSender sender) {
			plugin.config = null;
			File configFile = new File(plugin.getDataFolder(), "config.yml");
			configFile.delete();
			plugin.saveDefaultConfig();
			plugin.reloadConfig();
			plugin.loadConfig();
			
			sender.sendMessage(plugin.getMessage("messages.reset_config"));
		}
		
		protected void disable(CommandSender sender) {
			plugin.disable();
			plugin.getServer().broadcastMessage(plugin.getMessage("messages.plugin_disabled"));
		}
		
	}
