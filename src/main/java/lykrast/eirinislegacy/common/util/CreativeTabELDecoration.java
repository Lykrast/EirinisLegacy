package lykrast.eirinislegacy.common.util;

import lykrast.eirinislegacy.common.init.ModBlocks;
import lykrast.eirinislegacy.common.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabELDecoration extends CreativeTabs {
	
	public static final CreativeTabs instance = new CreativeTabELDecoration(CreativeTabs.getNextID(), "tabEirinisLegacyDecoration");

	public CreativeTabELDecoration(int index, String label) {
		super(index, label);
	}
	
	@Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModBlocks.petramiteDecoration, 1, 8);
    }

}
