package lykrast.eirinislegacy.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockMetadata extends ItemBlock {

	public ItemBlockMetadata(Block block)
	{
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

}
