package com.mcmaximilian.Phantazam;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Keybinds {

    public static KeyMapping ToggleCornering = new KeyMapping("key,Toggle_Cornering", 90, "key.Phantazm_Mod");

    public static String CorneringState = "off";

    @SubscribeEvent
    public static void registerKey(RegisterKeyMappingsEvent event) {
        event.register( ToggleCornering);
    }

}
