package co.zmc.solarcraft;

import co.zmc.solarcraft.proxy.Proxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Globals.MOD_ID, name = Globals.MOD_NAME)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SolarCraftMain {

  @Instance(Globals.MOD_ID)
  public static SolarCraftMain instance;

  @SidedProxy(clientSide = "co.zmc.solarcraft.proxy.ClientProxy", serverSide = "co.zmc.solarcraft.proxy.ServerProxy")
  public static Proxy proxy;
  
  @EventHandler
  public void onPreInit(FMLPreInitializationEvent e) {
	  
  }
  
  @EventHandler
  public void onInit(FMLInitializationEvent e) {
	  
  }
  
  @EventHandler
  public void onPostInit(FMLPostInitializationEvent e) {
	  
  }
}
