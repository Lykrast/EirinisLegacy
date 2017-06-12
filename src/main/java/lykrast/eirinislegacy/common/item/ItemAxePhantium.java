package lykrast.eirinislegacy.common.item;

import java.util.Random;

import lykrast.eirinislegacy.common.init.ModItems;
import lykrast.eirinislegacy.common.util.Config;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemAxePhantium extends ItemAxeGeneric {

	public ItemAxePhantium(ToolMaterial material) {
		super(material);
	}
	
	// Dropping Spectral Residue
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
	{
		if (Config.phantiumAxeDrop == 0) return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
		if (worldIn.isRemote) return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
		
		Block block = state.getBlock();
		
		if (block.getHarvestLevel(state) <= toolMaterial.getHarvestLevel() && block.getHarvestTool(state).equals("axe"))
		{
			Random random = worldIn instanceof World ? ((World)worldIn).rand : new Random();
			if (random.nextInt(Config.phantiumAxeDrop) == 0)
			{
				EntityItem residue = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.spectralResidue));
				worldIn.spawnEntity(residue);
			}
		}
		
		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}

}
