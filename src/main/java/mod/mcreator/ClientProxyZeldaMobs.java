package mod.mcreator;

import mod.mcreator.CommonProxyZeldaMobs;
import mod.mcreator.ZeldaMobs;
import mod.mcreator.mcreator_gibdo;

public class ClientProxyZeldaMobs
extends CommonProxyZeldaMobs {
    @Override
    public void registerRenderers(ZeldaMobs ins) {
        ins.mcreator_0.registerRenderers();
    }
}

