/*
 * VitalFly is a Spigot Plugin that gives players the ability to fly.
 * Copyright © 2022 Leopold Meinel & contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/LeoMeinel/VitalFly/blob/main/LICENSE
 */

package dev.meinel.leo.vitalfly;

import dev.meinel.leo.vitalfly.commands.VitalFlyCmd;
import dev.meinel.leo.vitalfly.commands.VitalFlySpeedCmd;
import dev.meinel.leo.vitalfly.files.Messages;
import dev.meinel.leo.vitalfly.listeners.PlayerChangedWorld;
import dev.meinel.leo.vitalfly.listeners.PlayerGamemodeChange;
import dev.meinel.leo.vitalfly.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class VitalFly
		extends JavaPlugin {

	private Messages messages;

	@Override
	public void onEnable() {
		registerListeners();
		registerCommands();
		saveDefaultConfig();
		messages = new Messages();
		Bukkit.getLogger()
		      .info("VitalFly v" + this.getDescription()
		                               .getVersion() + " enabled");
		Bukkit.getLogger()
		      .info("Copyright (C) 2022 Leopold Meinel");
		Bukkit.getLogger()
		      .info("This program comes with ABSOLUTELY NO WARRANTY!");
		Bukkit.getLogger()
		      .info("This is free software, and you are welcome to redistribute it under certain conditions.");
		Bukkit.getLogger()
		      .info("See https://github.com/LeoMeinel/VitalFly/blob/main/LICENSE for more details.");
	}

	@Override
	public void onDisable() {
		Bukkit.getLogger()
		      .info("VitalFly v" + this.getDescription()
		                               .getVersion() + " disabled");
	}

	private void registerListeners() {
		getServer().getPluginManager()
		           .registerEvents(new PlayerChangedWorld(), this);
		getServer().getPluginManager()
		           .registerEvents(new PlayerGamemodeChange(), this);
		getServer().getPluginManager()
		           .registerEvents(new PlayerJoin(), this);
	}

	private void registerCommands() {
		Objects.requireNonNull(getCommand("fly"))
		       .setExecutor(new VitalFlyCmd());
		Objects.requireNonNull(getCommand("flyspeed"))
		       .setExecutor(new VitalFlySpeedCmd());
	}

	public Messages getMessages() {
		return messages;
	}
}

