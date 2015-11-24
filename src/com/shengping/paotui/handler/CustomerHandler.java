package com.shengping.paotui.handler;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shengping.paotui.handler.model.ReturnMessage;
import com.shengping.paotui.model.Dx_Member;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.Dt_SysConfigService;
import com.shengping.paotui.service.Dx_MemberService;
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
	@RequestMapping(value="/sendCode", method = RequestMethod.POST)	//���ȸ�ע��
	public ReturnMessage SendCode(@RequestParam(value = "phone", required = true) String phone){
		ReturnMessage returnMessage=new ReturnMessage();
		if(dx_MemberService.testPhone(phone)){
			if(com.shengping.paotui.util.Validator.isMobile(phone)){
				if(applicationService.sendPhoneCode(phone, RandomStringUtils.randomNumeric(4))){
					returnMessage.setMessage("��֤���ѷ��ͣ���ע�����");
					returnMessage.setStatus(true);
				}else{
					returnMessage.setMessage("�����͵���֤��������࣬����ϵ�ͷ���������ɣ�");
					returnMessage.setStatus(false);
				}
			}else{
				returnMessage.setMessage("�ֻ��Ÿ�ʽ����");
				returnMessage.setStatus(false);
			}
		}else{
			returnMessage.setMessage("���ֻ��Ѿ�ע�������");
			returnMessage.setStatus(false);
		}
		return returnMessage;
	}
	@RequestMapping(value="/testPhoneCode", method = RequestMethod.POST)	//���ȸ�ע��ʱ����֤����֤
	public ReturnMessage testPhoneCode(@RequestParam(value = "phone", required = true) String phone,@RequestParam(value = "code", required = true) String code){
		ReturnMessage returnMessage=new ReturnMessage();
		if(applicationService.testPhoneCode(phone, code)){
			returnMessage.setStatus(true);
		}else{
			returnMessage.setMessage("��֤���������");
			returnMessage.setStatus(false);
		}
		
		return returnMessage;
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)	//���ȸ�ע��ʱ����֤����֤
	public ReturnMessage Register(@RequestParam(value = "phone", required = true) String phone,@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "pwd", required = true) String pwd){
		ReturnMessage returnMessage=new ReturnMessage();
		if(applicationService.testPhoneCode(phone, code)){
			applicationService.removePhoneCode(phone);
			Dx_Member member=new Dx_Member();
			member.setM_Mobile(phone);
			member.setM_PsW(pwd);
			if(dx_MemberService.register(member)>0){
				returnMessage.setStatus(true);
				returnMessage.setMessage("ע��ɹ���");
			}else{
				returnMessage.setStatus(false);
				returnMessage.setMessage("ע��ʧ�ܣ�");
			}
		}else{
			returnMessage.setMessage("��֤���������");
			returnMessage.setStatus(false);
		}
		
		return returnMessage;
	}
	@RequestMapping(value="/login_pwd", method = RequestMethod.POST)	//�û������¼
	public ReturnMessage login_pwd(@RequestParam(value = "phone", required = true) String phone,@RequestParam(value = "pwd", required = true) String pwd){
		ReturnMessage returnMessage=new ReturnMessage();
		Dx_Member member=dx_MemberService.Login(phone, pwd);
		if(member!=null){
			String token=TokenProcessor.getInstance().generateTokeCode();
			applicationService.addToken_Shop(phone,token);
			member.setToken(token);
			returnMessage.setStatus(true);
			returnMessage.setData(member);
			returnMessage.setMessage("��¼�ɹ�");
		}else{
			returnMessage.setStatus(false);
			returnMessage.setMessage("�ֻ��Ż��������");
		}
		return returnMessage;
	}
	@RequestMapping(value="/login_phone_sendcode", method = RequestMethod.POST)	//�û��ֻ���֤���¼ ��ȡ��֤��
	public ReturnMessage login_phone_sendcode(@RequestParam(value = "phone", required = true) String phone){
		ReturnMessage returnMessage=new ReturnMessage();
		if(com.shengping.paotui.util.Validator.isMobile(phone)){
			if(!dx_MemberService.testPhone(phone)){
					if(applicationService.sendPhoneCode(phone, RandomStringUtils.randomNumeric(4))){
						returnMessage.setMessage("��֤���ѷ��ͣ���ע�����");
						returnMessage.setStatus(true);
					}else{
						returnMessage.setMessage("�����͵���֤��������࣬����ϵ�ͷ���������ɣ�");
						returnMessage.setStatus(false);
					}
			}else{
				returnMessage.setMessage("���ֻ���δע�ᣡ");
				returnMessage.setStatus(false);
			}
		}else{
			returnMessage.setMessage("�ֻ��Ÿ�ʽ����");
			returnMessage.setStatus(false);
		}
		return returnMessage;
	}
	@RequestMapping(value="/login_phone", method = RequestMethod.POST)	//�û��ֻ���֤���¼
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
					returnMessage.setMessage("��¼�ɹ���");
				}else{
					returnMessage.setMessage("��֤���������");
					returnMessage.setStatus(false);
				}
			}else{
				returnMessage.setMessage("���ֻ���δע�ᣡ");
				returnMessage.setStatus(false);
			}
		}else{
			returnMessage.setMessage("�ֻ��Ÿ�ʽ����");
			returnMessage.setStatus(false);
		}
		return returnMessage;
	}
	@RequestMapping(value="/getpaotui", method = RequestMethod.POST)	//�û���ȡ���ȹ�˾��Ϣ
	public ReturnMessage getPaotui(@RequestParam(value = "areaid", required = true) String areaid){
		ReturnMessage returnMessage=new ReturnMessage();
		returnMessage.setData(dt_SysConfigService.getByArea(areaid));
		returnMessage.setStatus(true);
		return returnMessage;
	}
	@RequestMapping(value="/downOrder", method = RequestMethod.POST)	//�û��µ�
	public ReturnMessage downOrder(@RequestParam(value = "token", required = true) String token){
		ReturnMessage returnMessage=new ReturnMessage();
		
		return returnMessage;
	}
}
