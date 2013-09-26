/*
 * This file is part of SolarCraft.
 *
 * Copyright (c) 2013 ZephyrUnleashed LLC <http://www.zephyrunleashed.com/>
 * SolarCraft is licensed under the ZephyrUnleashed License Version 1.
 *
 * SolarCraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the ZephyrUnleashed License Version 1.
 *
 * SolarCraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the ZephyrUnleashed License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License.
 */
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
