package mod.mcreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class mcreator_darknut {
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
        RenderLiving customRender = new RenderLiving(Minecraft.func_71410_x().func_175598_ae(), new ModelDarknut(), 0.0f){

            protected ResourceLocation func_110775_a(Entity par1Entity) {
                return new ResourceLocation("Darknut.png");
            }
        };
        RenderingRegistry.registerEntityRenderingHandler(Entitydarknut.class, (Render)customRender);
    }

    public void serverLoad(FMLServerStartingEvent event) {
    }

    public void preInit(FMLPreInitializationEvent event) {
        int entityID;
        this.mobid = entityID = MathHelper.func_188210_a().hashCode();
        EntityRegistry.registerModEntity(Entitydarknut.class, (String)"darknut", (int)entityID, (Object)instance, (int)64, (int)1, (boolean)true, (int)13107, (int)6710886);
        EntityRegistry.addSpawn(Entitydarknut.class, (int)5, (int)1, (int)1, (EnumCreatureType)EnumCreatureType.MONSTER, (Biome[])new Biome[]{(Biome)Biome.field_185377_q.func_82594_a((Object)new ResourceLocation("forest"))});
        DungeonHooks.addDungeonMob((String)"darknut", (int)180);
    }

    public static Biome[] clean(RegistryNamespaced<ResourceLocation, Biome> in) {
        Iterator itr = in.iterator();
        ArrayList ls = new ArrayList();
        while (itr.hasNext()) {
            ls.add(itr.next());
        }
        return ls.toArray((T[])new Biome[ls.size()]);
    }

    public static class ModelDarknut
    extends ModelBase {
        ModelRenderer head;
        ModelRenderer body;
        ModelRenderer rightarm;
        ModelRenderer leftarm;
        ModelRenderer rightleg;
        ModelRenderer leftleg;
        ModelRenderer armor;

        public ModelDarknut() {
            this.field_78090_t = 64;
            this.field_78089_u = 64;
            this.head = new ModelRenderer((ModelBase)this, 0, 0);
            this.head.func_78789_a(-4.0f, -8.0f, -4.0f, 8, 8, 7);
            this.head.func_78793_a(0.0f, -3.0f, -1.0f);
            this.head.func_78787_b(64, 64);
            this.head.field_78809_i = true;
            this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
            this.body = new ModelRenderer((ModelBase)this, 16, 16);
            this.body.func_78789_a(-4.0f, 0.0f, -2.0f, 12, 15, 6);
            this.body.func_78793_a(-2.0f, -3.0f, -1.0f);
            this.body.func_78787_b(64, 64);
            this.body.field_78809_i = true;
            this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
            this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
            this.rightarm.func_78789_a(-3.0f, -2.0f, -2.0f, 4, 14, 4);
            this.rightarm.func_78793_a(-7.0f, -2.0f, 0.0f);
            this.rightarm.func_78787_b(64, 64);
            this.rightarm.field_78809_i = true;
            this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
            this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
            this.leftarm.func_78789_a(-1.0f, -2.0f, -2.0f, 4, 14, 4);
            this.leftarm.func_78793_a(7.0f, -2.0f, 0.0f);
            this.leftarm.func_78787_b(64, 64);
            this.leftarm.field_78809_i = true;
            this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
            this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
            this.rightleg.func_78789_a(-2.0f, 0.0f, -2.0f, 4, 12, 4);
            this.rightleg.func_78793_a(-2.0f, 12.0f, 0.0f);
            this.rightleg.func_78787_b(64, 64);
            this.rightleg.field_78809_i = true;
            this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
            this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
            this.leftleg.func_78789_a(-2.0f, 0.0f, -2.0f, 4, 12, 4);
            this.leftleg.func_78793_a(2.0f, 12.0f, 0.0f);
            this.leftleg.func_78787_b(64, 64);
            this.leftleg.field_78809_i = true;
            this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
            this.armor = new ModelRenderer((ModelBase)this, 16, 16);
            this.armor.func_78789_a(0.0f, 0.0f, 0.0f, 10, 13, 1);
            this.armor.func_78793_a(-5.0f, -3.0f, -4.0f);
            this.armor.func_78787_b(64, 64);
            this.armor.field_78809_i = true;
            this.setRotation(this.armor, 0.0f, 0.0f, 0.0f);
        }

        public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
            super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
            this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
            this.head.func_78785_a(f5);
            this.body.func_78785_a(f5);
            this.rightarm.func_78785_a(f5);
            this.leftarm.func_78785_a(f5);
            this.rightleg.func_78785_a(f5);
            this.leftleg.func_78785_a(f5);
            this.armor.func_78785_a(f5);
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
            this.leftleg.field_78795_f = MathHelper.func_76134_b((float)(f * 1.0f)) * -1.0f * f1;
            this.rightleg.field_78795_f = MathHelper.func_76134_b((float)(f * 1.0f)) * 1.0f * f1;
            this.rightarm.field_78795_f = MathHelper.func_76134_b((float)(f * 0.6662f + 3.1415927f)) * 2.0f * f1 * 0.5f;
            this.leftarm.field_78795_f = MathHelper.func_76134_b((float)(f * 0.6662f)) * 2.0f * f1 * 0.5f;
        }
    }

    public static class Entitydarknut
    extends EntityMob {
        World world = null;

        public Entitydarknut(World var1) {
            super(var1);
            this.world = var1;
            this.field_70728_aV = 5;
            this.field_70178_ae = true;
            this.addRandomArmor();
            this.func_94061_f(false);
            this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.8));
            this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
            this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
            this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, false));
            this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
            this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0f));
            this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayerMP.class, 6.0f));
            this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
            this.field_70715_bh.func_75776_a(9, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, true));
            this.field_70715_bh.func_75776_a(10, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
            this.field_70715_bh.func_75776_a(8, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayerMP.class, true));
            this.field_70715_bh.func_75776_a(9, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        }

        protected void func_110147_ax() {
            super.func_110147_ax();
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50.0);
            if (this.func_110148_a(SharedMonsterAttributes.field_111264_e) != null) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
            }
        }

        protected void addRandomArmor() {
        }

        protected Item func_146068_u() {
            return new ItemStack(Items.field_151166_bC).func_77973_b();
        }

        protected SoundEvent func_184639_G() {
            return (SoundEvent)SoundEvent.field_187505_a.func_82594_a((Object)new ResourceLocation("ZeldaMobs:entity.darknut.idle"));
        }

        protected SoundEvent func_184601_bQ() {
            return (SoundEvent)SoundEvent.field_187505_a.func_82594_a((Object)new ResourceLocation("ZeldaMobs:entity.darknut.hit"));
        }

        protected SoundEvent func_184615_bR() {
            return (SoundEvent)SoundEvent.field_187505_a.func_82594_a((Object)new ResourceLocation("ZeldaMobs:entity.darknut.death"));
        }

        public void func_70077_a(EntityLightningBolt entityLightningBolt) {
            super.func_70077_a(entityLightningBolt);
            int i = (int)this.field_70165_t;
            int j = (int)this.field_70163_u;
            int k = (int)this.field_70161_v;
            Entitydarknut entity = this;
        }

        public void func_180430_e(float l, float d) {
            super.func_180430_e(l, d);
            int i = (int)this.field_70165_t;
            int j = (int)this.field_70163_u;
            int k = (int)this.field_70161_v;
            super.func_180430_e(l, d);
            Entitydarknut entity = this;
        }

        public void func_70645_a(DamageSource source) {
            super.func_70645_a(source);
            int i = (int)this.field_70165_t;
            int j = (int)this.field_70163_u;
            int k = (int)this.field_70161_v;
            Entitydarknut entity = this;
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

