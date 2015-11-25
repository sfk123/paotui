package com.shengping.paotui.handler;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shengping.paotui.handler.model.ReturnMessage;
import com.shengping.paotui.model.Dx_Member;
import com.shengping.paotui.model.Dx_Order;
import com.shengping.paotui.model.Dx_RecAddress;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.Dt_SysConfigService;
import com.shengping.paotui.service.Dx_MemberService;
import com.shengping.paotui.service.Dx_RecAddressService;
import com.shengping.paotui.util.TokenProcessor;

@RequestMapping("/customerservice")
@RestController
public class CustomerHandler {
	
	@Autowired
	private Dx_MemberService dx_MemberService;
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private Dt_SysConfigService dt_SysConfigService;
	@Autowired
	private Dx_RecAddressService dx_RecAddressService;
	@RequestMapping(value="/sendCode", method = RequestMethod.POST)	//跑腿哥注册
	public ReturnMessage SendCode(@RequestParam(value = "phone", required = true) String phone){
		ReturnMessage returnMessage=new ReturnMessage();
		if(dx_MemberService.testPhone(phone)){
			if(com.shengping.paotui.util.Validator.isMobile(phone)){
				if(applicationService.sendPhoneCode(phone, RandomStringUtils.randomNumeric(4))){
					returnMessage.setMessage("验证码已发送，请注意查收");
					returnMessage.setStatus(true);
				}else{
					returnMessage.setMessage("您发送的验证码次数过多，请联系客服帮您解决吧！");
					returnMessage.setStatus(false);
				}
			}else{
				returnMessage.setMessage("手机号格式有误！");
				returnMessage.setStatus(false);
			}
		}else{
			returnMessage.setMessage("该手机已经注册过啦！");
			returnMessage.setStatus(false);
		}
		return returnMessage;
	}
	@RequestMapping(value="/testPhoneCode", method = RequestMethod.POST)	//跑腿哥注册时，验证码验证
	public ReturnMessage testPhoneCode(@RequestParam(value = "phone", required = true) String phone,@RequestParam(value = "code", required = true) String code){
		ReturnMessage returnMessage=new ReturnMessage();
		if(applicationService.testPhoneCode(phone, code)){
			returnMessage.setStatus(true);
		}else{
			returnMessage.setMessage("验证码输入错误！");
			returnMessage.setStatus(false);
		}
		
		return returnMessage;
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)	//跑腿哥注册时，验证码验证
	public ReturnMessage Register(@RequestParam(value = "phone", required = true) String phone,@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "pwd", required = true) String pwd){
		ReturnMessage returnMessage=new ReturnMessage();
		if(applicationService.testPhoneCode(phone, code)){
			applicationService.removePhoneCode(phone);
			Dx_Member member=new Dx_Member();
			member.setM_Mobile(phone);
			member.setM_PsW(pwd);
			int id=dx_MemberService.register(member);
			member.setM_ID(id);
			member.setM_SYMoney(0);
			String token=TokenProcessor.getInstance().generateTokeCode();
			applicationService.addToken_Shop(phone,token);
			member.setToken(token);
			if(id>0){
				returnMessage.setStatus(true);
				returnMessage.setData(member);
				returnMessage.setMessage("注册成功！");
			}else{
				returnMessage.setStatus(false);
				returnMessage.setMessage("注册失败！");
			}
		}else{
			returnMessage.setMessage("验证码输入错误！");
			returnMessage.setStatus(false);
		}
		
		return returnMessage;
	}
	@RequestMapping(value="/login_pwd", method = RequestMethod.POST)	//用户密码登录
	public ReturnMessage login_pwd(@RequestParam(value = "phone", required = true) String phone,@RequestParam(value = "pwd", required = true) String pwd){
		ReturnMessage returnMessage=new ReturnMessage();
		Dx_Member member=dx_MemberService.Login(phone, pwd);
		if(member!=null){
			String token=TokenProcessor.getInstance().generateTokeCode();
			applicationService.addToken_Shop(phone,token);
			member.setToken(token);
			returnMessage.setStatus(true);
			returnMessage.setData(member);
			returnMessage.setMessage("登录成功");
		}else{
			returnMessage.setStatus(false);
			returnMessage.setMessage("手机号或密码错误");
		}
		return returnMessage;
	}
	@RequestMapping(value="/login_phone_sendcode", method = RequestMethod.POST)	//用户手机验证码登录 获取验证码
	public ReturnMessage login_phone_sendcode(@RequestParam(value = "phone", required = true) String phone){
		ReturnMessage returnMessage=new ReturnMessage();
		if(com.shengping.paotui.util.Validator.isMobile(phone)){
			if(!dx_MemberService.testPhone(phone)){
					if(applicationService.sendPhoneCode(phone, RandomStringUtils.randomNumeric(4))){
						returnMessage.setMessage("验证码已发送，请注意查收");
						returnMessage.setStatus(true);
					}else{
						returnMessage.setMessage("您发送的验证码次数过多，请联系客服帮您解决吧！");
						returnMessage.setStatus(false);
					}
			}else{
				returnMessage.setMessage("该手机尚未注册！");
				returnMessage.setStatus(false);
			}
		}else{
			returnMessage.setMessage("手机号格式有误！");
			returnMessage.setStatus(false);
		}
		return returnMessage;
	}
	@RequestMapping(value="/login_phone", method = RequestMethod.POST)	//用户手机验证码登录
	public ReturnMessage login_phone(@RequestParam(value = "phone", required = true) String phone,@RequestParam(value = "code", required = true) String code){
		ReturnMessage returnMessage=new ReturnMessage();
		if(com.shengping.paotui.util.Validator.isMobile(phone)){
			if(!dx_MemberService.testPhone(phone)){
				if(applicationService.testPhoneCode(phone, code)){
					returnMessage.setStatus(true);
					String token=TokenProcessor.getInstance().generateTokeCode();
					applicationService.addToken_Shop(phone,token);
					Dx_Member member=dx_MemberService.getByPhone(phone);
					member.setToken(token);
					returnMessage.setData(member);
					returnMessage.setMessage("登录成功！");
				}else{
					returnMessage.setMessage("验证码输入错误！");
					returnMessage.setStatus(false);
				}
			}else{
				returnMessage.setMessage("该手机尚未注册！");
				returnMessage.setStatus(false);
			}
		}else{
			returnMessage.setMessage("手机号格式有误！");
			returnMessage.setStatus(false);
		}
		return returnMessage;
	}
	@RequestMapping(value="/getpaotui", method = RequestMethod.POST)	//用户获取跑腿公司信息
	public ReturnMessage getPaotui(@RequestParam(value = "areaid", required = true) String areaid){
		ReturnMessage returnMessage=new ReturnMessage();
		returnMessage.setData(dt_SysConfigService.getByArea(areaid));
		returnMessage.setStatus(true);
		return returnMessage;
	}
	@RequestMapping(value="/downOrder", method = RequestMethod.POST)	//用户下单
	public ReturnMessage downOrder(@RequestParam(value = "token", required = true) String token,@Validated Dx_Order order,BindingResult result
			,@RequestParam(value = "phone", required = true) String phone,@RequestParam(value = "location_start", required = true) String location_start,@RequestParam(value = "address_end", required = true) String address_end
			,@RequestParam(value = "location_end", required = true) String location_end,@RequestParam(value = "address_start", required = true) String address_start
			,@RequestParam(value = "transportation", required = true) String transportation){
		ReturnMessage returnMessage=new ReturnMessage();
		if(result.hasErrors()){
			returnMessage.setStatus(false);
			returnMessage.setMessage(result.getFieldError().getDefaultMessage());
		}else{
			if(applicationService.checkTokenOfShop(token)){
				Dx_RecAddress address=new Dx_RecAddress();//添加收货地址
			}else{
				returnMessage.setStatus(false);
				returnMessage.setMessage("非法操作");
			}
		}
		return returnMessage;
	}
	@RequestMapping(value="/crearAddress", method = RequestMethod.POST)//添加收货地址
	public ReturnMessage crearAddress(@RequestParam(value = "token", required = true) String token,@Validated Dx_RecAddress address,BindingResult result){
		ReturnMessage returnMessage=new ReturnMessage();
		if(result.hasErrors()){
			returnMessage.setStatus(false);
			returnMessage.setMessage(result.getFieldError().getDefaultMessage());
		}else{
			if(applicationService.checkTokenOfShop(token)){
				int id=dx_RecAddressService.creatAddress(address);
				address.setId(id);
				returnMessage.setStatus(true);
				returnMessage.setMessage("添加成功");
				returnMessage.setData(address);
			}else{
				returnMessage.setStatus(false);
				returnMessage.setMessage("非法操作");
			}
		}
		return returnMessage;
	}
	@RequestMapping(value="/getAddressList", method = RequestMethod.POST)//添加收货地址
	public ReturnMessage getAddressList(@RequestParam(value = "token", required = true) String token,@RequestParam(value = "userid", required = true) int userid){
		ReturnMessage returnMessage=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			
			returnMessage.setStatus(true);
			returnMessage.setData(dx_RecAddressService.getAddressList(userid));
		}else{
			returnMessage.setStatus(false);
			returnMessage.setMessage("非法操作");
		}
		return returnMessage;
	}
}
