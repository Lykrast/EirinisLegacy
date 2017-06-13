package lykrast.eirinislegacy.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockVariant extends BlockGeneric {

	public BlockVariant(Material material, SoundType soundType) {
		super(material, soundType);
	}

	public BlockVariant(Material material, SoundType soundType, float hardness, float resistance) {
		super(material, soundType, hardness, resistance);
	}

	public BlockVariant(Material material, SoundType soundType, float hardness, float resistance, String tool,
			int harvestLevel) {
		super(material, soundType, hardness, resistance, tool, harvestLevel);
	}

	/**
	 * List of the possible variants of this block, usually with yourEnum.values()
	 * @return list of the block's variants
	 */
	public abstract Enum[] getVariants();

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	// Those methods needs to be redefined using your variant properties, check BlockAnimiteOre for an example
	
	@Override
	public abstract void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list);

	@Override
	public abstract BlockStateContainer createBlockState();

	@Override
	public abstract int getMetaFromState(IBlockState state);

	@Override
	public abstract IBlockState getStateFromMeta(int meta);

	@Override
	@SideOnly(Side.CLIENT)
	public abstract void initModel();

}