package com.shengping.paotui.handler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.shengping.paotui.handler.model.ReturnMessage;
import com.shengping.paotui.model.Dx_ChildShops;
import com.shengping.paotui.model.Dx_ClassTable;
import com.shengping.paotui.model.Dx_Goods;
import com.shengping.paotui.model.Dx_pl;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.Dx_ChildShops_Service;
import com.shengping.paotui.service.Dx_ClassTableService;
import com.shengping.paotui.service.Dx_GoodsService;
import com.shengping.paotui.service.Dx_plService;
import com.shengping.paotui.util.MyUtil;
import com.shengping.paotui.util.PinYinUtil;
import com.shengping.paotui.util.TokenProcessor;

@RequestMapping("/shopservice")
@RestController
public class ShopHandler {
	
	@Autowired
	private Dx_ChildShops_Service shopService;
	@Autowired
	private Dx_plService dx_plService;
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private Dx_ClassTableService classService;
	@Autowired
	private Dx_GoodsService dx_GoodsService;

	@RequestMapping(value="/register", method = RequestMethod.POST)//商家注册
	public ReturnMessage shopRegister(@RequestParam(value="title",required=true) String title,@RequestParam(value="address",required=true) String address,
			@RequestParam(value="phone",required=true) String phone,@RequestParam(value="discount",required=true) String discount,@RequestParam(value="type",required=true) Integer type,
			@RequestParam(value="YYSJ",required=true) String YYSJ,@RequestParam(value="MD_Area",required=true) String MD_Area,@RequestParam(value="LoEMail",required=true) String LoEMail,
			@RequestParam(value="MD_GPRS",required=true) String MD_GPRS,@RequestParam(value="realname",required=true) String realname,@RequestParam(value="hotline",required=true) String hotline){
		ReturnMessage message=new ReturnMessage();
		if(shopService.testPhone(phone)){
			Dx_ChildShops shop=new Dx_ChildShops();
			shop.setHotline(hotline);//服务热线
			shop.setMD_Title(title);//商家名称
			shop.setMD_Address(address);//商家地址
			shop.setMD_Phone(phone);//商家电话
			shop.setMD_Maps(discount);//商家折扣
			shop.setMD_Type(type);//行业大类
			shop.setMD_YYSJ(YYSJ);//营业时间
			shop.setMD_Area(MD_Area);//城市编码
			shop.setMD_LoEMail(LoEMail);//邮箱地址
			shop.setMD_GPRS(MD_GPRS);//商家坐标
			shop.setRealname(realname);//商家联系人
			shop.setHotline(hotline);//商家服务热线
			shop.setMD_CreateTime(new Date());
			shop.setMD_LoName(phone);//登录名即商家手机号
			if(shopService.ShopRegister(shop)>0){
				message.setStatus(true);
				message.setMessage("申请成功，请耐心等待工作人员审核...");
			}else{
				message.setStatus(false);
				message.setMessage("申请失败，请联系管理人员");
			}
		}else{
			message.setStatus(false);
			message.setMessage("您输入的手机号已经被注册过了！");
		}
		return message;
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)//商家登陆
	public ReturnMessage shopLogin(@RequestParam(value="name",required=true) String name,@RequestParam(value="pwd",required=true) String pwd){
		ReturnMessage message=new ReturnMessage();
		Dx_ChildShops data=shopService.Login(name, pwd);
		if(data!=null){
			message.setStatus(true);
			String token=TokenProcessor.getInstance().generateTokeCode();
			applicationService.addToken_Shop(data.getMD_LoName()+"",token);
			data.setMD_LoPawss("******");
			data.setToken(token);
			message.setData(data);
		}else{
			message.setStatus(false);
			message.setMessage("用户名或密码错误！");
		}
		return message;
	}
	@RequestMapping(value="/logout", method = RequestMethod.POST)//商家退出
	public ReturnMessage shopLogout(@RequestParam(value="username",required=true) String username,@RequestParam(value="token",required=true) String token){
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			applicationService.ShopLogOut(username);
			message.setStatus(true);
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/comment", method = RequestMethod.POST)//获取商家评论
	public ReturnMessage getComment(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token){
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			message.setStatus(true);
			message.setData(dx_plService.getBuyShop(shopid));
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/upload_logo", method = RequestMethod.POST)	//上传商户logo
	public ReturnMessage upLoadLogo(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value = "avatar", required = false) MultipartFile file,HttpServletRequest request){
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			Dx_ChildShops shop=shopService.getById(shopid);
			if(shop==null){
				message.setStatus(false);
				message.setMessage("商户不存在！");
				return message;
			}else{
				String path = request.getSession().getServletContext().getRealPath("images/business/logo"); 
				String fileName =shop.getMD_LoName()+new Date().getTime();
				String fileType=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				fileName=fileName+fileType;
		        File targetFile = new File(path, fileName);  
		        if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		        }  
		        
		        //保存  
		        try {  
		            file.transferTo(targetFile);  
		            if(shopService.updateLogo(fileName, shopid)==1){
		            	message.setStatus(true);
						message.setMessage("图片上传成功！");
						message.setData(fileName);
						if(shop.getMD_Images()!=null){
						File oldfile = new File(path, shop.getMD_Images()); 
				        if(oldfile.exists()){
				        	oldfile.delete();
				        }
						}
		            }else{
		            	message.setStatus(false);
						message.setMessage("图片上传失败！");
		            }
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
			}
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/settime", method = RequestMethod.POST)	
	public ReturnMessage setTime(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value="time",required=true) String time){//设置营业时间
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			if(shopService.setTime(shopid, time)==1){
				message.setStatus(true);
				message.setMessage("设置成功！");
			}else{
				message.setStatus(false);
				message.setMessage("设置失败！");
			}
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/setaddress", method = RequestMethod.POST)	
	public ReturnMessage setAddress(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value="address",required=true) String address,@RequestParam(value="latlong",required=true) String latlong){//设置营业时间
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			if(shopService.setAddress(shopid, address, latlong)==1){
				message.setStatus(true);
				message.setData(address);
				message.setMessage("设置成功！");
			}else{
				message.setStatus(false);
				message.setMessage("设置失败！");
			}
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/setPhone", method = RequestMethod.POST)	
	public ReturnMessage setPhone(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value="phone",required=true) String phone){//设置店铺电话
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			if(shopService.setPhone(shopid, phone)==1){
				message.setStatus(true);
				message.setMessage("设置成功！");
			}else{
				message.setStatus(false);
				message.setMessage("设置失败！");
			}
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/ResetPwd", method = RequestMethod.POST)	
	public ReturnMessage ResetPwd(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value="old",required=true) String old,@RequestParam(value="newpwd",required=true) String newpwd){//设置店铺电话
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			if(shopService.ResetPwd(shopid, old, newpwd)){
				message.setStatus(true);
				message.setMessage("修改成功！");
			}else{
				message.setStatus(false);
				message.setMessage("修改失败，请检查原密码输入");
			}
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/setStatus", method = RequestMethod.POST)	
	public ReturnMessage setStatus(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value="status",required=true) int status){//设置店铺电话
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			if(shopService.setStatus(shopid, status)==1){
				message.setStatus(true);
				message.setMessage("修改成功！");
			}else{
				message.setStatus(false);
				message.setMessage("设置失败！");
			}
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/setCardInfo", method = RequestMethod.POST)	
	public ReturnMessage setCardInfo(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value="oner_name",required=true) String oner_name,@RequestParam(value="bankNumber",required=true) String bankNumber,
			@RequestParam(value="bankAddress",required=false) String bankAddress){//设置店铺电话
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			if(shopService.setCardInfo(shopid, oner_name, bankNumber, bankAddress)==1){
				message.setStatus(true);
				message.setMessage("保存成功！");
			}else{
				message.setStatus(false);
				message.setMessage("设置失败！");
			}
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/addProductClass", method = RequestMethod.POST)	
	public ReturnMessage addProductClass(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value="typeName",required=true) String typeName,@RequestParam(value="index",required=true) int index){
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			Dx_ClassTable class_=new Dx_ClassTable();
			class_.setC_ParentId(shopid);
			class_.setC_Title(typeName);
			class_.setC_OrderIndex(index);
			if(classService.addClass(class_)>0){
				message.setStatus(true);
				message.setMessage("添加成功！");
			}else{
				message.setStatus(false);
				message.setMessage("添加失败！");
			}
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/getProductClassByShop", method = RequestMethod.POST)	//获取商店所有产品分类
	public ReturnMessage getProductClassByShop(@RequestParam(value="shopid",required=true) int shopid,@RequestParam(value="token",required=true) String token){
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			message.setStatus(true);
			message.setData(classService.getByShop(shopid));
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/upload_good", method = RequestMethod.POST)	//上传商户logo
	public ReturnMessage upload_good(@RequestParam(value="typeid",required=true) int typeid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value = "avatar", required = true) MultipartFile goodImg,HttpServletRequest request,@RequestParam(value="name",required=true) String name
			,@RequestParam(value="price",required=true) double price,@RequestParam(value="BZF",required=true) double BZF,@RequestParam(value="index",required=true) int index){
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			Dx_ClassTable class_=classService.getById(typeid);
			Dx_ChildShops shop=shopService.getById(class_.getC_ParentId());
			String goodName=PinYinUtil.getPinYin(name);
			String path = request.getSession().getServletContext().getRealPath("images/business/products"); 
			String fileName =shop.getMD_LoName()+goodName+new Date().getTime();
			String fileType=goodImg.getOriginalFilename().substring(goodImg.getOriginalFilename().lastIndexOf("."));
			fileName=fileName+fileType;
		    File targetFile = new File(path, fileName);  
		    if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		        }  
		    //保存  
		    try {  
		        	goodImg.transferTo(targetFile);
		        	Dx_Goods goods=new Dx_Goods();
		        	goods.setBZF(BZF);
		        	goods.setTitle(name);
		        	goods.setGoodsMarkPrice(price);
		        	goods.setGoodsMinPic(fileName);
		        	goods.setIsOnline(1);
		        	goods.setIsdelete(0);
		        	goods.setCreateTime(new Date());
		        	goods.setOrderindex(index);
		        	goods.setClassId(typeid);
		            
		        	if(dx_GoodsService.add(goods)>0){
		            	message.setStatus(true);
						message.setMessage("商品添加成功！");
						message.setData(goods);
						
		            }else{
		            	message.setStatus(false);
						message.setMessage("商品添加失败！");
		            }
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
			
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/getGoodByClass", method = RequestMethod.POST)	//获取商店所有产品分类
	public ReturnMessage getGoodByClass(@RequestParam(value="classid",required=true) int classid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value="shopid",required=false) int shopid){
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			message.setStatus(true);
			if(classid==0){
				message.setData(dx_GoodsService.getGoods_undercarriage(shopid));
			}else
			message.setData(dx_GoodsService.getGoodByType(classid));
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@RequestMapping(value="/edit_good", method = RequestMethod.POST)	//上传商户logo
	public ReturnMessage edit_good(@RequestParam(value="goodid",required=true) int goodid,@RequestParam(value="token",required=true) String token,
			@RequestParam(value = "avatar", required = false) MultipartFile goodImg,HttpServletRequest request,@RequestParam(value="name",required=true) String name
			,@RequestParam(value="price",required=true) double price,@RequestParam(value="BZF",required=true) double BZF
			,@RequestParam(value="index",required=true) int index,@RequestParam(value="online",required=true) int online){
		ReturnMessage message=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			Dx_Goods good=dx_GoodsService.getByid(goodid);
			if(goodImg!=null){
				Dx_ClassTable class_=classService.getById(good.getClassId());
				Dx_ChildShops shop=shopService.getById(class_.getC_ParentId());
				String goodName=PinYinUtil.getPinYin(name);
				String path = request.getSession().getServletContext().getRealPath("images/business/products"); 
				String fileName =shop.getMD_LoName()+goodName+new Date().getTime();
				String fileType=goodImg.getOriginalFilename().substring(goodImg.getOriginalFilename().lastIndexOf("."));
				fileName=fileName+fileType;
			    File targetFile = new File(path, fileName);  
			    if(!targetFile.exists()){  
			            targetFile.mkdirs();  
			        }  
			  //保存  
			    try {  
			        	goodImg.transferTo(targetFile);
			        	if(good.getGoodsMinPic()!=null){
			        		File old = new File(path, good.getGoodsMinPic()); 
			        		if(old.exists()){
			        			old.delete();
			        		}
			        	}
			        	good.setGoodsMinPic(fileName);
			        	message.setData(fileName);
			    } catch (Exception e) {  
		            e.printStackTrace(); 
		            message.setStatus(false);
					message.setMessage("商品修改失败！\r\n"+e.getMessage());
					return message;
		        }  
			}
				good.setBZF(BZF);
	        	good.setTitle(name);
	        	good.setGoodsMarkPrice(price);
	        	good.setOrderindex(index);
	        	good.setIsOnline(online);
			
			dx_GoodsService.updateGood(good);
			message.setStatus(true);
			message.setMessage("商品修改成功！");
			
			
		}else{
			message.setStatus(false);
			message.setMessage("非法操作");
		}
		return message;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getRandomCode", method = RequestMethod.GET)	//商户找回密码时候的验证码，需要参数IMEI MD5值
	public void getRandomCode(@RequestParam(value="uuid",required=true) String uuid, HttpServletRequest req,HttpServletResponse resp){
		 try{
		Map<String, BufferedImage> codimg=MyUtil.getRandomCode();
		 Iterator<Map.Entry<String, BufferedImage>> it = codimg.entrySet().iterator();
		Map.Entry<String, BufferedImage> entry = it.next();
		String randomCode=entry.getKey();
		applicationService.addRandomCode(uuid, randomCode);
 
        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
 
        resp.setContentType("image/jpeg");
 
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(entry.getValue(), "jpeg", sos);
        sos.close();
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	@RequestMapping(value="/testRandomCode", method = RequestMethod.POST)	//商户找回密码时候的验证码，需要参数IMEI MD5值
	public ReturnMessage testRandomCode(@RequestParam(value="uuid",required=true) String uuid,@RequestParam(value="username",required=true) String username
			,@RequestParam(value="code",required=true) String code){
		ReturnMessage returnMessage=new ReturnMessage();
		
			if(applicationService.testRandomCode(uuid, code)){
				applicationService.removeRandomCode(uuid);
				returnMessage.setStatus(true);
			}else{
				returnMessage.setStatus(false);
				returnMessage.setMessage("验证码输入错误");
			}
		
		return returnMessage;
	}
}
