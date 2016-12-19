package mod.mcreator;

import mod.mcreator.CommonProxyZeldaMobs;
import mod.mcreator.ZeldaMobs;
import mod.mcreator.mcreator_darknut;
import mod.mcreator.mcreator_gibdo;
import mod.mcreator.mcreator_gossipStone;
import mod.mcreator.mcreator_molgera;
import mod.mcreator.mcreator_molgeraStatue;
import mod.mcreator.mcreator_oldMossyCobblestone;
import mod.mcreator.mcreator_zeldaMobsBlocks;

public class ClientProxyZeldaMobs
extends CommonProxyZeldaMobs {
    @Override
    public void registerRenderers(ZeldaMobs ins) {
        ins.mcreator_0.registerRenderers();
        ins.mcreator_1.registerRenderers();
        ins.mcreator_2.registerRenderers();
        ins.mcreator_3.registerRenderers();
        ins.mcreator_4.registerRenderers();
        ins.mcreator_5.registerRenderers();
        ins.mcreator_6.registerRenderers();
    }
}

