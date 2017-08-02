package mod.ganondorf629;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.Minecraft;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class molgera {

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
		RenderLiving customRender = new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new molgera.ModelMolgera2(), 0) {
			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("Molgera.png");
			}
		};
		RenderingRegistry.registerEntityRenderingHandler(molgera.Entitymolgera.class, customRender);

	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
		int entityID = MathHelper.getRandomUUID().hashCode();
		mobid = entityID;
		EntityRegistry.registerModEntity(new ResourceLocation("testzeldamobs:molgera"), molgera.Entitymolgera.class, "molgera",
				entityID, instance, 64, 1, true, (204 << 16) + (153 << 8) + 0, (255 << 16) + (153 << 8) + 0);
		EntityRegistry.addSpawn(molgera.Entitymolgera.class, 1, 1, 1, EnumCreatureType.MONSTER,
				Biome.REGISTRY.getObject(new ResourceLocation("desert")));

	}

	public static Biome[] clean(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext()) {
			ls.add(itr.next());
		}
		return ls.toArray(new Biome[ls.size()]);
	}

	public static class Entitymolgera extends EntityMob {
		World world = null;

		public Entitymolgera(World var1) {
			super(var1);
			world = var1;
			experienceValue = 150;
			this.isImmuneToFire = true;
			addRandomArmor();
			setNoAI(!true);
			this.tasks.addTask(0, new EntityAISwimming(this));
			this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
			this.tasks.addTask(8, new EntityAILookIdle(this));
			this.tasks.addTask(1, new EntityAIWander(this, 0.8D));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
			this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayerMP.class, 6.0F));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityWither.class, true));
			this.targetTasks.addTask(7, new EntityAIHurtByTarget(this, false));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
			this.targetTasks.addTask(8, new EntityAIHurtByTarget(this, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true));
			this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));

		}

		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.55D);
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
		}

		protected void addRandomArmor() {

		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.YELLOW,
				BossInfo.Overlay.PROGRESS));

		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		protected void dropRareDrop(int par1) {
			this.dropItem(new ItemStack(Items.EMERALD).getItem(), 1);
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(hookshot.block).getItem();
		}

		@Override
		protected net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testzeldamobs:entity.molgera.growl"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getHurtSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testzeldamobs:entity.molgera.hurt"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testzeldamobs:entity.molgera.death"));
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

			if (true) {
				world.createExplosion((Entity) null, i, j, k, 4F, true);
			}

			if (true) {
				Entity sentity = new babyMolgera.EntitybabyMolgera(world);
				if (sentity != null && !world.isRemote) {
					sentity.setLocationAndAngles(i, j, k, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(sentity);
				}
			}

			if (true) {
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 5, 1));
			}

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

	// Date: 13-04-17 12:44:16
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX

	public static class ModelMolgera2 extends ModelBase {
		// fields
		ModelRenderer head;
		ModelRenderer body;
		ModelRenderer rightarm;
		ModelRenderer leftarm;
		ModelRenderer rightleg;
		ModelRenderer leftleg;
		ModelRenderer body2;
		ModelRenderer body3;
		ModelRenderer body4;
		ModelRenderer tete;
		ModelRenderer corne1;
		ModelRenderer corne2;
		ModelRenderer body5;
		ModelRenderer body6;
		ModelRenderer body7;
		ModelRenderer queue;
		ModelRenderer body8;
		ModelRenderer body9;
		ModelRenderer body10;
		ModelRenderer body11;
		ModelRenderer body12;
		ModelRenderer body13;

		public ModelMolgera2() {
			textureWidth = 128;
			textureHeight = 128;

			head = new ModelRenderer(this, 0, 0);
			head.addBox(-4F, -8F, -4F, 1, 1, 1);
			head.setRotationPoint(3F, 7F, 4F);
			head.setTextureSize(128, 128);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
			body = new ModelRenderer(this, 16, 16);
			body.addBox(-4F, 0F, -2F, 8, 8, 4);
			body.setRotationPoint(0F, 0F, 0F);
			body.setTextureSize(128, 128);
			body.mirror = true;
			setRotation(body, 0F, 0F, 0F);
			rightarm = new ModelRenderer(this, 40, 16);
			rightarm.addBox(-3F, -2F, -2F, 1, 1, 1);
			rightarm.setRotationPoint(-2F, 2F, 2F);
			rightarm.setTextureSize(128, 128);
			rightarm.mirror = true;
			setRotation(rightarm, 0F, 0F, 0F);
			leftarm = new ModelRenderer(this, 40, 16);
			leftarm.addBox(-1F, -2F, -2F, 1, 1, 1);
			leftarm.setRotationPoint(5F, 2F, 2F);
			leftarm.setTextureSize(128, 128);
			leftarm.mirror = true;
			setRotation(leftarm, 0F, 0F, 0F);
			rightleg = new ModelRenderer(this, 0, 16);
			rightleg.addBox(-2F, 0F, -2F, 1, 1, 1);
			rightleg.setRotationPoint(0F, 8F, 0F);
			rightleg.setTextureSize(128, 128);
			rightleg.mirror = true;
			setRotation(rightleg, 0F, 0F, 0F);
			leftleg = new ModelRenderer(this, 0, 16);
			leftleg.addBox(-2F, 0F, -2F, 1, 1, 1);
			leftleg.setRotationPoint(3F, 8F, 0F);
			leftleg.setTextureSize(128, 128);
			leftleg.mirror = true;
			setRotation(leftleg, 0F, 0F, 0F);
			body2 = new ModelRenderer(this, 16, 16);
			body2.addBox(0F, 0F, 0F, 8, 8, 4);
			body2.setRotationPoint(0F, -1F, -6F);
			body2.setTextureSize(128, 128);
			body2.mirror = true;
			setRotation(body2, 0F, 0F, 0.8028515F);
			body3 = new ModelRenderer(this, 16, 16);
			body3.addBox(0F, 0F, 0F, 8, 8, 4);
			body3.setRotationPoint(0F, -1F, 2F);
			body3.setTextureSize(128, 128);
			body3.mirror = true;
			setRotation(body3, 0F, 0F, 0.8028515F);
			body4 = new ModelRenderer(this, 16, 16);
			body4.addBox(0F, 0F, 0F, 8, 8, 4);
			body4.setRotationPoint(-4F, 0F, 6F);
			body4.setTextureSize(128, 128);
			body4.mirror = true;
			setRotation(body4, 0F, 0F, 0F);
			tete = new ModelRenderer(this, 16, 16);
			tete.addBox(0F, 0F, 0F, 8, 8, 4);
			tete.setRotationPoint(-6F, 8F, -10F);
			tete.setTextureSize(128, 128);
			tete.mirror = true;
			setRotation(tete, 1.58825F, 0.8726646F, 0F);
			corne1 = new ModelRenderer(this, 16, 16);
			corne1.addBox(0F, 0F, 0F, 6, 4, 1);
			corne1.setRotationPoint(-8F, 7F, -14F);
			corne1.setTextureSize(128, 128);
			corne1.mirror = true;
			setRotation(corne1, 1.64061F, 0.8726646F, 0F);
			corne2 = new ModelRenderer(this, 16, 16);
			corne2.addBox(0F, 0F, 0F, 6, 4, 1);
			corne2.setRotationPoint(4F, 7F, -12F);
			corne2.setTextureSize(128, 128);
			corne2.mirror = true;
			setRotation(corne2, 1.58825F, 2.443461F, 0F);
			body5 = new ModelRenderer(this, 16, 16);
			body5.addBox(0F, 0F, 0F, 8, 8, 4);
			body5.setRotationPoint(0F, -1F, 10F);
			body5.setTextureSize(128, 128);
			body5.mirror = true;
			setRotation(body5, 0F, 0F, 0.8028515F);
			body6 = new ModelRenderer(this, 16, 16);
			body6.addBox(0F, 0F, 0F, 8, 8, 4);
			body6.setRotationPoint(-4F, 0F, 14F);
			body6.setTextureSize(128, 128);
			body6.mirror = true;
			setRotation(body6, 0F, 0F, 0F);
			body7 = new ModelRenderer(this, 16, 16);
			body7.addBox(0F, 0F, 0F, 8, 8, 4);
			body7.setRotationPoint(0F, -1F, 18F);
			body7.setTextureSize(128, 128);
			body7.mirror = true;
			setRotation(body7, 0F, 0F, 0.8028515F);
			queue = new ModelRenderer(this, 16, 16);
			queue.addBox(0F, 0F, 0F, 12, 2, 4);
			queue.setRotationPoint(-6F, 4F, 46F);
			queue.setTextureSize(128, 128);
			queue.mirror = true;
			setRotation(queue, 0F, 0F, 0F);
			body8 = new ModelRenderer(this, 16, 16);
			body8.addBox(0F, 0F, 0F, 8, 8, 4);
			body8.setRotationPoint(-4F, 0F, 22F);
			body8.setTextureSize(128, 128);
			body8.mirror = true;
			setRotation(body8, 0F, 0F, 0F);
			body9 = new ModelRenderer(this, 16, 16);
			body9.addBox(0F, 0F, 0F, 8, 8, 4);
			body9.setRotationPoint(0F, -1F, 26F);
			body9.setTextureSize(128, 128);
			body9.mirror = true;
			setRotation(body9, 0F, 0F, 0.8028515F);
			body10 = new ModelRenderer(this, 16, 16);
			body10.addBox(0F, 0F, 0F, 8, 8, 4);
			body10.setRotationPoint(-4F, 0F, 30F);
			body10.setTextureSize(128, 128);
			body10.mirror = true;
			setRotation(body10, 0F, 0F, 0F);
			body11 = new ModelRenderer(this, 16, 16);
			body11.addBox(0F, 0F, 0F, 8, 8, 4);
			body11.setRotationPoint(0F, -1F, 34F);
			body11.setTextureSize(128, 128);
			body11.mirror = true;
			setRotation(body11, 0F, 0F, 0.8028515F);
			body12 = new ModelRenderer(this, 16, 16);
			body12.addBox(0F, 0F, 0F, 8, 8, 4);
			body12.setRotationPoint(-4F, 0F, 38F);
			body12.setTextureSize(128, 128);
			body12.mirror = true;
			setRotation(body12, 0F, 0F, 0F);
			body13 = new ModelRenderer(this, 16, 16);
			body13.addBox(0F, 0F, 0F, 8, 8, 4);
			body13.setRotationPoint(0F, -1F, 42F);
			body13.setTextureSize(128, 128);
			body13.mirror = true;
			setRotation(body13, 0F, 0F, 0.8028515F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);

			head.render(f5);
			body.render(f5);
			rightarm.render(f5);
			leftarm.render(f5);
			rightleg.render(f5);
			leftleg.render(f5);
			body2.render(f5);
			body3.render(f5);
			body4.render(f5);
			tete.render(f5);
			corne1.render(f5);
			corne2.render(f5);
			body5.render(f5);
			body6.render(f5);
			body7.render(f5);
			queue.render(f5);
			body8.render(f5);
			body9.render(f5);
			body10.render(f5);
			body11.render(f5);
			body12.render(f5);
			body13.render(f5);
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
