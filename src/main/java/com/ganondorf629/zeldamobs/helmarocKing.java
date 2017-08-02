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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
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
public class helmarocKing {

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
		RenderLiving customRender = new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new helmarocKing.ModelHelmarocKing(), 0) {
			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("helmarocking.png");
			}
		};
		RenderingRegistry.registerEntityRenderingHandler(helmarocKing.EntityhelmarocKing.class, customRender);

	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
		int entityID = MathHelper.getRandomUUID().hashCode();
		mobid = entityID;
		EntityRegistry.registerModEntity(new ResourceLocation("testzeldamobs:helmarocKing"), helmarocKing.EntityhelmarocKing.class,
				"helmarocKing", entityID, instance, 64, 1, true, (0 << 16) + (0 << 8) + 204, (255 << 16) + (255 << 8) + 0);
		EntityRegistry.addSpawn(helmarocKing.EntityhelmarocKing.class, 2, 1, 1, EnumCreatureType.MONSTER, clean(Biome.REGISTRY));

	}

	public static Biome[] clean(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext()) {
			ls.add(itr.next());
		}
		return ls.toArray(new Biome[ls.size()]);
	}

	public static class EntityhelmarocKing extends EntityMob {
		World world = null;

		public EntityhelmarocKing(World var1) {
			super(var1);
			world = var1;
			experienceValue = 300;
			this.isImmuneToFire = true;
			addRandomArmor();
			setNoAI(!true);
			this.tasks.addTask(0, new EntityAISwimming(this));
			this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
			this.tasks.addTask(8, new EntityAILookIdle(this));
			this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
			this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityDragon.class, 6.0F));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true));
			this.targetTasks.addTask(7, new EntityAIHurtByTarget(this, false));

		}

		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.55D);
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30D);
		}

		protected void addRandomArmor() {

		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE,
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
			this.dropItem(new ItemStack(mace.block).getItem(), 1);
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(mirrorShield.block).getItem();
		}

		@Override
		protected net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testzeldamobs:entity.helmarocking.ambient"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getHurtSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testzeldamobs:entity.helmarocking.hurt"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testzeldamobs:entity.helmarocking.death"));
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
				Entity sentity = new blueBokoblin.EntityblueBokoblin(world);
				if (sentity != null && !world.isRemote) {
					sentity.setLocationAndAngles(i, j, k, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(sentity);
				}
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

	// Date: 13-04-17 01:08:21
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX

	public static class ModelHelmarocKing extends ModelBase {
		// fields
		ModelRenderer head;
		ModelRenderer body;
		ModelRenderer rightarm;
		ModelRenderer leftarm;
		ModelRenderer rightleg;
		ModelRenderer leftleg;
		ModelRenderer corps;
		ModelRenderer bec;
		ModelRenderer becpart2;
		ModelRenderer cou;
		ModelRenderer cou2;
		ModelRenderer ailedroite1;
		ModelRenderer ailegauche1;
		ModelRenderer ailedroite2;
		ModelRenderer ailedroite3;
		ModelRenderer ailegauche2;
		ModelRenderer ailegauche3;
		ModelRenderer corpsbas;
		ModelRenderer plumequeue;
		ModelRenderer plumequeue1;
		ModelRenderer plumequeue2;
		ModelRenderer couronnemilieu;
		ModelRenderer couronnedroite;
		ModelRenderer couronnegauche;
		ModelRenderer ailedroite4;
		ModelRenderer ailegauche4;
		ModelRenderer eye1;
		ModelRenderer eye2;

		public ModelHelmarocKing() {
			textureWidth = 128;
			textureHeight = 128;

			head = new ModelRenderer(this, 0, 0);
			head.addBox(-4F, -8F, -4F, 11, 11, 18);
			head.setRotationPoint(-2F, -84F, -10F);
			head.setTextureSize(128, 128);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
			body = new ModelRenderer(this, 16, 16);
			body.addBox(-4F, 0F, -2F, 18, 16, 16);
			body.setRotationPoint(-5F, -4F, -6F);
			body.setTextureSize(128, 128);
			body.mirror = true;
			setRotation(body, 0F, 0F, 0F);
			rightarm = new ModelRenderer(this, 40, 16);
			rightarm.addBox(-3F, -2F, -2F, 1, 1, 1);
			rightarm.setRotationPoint(-7F, -2F, 0F);
			rightarm.setTextureSize(128, 128);
			rightarm.mirror = true;
			setRotation(rightarm, 0F, 0F, 0F);
			leftarm = new ModelRenderer(this, 40, 16);
			leftarm.addBox(-1F, -2F, -2F, 1, 1, 1);
			leftarm.setRotationPoint(10F, -2F, 0F);
			leftarm.setTextureSize(128, 128);
			leftarm.mirror = true;
			setRotation(leftarm, 0F, 0F, 0F);
			rightleg = new ModelRenderer(this, 0, 16);
			rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
			rightleg.setRotationPoint(-4F, 12F, -2F);
			rightleg.setTextureSize(128, 128);
			rightleg.mirror = true;
			setRotation(rightleg, 0F, 0F, 0F);
			leftleg = new ModelRenderer(this, 0, 16);
			leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
			leftleg.setRotationPoint(4F, 12F, -3F);
			leftleg.setTextureSize(128, 128);
			leftleg.mirror = true;
			setRotation(leftleg, 0F, 0F, 0F);
			corps = new ModelRenderer(this, 0, 0);
			corps.addBox(0F, 0F, 0F, 37, 47, 29);
			corps.setRotationPoint(-18F, -70F, -17F);
			corps.setTextureSize(128, 128);
			corps.mirror = true;
			setRotation(corps, 0F, 0F, 0F);
			bec = new ModelRenderer(this, 0, 0);
			bec.addBox(0F, 0F, 0F, 5, 2, 7);
			bec.setRotationPoint(-3F, -86F, -21F);
			bec.setTextureSize(128, 128);
			bec.mirror = true;
			setRotation(bec, 0F, 0F, 0F);
			becpart2 = new ModelRenderer(this, 0, 0);
			becpart2.addBox(0F, 0F, 0F, 3, 1, 3);
			becpart2.setRotationPoint(-2F, -87F, -17F);
			becpart2.setTextureSize(128, 128);
			becpart2.mirror = true;
			setRotation(becpart2, 0F, 0F, 0F);
			cou = new ModelRenderer(this, 0, 0);
			cou.addBox(0F, 0F, 0F, 13, 6, 14);
			cou.setRotationPoint(-7F, -76F, -9F);
			cou.setTextureSize(128, 128);
			cou.mirror = true;
			setRotation(cou, 0F, 0F, 0F);
			cou2 = new ModelRenderer(this, 0, 0);
			cou2.addBox(0F, 0F, 0F, 9, 5, 12);
			cou2.setRotationPoint(-5F, -81F, -8F);
			cou2.setTextureSize(128, 128);
			cou2.mirror = true;
			setRotation(cou2, 0F, 0F, 0F);
			ailedroite1 = new ModelRenderer(this, 0, 0);
			ailedroite1.addBox(0F, 0F, 0F, 37, 38, 4);
			ailedroite1.setRotationPoint(-55.2F, -70F, 8F);
			ailedroite1.setTextureSize(128, 128);
			ailedroite1.mirror = true;
			setRotation(ailedroite1, 0F, 0F, 0F);
			ailegauche1 = new ModelRenderer(this, 0, 0);
			ailegauche1.addBox(0F, 0F, 0F, 37, 38, 4);
			ailegauche1.setRotationPoint(19F, -70F, 7.866667F);
			ailegauche1.setTextureSize(128, 128);
			ailegauche1.mirror = true;
			setRotation(ailegauche1, 0F, 0F, 0F);
			ailedroite2 = new ModelRenderer(this, 0, 0);
			ailedroite2.addBox(0F, 0F, 0F, 37, 38, 4);
			ailedroite2.setRotationPoint(-92F, -81F, 8F);
			ailedroite2.setTextureSize(128, 128);
			ailedroite2.mirror = true;
			setRotation(ailedroite2, 0F, 0F, 0F);
			ailedroite3 = new ModelRenderer(this, 0, 0);
			ailedroite3.addBox(0F, 0F, 0F, 53, 44, 4);
			ailedroite3.setRotationPoint(-145F, -95F, 8F);
			ailedroite3.setTextureSize(128, 128);
			ailedroite3.mirror = true;
			setRotation(ailedroite3, 0F, 0F, 0F);
			ailegauche2 = new ModelRenderer(this, 0, 0);
			ailegauche2.addBox(0F, 0F, 0F, 37, 38, 4);
			ailegauche2.setRotationPoint(56F, -81F, 8F);
			ailegauche2.setTextureSize(128, 128);
			ailegauche2.mirror = true;
			setRotation(ailegauche2, 0F, 0F, 0F);
			ailegauche3 = new ModelRenderer(this, 0, 0);
			ailegauche3.addBox(0F, 0F, 0F, 53, 44, 4);
			ailegauche3.setRotationPoint(93F, -95F, 8F);
			ailegauche3.setTextureSize(128, 128);
			ailegauche3.mirror = true;
			setRotation(ailegauche3, 0F, 0F, 0F);
			corpsbas = new ModelRenderer(this, 0, 0);
			corpsbas.addBox(0F, 0F, 0F, 31, 19, 25);
			corpsbas.setRotationPoint(-15F, -23F, -14.55556F);
			corpsbas.setTextureSize(128, 128);
			corpsbas.mirror = true;
			setRotation(corpsbas, 0F, 0F, 0F);
			plumequeue = new ModelRenderer(this, 16, 16);
			plumequeue.addBox(0F, 0F, 0F, 10, 10, 12);
			plumequeue.setRotationPoint(-5F, -4F, 8F);
			plumequeue.setTextureSize(128, 128);
			plumequeue.mirror = true;
			setRotation(plumequeue, 0F, 0F, 0F);
			plumequeue1 = new ModelRenderer(this, 16, 16);
			plumequeue1.addBox(0F, 0F, 0F, 6, 2, 30);
			plumequeue1.setRotationPoint(-3F, 0F, 20F);
			plumequeue1.setTextureSize(128, 128);
			plumequeue1.mirror = true;
			setRotation(plumequeue1, 0F, 0F, 0F);
			plumequeue2 = new ModelRenderer(this, 16, 16);
			plumequeue2.addBox(0F, 0F, 0F, 6, 2, 50);
			plumequeue2.setRotationPoint(-3F, -2F, 32F);
			plumequeue2.setTextureSize(128, 128);
			plumequeue2.mirror = true;
			setRotation(plumequeue2, 0F, 0F, 0F);
			couronnemilieu = new ModelRenderer(this, 0, 0);
			couronnemilieu.addBox(0F, 0F, 0F, 5, 11, 2);
			couronnemilieu.setRotationPoint(-3F, -103F, -10F);
			couronnemilieu.setTextureSize(128, 128);
			couronnemilieu.mirror = true;
			setRotation(couronnemilieu, 0F, 0F, 0F);
			couronnedroite = new ModelRenderer(this, 0, 0);
			couronnedroite.addBox(0F, 0F, 0F, 2, 7, 3);
			couronnedroite.setRotationPoint(-5F, -99F, -10F);
			couronnedroite.setTextureSize(128, 128);
			couronnedroite.mirror = true;
			setRotation(couronnedroite, 0F, 0F, 0F);
			couronnegauche = new ModelRenderer(this, 0, 0);
			couronnegauche.addBox(0F, 0F, 0F, 2, 7, 3);
			couronnegauche.setRotationPoint(2F, -99F, -10F);
			couronnegauche.setTextureSize(128, 128);
			couronnegauche.mirror = true;
			setRotation(couronnegauche, 0F, 0F, 0F);
			ailedroite4 = new ModelRenderer(this, 0, 0);
			ailedroite4.addBox(0F, 0F, 0F, 26, 43, 4);
			ailedroite4.setRotationPoint(-171F, -103.4F, 8F);
			ailedroite4.setTextureSize(128, 128);
			ailedroite4.mirror = true;
			setRotation(ailedroite4, 0F, 0F, 0F);
			ailegauche4 = new ModelRenderer(this, 0, 0);
			ailegauche4.addBox(0F, 0F, 0F, 26, 43, 4);
			ailegauche4.setRotationPoint(146F, -103.4F, 8F);
			ailegauche4.setTextureSize(128, 128);
			ailegauche4.mirror = true;
			setRotation(ailegauche4, 0F, 0F, 0F);
			eye1 = new ModelRenderer(this, 0, 0);
			eye1.addBox(0F, 0F, 0F, 2, 2, 1);
			eye1.setRotationPoint(1.6F, -91F, -16F);
			eye1.setTextureSize(128, 128);
			eye1.mirror = true;
			setRotation(eye1, 0F, 0F, 0F);
			eye2 = new ModelRenderer(this, 0, 0);
			eye2.addBox(0F, 0F, 0F, 2, 2, 1);
			eye2.setRotationPoint(-4.6F, -91F, -16F);
			eye2.setTextureSize(128, 128);
			eye2.mirror = true;
			setRotation(eye2, 0F, 0F, 0F);
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
			corps.render(f5);
			bec.render(f5);
			becpart2.render(f5);
			cou.render(f5);
			cou2.render(f5);
			ailedroite1.render(f5);
			ailegauche1.render(f5);
			ailedroite2.render(f5);
			ailedroite3.render(f5);
			ailegauche2.render(f5);
			ailegauche3.render(f5);
			corpsbas.render(f5);
			plumequeue.render(f5);
			plumequeue1.render(f5);
			plumequeue2.render(f5);
			couronnemilieu.render(f5);
			couronnedroite.render(f5);
			couronnegauche.render(f5);
			ailedroite4.render(f5);
			ailegauche4.render(f5);
			eye1.render(f5);
			eye2.render(f5);
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
