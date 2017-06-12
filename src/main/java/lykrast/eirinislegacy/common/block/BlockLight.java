package lykrast.eirinislegacy.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLight extends BlockGeneric {
	
	public BlockLight(Material material, SoundType soundType, float hardness, float resistance, float light) {
		super(material, soundType, hardness, resistance);
		setLightLevel(light);
	}

}
