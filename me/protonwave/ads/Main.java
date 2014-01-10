package me.protonwave.ads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Timer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {

	public boolean duelOff = true;
	public boolean challengeOff = true;
	public boolean winP, cd = false;
	public int delay = 60000;
	public int delay2 = 10000;
	public int s, min;
	public int cooldown = 60;
	public Player player;
	public Player target;
	public Player op;
	public Player winner;
	public Timer timer, afterWinning, seconds;
	public Collection<PotionEffect> potionsP;
	public Location entryP = null;
	public Collection<PotionEffect> potionsT;
	public Location entryT = null;
	public GameMode modeP = null;
	public GameMode modeT = null;
	public double healthP;
	public int foodP, fireP;
	public double healthT;
	public int foodT, fireT;

	public void onEnable() {
		Bukkit.getServer().getLogger()
				.info("Arena Duel System has been enabled.");
		getServer().getPluginManager().registerEvents(this, this);
		s = cooldown;
	}

	public void onDisable() {

		Bukkit.getServer().getLogger()
				.info("Arena Duel System has been disabled.");

	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if (event.getEntity() == player) {
			if (duelOff == false) {

				Bukkit.getServer().broadcastMessage(
						target.getName() + " " + ChatColor.DARK_AQUA + "has "
								+ ChatColor.DARK_RED + "Defeated "
								+ ChatColor.RESET + player.getName()
								+ ChatColor.DARK_AQUA + " in an Arena Duel!");
				winner = target;
				winP = false;
				player = null;
				target = null;

				winner.setFoodLevel(20);
				((CraftPlayer) winner).setHealth(20);
				winner.setFireTicks(0);

				winner.removePotionEffect(PotionEffectType.SPEED);
				winner.removePotionEffect(PotionEffectType.SLOW);
				winner.removePotionEffect(PotionEffectType.FAST_DIGGING);
				winner.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				winner.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				winner.removePotionEffect(PotionEffectType.JUMP);
				winner.removePotionEffect(PotionEffectType.CONFUSION);
				winner.removePotionEffect(PotionEffectType.REGENERATION);
				winner.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				winner.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				winner.removePotionEffect(PotionEffectType.WATER_BREATHING);
				winner.removePotionEffect(PotionEffectType.INVISIBILITY);
				winner.removePotionEffect(PotionEffectType.BLINDNESS);
				winner.removePotionEffect(PotionEffectType.NIGHT_VISION);
				winner.removePotionEffect(PotionEffectType.HUNGER);
				winner.removePotionEffect(PotionEffectType.WEAKNESS);
				winner.removePotionEffect(PotionEffectType.POISON);
				winner.removePotionEffect(PotionEffectType.WITHER);
				winner.removePotionEffect(PotionEffectType.HEALTH_BOOST);
				winner.removePotionEffect(PotionEffectType.ABSORPTION);
				winner.removePotionEffect(PotionEffectType.SATURATION);

				afterWinning = new Timer(delay2, afterDuel);
				afterWinning.start();

				winner.sendMessage(ChatColor.GREEN + "Congratulations! "
						+ ChatColor.DARK_AQUA
						+ "You will be teleported back in "
						+ ChatColor.DARK_RED + delay2 / 1000 + " seconds.");

				seconds = new Timer(1000, secondCounter);
				seconds.start();
				cd = true;
			}
		}
		if (event.getEntity() == target) {
			if (duelOff == false) {

				Bukkit.getServer().broadcastMessage(
						player.getName() + " " + ChatColor.DARK_AQUA + "has "
								+ ChatColor.DARK_RED + "Defeated "
								+ ChatColor.RESET + target.getName()
								+ ChatColor.DARK_AQUA + " in an Arena Duel!");
				winner = player;
				winP = true;
				player = null;
				target = null;

				winner.setFoodLevel(20);
				((CraftPlayer) winner).setHealth(20);
				winner.setFireTicks(0);

				winner.removePotionEffect(PotionEffectType.SPEED);
				winner.removePotionEffect(PotionEffectType.SLOW);
				winner.removePotionEffect(PotionEffectType.FAST_DIGGING);
				winner.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				winner.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				winner.removePotionEffect(PotionEffectType.JUMP);
				winner.removePotionEffect(PotionEffectType.CONFUSION);
				winner.removePotionEffect(PotionEffectType.REGENERATION);
				winner.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				winner.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				winner.removePotionEffect(PotionEffectType.WATER_BREATHING);
				winner.removePotionEffect(PotionEffectType.INVISIBILITY);
				winner.removePotionEffect(PotionEffectType.BLINDNESS);
				winner.removePotionEffect(PotionEffectType.NIGHT_VISION);
				winner.removePotionEffect(PotionEffectType.HUNGER);
				winner.removePotionEffect(PotionEffectType.WEAKNESS);
				winner.removePotionEffect(PotionEffectType.POISON);
				winner.removePotionEffect(PotionEffectType.WITHER);
				winner.removePotionEffect(PotionEffectType.HEALTH_BOOST);
				winner.removePotionEffect(PotionEffectType.ABSORPTION);
				winner.removePotionEffect(PotionEffectType.SATURATION);

				afterWinning = new Timer(delay2, afterDuel);
				afterWinning.start();

				winner.sendMessage(ChatColor.GREEN + "Congratulations! "
						+ ChatColor.DARK_AQUA
						+ "You will be teleported back in "
						+ ChatColor.DARK_RED + delay2 / 1000 + " seconds.");
				seconds = new Timer(1000, secondCounter);
				seconds.start();
				cd = true;
			}
		}

	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.DARK_RED
					+ "Arena Duel System can't be used from the console!");
			return true;
		}

		else {

			if (cmd.getName().equalsIgnoreCase("duel")) {
				if (duelOff) {
					if (getConfig().getConfigurationSection("duel1") == null
							|| getConfig().getConfigurationSection("duel2") == null) {
						sender.sendMessage(ChatColor.RED
								+ "The Duels Haven't been set up yet.");
						return true;
					}

					if (getConfig().getConfigurationSection("duel1") != null
							&& getConfig().getConfigurationSection("duel2") != null) {
						if (cd == false) {
							if (challengeOff) {
								player = (Player) sender;
								if (args.length == 0) {
									player.sendMessage(ChatColor.DARK_RED
											+ "Please specify a target to challenge!");
									return true;
								}
								if (args.length > 1) {
									player.sendMessage(ChatColor.DARK_RED
											+ "Please use the correct form of the command.");
									return true;
								}

								else {
									if (Bukkit.getServer().getPlayer(args[0]) == player) {
										player.sendMessage(ChatColor.DARK_RED
												+ "You can't challenge yourself!");
										return true;
									}

									else {
										target = Bukkit.getServer().getPlayer(
												args[0]);
										if (target == null) {
											sender.sendMessage(ChatColor.DARK_RED
													+ "Could not find player "
													+ args[0] + ".");
											return true;
										}
										challengeOff = false;
										Bukkit.getServer()
												.broadcastMessage(
														target.getName()
																+ " "
																+ ChatColor.DARK_AQUA
																+ "has been challenged by "
																+ ChatColor.RESET
																+ player.getName()
																+ ChatColor.DARK_AQUA
																+ " to an Arena Duel and has "
																+ ChatColor.DARK_RED
																+ delay
																/ 1000
																+ " seconds"
																+ ChatColor.DARK_AQUA
																+ " to respond!");
										target.sendMessage(ChatColor.DARK_AQUA
												+ "To accept the duel - Type: "
												+ ChatColor.GREEN
												+ "/duelaccept");
										target.sendMessage(ChatColor.DARK_AQUA
												+ "To decline the duel - Type: "
												+ ChatColor.GREEN
												+ "/dueldecline");

										timer = new Timer(delay, taskPerformer);
										timer.start();
										return true;
									}

								}

							} else {
								sender.sendMessage(ChatColor.DARK_RED
										+ "There is a challenge going on!");
							}
						}
						if (cd) {
							min = s / 60;
							if (min == 1) {
								sender.sendMessage(ChatColor.DARK_AQUA
										+ "Duels are on cooldown. Remaining: "
										+ ChatColor.DARK_RED + min + " minute"
										+ ChatColor.DARK_AQUA + " and "
										+ ChatColor.DARK_RED + s % 60
										+ " seconds.");
							}
							if (min > 1) {
								sender.sendMessage(ChatColor.DARK_AQUA
										+ "Duels are on cooldown. Remaining: "
										+ ChatColor.DARK_RED + min + " minutes"
										+ ChatColor.DARK_AQUA + " and "
										+ ChatColor.DARK_RED + s % 60
										+ " seconds.");
							}
							if (min < 1) {
								sender.sendMessage(ChatColor.DARK_AQUA
										+ "Duels are on cooldown. Remaining: "
										+ ChatColor.DARK_RED + s + " seconds.");
								return true;

							}
						}
					}
				} else {
					sender.sendMessage(ChatColor.DARK_RED
							+ "There is already a duel going on!");
					return true;
				}
			}
			if (cmd.getName().equalsIgnoreCase("duelaccept")) {
				if (sender == target) {
					if (duelOff) {
						timer.stop();

						Bukkit.getServer().broadcastMessage(
								target.getName() + " " + ChatColor.DARK_AQUA
										+ "has " + ChatColor.GREEN
										+ "Accepted " + ChatColor.RESET
										+ player.getName()
										+ ChatColor.DARK_AQUA
										+ "'s duel challenge!");

						healthP = ((CraftPlayer) player).getHandle()
								.getHealth();
						foodP = player.getFoodLevel();
						modeP = player.getGameMode();
						potionsP = player.getActivePotionEffects();
						entryP = player.getLocation();
						fireP = player.getFireTicks();

						healthT = ((CraftPlayer) target).getHandle()
								.getHealth();
						foodT = target.getFoodLevel();
						modeT = target.getGameMode();
						potionsT = target.getActivePotionEffects();
						entryT = target.getLocation();
						fireT = target.getFireTicks();

						duelOff = false;
						challengeOff = true;
						
                        World w1 = Bukkit.getServer().getWorld(getConfig().getString("duel1.world"));
                        double x1 = getConfig().getDouble("duel1.x");
                        double y1 = getConfig().getDouble("duel1.y");
                        double z1 = getConfig().getDouble("duel1.z");
                        player.teleport(new Location(w1, x1, y1, z1));
                        player.sendMessage(ChatColor.DARK_RED + "Begin!");

                        World w2 = Bukkit.getServer().getWorld(getConfig().getString("duel2.world"));
                        double x2 = getConfig().getDouble("duel2.x");
                        double y2 = getConfig().getDouble("duel2.y");
                        double z2 = getConfig().getDouble("duel2.z");
                        target.teleport(new Location(w2, x2, y2, z2));
                        target.sendMessage(ChatColor.DARK_RED + "Begin!");
                        
						player.setGameMode(GameMode.SURVIVAL);
						target.setGameMode(GameMode.SURVIVAL);
						player.setFoodLevel(20);
						target.setFoodLevel(20);
						((CraftPlayer) player).setHealth(20);
						((CraftPlayer) target).setHealth(20);

						player.setFireTicks(0);
						player.removePotionEffect(PotionEffectType.SPEED);
						player.removePotionEffect(PotionEffectType.SLOW);
						player.removePotionEffect(PotionEffectType.FAST_DIGGING);
						player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
						player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						player.removePotionEffect(PotionEffectType.JUMP);
						player.removePotionEffect(PotionEffectType.CONFUSION);
						player.removePotionEffect(PotionEffectType.REGENERATION);
						player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						player.removePotionEffect(PotionEffectType.WATER_BREATHING);
						player.removePotionEffect(PotionEffectType.INVISIBILITY);
						player.removePotionEffect(PotionEffectType.BLINDNESS);
						player.removePotionEffect(PotionEffectType.NIGHT_VISION);
						player.removePotionEffect(PotionEffectType.HUNGER);
						player.removePotionEffect(PotionEffectType.WEAKNESS);
						player.removePotionEffect(PotionEffectType.POISON);
						player.removePotionEffect(PotionEffectType.WITHER);
						player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
						player.removePotionEffect(PotionEffectType.ABSORPTION);
						player.removePotionEffect(PotionEffectType.SATURATION);

						target.setFireTicks(0);
						target.removePotionEffect(PotionEffectType.SPEED);
						target.removePotionEffect(PotionEffectType.SLOW);
						target.removePotionEffect(PotionEffectType.FAST_DIGGING);
						target.removePotionEffect(PotionEffectType.SLOW_DIGGING);
						target.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						target.removePotionEffect(PotionEffectType.JUMP);
						target.removePotionEffect(PotionEffectType.CONFUSION);
						target.removePotionEffect(PotionEffectType.REGENERATION);
						target.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						target.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						target.removePotionEffect(PotionEffectType.WATER_BREATHING);
						target.removePotionEffect(PotionEffectType.INVISIBILITY);
						target.removePotionEffect(PotionEffectType.BLINDNESS);
						target.removePotionEffect(PotionEffectType.NIGHT_VISION);
						target.removePotionEffect(PotionEffectType.HUNGER);
						target.removePotionEffect(PotionEffectType.WEAKNESS);
						target.removePotionEffect(PotionEffectType.POISON);
						target.removePotionEffect(PotionEffectType.WITHER);
						target.removePotionEffect(PotionEffectType.HEALTH_BOOST);
						target.removePotionEffect(PotionEffectType.ABSORPTION);
						target.removePotionEffect(PotionEffectType.SATURATION);
						return true;
					} else {
						sender.sendMessage(ChatColor.DARK_RED
								+ "There is already a duel going on!");
						return true;
					}

				} else {
					sender.sendMessage(ChatColor.DARK_RED
							+ "You haven't been challenged!");
					return true;
				}
			}

			if (cmd.getName().equalsIgnoreCase("dueldecline")) {
				if (sender == target) {
					if (duelOff) {
						timer.stop();

						Bukkit.getServer().broadcastMessage(
								target.getName() + " " + ChatColor.DARK_AQUA
										+ "has " + ChatColor.DARK_RED
										+ "Declined " + ChatColor.RESET
										+ player.getName()
										+ ChatColor.DARK_AQUA
										+ "'s duel challenge!");

						player = null;
						target = null;
						challengeOff = true;
						cd = true;

						seconds = new Timer(1000, secondCounter);
						seconds.start();
						return true;
					} else {
						sender.sendMessage(ChatColor.DARK_RED
								+ "There is already a duel going on!");
						return true;
					}

				} else {
					sender.sendMessage(ChatColor.DARK_RED
							+ "You haven't been challenged!");
					return true;
				}
			}

			if (cmd.getName().equalsIgnoreCase("duelset1")) {
				if (!sender.hasPermission("duel.set")) {
					sender.sendMessage(ChatColor.DARK_RED
							+ "You don't have permissions to use this!");
					return true;
				}

				else {
					op = (Player) sender;
					getConfig().set("duel1.world",
							op.getLocation().getWorld().getName());
					getConfig().set("duel1.x", op.getLocation().getX());
					getConfig().set("duel1.y", op.getLocation().getY());
					getConfig().set("duel1.z", op.getLocation().getZ());
					saveConfig();
					op.sendMessage(ChatColor.DARK_AQUA
							+ "Combatant Spawn 1 Set!");
					op = null;
					return true;
				}
			}
			if (cmd.getName().equalsIgnoreCase("duelset2")) {
				if (!sender.hasPermission("duel.set")) {
					sender.sendMessage(ChatColor.DARK_RED
							+ "You don't have permissions to use this!");
					return true;
				}

				else {
					op = (Player) sender;
					getConfig().set("duel2.world",
							op.getLocation().getWorld().getName());
					getConfig().set("duel2.x", op.getLocation().getX());
					getConfig().set("duel2.y", op.getLocation().getY());
					getConfig().set("duel2.z", op.getLocation().getZ());
					saveConfig();
					op.sendMessage(ChatColor.DARK_AQUA
							+ "Combatant Spawn 2 Set!");
					op = null;
					return true;
				}
			}

		}
		return true;
	}

	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent event1) {
			challengeOff = true;
			Bukkit.getServer().broadcastMessage(
					target.getName() + " " + ChatColor.DARK_AQUA
							+ "didn't respond to the challenge!");
			timer.stop();

		}
	};

	ActionListener afterDuel = new ActionListener() {
		public void actionPerformed(ActionEvent event2) {
			duelOff = true;
			cd = true;
			if (winP) {

				winner.teleport(entryP);
				winner.setGameMode(modeP);
				((CraftPlayer) winner).setHealth(healthP);
				winner.setFoodLevel(foodP);
				winner.addPotionEffects(potionsP);
				winner.setFireTicks(fireP);

			}
			if (winP == false) {

				winner.teleport(entryT);
				winner.setGameMode(modeT);
				((CraftPlayer) winner).setHealth(healthT);
				winner.setFoodLevel(foodT);
				winner.addPotionEffects(potionsT);
				winner.setFireTicks(fireT);

			}

			afterWinning.stop();

		}
	};

	ActionListener secondCounter = new ActionListener() {
		public void actionPerformed(ActionEvent event3) {
			s--;
			if (s <= 0) {
				seconds.stop();
				s = cooldown;
				cd = false;
			}

		}
	};

}
