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
public class ganondorf {

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
		RenderLiving customRender = new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new ganondorf.ModelGanondorf(), 0) {
			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("ganondorf.png");
			}
		};
		RenderingRegistry.registerEntityRenderingHandler(ganondorf.Entityganondorf.class, customRender);

	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
		int entityID = MathHelper.getRandomUUID().hashCode();
		mobid = entityID;
		EntityRegistry.registerModEntity(new ResourceLocation("testzeldamobs:ganondorf"), ganondorf.Entityganondorf.class, "ganondorf",
				entityID, instance, 64, 1, true, (153 << 16) + (0 << 8) + 0, (0 << 16) + (0 << 8) + 0);
		EntityRegistry.addSpawn(ganondorf.Entityganondorf.class, 1, 1, 1, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));

	}

	public static Biome[] clean(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext()) {
			ls.add(itr.next());
		}
		return ls.toArray(new Biome[ls.size()]);
	}

	public static class Entityganondorf extends EntityMob {
		World world = null;

		public Entityganondorf(World var1) {
			super(var1);
			world = var1;
			experienceValue = 5;
			this.isImmuneToFire = true;
			addRandomArmor();
			setNoAI(!true);
			this.tasks.addTask(0, new EntityAISwimming(this));
			this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
			this.tasks.addTask(8, new EntityAILookIdle(this));
			this.tasks.addTask(1, new EntityAIWander(this, 0.8D));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
			this.tasks.addTask(3, new EntityAIOpenDoor(this, false));
			this.tasks.addTask(5, new EntityAISwimming(this));
			this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityDragon.class, 6.0F));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
			this.targetTasks.addTask(8, new EntityAIHurtByTarget(this, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true));
			this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(9, new EntityAIAttackMelee(this, 1.0D, false));

		}

		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20D);
		}

		protected void addRandomArmor() {

		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED,
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

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		protected net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		protected net.minecraft.util.SoundEvent getHurtSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("game.neutral.hurt"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("game.neutral.die"));
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

			if (true) {
				world.spawnEntity(new EntityLightningBolt(world, i, j, k, false));
			}

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
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 5, 1));
			}

			if (true) {
				world.getWorldInfo().setRaining(!world.getWorldInfo().isRaining());
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

	// Date: 28-01-17 13:51:44
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX

	public static class ModelGanondorf extends ModelBase {
		// fields
		ModelRenderer head;
		ModelRenderer body;
		ModelRenderer rightarm;
		ModelRenderer leftarm;
		ModelRenderer rightleg;
		ModelRenderer leftleg;
		ModelRenderer epaule1;
		ModelRenderer epaule2;

		public ModelGanondorf() {
			textureWidth = 64;
			textureHeight = 64;

			head = new ModelRenderer(this, 0, 0);
			head.addBox(-4F, -8F, -4F, 8, 8, 8);
			head.setRotationPoint(0F, 0F, 0F);
			head.setTextureSize(64, 64);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
			body = new ModelRenderer(this, 16, 16);
			body.addBox(-4F, 0F, -2F, 8, 12, 4);
			body.setRotationPoint(0F, 0F, 0F);
			body.setTextureSize(64, 64);
			body.mirror = true;
			setRotation(body, 0F, 0F, 0F);
			rightarm = new ModelRenderer(this, 40, 16);
			rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
			rightarm.setRotationPoint(-5F, 2F, 0F);
			rightarm.setTextureSize(64, 64);
			rightarm.mirror = true;
			setRotation(rightarm, 0F, 0F, 0F);
			leftarm = new ModelRenderer(this, 40, 16);
			leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
			leftarm.setRotationPoint(5F, 2F, 0F);
			leftarm.setTextureSize(64, 64);
			leftarm.mirror = true;
			setRotation(leftarm, 0F, 0F, 0F);
			rightleg = new ModelRenderer(this, 0, 16);
			rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
			rightleg.setRotationPoint(-2F, 12F, 0F);
			rightleg.setTextureSize(64, 64);
			rightleg.mirror = true;
			setRotation(rightleg, 0F, 0F, 0F);
			leftleg = new ModelRenderer(this, 0, 16);
			leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
			leftleg.setRotationPoint(2F, 12F, 0F);
			leftleg.setTextureSize(64, 64);
			leftleg.mirror = true;
			setRotation(leftleg, 0F, 0F, 0F);
			epaule1 = new ModelRenderer(this, 40, 16);
			epaule1.addBox(0F, 0F, 0F, 4, 1, 4);
			epaule1.setRotationPoint(5F, -1F, -2F);
			epaule1.setTextureSize(64, 64);
			epaule1.mirror = true;
			setRotation(epaule1, 0F, 0F, 0F);
			epaule2 = new ModelRenderer(this, 40, 16);
			epaule2.addBox(0F, 0F, 0F, 4, 1, 4);
			epaule2.setRotationPoint(-9F, -1F, -2F);
			epaule2.setTextureSize(64, 64);
			epaule2.mirror = true;
			setRotation(epaule2, 0F, 0F, 0F);
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
			epaule1.render(f5);
			epaule2.render(f5);
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
