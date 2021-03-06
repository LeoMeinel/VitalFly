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

package dev.meinel.leo.vitalfly.listeners;

import dev.meinel.leo.vitalfly.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerChangedWorld
		implements Listener {

	@EventHandler
	public void onPlayerChangedWorld(@NotNull PlayerChangedWorldEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPermission("vitalfly.fly") || !player.hasPermission("vitalfly.fly.worldchange")) {
			return;
		}
		player.setAllowFlight(true);
		Chat.sendMessage(player, "now-flying");
	}
}
