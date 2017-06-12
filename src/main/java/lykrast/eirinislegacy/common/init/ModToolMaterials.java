package lykrast.eirinislegacy.common.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterials {
	
	public static ToolMaterial PETRAMITE = EnumHelper.addToolMaterial("petramite", 1, 250, 3.0F, 1.0F, 14);
	public static ToolMaterial PHANTIUM = EnumHelper.addToolMaterial("phantium", 2, 510, 8.0F, 3.0F, 16);
	
	public static void init()
	{
		PETRAMITE = EnumHelper.addToolMaterial("petramite", 1, 250, 3.0F, 1.0F, 14);
		PHANTIUM = EnumHelper.addToolMaterial("phantium", 2, 510, 8.0F, 3.0F, 16);
	}
	
	public static void initRepair()
	{
		PETRAMITE.setRepairItem(new ItemStack(ModBlocks.petramite));
		PHANTIUM.setRepairItem(new ItemStack(ModItems.phantiumIngot));
	}

}
