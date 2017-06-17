package lykrast.eirinislegacy.common.block;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableSet;

import lykrast.eirinislegacy.common.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMachineCasing extends BlockVariant {

	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", VariantsMachineCasing.class);

	public BlockMachineCasing(float hardness, float resistance, int harvestLevel) {
		super(Material.ROCK, SoundType.STONE, hardness, resistance, "pickaxe", harvestLevel, true);
		setDefaultState(blockState.getBaseState().withProperty(VARIANT, VariantsMachineCasing.NORMAL));
	}
	
	@Override
	public Enum[] getVariants() {
		return VariantsMachineCasing.values();
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (Enum v : getVariants()) 
			list.add(new ItemStack(this, 1, getMetaFromState(blockState.getBaseState().withProperty(VARIANT, v))));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{VARIANT});
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((VariantsMachineCasing) state.getValue(VARIANT)).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(VARIANT, getVariants()[meta]);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void initModel() {
		for (Enum v : getVariants()) 
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), getMetaFromState(blockState.getBaseState().withProperty(VARIANT, v)), 
					new ModelResourceLocation(getRegistryName() + "_" + v, "inventory"));
	}
	
	public enum VariantsMachineCasing implements IStringSerializable {
		
		NORMAL, ADVANCED;
		
		@Override
	    public String getName()
	    {
	        return name().toLowerCase();
	    }
	    @Override
	    public String toString()
	    {
	        return getName();
	    }
	}

}
