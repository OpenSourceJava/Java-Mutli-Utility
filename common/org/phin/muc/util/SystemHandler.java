package org.phin.muc.util;

import org.phin.muc.lib.Strings;

public class SystemHandler {
	
	public static void getRAM() {
		long byteRam = Runtime.getRuntime().freeMemory();
		long kiloByteRam = byteRam / 1024;
		long megaByteRam = kiloByteRam / 1024;
		long gigaByteRam = megaByteRam / 1024;
		
		String byteRamS = String.valueOf(byteRam);
		String kiloByteRamS = String.valueOf(kiloByteRam);
		String megaByteRamS = String.valueOf(megaByteRam);
		String gigaByteRamS = String.valueOf(gigaByteRam);
		
		Strings.messageFrame.print("RAM in the JVM");
		Strings.messageFrame.print("ram in Bytes = " + byteRamS + "\n");
		Strings.messageFrame.print("ram in Kilo Bytes = " + kiloByteRamS + "\n");
		Strings.messageFrame.print("ram in Mega Bytes = " + megaByteRamS + "\n");
		Strings.messageFrame.print("ram in Giga Bytes = " + gigaByteRamS + "\n");
		
	}
	
	public static void runGC() {
		Strings.messageFrame.print("running... \n");
		Runtime.getRuntime().gc();
		Strings.messageFrame.print("done... \n");
	}

	public static void getProcessors() {
		int proc = Runtime.getRuntime().availableProcessors();
		String string = String.valueOf(proc);
		
		Strings.messageFrame.print("processors available to the JVM = " + string + "\n");
	}

	public static void getMaxRAM() {
		long byteRam = Runtime.getRuntime().maxMemory();
		long kiloByteRam = byteRam / 1024;
		long megaByteRam = kiloByteRam / 1024;
		long gigaByteRam = megaByteRam / 1024;
		
		String byteRamS = String.valueOf(byteRam);
		String kiloByteRamS = String.valueOf(kiloByteRam);
		String megaByteRamS = String.valueOf(megaByteRam);
		String gigaByteRamS = String.valueOf(gigaByteRam);
		
		Strings.messageFrame.print("max RAM in the JVM = " + byteRamS + " bytes \n");
		Strings.messageFrame.print("max RAM in the JVM = " + kiloByteRamS + " kilo bytes \n");
		Strings.messageFrame.print("max RAM in the JVM = " + megaByteRamS + " mega bytes \n");
		Strings.messageFrame.print("max RAM in the JVM = " + gigaByteRamS + " giga bytes \n");
		
	}
	
	public static void getTotalRam() {
		long byteRam = Runtime.getRuntime().totalMemory();
		long kiloByteRam = byteRam / 1024;
		long megaByteRam = kiloByteRam / 1024;
		long gigaByteRam = megaByteRam / 1024;
		
		String byteRamS = String.valueOf(byteRam);
		String kiloByteRamS = String.valueOf(kiloByteRam);
		String megaByteRamS = String.valueOf(megaByteRam);
		String gigaByteRamS = String.valueOf(gigaByteRam);
		
		Strings.messageFrame.print("total RAM in the JVM = " + byteRamS + " bytes \n");
		Strings.messageFrame.print("total RAM in the JVM = " + kiloByteRamS + " kilo bytes \n");
		Strings.messageFrame.print("total RAM in the JVM = " + megaByteRamS + " mega bytes \n");
		Strings.messageFrame.print("total RAM in the JVM = " + gigaByteRamS + " giga bytes \n");
		
	}
	
}
