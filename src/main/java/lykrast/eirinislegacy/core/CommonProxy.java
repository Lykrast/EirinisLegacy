package lykrast.eirinislegacy.core;

import java.io.File;

import lykrast.eirinislegacy.common.init.ModBlocks;
import lykrast.eirinislegacy.common.init.ModItems;
import lykrast.eirinislegacy.common.init.ModRecipes;
import lykrast.eirinislegacy.common.init.ModToolMaterials;
import lykrast.eirinislegacy.common.util.Config;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public static Configuration config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "eirinis_legacy.cfg"));
        Config.readConfig();
        
		ModBlocks.init();
		ModToolMaterials.init();
		ModItems.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		if (config.hasChanged()) {
            config.save();
		}
		ModRecipes.init();
	}

}
