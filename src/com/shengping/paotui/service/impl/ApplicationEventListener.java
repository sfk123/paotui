package com.shengping.paotui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

import com.shengping.paotui.service.ApplicationService;

@SuppressWarnings("rawtypes")
public class ApplicationEventListener implements ApplicationListener {

	@Autowired
	private ApplicationService applicationService;
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// ���������ˢ���¼�
		if (event instanceof ContextClosedEvent) {
			applicationService.applicationStop();
//			System.out.println(event.getClass().getSimpleName() + " �¼��ѷ�����");
		} else if (event instanceof ContextRefreshedEvent) {// ����������ر��¼�
//			System.out.println(event.getClass().getSimpleName() + " �¼��ѷ�����");
		} else if (event instanceof ContextStartedEvent) {
//			System.out.println(event.getClass().getSimpleName() + " �¼��ѷ�����");
		} else if (event instanceof ContextStoppedEvent) {
//			System.out.println(event.getClass().getSimpleName() + " �¼��ѷ�����");
		} else {
//			System.out.println("�������¼�����:" + event.getClass().getName());
		}
	}

}
