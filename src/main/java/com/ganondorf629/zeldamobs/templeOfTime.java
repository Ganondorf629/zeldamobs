package mod.ganondorf629;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;

import java.util.Random;

public class templeOfTime {

	public static Object instance;

	public templeOfTime() {
	}

	public void load(FMLInitializationEvent event) {
	}

	public void generateSurface(World world, Random random, int i2, int k2) {

		int i = i2 + random.nextInt(15);
		int k = k2 + random.nextInt(15);

		int chunkX = i >> 4;
		int chunkZ = k >> 4;
		int height = world.getChunkFromChunkCoords(chunkX, chunkZ).getHeight(new BlockPos(i & 15, 0, k & 15));

		int j = height - 1;
		if (world.getBiome(new BlockPos(i, j, k)).getBiomeName().equals("forest")) {

			if ((random.nextInt(1000000) + 1) <= 1) {
				boolean place = true;

				for (int y = 0; y < 4; y++)
					for (int z = 0; z < 4; z++)
						for (int x = 0; x < 5; x++)
							if (world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock() != Blocks.AIR)
								place = false;

				if (place) {
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 1, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 1, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 1, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 1, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 1, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 1, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 1, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 1, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 1, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 1, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 1, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 1, k + 2), Block.getBlockById(236).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 1, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 1, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 1, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 1, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 1, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 1, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 2, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 2, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 2, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 2, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 2, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 2, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 2, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 2, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 2, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 2, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 2, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 2, k + 2), Block.getBlockById(54).getStateFromMeta(2), 3);
					world.setBlockState(new BlockPos(i + 3, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 2, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 2, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 2, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 2, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 2, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 2, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 3, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 3, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 3, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 3, k + 0), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 3, k + 0), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 3, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 3, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 3, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 3, k + 1), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 3, k + 1), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 3, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 3, k + 2), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 3, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 3, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 3, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 3, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 3, k + 3), Block.getBlockById(237).getStateFromMeta(0), 3);
					Entity sentity0 = EntityList.createEntityByIDFromName(new ResourceLocation("testzeldamobs:darknut"), world);
					if (sentity0 != null) {
						sentity0.setLocationAndAngles(i + 2.5, j + 1.0, k + 1.5, world.rand.nextFloat() * 360F, 0);
						world.spawnEntity(sentity0);
					}
				}
			}
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
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

}
