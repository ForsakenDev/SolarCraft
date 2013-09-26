package co.zmc.solarcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "solarcraft_main")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SolarCraftMain {

  @Instance
  public static SolarCraftMain instance;

}
