package com.ipeaksoft.moneyday.api.util;

import com.ipeaksoft.moneyday.api.vo.ActiveAidewei;
import com.ipeaksoft.moneyday.api.vo.ActiveBase;
import com.ipeaksoft.moneyday.api.vo.ActiveDomob;
import com.ipeaksoft.moneyday.api.vo.ActiveLimei;
import com.ipeaksoft.moneyday.api.vo.ActiveWanpu;
import com.ipeaksoft.moneyday.api.vo.ActiveYouMi;
import com.ipeaksoft.moneyday.api.vo.AdsClick;
import com.ipeaksoft.moneyday.api.vo.FastActive;
import com.ipeaksoft.moneyday.api.vo.FastClick;

public class RedisKeyUtil {

	public static final String SUFFIX = "MONEYDAY";
	public static final String SEPERATE = "_";
	public static final int TIMEOUT_CLICK = 3 * 3600;

	public static String getKey(FastClick click) {
		if (click != null) {
			return click.getIdfa() + SEPERATE + click.getAppID() + SEPERATE
					+ SUFFIX;
		}
		return null;
	}

	public static String getKey(FastActive active) {
		if (active != null) {
			return active.getIdfa() + SEPERATE + active.getAppID() + SEPERATE
					+ SUFFIX;
		}
		return null;
	}
	
	public static String getKey(AdsClick click){
		if (click != null) {
			return click.getIdfa() + SEPERATE + click.getAppName() + SEPERATE
					+ SUFFIX;
		}
		return null;
	}
	
	public static String getKey(ActiveBase base){
		if (base == null){
			return null;
		}
		
		if (base instanceof ActiveAidewei){
			ActiveAidewei active = (ActiveAidewei)base;
			return active.getIdfa().toUpperCase() + SEPERATE + active.getAppName() + SEPERATE
					+ SUFFIX;
		}
		else if (base instanceof ActiveLimei){
			ActiveLimei active = (ActiveLimei)base;
			return active.getIdfa().toUpperCase() + SEPERATE + active.getTitle() + SEPERATE
					+ SUFFIX;
		}
		else if (base instanceof ActiveYouMi){
			ActiveYouMi active = (ActiveYouMi)base;
			return active.getDevice().toUpperCase() + SEPERATE + active.getAd() + SEPERATE
					+ SUFFIX;
		}
		else if (base instanceof ActiveDomob){
			ActiveDomob active = (ActiveDomob)base;
			return active.getDevice().toUpperCase() + SEPERATE + active.getAd() + SEPERATE
					+ SUFFIX;
		}
		else if (base instanceof ActiveWanpu){
			ActiveWanpu active = (ActiveWanpu)base;
			return active.getUdid().toUpperCase() + SEPERATE + active.getAd_name() + SEPERATE
					+ SUFFIX;
		}
		return null;
	}
	
}
