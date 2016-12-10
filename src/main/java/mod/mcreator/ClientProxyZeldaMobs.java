package mod.mcreator;

public class ClientProxyTestEnvironmentMod extends CommonProxyTestEnvironmentMod {

	@Override
	public void registerRenderers(TestEnvironmentMod ins) {
		ins.mcreator_0.registerRenderers();

	}
}
