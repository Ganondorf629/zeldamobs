package ganondorf629.zeldamobs;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.Minecraft;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class gibdo {

	public int mobid = 0;
	public static Object instance;

	public void load(FMLInitializationEvent event) {
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void registerRenderers() {
		RenderLiving customRender = new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new gibdo.Modelgibdo(), 0) {
			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("gibdotexture.png");
			}
		};
		RenderingRegistry.registerEntityRenderingHandler(gibdo.Entitygibdo.class, customRender);

	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
		int entityID = MathHelper.getRandomUUID().hashCode();
		mobid = entityID;
		EntityRegistry.registerModEntity(new ResourceLocation("ZeldaMobs:gibdo"), gibdo.Entitygibdo.class, "gibdo", entityID,
				instance, 64, 1, true, (204 << 16) + (153 << 8) + 0, (51 << 16) + (102 << 8) + 0);
		EntityRegistry.addSpawn(gibdo.Entitygibdo.class, 10, 1, 1, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));

	}

	public static Biome[] clean(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext()) {
			ls.add(itr.next());
		}
		return ls.toArray(new Biome[ls.size()]);
	}

	public static class Entitygibdo extends EntityMob {
		World world = null;

		public Entitygibdo(World var1) {
			super(var1);
			world = var1;
			experienceValue = 5;
			this.isImmuneToFire = false;
			addRandomArmor();
			setNoAI(!true);

			this.tasks.addTask(1, new EntityAIWander(this, 0.8D));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAIOpenDoor(this, true));
			this.tasks.addTask(3, new EntityAIOpenDoor(this, false));

			this.tasks.addTask(5, new EntityAISwimming(this));
			this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityDragon.class, 6.0F));
			this.tasks.addTask(7, new EntityAIAttackMelee(this, 1.0D, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
			this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true));
			this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));

		}

		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}

		protected void addRandomArmor() {

		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Items.EMERALD).getItem();
		}

		@Override
		protected net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"ZeldaMobs:entity.gibdo.idle"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getHurtSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"ZeldaMobs:entity.gibdo.hurt"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"ZeldaMobs:entity.gibdo.death"));
		}

		@Override
		public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
			super.onStruckByLightning(entityLightningBolt);
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Entity entity = this;

		}

		@Override
		public void fall(float l, float d) {
			super.fall(l, d);
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			super.fall(l, d);
			Entity entity = this;

		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Entity entity = this;

		}

		@Override
		public boolean processInteract(EntityPlayer entity, EnumHand hand) {
			super.processInteract(entity, hand);
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;

			return true;
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

	}

	// Date: 10-12-16 11:38:15
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX

	public static class Modelgibdo extends ModelBase {
		// fields
		ModelRenderer mask;
		ModelRenderer body;
		ModelRenderer rightarm;
		ModelRenderer leftarm;
		ModelRenderer rightleg;
		ModelRenderer leftleg;
		ModelRenderer head;

		public Modelgibdo() {
			textureWidth = 64;
			textureHeight = 32;

			mask = new ModelRenderer(this, 0, 0);
			mask.addBox(-4F, -8F, -4F, 8, 8, 1);
			mask.setRotationPoint(0F, 0F, 1F);
			mask.setTextureSize(64, 32);
			mask.mirror = true;
			setRotation(mask, 0F, 0F, 0F);
			body = new ModelRenderer(this, 16, 16);
			body.addBox(-4F, 0F, -2F, 8, 12, 4);
			body.setRotationPoint(0F, 0F, 0F);
			body.setTextureSize(64, 32);
			body.mirror = true;
			setRotation(body, 0.1047198F, 0F, 0F);
			rightarm = new ModelRenderer(this, 40, 16);
			rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
			rightarm.setRotationPoint(-5F, 2F, 0F);
			rightarm.setTextureSize(64, 32);
			rightarm.mirror = true;
			setRotation(rightarm, 0F, 0F, 0F);
			leftarm = new ModelRenderer(this, 40, 16);
			leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
			leftarm.setRotationPoint(5F, 2F, 0F);
			leftarm.setTextureSize(64, 32);
			leftarm.mirror = true;
			setRotation(leftarm, 0F, 0F, 0F);
			rightleg = new ModelRenderer(this, 0, 16);
			rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
			rightleg.setRotationPoint(-2F, 12F, 1F);
			rightleg.setTextureSize(64, 32);
			rightleg.mirror = true;
			setRotation(rightleg, 0F, 0F, 0F);
			leftleg = new ModelRenderer(this, 0, 16);
			leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
			leftleg.setRotationPoint(2F, 12F, 1F);
			leftleg.setTextureSize(64, 32);
			leftleg.mirror = true;
			setRotation(leftleg, 0F, 0F, 0F);
			head = new ModelRenderer(this, 0, 0);
			head.addBox(0F, 0F, 0F, 6, 7, 3);
			head.setRotationPoint(-3F, -7F, -2F);
			head.setTextureSize(64, 32);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);

			mask.render(f5);
			body.render(f5);
			rightarm.render(f5);
			leftarm.render(f5);
			rightleg.render(f5);
			leftleg.render(f5);
			head.render(f5);
		}

		private void setRotation(ModelRenderer model, float x, float y, float z) {
			model.rotateAngleX = x;
			model.rotateAngleY = y;
			model.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)

		{
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		}

	}

}
