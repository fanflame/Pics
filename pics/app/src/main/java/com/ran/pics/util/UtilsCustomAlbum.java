package com.ran.pics.util;

import android.graphics.Bitmap;
import android.os.StatFs;

import java.io.File;

public class UtilsCustomAlbum {
	public static final int IO_BUFFER_SIZE = 8 * 1024;
	/**
	 * Check how much usable space is available at a given path.
	 * 
	 * @param path
	 *            The path to check
	 * @return The space available in bytes
	 */
	public static long getUsableSpace(File path) {
		final StatFs stats = new StatFs(path.getPath());
		return (long) stats.getBlockSize() * (long) stats.getAvailableBlocks();
	}

	/**
	 * Get the size in bytes of a bitmap.
	 * 
	 * @param bitmap
	 * @return size in bytes
	 */
	public static int getBitmapSize(Bitmap bitmap) {
		// Pre HC-MR1
		return bitmap.getRowBytes() * bitmap.getHeight();
	}
}
