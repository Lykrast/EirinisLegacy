package lykrast.eirinislegacy.common.init;

import lykrast.eirinislegacy.common.block.*;
import lykrast.eirinislegacy.common.item.ItemBlockMetadata;
import lykrast.eirinislegacy.common.util.Config;
import lykrast.eirinislegacy.common.util.CreativeTabEL;
import lykrast.eirinislegacy.common.util.CreativeTabELDecoration;
import lykrast.eirinislegacy.common.util.CreativeTabELMachines;
import lykrast.eirinislegacy.core.EirinisLegacy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	
	public static BlockGeneric petramite, animiteOre, animiteBlock, coalImbuedBlock, corporaBlock, phantiumBlock, spectralCrystalBlock, machineCasing, machineCasingAdvanced;
	
	public static void init() {
		petramite = registerBlock(new BlockGeneric(Material.ROCK, SoundType.STONE, 1.5F, 30.0F, "pickaxe", 0), "petramite");
		animiteOre = registerBlock(new BlockAnimiteOre(3.0F, 15.0F, 2), "animite_ore");
		animiteBlock = registerBlock(new BlockGeneric(Material.IRON, SoundType.METAL, 5.0F, 30.0F, "pickaxe", 2), "animite_block");
		coalImbuedBlock = registerBlock(new BlockGeneric(Material.ROCK, SoundType.STONE, 5.0F, 30.0F, "pickaxe", 0), "coal_imbued_block");
		corporaBlock = registerBlock(new BlockGeneric(Material.GRASS, SoundType.PLANT, 0.5F, 2.5F), "corpora_block");
		phantiumBlock = registerBlock(new BlockGeneric(Material.IRON, SoundType.METAL, 5.0F, 30.0F, "pickaxe", 2), "phantium_block");
		spectralCrystalBlock = registerBlock(new BlockLight(Material.GLASS, SoundType.GLASS, 0.5F, 2.0F, 1.0F), "spectral_crystal_block");		
		
		machineCasing = registerBlock(new BlockGeneric(Material.ROCK, SoundType.STONE, 1.5F, 30.0F, "pickaxe", 0), "machine_casing", CreativeTabELMachines.instance);
		machineCasingAdvanced = registerBlock(new BlockGeneric(Material.ROCK, SoundType.STONE, 1.5F, 30.0F, "pickaxe", 0), "machine_casing_advanced", CreativeTabELMachines.instance);
    }

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		petramite.initModel();
		animiteOre.initModel();
		animiteBlock.initModel();
		coalImbuedBlock.initModel();
		corporaBlock.initModel();
		phantiumBlock.initModel();
		spectralCrystalBlock.initModel();
		
		machineCasing.initModel();
		machineCasingAdvanced.initModel();
	}
	
	public static BlockGeneric registerBlock(BlockGeneric block, String name)
	{
		return registerBlock(block,name,CreativeTabEL.instance);
	}
	
	public static BlockGeneric registerBlock(BlockGeneric block, String name, CreativeTabs tab)
	{
        block.setRegistryName(name);
        block.setUnlocalizedName(EirinisLegacy.MODID + "." + name);
        
        GameRegistry.register(block);
        if (block instanceof BlockVariant) GameRegistry.register(new ItemBlockMetadata(block), block.getRegistryName());
        else GameRegistry.register(new ItemBlock(block), block.getRegistryName());
        
        if (tab != null) block.setCreativeTab(tab);
        
		return block;
	}
}
