package net.dent.client;

import net.fabricmc.api.ModInitializer;

public class DentClientMod implements ModInitializer {
	@Override
	public void onInitialize() {

	    if(DentClient.instance.isGhost()) {
	        return;
        }

        System.out.println("########################################");
        System.out.println("    INITIALIZING DENT CLIENT V " + DentClient.getVersion());
        System.out.println("########################################");
        System.out.println("                                        ");
        System.out.println(" Dent Client Credits:   ");
        System.out.println("     - Head Dev: Whop42");
        System.out.println("     - Dev?: InvertedCube");
	}
}
