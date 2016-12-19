package mod.mcreator;

import java.util.Random;
import mod.mcreator.mcreator_gossipStone;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class mcreator_zeldaMobsBlocks {
    public static Object instance;
    public static CreativeTabs tab;

    public void load(FMLInitializationEvent event) {
    }

    public void registerRenderers() {
    }

    public void generateNether(World world, Random random, int chunkX, int chunkZ) {
    }

    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
    }

    public int addFuel(ItemStack fuel) {
        return 0;
    }

    public void serverLoad(FMLServerStartingEvent event) {
    }

    public void preInit(FMLPreInitializationEvent event) {
    }

    static {
        tab = new CreativeTabs("tabzeldaMobsBlocks"){

            @SideOnly(value=Side.CLIENT)
            public Item func_78016_d() {
                return new ItemStack((Block)mcreator_gossipStone.block).func_77973_b();
            }
        };
    }

}

