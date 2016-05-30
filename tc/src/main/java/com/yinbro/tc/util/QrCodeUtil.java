package com.yinbro.tc.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.io.IOException;
import java.awt.image.BufferedImage;

public final class QrCodeUtil {

	public static File getQrCodeImg(String str) {
		File file = new File("new.png");
		String format = "png";
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 500, 500, hints);
			MatrixToImageWriter.writeToFile(bitMatrix, format, file);
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getStrFromQr(File file) {
		String str = null;
		BufferedImage image;
		try {
			image = ImageIO.read(file);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return str;
	}


}