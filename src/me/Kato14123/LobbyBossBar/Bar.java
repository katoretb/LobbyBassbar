package me.Kato14123.LobbyBossBar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class Bar {
	@SuppressWarnings("unused")
	private int taskID = -1;
	private final Main plugin;
	private BossBar bar;
	
	public Bar(Main plugin) {
		this.plugin = plugin;
	}
	
	public void addPlayer(Player player) {
		bar.addPlayer(player);
	}
	
	public BossBar getBar() {
		return bar;
	}
	
	public void createBar() {
		bar = Bukkit.createBossBar(format("&fmylove-network.net"), BarColor.WHITE, BarStyle.SOLID);
		bar.setVisible(true);
		cast();
	}
	
	public void cast() {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			int count = -1;
			double progress = 1.0;
			double time = 1.0/10;
			
			@Override
			public void run() {
				bar.setProgress(1.0);
				switch(count) {
				case -1:
					break;
				case 0:
					bar.setTitle(format("&fmylove-network.net"));
					bar.setColor(BarColor.PINK);
					break;
				case 1:
					bar.setColor(BarColor.RED);
					break;
				case 2:
					bar.setColor(BarColor.YELLOW);
					break;
				case 3:
					bar.setColor(BarColor.GREEN);
					break;
				case 4:
					bar.setColor(BarColor.BLUE);
					break;
				case 5:
				default:
					bar.setColor(BarColor.PURPLE);
					count = -1;
					break;
				}
				progress = progress - time;
			    if(progress <= 0) {
			    	progress = 1.0;
			    	count++;
			    }
			}
			
		}, 0, 0);
	}
	
	private String format(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}