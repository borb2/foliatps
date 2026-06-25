package com.sirborb.foliatps;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class FoliaTpsExpansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "foliatps";
    }

    @Override
    public @NotNull String getAuthor() {
        return "SirBorb";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        double mspt = Bukkit.getServer().getAverageTickTime();

        switch (params.toLowerCase()) {
            case "mspt":
                return String.format("%.1f", mspt);

            case "mspt_colored": {
                String color;
                if (mspt < 40.0) {
                    color = "&a";
                } else if (mspt <= 47.0) {
                    color = "&e";
                } else {
                    color = "&c";
                }
                return ChatColor.translateAlternateColorCodes('&', color + String.format("%.1f", mspt));
            }

            case "tps": {
                double tps = Math.min(20.0, 1000.0 / mspt);
                return String.format("%.1f", tps);
            }

            case "tps_colored": {
                double tps = Math.min(20.0, 1000.0 / mspt);
                String color;
                if (tps > 18.0) {
                    color = "&a";
                } else if (tps >= 15.0) {
                    color = "&e";
                } else {
                    color = "&c";
                }
                return ChatColor.translateAlternateColorCodes('&', color + String.format("%.1f", tps));
            }

            case "tick_health": {
                double health = (1.0 - mspt / 50.0) * 100.0;
                health = Math.max(0.0, Math.min(100.0, health));
                return Math.round(health) + "%";
            }

            case "tick_health_colored": {
                double health = (1.0 - mspt / 50.0) * 100.0;
                health = Math.max(0.0, Math.min(100.0, health));
                String color;
                if (health > 85.0) {
                    color = "&a";
                } else if (health >= 70.0) {
                    color = "&e";
                } else {
                    color = "&c";
                }
                return ChatColor.translateAlternateColorCodes('&', color + Math.round(health) + "%");
            }
        }

        return null;
    }
}
