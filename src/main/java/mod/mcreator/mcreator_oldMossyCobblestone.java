package mod.mcreator;

import java.util.Random;
import mod.mcreator.mcreator_zeldaMobsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class mcreator_oldMossyCobblestone {
    public static BlockOldMossyCobblestone block = (BlockOldMossyCobblestone)new BlockOldMossyCobblestone().func_149711_c(2.0f).func_149752_b(10.0f).func_149715_a(0.0f).func_149663_c("OldMossyCobblestone").func_149713_g(6).func_149722_s().func_149647_a(mcreator_zeldaMobsBlocks.tab);
    public static Object instance;

    public int addFuel(ItemStack fuel) {
        return 0;
    }

    public void serverLoad(FMLServerStartingEvent event) {
    }

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void registerRenderers() {
    }

    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178086_a(Item.func_150898_a((Block)block), 0, new ModelResourceLocation("ZeldaMobs:OldMossyCobblestone", "inventory"));
        }
    }

    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
    }

    public void generateNether(World world, Random random, int chunkX, int chunkZ) {
    }

    static {
        block.setHarvestLevel("pickaxe", 0);
    }

    static class BlockOldMossyCobblestone
    extends BlockFalling {
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        int a5 = 0;
        int a6 = 0;
        boolean red = false;

        protected BlockOldMossyCobblestone() {
            super(Material.field_151576_e);
            GameRegistry.registerBlock((Block)this, (String)"OldMossyCobblestone");
            this.func_149672_a(SoundType.field_185851_d);
        }

        public void func_176213_c(World world, BlockPos pos, IBlockState state) {
            int i = pos.func_177958_n();
            int j = pos.func_177956_o();
            int k = pos.func_177952_p();
            EntityPlayerSP entity = Minecraft.func_71410_x().field_71439_g;
            world.func_175684_a(new BlockPos(i, j, k), (Block)this, this.func_149738_a(world));
        }

        public int func_180656_a(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
            return this.red ? 15 : 0;
        }

        public int func_176211_b(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
            return this.red ? 15 : 0;
        }

        @SideOnly(value=Side.CLIENT)
        public BlockRenderLayer func_180664_k() {
            return BlockRenderLayer.SOLID;
        }

        public AxisAlignedBB func_185496_a(IBlockState state, IBlockAccess source, BlockPos pos) {
            return new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        }

        public int func_149738_a(World world) {
            return 10;
        }

        public int func_149745_a(Random par1Random) {
            return 1;
        }
    }

}

