package com.pigsense.anticheat;

import com.github.retrooper.packetevents.PacketEvents;
import com.pigsense.anticheat.manager.CheckManager;
import com.pigsense.anticheat.manager.DataManager;
import com.pigsense.anticheat.packet.PacketListener;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pigsense extends JavaPlugin {

    private static Pigsense instance;
    private DataManager dataManager;
    private CheckManager checkManager;

    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.dataManager = new DataManager();
        this.checkManager = new CheckManager();

        PacketEvents.getAPI().init();
        PacketEvents.getAPI().getEventManager().registerListener(new PacketListener(dataManager, checkManager));

        this.getLogger().info("pigsense enabled \uD83D\uDC16");
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }
}
