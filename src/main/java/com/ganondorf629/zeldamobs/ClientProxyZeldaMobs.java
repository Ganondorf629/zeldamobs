package com.ganondorf629.zeldamobs;

import com.ganondorf629.zeldamobs.ZeldaMobs;

public class ClientProxyZeldaMobs extends CommonProxyZeldaMobs {

	@Override
	public void registerRenderers(zeldamobs ins) {
		ins.zeldamobs_0.registerRenderers();
		ins.zeldamobs_1.registerRenderers();
		ins.zeldamobs_2.registerRenderers();
		ins.zeldamobs_3.registerRenderers();
		ins.zeldamobs_4.registerRenderers();
		ins.zeldamobs_5.registerRenderers();
		ins.zeldamobs_6.registerRenderers();
		ins.zeldamobs_7.registerRenderers();

	}
}
