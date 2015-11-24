package com.shengping.paotui.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengping.paotui.handler.model.TimeRomove;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.TimerService;
@Service
public class TimerServiceImpl implements TimerService{

	@Autowired
	private ApplicationService applicationService;
	
	private Map<String,TimeRomove> values;
	
	public TimerServiceImpl(){
		values=new HashMap<String, TimeRomove>();
		timer.schedule(new MyTask(), 1, 6000); //一分钟执行一次
	}
	private Timer timer = new Timer();  
	class MyTask extends TimerTask {  
		 
	    @Override  
	    public void run() {  
	    	for (Map.Entry<String, TimeRomove> entry : values.entrySet()) {  
	    		 long diff = new Date().getTime()- entry.getValue().getDate().getTime();
	    		 long hours = diff / (1000 * 60 * 60 );
	    		 if(hours>8){//超过8小时就移除
	    			 applicationService.removeMapKey(entry.getKey(), entry.getValue().getMap());
	    			 values.remove(entry.getKey());
	    		 }
	    	}  
	        
	    }  
	}
	@Override
	public void putRemove(String key, String map) {
		
		TimeRomove remove=new TimeRomove();
		remove.setMap(map);
		remove.setDate(new Date());
		values.put(key, remove);
	}

}
