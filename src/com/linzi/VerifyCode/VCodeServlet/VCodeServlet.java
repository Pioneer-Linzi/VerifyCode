package com.linzi.VerifyCode.VCodeServlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 駩证码中的控制层
 * 用以实现网页中的验证码的请求回复
 */
import javax.servlet.http.HttpSession;

import com.linzi.VerifyCode.VCodeImg.VCodeImg;

/**
 * Servlet implementation class VCodeServlet
 */
@WebServlet("/VCodeServlet")
public class VCodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VCodeImg vcodeImg=new VCodeImg();
		BufferedImage img=(BufferedImage) vcodeImg.getImg();
		ImageIO.write(img, "JPEG", resp.getOutputStream());
		String verifyCode=vcodeImg.getVCodes();
		HttpSession session=req.getSession(true);
		session.setAttribute("verifyCode", verifyCode);
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
