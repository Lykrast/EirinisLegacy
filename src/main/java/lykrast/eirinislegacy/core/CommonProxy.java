package lykrast.eirinislegacy.core;

import java.io.File;

import lykrast.eirinislegacy.common.init.ModBlocks;
import lykrast.eirinislegacy.common.init.ModItems;
import lykrast.eirinislegacy.common.init.ModRecipes;
import lykrast.eirinislegacy.common.init.ModToolMaterials;
import lykrast.eirinislegacy.common.util.Config;
import lykrast.eirinislegacy.common.world.WorldGenOre;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public static Configuration config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "eirinis_legacy.cfg"));
        Config.readConfig();
        
		ModBlocks.init();
		//Tools require materials to be initialized
		ModToolMaterials.init();
		ModItems.init();
		//Repair require items to be initialized
		ModToolMaterials.init();
		//Some blocks need items (crops)
		ModBlocks.initAfterItems();
		
		GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);
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
