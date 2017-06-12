package lykrast.eirinislegacy.common.block;

import net.minecraft.util.IStringSerializable;

public enum VariantsAnimiteOre implements IStringSerializable {
	
	STONE, PETRAMITE;
	
	@Override
    public String getName()
    {
        return name().toLowerCase();
    }
    @Override
    public String toString()
    {
        return getName();
    }
}
