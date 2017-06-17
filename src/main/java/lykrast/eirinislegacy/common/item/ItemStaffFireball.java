package lykrast.eirinislegacy.common.item;

import lykrast.eirinislegacy.common.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemStaffFireball extends ItemStaffGeneric {

	public ItemStaffFireball(int max, int use) {
		super(max, use);
	}
	
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!hasEnoughEnergy(itemstack)) return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);

        playerIn.swingArm(handIn);
        //worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (worldIn.isRemote) worldIn.playEvent((EntityPlayer)null, 1016, new BlockPos(playerIn), 0);
        
        if (!worldIn.isRemote)
        {
            Vec3d vec3d = playerIn.getLook(1.0F);
            double accuracy = 20;

            EntitySmallFireball entitysmallfireball = new EntitySmallFireball(worldIn, playerIn, 
            		vec3d.xCoord * accuracy, vec3d.yCoord * accuracy, vec3d.zCoord * accuracy);
            entitysmallfireball.posY = playerIn.posY + (double)(playerIn.height / 2.0F) + 0.5D;
            worldIn.spawnEntity(entitysmallfireball);
        }

		useEnergy(itemstack, playerIn);

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

}
