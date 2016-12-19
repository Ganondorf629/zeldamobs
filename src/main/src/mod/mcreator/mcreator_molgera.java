package mod.mcreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class mcreator_molgera {
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

    @SideOnly(value=Side.CLIENT)
    public void registerRenderers() {
        RenderLiving customRender = new RenderLiving(Minecraft.func_71410_x().func_175598_ae(), (ModelBase)new ModelSilverfish(), 0.0f){

            protected ResourceLocation func_110775_a(Entity par1Entity) {
                return new ResourceLocation("Molgera.png");
            }
        };
        RenderingRegistry.registerEntityRenderingHandler(Entitymolgera.class, (Render)customRender);
    }

    public void serverLoad(FMLServerStartingEvent event) {
    }

    public void preInit(FMLPreInitializationEvent event) {
        int entityID;
        this.mobid = entityID = MathHelper.func_188210_a().hashCode();
        EntityRegistry.registerModEntity(Entitymolgera.class, (String)"molgera", (int)entityID, (Object)instance, (int)64, (int)1, (boolean)true, (int)13408512, (int)16750848);
        EntityRegistry.addSpawn(Entitymolgera.class, (int)1, (int)1, (int)1, (EnumCreatureType)EnumCreatureType.MONSTER, (Biome[])new Biome[]{(Biome)Biome.field_185377_q.func_82594_a((Object)new ResourceLocation("desert"))});
    }

    public static Biome[] clean(RegistryNamespaced<ResourceLocation, Biome> in) {
        Iterator itr = in.iterator();
        ArrayList ls = new ArrayList();
        while (itr.hasNext()) {
            ls.add(itr.next());
        }
        return ls.toArray((T[])new Biome[ls.size()]);
    }

    public static class ModelMolgera
    extends ModelBase {
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
            this.field_78090_t = 128;
            this.field_78089_u = 128;
            this.cou = new ModelRenderer((ModelBase)this, 0, 0);
            this.cou.func_78789_a(-4.0f, -4.0f, -8.0f, 8, 8, 5);
            this.cou.func_78793_a(0.0f, 20.0f, -4.0f);
            this.cou.func_78787_b(128, 128);
            this.cou.field_78809_i = true;
            this.setRotation(this.cou, 0.0f, 0.0f, 0.0f);
            this.body = new ModelRenderer((ModelBase)this, 28, 8);
            this.body.func_78789_a(-5.0f, -10.0f, -7.0f, 20, 40, 8);
            this.body.func_78793_a(-5.0f, 17.0f, 3.0f);
            this.body.func_78787_b(128, 128);
            this.body.field_78809_i = true;
            this.setRotation(this.body, 1.570796f, 0.0f, 0.0f);
            this.queue2 = new ModelRenderer((ModelBase)this, 0, 16);
            this.queue2.func_78789_a(-2.0f, 0.0f, -2.0f, 8, 20, 4);
            this.queue2.func_78793_a(10.0f, 18.0f, 35.0f);
            this.queue2.func_78787_b(128, 128);
            this.queue2.field_78809_i = true;
            this.setRotation(this.queue2, 0.0f, 0.0f, 1.553343f);
            this.aile1 = new ModelRenderer((ModelBase)this, 0, 16);
            this.aile1.func_78789_a(-2.0f, 18.0f, -2.0f, 2, 4, 4);
            this.aile1.func_78793_a(5.0f, 21.0f, -19.0f);
            this.aile1.func_78787_b(128, 128);
            this.aile1.field_78809_i = true;
            this.setRotation(this.aile1, 0.0f, 0.2443461f, 1.553343f);
            this.queue1 = new ModelRenderer((ModelBase)this, 0, 16);
            this.queue1.func_78789_a(0.0f, 0.0f, 0.0f, 8, 17, 4);
            this.queue1.func_78793_a(8.0f, 16.0f, 37.0f);
            this.queue1.func_78787_b(128, 128);
            this.queue1.field_78809_i = true;
            this.setRotation(this.queue1, 0.0f, 0.0f, 1.553343f);
            this.head = new ModelRenderer((ModelBase)this, 0, 0);
            this.head.func_78789_a(0.0f, 0.0f, 0.0f, 26, 6, 9);
            this.head.func_78793_a(-13.0f, 17.0f, -21.0f);
            this.head.func_78787_b(128, 128);
            this.head.field_78809_i = true;
            this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
            this.aile2 = new ModelRenderer((ModelBase)this, 0, 16);
            this.aile2.func_78789_a(0.0f, 0.0f, 0.0f, 2, 4, 4);
            this.aile2.func_78793_a(11.0f, 19.0f, -13.0f);
            this.aile2.func_78787_b(128, 128);
            this.aile2.field_78809_i = true;
            this.setRotation(this.aile2, 0.0f, 2.844887f, 1.553343f);
            this.aile3 = new ModelRenderer((ModelBase)this, 0, 16);
            this.aile3.func_78789_a(0.0f, 0.0f, 0.0f, 2, 4, 4);
            this.aile3.func_78793_a(-11.0f, 20.0f, -21.0f);
            this.aile3.func_78787_b(128, 128);
            this.aile3.field_78809_i = true;
            this.setRotation(this.aile3, 0.0f, -0.3141593f, 1.553343f);
            this.aile4 = new ModelRenderer((ModelBase)this, 0, 16);
            this.aile4.func_78789_a(0.0f, 0.0f, 0.0f, 2, 4, 4);
            this.aile4.func_78793_a(13.0f, 19.0f, -16.53333f);
            this.aile4.func_78787_b(128, 128);
            this.aile4.field_78809_i = true;
            this.setRotation(this.aile4, 0.0f, -2.75762f, 1.553343f);
            this.bouche1 = new ModelRenderer((ModelBase)this, 0, 0);
            this.bouche1.func_78789_a(0.0f, 0.0f, 0.0f, 18, 6, 11);
            this.bouche1.func_78793_a(3.0f, 17.0f, -15.0f);
            this.bouche1.func_78787_b(128, 128);
            this.bouche1.field_78809_i = true;
            this.setRotation(this.bouche1, 0.0f, 2.094395f, 0.0f);
            this.bouche2 = new ModelRenderer((ModelBase)this, 0, 0);
            this.bouche2.func_78789_a(0.0f, 0.0f, 0.0f, 19, 6, 11);
            this.bouche2.func_78793_a(-13.0f, 17.0f, -20.0f);
            this.bouche2.func_78787_b(128, 128);
            this.bouche2.field_78809_i = true;
            this.setRotation(this.bouche2, 0.0f, 1.012291f, 0.0f);
            this.dents = new ModelRenderer((ModelBase)this, 0, 0);
            this.dents.func_78789_a(0.0f, 0.0f, 0.0f, 6, 6, 6);
            this.dents.func_78793_a(-4.0f, 17.0f, -34.0f);
            this.dents.func_78787_b(128, 128);
            this.dents.field_78809_i = true;
            this.setRotation(this.dents, 0.0f, 1.012291f, 0.0f);
            this.queue3 = new ModelRenderer((ModelBase)this, 0, 16);
            this.queue3.func_78789_a(0.0f, 0.0f, 0.0f, 3, 4, 7);
            this.queue3.func_78793_a(-2.0f, 17.0f, 41.0f);
            this.queue3.func_78787_b(128, 128);
            this.queue3.field_78809_i = true;
            this.setRotation(this.queue3, 0.0f, -0.7679449f, 1.553343f);
            this.queue4.field_78809_i = true;
            this.queue4 = new ModelRenderer((ModelBase)this, 0, 16);
            this.queue4.func_78789_a(0.0f, 0.0f, 0.0f, 3, 4, 7);
            this.queue4.func_78793_a(5.0f, 17.0f, 38.0f);
            this.queue4.func_78787_b(128, 128);
            this.queue4.field_78809_i = true;
            this.setRotation(this.queue4, 0.0f, 0.7330383f, 1.553343f);
            this.queue4.field_78809_i = false;
        }

        public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
            super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
            this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
            this.cou.func_78785_a(f5);
            this.body.func_78785_a(f5);
            this.queue2.func_78785_a(f5);
            this.aile1.func_78785_a(f5);
            this.queue1.func_78785_a(f5);
            this.head.func_78785_a(f5);
            this.aile2.func_78785_a(f5);
            this.aile3.func_78785_a(f5);
            this.aile4.func_78785_a(f5);
            this.bouche1.func_78785_a(f5);
            this.bouche2.func_78785_a(f5);
            this.dents.func_78785_a(f5);
            this.queue3.func_78785_a(f5);
            this.queue4.func_78785_a(f5);
        }

        private void setRotation(ModelRenderer model, float x, float y, float z) {
            model.field_78795_f = x;
            model.field_78796_g = y;
            model.field_78808_h = z;
        }

        public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
            super.func_78087_a(f, f1, f2, f3, f4, f5, e);
            this.head.field_78796_g = f3 / 57.295776f;
            this.head.field_78795_f = f4 / 57.295776f;
            this.aile2.field_78795_f = MathHelper.func_76134_b((float)(f * 1.0f)) * -1.0f * f1;
            this.aile1.field_78795_f = MathHelper.func_76134_b((float)(f * 1.0f)) * 1.0f * f1;
            this.aile3.field_78795_f = MathHelper.func_76134_b((float)(f * 0.6662f + 3.1415927f)) * 2.0f * f1 * 0.5f;
            this.aile4.field_78795_f = MathHelper.func_76134_b((float)(f * 0.6662f)) * 2.0f * f1 * 0.5f;
        }
    }

    public static class Entitymolgera
    extends EntityMob {
        World world = null;
        private final BossInfoServer bossInfo;

        public Entitymolgera(World var1) {
            super(var1);
            this.bossInfo = new BossInfoServer(this.func_145748_c_(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS);
            this.world = var1;
            this.field_70728_aV = 150;
            this.field_70178_ae = true;
            this.addRandomArmor();
            this.func_94061_f(false);
            this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
            this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
            this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
            this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.8));
            this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
            this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
            this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0f));
            this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayerMP.class, 6.0f));
            this.field_70715_bh.func_75776_a(6, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityWither.class, true));
            this.field_70715_bh.func_75776_a(7, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
            this.field_70715_bh.func_75776_a(7, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, true));
            this.field_70715_bh.func_75776_a(8, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
            this.field_70715_bh.func_75776_a(8, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayerMP.class, true));
            this.field_70715_bh.func_75776_a(9, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        }

        protected void func_110147_ax() {
            super.func_110147_ax();
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.44999999999999996);
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0);
            if (this.func_110148_a(SharedMonsterAttributes.field_111264_e) != null) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(10.0);
            }
        }

        protected void addRandomArmor() {
        }

        public boolean func_184222_aU() {
            return false;
        }

        public void func_184178_b(EntityPlayerMP player) {
            super.func_184178_b(player);
            this.bossInfo.func_186760_a(player);
        }

        public void func_184203_c(EntityPlayerMP player) {
            super.func_184203_c(player);
            this.bossInfo.func_186761_b(player);
        }

        public void func_70071_h_() {
            super.func_70071_h_();
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
        }

        protected Item func_146068_u() {
            return null;
        }

        protected SoundEvent func_184639_G() {
            return (SoundEvent)SoundEvent.field_187505_a.func_82594_a((Object)new ResourceLocation("ZeldaMobs:entity.molgera.growl"));
        }

        protected SoundEvent func_184601_bQ() {
            return (SoundEvent)SoundEvent.field_187505_a.func_82594_a((Object)new ResourceLocation("ZeldaMobs:entity.molgera.hurt"));
        }

        protected SoundEvent func_184615_bR() {
            return (SoundEvent)SoundEvent.field_187505_a.func_82594_a((Object)new ResourceLocation("ZeldaMobs:entity.molgera.death"));
        }

        public void func_70077_a(EntityLightningBolt entityLightningBolt) {
            super.func_70077_a(entityLightningBolt);
            int i = (int)this.field_70165_t;
            int j = (int)this.field_70163_u;
            int k = (int)this.field_70161_v;
            Entitymolgera entity = this;
        }

        public void func_180430_e(float l, float d) {
            super.func_180430_e(l, d);
            int i = (int)this.field_70165_t;
            int j = (int)this.field_70163_u;
            int k = (int)this.field_70161_v;
            super.func_180430_e(l, d);
            Entitymolgera entity = this;
        }

        public void func_70645_a(DamageSource source) {
            super.func_70645_a(source);
            int i = (int)this.field_70165_t;
            int j = (int)this.field_70163_u;
            int k = (int)this.field_70161_v;
            Entitymolgera entity = this;
        }

        public boolean func_184645_a(EntityPlayer entity, EnumHand hand, ItemStack stack) {
            super.func_184645_a(entity, hand, stack);
            int i = (int)this.field_70165_t;
            int j = (int)this.field_70163_u;
            int k = (int)this.field_70161_v;
            return true;
        }

        protected float func_70599_aP() {
            return 1.0f;
        }
    }

}

