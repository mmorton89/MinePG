package rpg.items.armor.archer;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import rpg.config.base.archer.ArcherArmor;
import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.ItemRPGArmor;
import rpg.playerinfo.PlayerInformation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class ArcherTrainingArmor extends ItemRPGArmor implements IArmorTextureProvider {
	
    final int armorType;
    
	public ArcherTrainingArmor(int itemid, EnumRPGArmorMaterial material, int par3, int par4, String name) {
		super(itemid, material, par3, par4, name);
		this.armorType = par4;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == ArcherArmor.tunicTraining.itemID || itemstack.itemID == ArcherArmor.bootsTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/ba/training_1.png";
		}
		else if (itemstack.itemID == ArcherArmor.legsTraining.itemID)
		{
		    return "/mods/rpg/textures/armor/ba/training_2.png";
		}

		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
	    
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
	    PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name accordingly
        if(PlayerInfoFake.getPlayersClass() == "Archer" && player.experienceLevel >= 1) {
            par3List.add("Class: �AArcher, �4Berserker");
            par3List.add("Level: �A1");
        } else if(PlayerInfoFake.getPlayersClass() == "Berserker" && player.experienceLevel >= 1) {
            par3List.add("Class: �4Archer, �ABerserker");
            par3List.add("Level: �41");
        } else if(PlayerInfoFake.getPlayersClass() == "Archer" && player.experienceLevel != 1) {
            par3List.add("Class: �AArcher, �4Berserker");
            par3List.add("Level: �41");
        } else if(PlayerInfoFake.getPlayersClass() == "Berserker" && player.experienceLevel != 1) {
            par3List.add("Class: �4Archer, �ABerserker");
            par3List.add("Level: �41");
        } else if((PlayerInfoFake.getPlayersClass() != "Archer" || PlayerInfoFake.getPlayersClass() != "Berserker") && player.experienceLevel == 1) {
            par3List.add("Class: �4Archer, �4Berserker");
            par3List.add("Level: �A1");
        } else {
            par3List.add("Class: �4Archer, �4Berserker");
            par3List.add("Level: �41");
        }
    }
}