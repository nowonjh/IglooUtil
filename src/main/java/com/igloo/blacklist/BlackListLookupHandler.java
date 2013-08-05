package com.igloo.blacklist;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;
import org.araqne.logdb.LookupHandler;
import org.araqne.logdb.LookupHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.igloo.util.IglooCache;

@Component(name = "blacklist-lookup-handler")
public class BlackListLookupHandler implements LookupHandler {
	Logger logger = LoggerFactory.getLogger(BlackListLookupHandler.class.getName());
	
	@Requires
	private LookupHandlerRegistry handlerRegistry;
	private IglooCache cache;
	
	@Validate
	public void start() {
		if(handlerRegistry.getLookupHandler("blacklist") != null){
			handlerRegistry.removeLookupHandler("blacklist");
		}
		handlerRegistry.addLookupHandler("blacklist", this);
		cache = IglooCache.getInstance();
	}

	@Invalidate
	public void stop() {
		if (handlerRegistry != null){
			handlerRegistry.removeLookupHandler("blacklist");
		}
			
	}

	public Object lookup(String srcField, String dstField, Object value) {
		if (dstField.equals("ip")) {
			if(value != null){
				return cache.isBlackListIP(value.toString());
			}
		}
		if (dstField.equals("url")) {
			if(value != null){
				return cache.isBlackListUrl(value.toString());
			}
			
		}	
		if (dstField.equals("port")) {
			if(value != null){
				return cache.isBlackListPort(value.toString());
			}
		}
		return false;
	}

}