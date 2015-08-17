package com.linzi.VerifyCode.VCodeImg;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VCodeImg {

	/**
	 * 用来画出我们的駩证码的图片
	 */
	// 创建图片
	private int h;
	private int w;
	private StringBuilder VCodes = new StringBuilder(4);

	public VCodeImg() {
		this.w = 70;
		this.h = 35;
	}

	public String getVCodes() {
		return VCodes.toString();
	}

	public Image createImg() {
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		return img;
	}

	public Image imgDraw() {
		// 在这里面画出我们的验证码
		Image img = createImg();
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, w, h);
		for (int i = 0; i < 4; i++) {
			// 随机生成的code
			String code = randomCode();
			VCodes.append(code);
			// 随机的字号
			int num = randomNum();
			// 随机的字的类型
			String type = randomType();
			// 随机的颜色
			Color fontColor = randomColor();
			g.setFont(new Font(type, fontint(), num));
			g.setColor(fontColor);
			g.drawString(code, w / 4 * i, h - 10);
			g.drawLine(random.nextInt(w), random.nextInt(h), random.nextInt(w), random.nextInt(h));

		}
		return img;
	}

	public Image getImg() {
		Image img = imgDraw();
		return img;
	}

	private String codes = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	private Random random = new Random();

	public String randomCode() {
		char[] codesch = codes.toCharArray();
		String code = codesch[random.nextInt(codesch.length)] + "";
		return code;
	}

	private int[] nums = { 22, 23, 24, 25, 26, 27 };

	public int randomNum() {
		int num = nums[random.nextInt(nums.length)];
		return num;
	}

	private String[] types = { "隶书", "幼圆", "魏碑", "宋体", "黑体", "楷体" };

	public String randomType() {
		String type = types[random.nextInt(types.length)];
		return type;
	}

	public Color randomColor() {
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		Color fontcolor = new Color(r, g, b);
		return fontcolor;
	}

	public int fontint() {
		int b = random.nextInt(4);
		return b;
	}

}
