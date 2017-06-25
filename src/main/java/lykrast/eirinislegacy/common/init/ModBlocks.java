package lykrast.eirinislegacy.common.init;

import java.util.ArrayList;
import java.util.List;

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
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

	public static Block petramite, animiteOre, animiteBlock, coalImbuedBlock, corporaBlock, phantiumBlock, spectralCrystalBlock, 
		machineCasing, machineCasingAdvanced,
		corporaCrop, 
		petramiteDecoration, 
		spectralBlock;
	private static final List<Block> blockList = new ArrayList<Block>();

	public static void init() {
		petramite = registerBlock(new BlockGeneric(Material.ROCK, SoundType.STONE, 1.5F, 30.0F, "pickaxe", 0), "petramite");
		animiteOre = registerBlock(new BlockAnimiteOre(3.0F, 15.0F, 2), "animite_ore");
		animiteBlock = registerBlock(new BlockGeneric(Material.IRON, SoundType.METAL, 5.0F, 30.0F, "pickaxe", 2), "animite_block");
		coalImbuedBlock = registerBlock(new BlockGeneric(Material.ROCK, SoundType.STONE, 5.0F, 30.0F, "pickaxe", 0), "coal_imbued_block");
		corporaBlock = registerBlock(new BlockGeneric(Material.GRASS, SoundType.PLANT, 0.5F, 2.5F), "corpora_block");
		phantiumBlock = registerBlock(new BlockGeneric(Material.IRON, SoundType.METAL, 5.0F, 30.0F, "pickaxe", 2), "phantium_block");
		spectralCrystalBlock = registerBlock(new BlockLight(Material.GLASS, SoundType.GLASS, 0.5F, 2.0F, 1.0F), "spectral_crystal_block");		

		machineCasing = registerBlock(new BlockMachineCasing(1.5F, 30.0F, 0), "machine_casing", CreativeTabELMachines.instance);

		spectralBlock = registerBlock(new BlockSpectralBlock(0.10F, 0.5F), "spectral_block", null);
		
		if (Config.decorationEnabled)
		{
			petramiteDecoration = registerBlock(new BlockPetramiteDecoration(1.5F, 30.0F, 0), "petramite_decoration", CreativeTabELDecoration.instance);
		}
	}

	public static void initAfterItems()
	{
		corporaCrop = registerBlock(new BlockCropGeneric(ModItems.corpora, ModItems.corporaSeeds), "corpora_crop", null);
	}

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		for (Block b : blockList) initModel(b);
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModel(Block b) {
		if (b instanceof BlockVariant) ((BlockVariant) b).initModel();
		else ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation(b.getRegistryName(), "inventory"));
    }

	public static Block registerBlock(Block block, String name)
	{
		return registerBlock(block,name,CreativeTabEL.instance);
	}

	public static Block registerBlock(Block block, String name, CreativeTabs tab)
	{
		block.setRegistryName(name);
		block.setUnlocalizedName(EirinisLegacy.MODID + "." + name);

		ForgeRegistries.BLOCKS.register(block);
		
		if (block instanceof BlockVariant)
		{
			ItemBlock item = new ItemBlockMetadata(block, ((BlockVariant) block).hasVariantNames());
			item.setRegistryName(block.getRegistryName());
			ForgeRegistries.ITEMS.register(item);
		}
		else
		{
			ItemBlock item = new ItemBlock(block);
			item.setRegistryName(block.getRegistryName());
			ForgeRegistries.ITEMS.register(item);
		}

		if (tab != null) block.setCreativeTab(tab);
		
		blockList.add(block);

		return block;
	}
}
