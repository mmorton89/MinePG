package rpg.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import rpg.enums.EnumRPGToolMaterial;

public class ItemRPGAxe extends ItemRPGTool {

    /** an array of the blocks this axe is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] { Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin,
            Block.pumpkinLantern };

    public ItemRPGAxe(int par1, EnumRPGToolMaterial par2EnumToolMaterial, String name) {
        super(par1, 3, par2EnumToolMaterial, blocksEffectiveAgainst, name);

    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    @Override
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
        return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial
                : super.getStrVsBlock(par1ItemStack, par2Block);
    }
}
