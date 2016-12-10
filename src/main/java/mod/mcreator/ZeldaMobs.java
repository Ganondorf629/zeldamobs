package mod.mcreator;

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

@Mod(modid = TestEnvironmentMod.MODID, version = TestEnvironmentMod.VERSION)
public class TestEnvironmentMod implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "TestEnvironmentMod";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "mod.mcreator.ClientProxyTestEnvironmentMod", serverSide = "mod.mcreator.CommonProxyTestEnvironmentMod")
	public static CommonProxyTestEnvironmentMod proxy;

	@Instance(MODID)
	public static TestEnvironmentMod instance;

	mcreator_gibdo mcreator_0 = new mcreator_gibdo();

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (mcreator_0.addFuel(fuel) != 0)
			return mcreator_0.addFuel(fuel);
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

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 1);
		if (event.getSide() == Side.CLIENT) {
			OBJLoader.INSTANCE.addDomain("TestEnvironmentMod");
		}
		MinecraftForge.EVENT_BUS.register(new mcreator_GlobalEventsTestEnvironmentMod());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		mcreator_0.load(event);
		proxy.registerRenderers(this);

	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		mcreator_0.serverLoad(event);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		mcreator_0.instance = this.instance;
		mcreator_0.preInit(event);

		ResourceLocation sound0 = new ResourceLocation("TestEnvironmentMod", "1");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound0).setRegistryName(sound0));

		ResourceLocation sound1 = new ResourceLocation("TestEnvironmentMod", "2");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound1).setRegistryName(sound1));

		ResourceLocation sound2 = new ResourceLocation("TestEnvironmentMod", "3");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound2).setRegistryName(sound2));

		ResourceLocation sound3 = new ResourceLocation("TestEnvironmentMod", "4");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound3).setRegistryName(sound3));

		ResourceLocation sound4 = new ResourceLocation("TestEnvironmentMod", "5");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound4).setRegistryName(sound4));

		ResourceLocation sound5 = new ResourceLocation("TestEnvironmentMod", "6");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound5).setRegistryName(sound5));

		ResourceLocation sound6 = new ResourceLocation("TestEnvironmentMod", "7");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound6).setRegistryName(sound6));

		ResourceLocation sound7 = new ResourceLocation("TestEnvironmentMod", "8");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound7).setRegistryName(sound7));

		ResourceLocation sound8 = new ResourceLocation("TestEnvironmentMod", "9");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound8).setRegistryName(sound8));

		ResourceLocation sound9 = new ResourceLocation("TestEnvironmentMod", "10");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound9).setRegistryName(sound9));

		ResourceLocation sound10 = new ResourceLocation("TestEnvironmentMod", "11");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound10).setRegistryName(sound10));

		ResourceLocation sound11 = new ResourceLocation("TestEnvironmentMod", "12");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound11).setRegistryName(sound11));

		ResourceLocation sound12 = new ResourceLocation("TestEnvironmentMod", "13");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound12).setRegistryName(sound12));

		ResourceLocation sound13 = new ResourceLocation("TestEnvironmentMod", "14");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound13).setRegistryName(sound13));

		ResourceLocation sound14 = new ResourceLocation("TestEnvironmentMod", "15");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound14).setRegistryName(sound14));

		ResourceLocation sound15 = new ResourceLocation("TestEnvironmentMod", "16");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound15).setRegistryName(sound15));

		ResourceLocation sound16 = new ResourceLocation("TestEnvironmentMod", "17");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound16).setRegistryName(sound16));

		ResourceLocation sound17 = new ResourceLocation("TestEnvironmentMod", "18");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound17).setRegistryName(sound17));

		ResourceLocation sound18 = new ResourceLocation("TestEnvironmentMod", "19");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound18).setRegistryName(sound18));

		ResourceLocation sound19 = new ResourceLocation("TestEnvironmentMod", "20");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound19).setRegistryName(sound19));

		ResourceLocation sound20 = new ResourceLocation("TestEnvironmentMod", "21");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound20).setRegistryName(sound20));

		ResourceLocation sound21 = new ResourceLocation("TestEnvironmentMod", "22");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound21).setRegistryName(sound21));

		ResourceLocation sound22 = new ResourceLocation("TestEnvironmentMod", "23");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound22).setRegistryName(sound22));

		ResourceLocation sound23 = new ResourceLocation("TestEnvironmentMod", "24");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound23).setRegistryName(sound23));

		ResourceLocation sound24 = new ResourceLocation("TestEnvironmentMod", "25");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound24).setRegistryName(sound24));

		ResourceLocation sound25 = new ResourceLocation("TestEnvironmentMod", "26");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound25).setRegistryName(sound25));

		ResourceLocation sound26 = new ResourceLocation("TestEnvironmentMod", "26");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound26).setRegistryName(sound26));

		ResourceLocation sound27 = new ResourceLocation("TestEnvironmentMod", "27");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound27).setRegistryName(sound27));

		ResourceLocation sound28 = new ResourceLocation("TestEnvironmentMod", "27");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound28).setRegistryName(sound28));

		ResourceLocation sound29 = new ResourceLocation("TestEnvironmentMod", "28");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound29).setRegistryName(sound29));

		ResourceLocation sound30 = new ResourceLocation("TestEnvironmentMod", "29");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound30).setRegistryName(sound30));

		ResourceLocation sound31 = new ResourceLocation("TestEnvironmentMod", "30");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound31).setRegistryName(sound31));

		ResourceLocation sound32 = new ResourceLocation("TestEnvironmentMod", "31");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound32).setRegistryName(sound32));

		ResourceLocation sound33 = new ResourceLocation("TestEnvironmentMod", "32");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound33).setRegistryName(sound33));

		ResourceLocation sound34 = new ResourceLocation("TestEnvironmentMod", "33");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound34).setRegistryName(sound34));

		ResourceLocation sound35 = new ResourceLocation("TestEnvironmentMod", "34");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound35).setRegistryName(sound35));

		ResourceLocation sound36 = new ResourceLocation("TestEnvironmentMod", "35");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound36).setRegistryName(sound36));

		ResourceLocation sound37 = new ResourceLocation("TestEnvironmentMod", "36");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound37).setRegistryName(sound37));

		ResourceLocation sound38 = new ResourceLocation("TestEnvironmentMod", "37");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound38).setRegistryName(sound38));

		ResourceLocation sound39 = new ResourceLocation("TestEnvironmentMod", "38");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound39).setRegistryName(sound39));

		ResourceLocation sound40 = new ResourceLocation("TestEnvironmentMod", "39");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound40).setRegistryName(sound40));

		ResourceLocation sound41 = new ResourceLocation("TestEnvironmentMod", "40");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound41).setRegistryName(sound41));

		ResourceLocation sound42 = new ResourceLocation("TestEnvironmentMod", "41");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound42).setRegistryName(sound42));

		ResourceLocation sound43 = new ResourceLocation("TestEnvironmentMod", "42");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound43).setRegistryName(sound43));

		ResourceLocation sound44 = new ResourceLocation("TestEnvironmentMod", "43");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound44).setRegistryName(sound44));

		ResourceLocation sound45 = new ResourceLocation("TestEnvironmentMod", "45");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound45).setRegistryName(sound45));

		ResourceLocation sound46 = new ResourceLocation("TestEnvironmentMod", "46");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound46).setRegistryName(sound46));

		ResourceLocation sound47 = new ResourceLocation("TestEnvironmentMod", "47");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound47).setRegistryName(sound47));

		ResourceLocation sound48 = new ResourceLocation("TestEnvironmentMod", "48");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound48).setRegistryName(sound48));

		ResourceLocation sound49 = new ResourceLocation("TestEnvironmentMod", "49");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound49).setRegistryName(sound49));

		ResourceLocation sound50 = new ResourceLocation("TestEnvironmentMod", "50");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound50).setRegistryName(sound50));

		ResourceLocation sound51 = new ResourceLocation("TestEnvironmentMod", "");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound51).setRegistryName(sound51));

		ResourceLocation sound52 = new ResourceLocation("TestEnvironmentMod", "entity.gibdo.death");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound52).setRegistryName(sound52));

		ResourceLocation sound53 = new ResourceLocation("TestEnvironmentMod", "entity.gibdo.hurt");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound53).setRegistryName(sound53));

		ResourceLocation sound54 = new ResourceLocation("TestEnvironmentMod", "entity.gibdo.idle");
		GameRegistry.register(new net.minecraft.util.SoundEvent(sound54).setRegistryName(sound54));

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
