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
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAnimiteOre extends BlockGeneric implements IBlockMetadata {

	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", VariantsAnimiteOre.class);

	public BlockAnimiteOre(float hardness, float resistance, int harvestLevel) {
		super(Material.ROCK, SoundType.STONE, hardness, resistance, "pickaxe", harvestLevel);
		setDefaultState(blockState.getBaseState().withProperty(VARIANT, VariantsAnimiteOre.STONE));
	}

	@Override
	public Class getVariants() {
		return VariantsAnimiteOre.class;
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 * From Minecraft's stone block
	 */
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (VariantsAnimiteOre v : VariantsAnimiteOre.values()) 
			list.add(new ItemStack(this, 1, getMetaFromState(blockState.getBaseState().withProperty(VARIANT, v))));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void initModel() {
		for (VariantsAnimiteOre v : VariantsAnimiteOre.values()) 
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), getMetaFromState(blockState.getBaseState().withProperty(VARIANT, v)), 
					new ModelResourceLocation(getRegistryName() + "_" + v, "inventory"));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{VARIANT});
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((VariantsAnimiteOre) state.getValue(VARIANT)).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(VARIANT, VariantsAnimiteOre.values()[meta]);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.animite;
	}
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return Math.max(0, random.nextInt(fortune + 2) - 1) + 1;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
	{
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		return MathHelper.getInt(rand, 3, 7);
	}
	
	/**
     * Spawns this Block's drops into the World as EntityItems.
     * <br>
     * Copied from vanilla to prevent metadata on dropped animite
     * @param chance The chance that each Item is actually spawned (1.0 = always, 0.0 = never)
     * @param fortune The player's fortune level
     */
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
		if (!worldIn.isRemote) {
			int var6 = this.quantityDroppedWithBonus(fortune, worldIn.rand);

			for (int var7 = 0; var7 < var6; ++var7) {
				if (worldIn.rand.nextFloat() <= chance) {
					Item var8 = this.getItemDropped(state, worldIn.rand, fortune);

					if (var8 != null) {
						spawnAsEntity(worldIn, pos, new ItemStack(var8, 1, 0));
					}
				}
			}
		}
	}

}
