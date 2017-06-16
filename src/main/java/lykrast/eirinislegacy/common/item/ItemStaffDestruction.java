package lykrast.eirinislegacy.common.item;

import lykrast.eirinislegacy.common.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemStaffDestruction extends ItemStaffGeneric {

	public ItemStaffDestruction(int max, int use) {
		super(max, use);
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		if (!hasEnoughEnergy(itemstack)) return EnumActionResult.FAIL;

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();
		
		if (player.canPlayerEdit(pos, facing, itemstack))
		{
			float hardness = state.getBlockHardness(worldIn, pos);
			if (block.getHarvestLevel(state) < 3 && hardness >= 0 && hardness < Blocks.OBSIDIAN.getDefaultState().getBlockHardness(worldIn, pos))
			{
				worldIn.playEvent(2001, pos, Block.getStateId(state));

		        if (!worldIn.isRemote)
		        {
		        	worldIn.setBlockToAir(pos);
		        }
	            if (hardness != 0) useEnergy(itemstack, player);
		        player.addStat(StatList.getObjectUseStats(this));
                return EnumActionResult.SUCCESS;
			}
			return EnumActionResult.PASS;
		}
		else return EnumActionResult.FAIL;
	}

}
