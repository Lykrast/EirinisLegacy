package lykrast.eirinislegacy.common.block;

import java.util.Random;

import com.google.common.collect.ImmutableSet;

import lykrast.eirinislegacy.common.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAnimiteOre extends BlockGeneric {
	
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", VariantsAnimiteOre.class);
	
	public BlockAnimiteOre(float hardness, float resistance, int harvestLevel) {
        super(Material.ROCK, SoundType.STONE, hardness, resistance, "pickaxe", harvestLevel);
        setDefaultState(blockState.getBaseState().withProperty(VARIANT, VariantsAnimiteOre.STONE));
    }
	
	@Override
	public BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[]{VARIANT});
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((VariantsAnimiteOre) state.getValue(VARIANT)).ordinal();
	}
    
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
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

}
