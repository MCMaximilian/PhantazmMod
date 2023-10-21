package com.mcmaximilian.Phantazam;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Keybinds {

    public static KeyMapping ToggleCornering = new KeyMapping("Toggle Cornering", 90, "Phantazm Mod");

    public static String CorneringState = "";

    @SubscribeEvent
    public static void registerKey(RegisterKeyMappingsEvent event) {
        event.register( ToggleCornering);
    }

}
