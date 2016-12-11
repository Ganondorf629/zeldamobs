package mod.mcreator;

import java.util.Random;
import mod.mcreator.CommonProxyZeldaMobs;
import mod.mcreator.mcreator_GlobalEventsZeldaMobs;
import mod.mcreator.mcreator_gibdo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid="ZeldaMobs", version="1.0", acceptedMinecraftVersions="[1.10.2]")
public class ZeldaMobs
implements IFuelHandler,
IWorldGenerator {
    public static final String MODID = "ZeldaMobs";
    public static final String VERSION = "1.0";
    @SidedProxy(clientSide="mod.mcreator.ClientProxyZeldaMobs", serverSide="mod.mcreator.CommonProxyZeldaMobs")
    public static CommonProxyZeldaMobs proxy;
    @Mod.Instance(value="ZeldaMobs")
    public static ZeldaMobs instance;
    mcreator_gibdo mcreator_0 = new mcreator_gibdo();

    public int getBurnTime(ItemStack fuel) {
        if (this.mcreator_0.addFuel(fuel) != 0) {
            return this.mcreator_0.addFuel(fuel);
        }
        return 0;
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        chunkX *= 16;
        chunkZ *= 16;
        if (world.field_73011_w.getDimension() == -1) {
            this.mcreator_0.generateNether(world, random, chunkX, chunkZ);
        }
        if (world.field_73011_w.getDimension() == 0) {
            this.mcreator_0.generateSurface(world, random, chunkX, chunkZ);
        }
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        GameRegistry.registerFuelHandler((IFuelHandler)this);
        GameRegistry.registerWorldGenerator((IWorldGenerator)this, (int)1);
        if (event.getSide() == Side.CLIENT) {
            OBJLoader.INSTANCE.addDomain("ZeldaMobs");
        }
        MinecraftForge.EVENT_BUS.register((Object)new mcreator_GlobalEventsZeldaMobs());
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)this, (IGuiHandler)new GuiHandler());
        this.mcreator_0.load(event);
        proxy.registerRenderers(this);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        this.mcreator_0.serverLoad(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        mcreator_gibdo.instance = instance;
        this.mcreator_0.preInit(event);
        ResourceLocation sound0 = new ResourceLocation("ZeldaMobs", "entity.gibdo.death");
        GameRegistry.register((IForgeRegistryEntry)new SoundEvent(sound0).setRegistryName(sound0));
        ResourceLocation sound1 = new ResourceLocation("ZeldaMobs", "entity.gibdo.hurt");
        GameRegistry.register((IForgeRegistryEntry)new SoundEvent(sound1).setRegistryName(sound1));
        ResourceLocation sound2 = new ResourceLocation("ZeldaMobs", "entity.gibdo.idle");
        GameRegistry.register((IForgeRegistryEntry)new SoundEvent(sound2).setRegistryName(sound2));
    }

    public static class GuiHandler
    implements IGuiHandler {
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }

        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }
    }

}

