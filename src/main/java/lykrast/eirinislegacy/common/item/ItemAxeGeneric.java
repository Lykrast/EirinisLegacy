package lykrast.eirinislegacy.common.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAxeGeneric extends ItemAxe {

	// Strange but has to be done
	public ItemAxeGeneric(ToolMaterial material) {
		super(material, material.getDamageVsEntity(), material.getEfficiencyOnProperMaterial());
	}

	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return toolMaterial.getRepairItemStack().isItemEqual(repair);
	}

}
