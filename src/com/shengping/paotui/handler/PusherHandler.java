package com.shengping.paotui.handler;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shengping.paotui.handler.model.ReturnMessage;
import com.shengping.paotui.model.Dx_Clerks;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.Dx_ClerksService;
import com.shengping.paotui.util.PinYinUtil;
import com.shengping.paotui.util.TokenProcessor;


@RequestMapping("/pusherservice")
@RestController
public class PusherHandler {

	@Autowired
	private Dx_ClerksService dx_ClerksService;
	@Autowired
	private ApplicationService applicationService;
	@RequestMapping(value="/sendCode", method = RequestMethod.POST)	//���ȸ�ע��
	public ReturnMessage SendCode(@RequestParam(value = "phone", required = true) String phone){
		ReturnMessage returnMessage=new ReturnMessage();
		if(dx_ClerksService.testPhone(phone)){
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
			returnMessage.setMessage("���ֻ����Ѿ�ע����ˣ�");
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
	@RequestMapping(value="/register", method = RequestMethod.POST)	//���ȸ�ע��
	public ReturnMessage Register(@RequestParam(value = "avatar", required = true) MultipartFile avatar,@RequestParam(value = "photo1", required = true) MultipartFile photo1,
			@RequestParam(value = "photo2", required = true) MultipartFile photo2,@RequestParam(value = "photo3", required = true) MultipartFile photo3
			,@Validated Dx_Clerks clerks, BindingResult result,@RequestParam(value = "code", required = true) String code,HttpServletRequest request){
		ReturnMessage returnMessage=new ReturnMessage();
		if(result.hasErrors()){
			returnMessage.setStatus(false);
			returnMessage.setMessage(result.getFieldError().getDefaultMessage());
		}else{
			if(applicationService.testPhoneCode(clerks.getCL_Tell(), code)){
				String path = request.getSession().getServletContext().getRealPath("images/pusher"); 
				String avatarName =PinYinUtil.getPinYin(clerks.getCL_Name())+new Date().getTime();
				String fileType=avatar.getOriginalFilename().substring(avatar.getOriginalFilename().lastIndexOf("."));
				avatarName=avatarName+fileType;
		        File targetFile_avatarName = new File(path, avatarName);  
		        if(!targetFile_avatarName.exists()){  
		        	targetFile_avatarName.mkdirs();  
		        } 
		        String photo1name =PinYinUtil.getPinYin(clerks.getCL_Name())+"photo1"+new Date().getTime();
				fileType=photo1.getOriginalFilename().substring(photo1.getOriginalFilename().lastIndexOf("."));
				photo1name=photo1name+fileType;
		        File targetFile_photo1 = new File(path, photo1name);  
		        if(!targetFile_photo1.exists()){  
		        	targetFile_photo1.mkdirs();  
		        } 
		        String photo2name =PinYinUtil.getPinYin(clerks.getCL_Name())+"photo2"+new Date().getTime();
				fileType=photo2.getOriginalFilename().substring(photo2.getOriginalFilename().lastIndexOf("."));
				photo2name=photo2name+fileType;
		        File targetFile_photo2 = new File(path, photo2name);  
		        if(!targetFile_photo2.exists()){  
		        	targetFile_photo2.mkdirs();  
		        } 
		        String photo3name =PinYinUtil.getPinYin(clerks.getCL_Name())+"photo3"+new Date().getTime();
				fileType=photo3.getOriginalFilename().substring(photo3.getOriginalFilename().lastIndexOf("."));
				photo3name=photo3name+fileType;
		        File targetFile_photo3 = new File(path, photo3name);  
		        if(!targetFile_photo3.exists()){  
		        	targetFile_photo3.mkdirs();  
		        } 
		        try {
					avatar.transferTo(targetFile_avatarName);
					photo1.transferTo(targetFile_photo1);
					photo2.transferTo(targetFile_photo2);
					photo3.transferTo(targetFile_photo3);
					clerks.setCL_WorkPhoto(avatarName);//������
					clerks.setCL_HZPhoto(photo1name);//�ֳ����֤��Ƭ
					clerks.setCL_ZMPhoto(photo2name);
					clerks.setCL_FMPhoto(photo3name);
					clerks.setCL_LoginName(clerks.getCL_Tell());//��¼�����û��ֻ���
					if(dx_ClerksService.register(clerks)>0){
						returnMessage.setStatus(true);
						applicationService.removePhoneCode(clerks.getCL_Tell());
						returnMessage.setMessage("ע��ɹ�����ȴ�������Ա���");
					}else{
						returnMessage.setStatus(false);
						returnMessage.setMessage("ע��ʧ�ܣ�����ϵ����Ա");
					}
				} catch (IllegalStateException e) {
					returnMessage.setStatus(false);
					returnMessage.setMessage(e.getMessage());
					e.printStackTrace();
				} catch (IOException e) {
					returnMessage.setStatus(false);
					returnMessage.setMessage(e.getMessage());
					e.printStackTrace();
				}
			}else{
				returnMessage.setMessage("��֤���������");
				returnMessage.setStatus(false);
			}
		}
		return returnMessage;
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)	//���ȸ�ע��
	public ReturnMessage login(@RequestParam(value = "username", required = true) String username,@RequestParam(value = "pwd", required = true) String pwd){
		ReturnMessage returnMessage=new ReturnMessage();
		Dx_Clerks clerks=dx_ClerksService.login(username, pwd);
		if(clerks!=null){
			String token=TokenProcessor.getInstance().generateTokeCode();
			applicationService.addToken_Shop(username,token);
			clerks.setToken(token);
			returnMessage.setData(clerks);
			returnMessage.setStatus(true);
		}else{
			returnMessage.setStatus(false);
			returnMessage.setMessage("�û����������������");
		}
		return returnMessage;
	}
	@RequestMapping(value="/updateStatus", method = RequestMethod.POST)	//���ȸ�ע��
	public ReturnMessage updateStatus(@RequestParam(value = "token", required = true) String token,@RequestParam(value = "status", required = true) int status
			,@RequestParam(value = "pusherid", required = true) int pusherid){
		ReturnMessage returnMessage=new ReturnMessage();
		if(applicationService.checkTokenOfShop(token)){
			dx_ClerksService.updateStatus(status, pusherid);
			if(status==1){
				returnMessage.setData(true);
			}else{
				returnMessage.setData(false);
			}
			returnMessage.setStatus(true);
		}else{
			returnMessage.setStatus(false);
			returnMessage.setMessage("�Ƿ�����");
		}
		return returnMessage;
	}
}
