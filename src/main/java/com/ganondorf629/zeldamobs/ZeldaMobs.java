package ganondorf629.zeldamobs;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.model.obj.OBJLoader;

import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Random;

@Mod(modid = ZeldaMobs.MODID, version = ZeldaMobs.VERSION)
public class ZeldaMobs implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "ZeldaMobs";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "ganondorf629.zeldamobs.ClientProxyZeldaMobs", serverSide = "ganondorf629.zeldamobs.CommonProxyZeldaMobs")
	public static CommonProxyZeldaMobs proxy;

	@Instance(MODID)
	public static ZeldaMobs instance;

	gibdo mcreator_0 = new gibdo();
	darknut mcreator_1 = new darknut();
	molgera mcreator_2 = new molgera();
	molgeraStatue mcreator_3 = new molgeraStatue();
	gossipStone mcreator_4 = new gossipStone();
	oldMossyCobblestone mcreator_5 = new oldMossyCobblestone();
	zeldaMobsBlocks mcreator_6 = new zeldaMobsBlocks();
	stalchildStatue mcreator_7 = new stalchildStatue();

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (mcreator_0.addFuel(fuel) != 0)
			return mcreator_0.addFuel(fuel);
		if (mcreator_1.addFuel(fuel) != 0)
			return mcreator_1.addFuel(fuel);
		if (mcreator_2.addFuel(fuel) != 0)
			return mcreator_2.addFuel(fuel);
		if (mcreator_3.addFuel(fuel) != 0)
			return mcreator_3.addFuel(fuel);
		if (mcreator_4.addFuel(fuel) != 0)
			return mcreator_4.addFuel(fuel);
		if (mcreator_5.addFuel(fuel) != 0)
			return mcreator_5.addFuel(fuel);
		if (mcreator_6.addFuel(fuel) != 0)
			return mcreator_6.addFuel(fuel);
		if (mcreator_7.addFuel(fuel) != 0)
			return mcreator_7.addFuel(fuel);
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		chunkX = chunkX * 16;
		chunkZ = chunkZ * 16;
		if (world.provider.getDimension() == -1)
			mcreator_0.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_0.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_1.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_1.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_2.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_2.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_3.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_3.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_4.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_4.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_5.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_5.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_6.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_6.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_7.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_7.generateSurface(world, random, chunkX, chunkZ);

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 1);
		if (event.getSide() == Side.CLIENT) {
			OBJLoader.INSTANCE.addDomain("ZeldaMobs");
		}
		MinecraftForge.EVENT_BUS.register(new GlobalEventsZeldaMobs());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		mcreator_0.load(event);
		mcreator_1.load(event);
		mcreator_2.load(event);
		mcreator_3.load(event);
		mcreator_4.load(event);
		mcreator_5.load(event);
		mcreator_6.load(event);
		mcreator_7.load(event);
		proxy.registerRenderers(this);

	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		mcreator_0.serverLoad(event);
		mcreator_1.serverLoad(event);
		mcreator_2.serverLoad(event);
		mcreator_3.serverLoad(event);
		mcreator_4.serverLoad(event);
		mcreator_5.serverLoad(event);
		mcreator_6.serverLoad(event);
		mcreator_7.serverLoad(event);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		mcreator_0.instance = this.instance;
		mcreator_1.instance = this.instance;
		mcreator_2.instance = this.instance;
		mcreator_3.instance = this.instance;
		mcreator_4.instance = this.instance;
		mcreator_5.instance = this.instance;
		mcreator_6.instance = this.instance;
		mcreator_7.instance = this.instance;
		mcreator_0.preInit(event);
		mcreator_1.preInit(event);
		mcreator_2.preInit(event);
		mcreator_3.preInit(event);
		mcreator_4.preInit(event);
		mcreator_5.preInit(event);
		mcreator_6.preInit(event);
		mcreator_7.preInit(event);

		ResourceLocation sound0 = new ResourceLocation("ZeldaMobs", "entity.gibdo.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound0).setRegistryName(sound0));

		ResourceLocation sound1 = new ResourceLocation("ZeldaMobs", "entity.gibdo.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound1).setRegistryName(sound1));

		ResourceLocation sound2 = new ResourceLocation("ZeldaMobs", "entity.gibdo.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound2).setRegistryName(sound2));

		ResourceLocation sound3 = new ResourceLocation("ZeldaMobs", "entity.darknut.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound3).setRegistryName(sound3));

		ResourceLocation sound4 = new ResourceLocation("ZeldaMobs", "entity.darknut.hit");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound4).setRegistryName(sound4));

		ResourceLocation sound5 = new ResourceLocation("ZeldaMobs", "entity.darknut.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound5).setRegistryName(sound5));

		ResourceLocation sound6 = new ResourceLocation("ZeldaMobs", "entity.molgera.growl");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound6).setRegistryName(sound6));

		ResourceLocation sound7 = new ResourceLocation("ZeldaMobs", "entity.molgera.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound7).setRegistryName(sound7));

		ResourceLocation sound8 = new ResourceLocation("ZeldaMobs", "entity.molgera.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound8).setRegistryName(sound8));

		ResourceLocation sound9 = new ResourceLocation("ZeldaMobs", "entity.stalchild.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound9).setRegistryName(sound9));

		ResourceLocation sound10 = new ResourceLocation("ZeldaMobs", "entity.stalchild.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound10).setRegistryName(sound10));

		ResourceLocation sound11 = new ResourceLocation("ZeldaMobs", "entity.stalchild.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound11).setRegistryName(sound11));

	}

	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}
	}

}
