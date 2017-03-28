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
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelSilverfish;
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
		RenderLiving customRender = new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new ModelSilverfish(), 0) {
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
		EntityRegistry.registerModEntity(new ResourceLocation("ZeldaMobs:molgera"), molgera.Entitymolgera.class, "molgera",
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
			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.44999999999999996D);
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

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		protected net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"ZeldaMobs:entity.molgera.growl"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getHurtSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"ZeldaMobs:entity.molgera.hurt"));
		}

		@Override
		protected net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"ZeldaMobs:entity.molgera.death"));
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

	// Date: 12-12-16 19:54:37
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX

	public static class ModelMolgera extends ModelBase {
		// fields
		ModelRenderer cou;
		ModelRenderer body;
		ModelRenderer queue2;
		ModelRenderer aile1;
		ModelRenderer queue1;
		ModelRenderer head;
		ModelRenderer aile2;
		ModelRenderer aile3;
		ModelRenderer aile4;
		ModelRenderer bouche1;
		ModelRenderer bouche2;
		ModelRenderer dents;
		ModelRenderer queue3;
		ModelRenderer queue4;

		public ModelMolgera() {
			textureWidth = 128;
			textureHeight = 128;

			cou = new ModelRenderer(this, 0, 0);
			cou.addBox(-4F, -4F, -8F, 8, 8, 5);
			cou.setRotationPoint(0F, 20F, -4F);
			cou.setTextureSize(128, 128);
			cou.mirror = true;
			setRotation(cou, 0F, 0F, 0F);
			body = new ModelRenderer(this, 28, 8);
			body.addBox(-5F, -10F, -7F, 20, 40, 8);
			body.setRotationPoint(-5F, 17F, 3F);
			body.setTextureSize(128, 128);
			body.mirror = true;
			setRotation(body, 1.570796F, 0F, 0F);
			queue2 = new ModelRenderer(this, 0, 16);
			queue2.addBox(-2F, 0F, -2F, 8, 20, 4);
			queue2.setRotationPoint(10F, 18F, 35F);
			queue2.setTextureSize(128, 128);
			queue2.mirror = true;
			setRotation(queue2, 0F, 0F, 1.553343F);
			aile1 = new ModelRenderer(this, 0, 16);
			aile1.addBox(-2F, 18F, -2F, 2, 4, 4);
			aile1.setRotationPoint(5F, 21F, -19F);
			aile1.setTextureSize(128, 128);
			aile1.mirror = true;
			setRotation(aile1, 0F, 0.2443461F, 1.553343F);
			queue1 = new ModelRenderer(this, 0, 16);
			queue1.addBox(0F, 0F, 0F, 8, 17, 4);
			queue1.setRotationPoint(8F, 16F, 37F);
			queue1.setTextureSize(128, 128);
			queue1.mirror = true;
			setRotation(queue1, 0F, 0F, 1.553343F);
			head = new ModelRenderer(this, 0, 0);
			head.addBox(0F, 0F, 0F, 26, 6, 9);
			head.setRotationPoint(-13F, 17F, -21F);
			head.setTextureSize(128, 128);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
			aile2 = new ModelRenderer(this, 0, 16);
			aile2.addBox(0F, 0F, 0F, 2, 4, 4);
			aile2.setRotationPoint(11F, 19F, -13F);
			aile2.setTextureSize(128, 128);
			aile2.mirror = true;
			setRotation(aile2, 0F, 2.844887F, 1.553343F);
			aile3 = new ModelRenderer(this, 0, 16);
			aile3.addBox(0F, 0F, 0F, 2, 4, 4);
			aile3.setRotationPoint(-11F, 20F, -21F);
			aile3.setTextureSize(128, 128);
			aile3.mirror = true;
			setRotation(aile3, 0F, -0.3141593F, 1.553343F);
			aile4 = new ModelRenderer(this, 0, 16);
			aile4.addBox(0F, 0F, 0F, 2, 4, 4);
			aile4.setRotationPoint(13F, 19F, -16.53333F);
			aile4.setTextureSize(128, 128);
			aile4.mirror = true;
			setRotation(aile4, 0F, -2.75762F, 1.553343F);
			bouche1 = new ModelRenderer(this, 0, 0);
			bouche1.addBox(0F, 0F, 0F, 18, 6, 11);
			bouche1.setRotationPoint(3F, 17F, -15F);
			bouche1.setTextureSize(128, 128);
			bouche1.mirror = true;
			setRotation(bouche1, 0F, 2.094395F, 0F);
			bouche2 = new ModelRenderer(this, 0, 0);
			bouche2.addBox(0F, 0F, 0F, 19, 6, 11);
			bouche2.setRotationPoint(-13F, 17F, -20F);
			bouche2.setTextureSize(128, 128);
			bouche2.mirror = true;
			setRotation(bouche2, 0F, 1.012291F, 0F);
			dents = new ModelRenderer(this, 0, 0);
			dents.addBox(0F, 0F, 0F, 6, 6, 6);
			dents.setRotationPoint(-4F, 17F, -34F);
			dents.setTextureSize(128, 128);
			dents.mirror = true;
			setRotation(dents, 0F, 1.012291F, 0F);
			queue3 = new ModelRenderer(this, 0, 16);
			queue3.addBox(0F, 0F, 0F, 3, 4, 7);
			queue3.setRotationPoint(-2F, 17F, 41F);
			queue3.setTextureSize(128, 128);
			queue3.mirror = true;
			setRotation(queue3, 0F, -0.7679449F, 1.553343F);
			queue4.mirror = true;
			queue4 = new ModelRenderer(this, 0, 16);
			queue4.addBox(0F, 0F, 0F, 3, 4, 7);
			queue4.setRotationPoint(5F, 17F, 38F);
			queue4.setTextureSize(128, 128);
			queue4.mirror = true;
			setRotation(queue4, 0F, 0.7330383F, 1.553343F);
			queue4.mirror = false;
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);

			cou.render(f5);
			body.render(f5);
			queue2.render(f5);
			aile1.render(f5);
			queue1.render(f5);
			head.render(f5);
			aile2.render(f5);
			aile3.render(f5);
			aile4.render(f5);
			bouche1.render(f5);
			bouche2.render(f5);
			dents.render(f5);
			queue3.render(f5);
			queue4.render(f5);
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
			this.aile2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.aile1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.aile3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
			this.aile4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		}

	}

}
