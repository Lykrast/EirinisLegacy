package lykrast.eirinislegacy.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpectralBlock extends BlockGeneric {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 4);
	
	public BlockSpectralBlock(float hardness, float resistance) {
		super(Material.GLASS, SoundType.GLASS, hardness, resistance);
		setTickRandomly(true);
        setLightOpacity(0);
		setLightLevel(0.25F);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
    	worldIn.playEvent(2001, pos, Block.getStateId(state));
    	
		int i = ((Integer)state.getValue(AGE)).intValue();

        if (i < 3)
        {
        	worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
        	worldIn.scheduleUpdate(pos, this, MathHelper.getInt(rand, 100, 200));
        }
        else
        {
        	worldIn.setBlockToAir(pos);
        }
	}
	
	@Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }

	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(MathHelper.clamp(meta, 0, 3)));
    }

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AGE});
	}
    
    public int quantityDropped(Random random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        return block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    @Override
    public boolean causesSuffocation(IBlockState state)
    {
        return false;
    }

}
