package mod.ganondorf629;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.util.EnumHelper;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;

import java.util.Set;
import java.util.Random;
import java.util.HashMap;

public class boomerang {

	public boomerang() {
	}

	public static Item block;
	public static Object instance;

	public void load(FMLInitializationEvent event) {
		ItemStack stack = new ItemStack(block, 1);
		if (event.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(block, 0, new ModelResourceLocation("testzeldamobs:boomerang", "inventory"));
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

	public void registerRenderers() {
	}

	static {
		Item.ToolMaterial enumt = EnumHelper.addToolMaterial("BOOMERANG", 1, 100, 4F, 4, 2);
		block = (Item) (new ItemSword(enumt) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("sword", 1);
				return ret.keySet();
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
				float var4 = 1.0F;
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * (double) var4);
				int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * (double) var4 + 1.62D);
				int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) var4);

				if (true) {
					EntityTippedArrow entityarrow = new EntityTippedArrow(world, (EntityLivingBase) entity);
					entityarrow.setVelocity(3 * 2.0F, 3 * 2.0F, 3 * 2.0F);
					entityarrow.setDamage(3 * 2.0F);
					entityarrow.setKnockbackStrength(1);
					world.playSound((EntityPlayer) null, entity.posX, entity.posY, entity.posZ, SoundEvents.ENTITY_ARROW_SHOOT,
							SoundCategory.NEUTRAL, 1.0F, 1.0F);
					if (!world.isRemote)
						world.spawnEntity(entityarrow);
				}

				return ar;
			}
		}).setUnlocalizedName("Boomerang");
		block.setRegistryName("Boomerang");
		GameRegistry.register(block);
		block.setCreativeTab(CreativeTabs.COMBAT);

	}

}
