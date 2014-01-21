package org.phin.mu.util;

import org.phin.mu.lib.Strings;

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
		
		Strings.log.print("RAM in the JVM");
		Strings.log.print("ram in Bytes = " + byteRamS + "\n");
		Strings.log.print("ram in Kilo Bytes = " + kiloByteRamS + "\n");
		Strings.log.print("ram in Mega Bytes = " + megaByteRamS + "\n");
		Strings.log.print("ram in Giga Bytes = " + gigaByteRamS + "\n");
		
	}
	
	public static void runGC() {
		Strings.log.print("running... \n");
		Runtime.getRuntime().gc();
		Strings.log.print("done... \n");
	}

	public static void getProcessors() {
		int proc = Runtime.getRuntime().availableProcessors();
		String string = String.valueOf(proc);
		
		Strings.log.print("processors available to the JVM = " + string + "\n");
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
		
		Strings.log.print("max RAM in the JVM = " + byteRamS + " bytes \n");
		Strings.log.print("max RAM in the JVM = " + kiloByteRamS + " kilo bytes \n");
		Strings.log.print("max RAM in the JVM = " + megaByteRamS + " mega bytes \n");
		Strings.log.print("max RAM in the JVM = " + gigaByteRamS + " giga bytes \n");
		
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
		
		Strings.log.print("total RAM in the JVM = " + byteRamS + " bytes \n");
		Strings.log.print("total RAM in the JVM = " + kiloByteRamS + " kilo bytes \n");
		Strings.log.print("total RAM in the JVM = " + megaByteRamS + " mega bytes \n");
		Strings.log.print("total RAM in the JVM = " + gigaByteRamS + " giga bytes \n");
		
	}
	
}
