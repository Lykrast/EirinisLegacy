package lykrast.eirinislegacy.core;

import java.util.logging.Logger;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EirinisLegacy.MODID, version = EirinisLegacy.VERSION)
public class EirinisLegacy
{
    public static final String MODID = "eirinislegacy";
    public static final String VERSION = "0.1";
    
    @Instance(MODID)
    public static EirinisLegacy instance;
    
    public static Logger logger;
    
    @SidedProxy(clientSide = "lykrast.eirinislegacy.core.ClientProxy", serverSide = "lykrast.eirinislegacy.core.CommonProxy")
	public static CommonProxy proxy;
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
