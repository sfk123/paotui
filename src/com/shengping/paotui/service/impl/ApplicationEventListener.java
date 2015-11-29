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
		// 如果是容器刷新事件
		if (event instanceof ContextClosedEvent) {
			applicationService.applicationStop();
//			System.out.println(event.getClass().getSimpleName() + " 事件已发生！");
		} else if (event instanceof ContextRefreshedEvent) {// 如果是容器关闭事件
//			System.out.println(event.getClass().getSimpleName() + " 事件已发生！");
		} else if (event instanceof ContextStartedEvent) {
//			System.out.println(event.getClass().getSimpleName() + " 事件已发生！");
		} else if (event instanceof ContextStoppedEvent) {
//			System.out.println(event.getClass().getSimpleName() + " 事件已发生！");
		} else {
//			System.out.println("有其它事件发生:" + event.getClass().getName());
		}
	}

}
