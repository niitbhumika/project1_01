package com.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.giftsgallery.dao.ProductDAO;
import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.UserInfo;




@Controller
public class HomeController {
	
@RequestMapping("/agift")
public String showagift()
{
	return "agift";
	
}
@RequestMapping("/home")
public String showhome()
{
	return "home";
}
@RequestMapping("/AboutUs")
public String showAboutUs()
{
	return "AboutUs";
}
@RequestMapping("/Products")
public String showProducts()
{
	return "Products";
}

@RequestMapping("/")
public String showIndex()
{
	return "home";
}
@RequestMapping("/login")
public String showlogin()
{
	return "login";
}


/*@RequestMapping ("/validate")
public void checkUser(HttpServletRequest req,HttpServletResponse res)
{
	String s1=req.getParameter("name1");
    String s2=req.getParameter("password1");
	if(s1.equals("sa@gmail.com")&&s2.equals("sa"))
	
	{
		System.out.println("valid");
	}
	else
	{System.out.println("Not Valid");
	
	}
}*/
@RequestMapping ("/validate")
public ModelAndView checkUser(@RequestParam("name1")String s1,@RequestParam("password1")String s2)
{
	String message; 
	ModelAndView mv;
	if(s1.equals("sa@gmail.com")&&s2.equals("sa"))
	{
		message="valid";
		mv=new ModelAndView("AdminHome");
		mv.addObject("info",message);
		
	}
	else
	{message="Invalid";
	mv=new ModelAndView("login");
	mv.addObject("info",message);	
	}
	return mv;
	}


/*Logout*/
@RequestMapping("/Logout")
public String showLogout()
{
	return "Logout";
}
/*Sample*/
@RequestMapping("/register")
public ModelAndView showsample (@ModelAttribute("user")UserInfo user,BindingResult result,HttpServletRequest request)

{
	ModelAndView mv = new ModelAndView ("register");
	return mv;
	
}
//when user clicks submit these details are posted//
@RequestMapping(value="/addUser", method=RequestMethod.POST)
public ModelAndView addUser (@ModelAttribute("user")UserInfo user,
		ModelMap model,BindingResult result,HttpServletRequest request)
{
	ModelAndView mv= new ModelAndView("login");
	 return mv;
}
/*Add Product*/
@Autowired
ProductDAO productDAO; 

@ModelAttribute
public Product returnObject ()

{
	return new Product();
}
@RequestMapping (value="/addproduct",method=RequestMethod.POST)
public String ShowAddProduct (@Valid @ModelAttribute("product")com.niit.shoppingcart.giftsgallery.model.Product product, Model model, BindingResult result,HttpServletRequest request)throws IOException
{
System.out.println(product.getProd_name());
System.out.println("image upload");
System.out.println("myproduct controller called");
MultipartFile image=product.getImage();
Path path;/*belong to nio package*/
path=Paths.get("F:/bhumika/Giftgallery/src/main/webapp/resources/images/"+product.getProd_id()+".jpg");
System.out.println("Path="+path);
System.out.println("File name"+product.getImage().getOriginalFilename());
if(image!=null&&!image.isEmpty())
{
	try {
		image.transferTo(new File(path.toString()));
		System.out.println("Image Saved in:"+path.toString());
	}
	catch(Exception e)
	
	{
		e.printStackTrace();
		System.out.println("Image not saved");
		
		
		
	}
}
		
productDAO.saveOrUpdate (product);
return "product";
}
 
}
