package com.ganondorf629.zeldamobs;

import com.ganondorf629.zeldamobs.ZeldaMobs;

public class ClientProxyZeldaMobs extends CommonProxyZeldaMobs {

	@Override
	public void registerRenderers(ZeldaMobs ins) {
		ins.mcreator_0.registerRenderers();
		ins.mcreator_1.registerRenderers();
		ins.mcreator_2.registerRenderers();
		ins.mcreator_3.registerRenderers();
		ins.mcreator_4.registerRenderers();
		ins.mcreator_5.registerRenderers();
		ins.mcreator_6.registerRenderers();
		ins.mcreator_7.registerRenderers();

	}
}
