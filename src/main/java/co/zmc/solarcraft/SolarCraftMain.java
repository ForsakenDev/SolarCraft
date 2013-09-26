package co.zmc.solarcraft;

import java.io.File;

import net.minecraftforge.common.Configuration;
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

  @SidedProxy(clientSide = Globals.MOD_PACKAGE + ".proxy.ClientProxy", serverSide = Globals.MOD_PACKAGE + ".proxy.ServerProxy")
  public static Proxy proxy;

  private Configuration mainConfig;
  private File mainConfigFile;

  @EventHandler
  public void onPreInit(FMLPreInitializationEvent event) {
    this.mainConfigFile = new File(event.getModConfigurationDirectory(), Globals.MOD_NAME + "/main.cfg");
    this.reloadConfig();
  }

  @EventHandler
  public void onInit(FMLInitializationEvent event) {

  }

  @EventHandler
  public void onPostInit(FMLPostInitializationEvent event) {

  }

  private void reloadConfig() {
    this.mainConfig = new Configuration(this.mainConfigFile);
    this.mainConfig.load();
    this.mainConfig.save();
  }
}
