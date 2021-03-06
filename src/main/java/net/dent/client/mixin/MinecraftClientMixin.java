package net.dent.client.mixin;

import net.dent.client.DentClient;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    private Window window;

   /* @Inject(at = @At("RETURN"), method = "updateWindowTitle")
	private void updateWindowTitle(CallbackInfo info) {
		this.window.setTitle(DentClient.instance.name + " v" + DentClient.instance.version);
	}*/

    @Inject(at = @At("HEAD"), method = "run")
    private void run(CallbackInfo info) {
        DentClient.instance.run();
    }

    @Inject(at = @At("HEAD"), method = "stop")
    private void stop(CallbackInfo info) {
        DentClient.instance.stop();
    }


}
