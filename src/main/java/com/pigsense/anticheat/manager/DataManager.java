package com.pigsense.anticheat.manager;

import com.pigsense.anticheat.data.PlayerData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class DataManager {

    private final Map<Player, PlayerData> dataMap = new HashMap<>();

    public PlayerData getData(Player player) {
        return dataMap.computeIfAbsent(player, p -> new PlayerData());
    }

    public void remove(Player player) {
        dataMap.remove(player);
    }
}
