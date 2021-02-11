package net.dent.client;

import net.dent.client.gui.GUI;
import net.fabricmc.api.ModInitializer;

public class DentClientFabric implements ModInitializer {
	public static double version = 0.42;
	String name = "Dent Client";


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		GUI gui = new GUI();
	}
}
