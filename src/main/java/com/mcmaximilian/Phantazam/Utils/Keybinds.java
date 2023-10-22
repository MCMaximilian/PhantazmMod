package com.mcmaximilian.Phantazam.Utils;

import com.mcmaximilian.Phantazam.Main;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

public class Keybinds {

    private static final String Category  = "key.category.phantazmmod.PhantazmMod";

    private static final String Cornering = "key.phantazmmod.toggle_cornering";

    public static final KeyMapping ToggleCornering  = new KeyMapping(Cornering, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z , Category );

    public static String CorneringState = "off";

    @Mod.EventBusSubscriber( modid = Main.MODID , value = Dist.CLIENT)
    public static class KeyGenerate {

        @SubscribeEvent
        public static void registerKey(RegisterKeyMappingsEvent event) {
            event.register( ToggleCornering);
        }
    }

    @Mod.EventBusSubscriber( modid = Main.MODID, value = Dist.CLIENT , bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class FixGenerate {

        @SubscribeEvent
        public static void fixKey( RegisterKeyMappingsEvent event) {
            event.register( ToggleCornering );
        }
    }

}
