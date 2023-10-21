package com.mcmaximilian.Phantazam;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

import static com.mcmaximilian.Phantazam.Keybinds.CorneringState;
import static com.mcmaximilian.Phantazam.Keybinds.ToggleCornering;

public class EventListener {

    @SubscribeEvent
    public static void onKeyInput( TickEvent.ClientTickEvent event) {
        if ( event.phase == TickEvent.Phase.END) {

            if ( ToggleCornering.consumeClick() ) {

                if (CorneringState.equalsIgnoreCase("on")) {

                    CorneringState = "off";
                    net.minecraft.network.chat.Component component = Component.nullToEmpty("Cornering is off!");
                    component.getStyle().withColor(ChatFormatting.YELLOW);
                    component.getStyle().withBold( true);
                    Objects.requireNonNull(Minecraft.getInstance().player).displayClientMessage( component, true);
                }
                else if ( CorneringState.equalsIgnoreCase("off")) {
                    CorneringState = "on";
                    net.minecraft.network.chat.Component component = Component.nullToEmpty("Cornering is on!");
                    component.getStyle().withColor(ChatFormatting.YELLOW);
                    component.getStyle().withBold( true);
                    Objects.requireNonNull(Minecraft.getInstance().player).displayClientMessage( component, true);
                }
            }
        }
    }
}
