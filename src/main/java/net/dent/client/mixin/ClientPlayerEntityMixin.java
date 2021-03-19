package net.dent.client.mixin;

import net.dent.client.DentClient;
import net.dent.client.event.Event;
import net.dent.client.event.events.EventMotion;
import net.dent.client.event.events.EventUpdate;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    //Processes dent commands
    @Inject(at = @At("HEAD"),
            method = "sendChatMessage",
            cancellable = true)
    private void onSendChatMessage(String message, CallbackInfo info) {
        if (DentClient.instance.commandManager.processCommand(message)) {
            info.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void preTick(CallbackInfo callbackInfo) {
        new EventUpdate().call();
    }

    @Inject(at = {@At("HEAD")}, method = {"sendMovementPackets()V"})
    private void onSendMovementPacketsHEAD(CallbackInfo ci) {
        new EventMotion(Event.Type.PRE).call();
    }

    @Inject(at = {@At("TAIL")}, method = {"sendMovementPackets()V"})
    private void onSendMovementPacketsTAIL(CallbackInfo ci) {
        new EventMotion(Event.Type.POST).call();
    }


}
