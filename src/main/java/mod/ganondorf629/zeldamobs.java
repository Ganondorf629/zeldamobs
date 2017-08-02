package mod.ganondorf629;

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

@Mod(modid = testzeldamobs.MODID, version = testzeldamobs.VERSION)
public class testzeldamobs implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "testzeldamobs";
	public static final String VERSION = "1.6.2";

	@SidedProxy(clientSide = "mod.ganondorf629.ClientProxytestzeldamobs", serverSide = "mod.ganondorf629.CommonProxytestzeldamobs")
	public static CommonProxytestzeldamobs proxy;

	@Instance(MODID)
	public static testzeldamobs instance;

	gibdo 0 = new gibdo();
	darknut 1 = new darknut();
	molgera 2 = new molgera();
	molgeraStatue 3 = new molgeraStatue();
	gossipStone 4 = new gossipStone();
	oldMossyCobblestone 5 = new oldMossyCobblestone();
	zeldaMobsBlocks 6 = new zeldaMobsBlocks();
	stalchildStatue 7 = new stalchildStatue();
	blueBokoblin 8 = new blueBokoblin();
	breathOfTheWildBokoblin 9 = new breathOfTheWildBokoblin();
	hylianShield 10 = new hylianShield();
	masterSword 11 = new masterSword();
	stalchild 12 = new stalchild();
	mace 13 = new mace();
	heroSword 14 = new heroSword();
	hookshot 15 = new hookshot();
	kokiriShield 16 = new kokiriShield();
	boomerang 17 = new boomerang();
	ganondorf 18 = new ganondorf();
	braveShield 19 = new braveShield();
	momie 20 = new momie();
	tektite 21 = new tektite();
	babyMolgera 22 = new babyMolgera();
	mirrorShield 23 = new mirrorShield();
	helmarocKing 24 = new helmarocKing();
	templeOfTime 25 = new templeOfTime();

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (0.addFuel(fuel) != 0)
			return 0.addFuel(fuel);
		if (1.addFuel(fuel) != 0)
			return 1.addFuel(fuel);
		if (2.addFuel(fuel) != 0)
			return 2.addFuel(fuel);
		if (3.addFuel(fuel) != 0)
			return 3.addFuel(fuel);
		if (4.addFuel(fuel) != 0)
			return 4.addFuel(fuel);
		if (5.addFuel(fuel) != 0)
			return 5.addFuel(fuel);
		if (6.addFuel(fuel) != 0)
			return 6.addFuel(fuel);
		if (7.addFuel(fuel) != 0)
			return 7.addFuel(fuel);
		if (8.addFuel(fuel) != 0)
			return 8.addFuel(fuel);
		if (9.addFuel(fuel) != 0)
			return 9.addFuel(fuel);
		if (10.addFuel(fuel) != 0)
			return 10.addFuel(fuel);
		if (11.addFuel(fuel) != 0)
			return 11.addFuel(fuel);
		if (12.addFuel(fuel) != 0)
			return 12.addFuel(fuel);
		if (13.addFuel(fuel) != 0)
			return 13.addFuel(fuel);
		if (14.addFuel(fuel) != 0)
			return 14.addFuel(fuel);
		if (15.addFuel(fuel) != 0)
			return 15.addFuel(fuel);
		if (16.addFuel(fuel) != 0)
			return 16.addFuel(fuel);
		if (17.addFuel(fuel) != 0)
			return 17.addFuel(fuel);
		if (18.addFuel(fuel) != 0)
			return 18.addFuel(fuel);
		if (19.addFuel(fuel) != 0)
			return 19.addFuel(fuel);
		if (20.addFuel(fuel) != 0)
			return 20.addFuel(fuel);
		if (21.addFuel(fuel) != 0)
			return 21.addFuel(fuel);
		if (22.addFuel(fuel) != 0)
			return 22.addFuel(fuel);
		if (23.addFuel(fuel) != 0)
			return 23.addFuel(fuel);
		if (24.addFuel(fuel) != 0)
			return 24.addFuel(fuel);
		if (25.addFuel(fuel) != 0)
			return 25.addFuel(fuel);
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		chunkX = chunkX * 16;
		chunkZ = chunkZ * 16;
		if (world.provider.getDimension() == -1)
			0.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			0.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			1.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			1.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			2.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			2.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			3.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			3.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			4.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			4.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			5.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			5.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			6.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			6.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			7.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			7.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			8.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			8.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			9.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			9.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			10.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			10.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			11.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			11.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			12.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			12.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			13.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			13.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			14.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			14.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			15.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			15.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			16.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			16.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			17.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			17.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			18.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			18.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			19.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			19.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			20.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			20.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			21.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			21.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			22.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			22.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			23.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			23.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			24.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			24.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			25.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			25.generateSurface(world, random, chunkX, chunkZ);

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 1);
		if (event.getSide() == Side.CLIENT) {
			OBJLoader.INSTANCE.addDomain("testzeldamobs");
		}
		MinecraftForge.EVENT_BUS.register(new GlobalEventstestzeldamobs());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		0.load(event);
		1.load(event);
		2.load(event);
		3.load(event);
		4.load(event);
		5.load(event);
		6.load(event);
		7.load(event);
		8.load(event);
		9.load(event);
		10.load(event);
		11.load(event);
		12.load(event);
		13.load(event);
		14.load(event);
		15.load(event);
		16.load(event);
		17.load(event);
		18.load(event);
		19.load(event);
		20.load(event);
		21.load(event);
		22.load(event);
		23.load(event);
		24.load(event);
		25.load(event);
		proxy.registerRenderers(this);

	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		0.serverLoad(event);
		1.serverLoad(event);
		2.serverLoad(event);
		3.serverLoad(event);
		4.serverLoad(event);
		5.serverLoad(event);
		6.serverLoad(event);
		7.serverLoad(event);
		8.serverLoad(event);
		9.serverLoad(event);
		10.serverLoad(event);
		11.serverLoad(event);
		12.serverLoad(event);
		13.serverLoad(event);
		14.serverLoad(event);
		15.serverLoad(event);
		16.serverLoad(event);
		17.serverLoad(event);
		18.serverLoad(event);
		19.serverLoad(event);
		20.serverLoad(event);
		21.serverLoad(event);
		22.serverLoad(event);
		23.serverLoad(event);
		24.serverLoad(event);
		25.serverLoad(event);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		0.instance = this.instance;
		1.instance = this.instance;
		2.instance = this.instance;
		3.instance = this.instance;
		4.instance = this.instance;
		5.instance = this.instance;
		6.instance = this.instance;
		7.instance = this.instance;
		8.instance = this.instance;
		9.instance = this.instance;
		10.instance = this.instance;
		11.instance = this.instance;
		12.instance = this.instance;
		13.instance = this.instance;
		14.instance = this.instance;
		15.instance = this.instance;
		16.instance = this.instance;
		17.instance = this.instance;
		18.instance = this.instance;
		19.instance = this.instance;
		20.instance = this.instance;
		21.instance = this.instance;
		22.instance = this.instance;
		23.instance = this.instance;
		24.instance = this.instance;
		25.instance = this.instance;
		0.preInit(event);
		1.preInit(event);
		2.preInit(event);
		3.preInit(event);
		4.preInit(event);
		5.preInit(event);
		6.preInit(event);
		7.preInit(event);
		8.preInit(event);
		9.preInit(event);
		10.preInit(event);
		11.preInit(event);
		12.preInit(event);
		13.preInit(event);
		14.preInit(event);
		15.preInit(event);
		16.preInit(event);
		17.preInit(event);
		18.preInit(event);
		19.preInit(event);
		20.preInit(event);
		21.preInit(event);
		22.preInit(event);
		23.preInit(event);
		24.preInit(event);
		25.preInit(event);

		ResourceLocation sound0 = new ResourceLocation("testzeldamobs", "entity.gibdo.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound0).setRegistryName(sound0));

		ResourceLocation sound1 = new ResourceLocation("testzeldamobs", "entity.gibdo.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound1).setRegistryName(sound1));

		ResourceLocation sound2 = new ResourceLocation("testzeldamobs", "entity.gibdo.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound2).setRegistryName(sound2));

		ResourceLocation sound3 = new ResourceLocation("testzeldamobs", "entity.darknut.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound3).setRegistryName(sound3));

		ResourceLocation sound4 = new ResourceLocation("testzeldamobs", "entity.darknut.hit");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound4).setRegistryName(sound4));

		ResourceLocation sound5 = new ResourceLocation("testzeldamobs", "entity.darknut.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound5).setRegistryName(sound5));

		ResourceLocation sound6 = new ResourceLocation("testzeldamobs", "entity.molgera.growl");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound6).setRegistryName(sound6));

		ResourceLocation sound7 = new ResourceLocation("testzeldamobs", "entity.molgera.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound7).setRegistryName(sound7));

		ResourceLocation sound8 = new ResourceLocation("testzeldamobs", "entity.molgera.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound8).setRegistryName(sound8));

		ResourceLocation sound9 = new ResourceLocation("testzeldamobs", "entity.stalchild.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound9).setRegistryName(sound9));

		ResourceLocation sound10 = new ResourceLocation("testzeldamobs", "entity.stalchild.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound10).setRegistryName(sound10));

		ResourceLocation sound11 = new ResourceLocation("testzeldamobs", "entity.stalchild.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound11).setRegistryName(sound11));

		ResourceLocation sound12 = new ResourceLocation("testzeldamobs", "entity.bokoblin.attack");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound12).setRegistryName(sound12));

		ResourceLocation sound13 = new ResourceLocation("testzeldamobs", "entity.bokoblin.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound13).setRegistryName(sound13));

		ResourceLocation sound14 = new ResourceLocation("testzeldamobs", "entity.bokoblin.hit");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound14).setRegistryName(sound14));

		ResourceLocation sound15 = new ResourceLocation("testzeldamobs", "entity.jayharla.hit");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound15).setRegistryName(sound15));

		ResourceLocation sound16 = new ResourceLocation("testzeldamobs", "entity.jayharla.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound16).setRegistryName(sound16));

		ResourceLocation sound17 = new ResourceLocation("testzeldamobs", "entity.jayharla.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound17).setRegistryName(sound17));

		ResourceLocation sound18 = new ResourceLocation("testzeldamobs", "entity.molblin.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound18).setRegistryName(sound18));

		ResourceLocation sound19 = new ResourceLocation("testzeldamobs", "entity.molblin.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound19).setRegistryName(sound19));

		ResourceLocation sound20 = new ResourceLocation("testzeldamobs", "entity.molblin.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound20).setRegistryName(sound20));

		ResourceLocation sound21 = new ResourceLocation("testzeldamobs", "entity.helmarocking.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound21).setRegistryName(sound21));

		ResourceLocation sound22 = new ResourceLocation("testzeldamobs", "entity.helmarocking.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound22).setRegistryName(sound22));

		ResourceLocation sound23 = new ResourceLocation("testzeldamobs", "entity.helmarocking.ambient");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound23).setRegistryName(sound23));

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
