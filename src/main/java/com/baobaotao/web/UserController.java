package com.baobaotao.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String register() {
		return "user/register";
	}

	// method=RequestMethod.POST
	@RequestMapping()
	public ModelAndView createUser(@Valid User user,BindingResult result) {
		if(result.hasErrors()){
			return new ModelAndView("user/register");
		}
		userService.createUser(user);
		ModelAndView mv = new ModelAndView("user/success");
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/userDetail/{userId}")
	public ModelAndView getUserByUserId(@PathVariable("userId") int userId,
			@RequestHeader(value = "Content-Type", required = false) String contentType) {
		User user = userService.findUserById(userId);
		ModelAndView mv = new ModelAndView("user/userInfo");
		mv.addObject("user", user);
		System.out.println(contentType);
		return mv;
	}

	@RequestMapping("/handle41")
	public ModelAndView handle41(@RequestBody String requestBody) {
		System.out.println(requestBody);
		return null;
	}

	@RequestMapping("/handle42")
	@ResponseBody
	public BufferedImage handle42(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedImage image = new BufferedImage(90, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200,250));
		g.fillRect(0, 0, 90, 30);
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		g.setColor(getRandColor(160,200));
		for (int i=0;i<155;i++)
		{
		int x = random.nextInt(90);
		int y = random.nextInt(30);
		int xl = random.nextInt(12);
		int yl = random.nextInt(12);
		g.drawLine(x,y,x+xl,y+yl);
		}
		String sRand="";
		for (int i=0;i<4;i++){
		String rand=String.valueOf(random.nextInt(10));
		sRand+=rand;
		g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		g.drawString(rand,13*i+18,21);
		}
		g.dispose();
		//
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		/*response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		ImageIO.write(image, "JPEG", response.getOutputStream());*/
		//return bos.toByteArray();
		//byte[] fileData=FileCopyUtils.copyToByteArray(rs.getInputStream());
		return image;
	}
	
	
	public Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	@RequestMapping("/showUserList")
	public String getUserList(ModelMap map){
		Calendar cl=Calendar.getInstance();
		List<User> userList=new ArrayList<>();
		User user=new User();
		user.setUserId(123);
		user.setUserName("liujiangshan");
		user.seteMail("qduljs2011@163.com");
		user.setLastVisit(cl.getTime());
		userList.add(user);
		User user2=new User();
		user2.setCredits(123);
		user2.setUserId(123);
		user2.setLastIp("12313");
		user2.setPassword("123");
		user2.setLastVisit(cl.getTime());
		userList.add(user2);
		map.addAttribute("userList",userList);
		return "user/userList";
	}
	@RequestMapping("/showUserListFtl")
	public String getUserListFtl(HttpServletRequest request,ModelMap map){
		System.out.println(request.getSession().getServletContext().getContextPath());
		Calendar cl=Calendar.getInstance();
		List<User> userList=new ArrayList<>();
		User user=new User();
		user.setUserId(123);
		user.setUserName("liujiangshan");
		user.seteMail("qduljs2011@163.com");
		user.setLastVisit(cl.getTime());
		userList.add(user);
		User user2=new User();
		user2.setCredits(123);
		user2.setUserId(123);
		user2.setLastIp("12313");
		user2.setPassword("123");
		user2.setLastVisit(cl.getTime());
		userList.add(user2);
		map.addAttribute("userList",userList);
		return "userListFtl";
	}
	public static void main(String[] args) {
		Object command=new LoginCommand();
		Object c=new UserController();
		System.out.println(command==c);
	}
}
