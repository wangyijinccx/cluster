package com.ipeaksoft.moneyday.core.util;

import com.ipeaksoft.moneyday.core.dto.ActiveAidewei;
import com.ipeaksoft.moneyday.core.dto.ActiveBase;
import com.ipeaksoft.moneyday.core.dto.ActiveDomob;
import com.ipeaksoft.moneyday.core.dto.ActiveLimei;
import com.ipeaksoft.moneyday.core.dto.ActiveWanpu;
import com.ipeaksoft.moneyday.core.dto.ActiveYouMi;
import com.ipeaksoft.moneyday.core.dto.AdsClick;
import com.ipeaksoft.moneyday.core.dto.FastClick;

public class RedisKeyUtil {

	public static final String NEW_ASSIST_APPID = "1234";
	public static final String SUFFIX = "MONEYDAY";
	public static final String SEPERATE = "_";
	public static final int TIMEOUT_CLICK = 24 * 3600;

	public static String getKey(FastClick click) {
		if (click != null) {
			String idfa = click.getIdfa();
			if (NEW_ASSIST_APPID.equals(click.getAppID())) {
				idfa = click.getMobile();
			}
			return idfa + SEPERATE + click.getAppID() + SEPERATE + SUFFIX;
		} else {
			return null;
		}
	}

	public static String getKey(FastActive active) {
		if (active != null) {
			return active.getIdfa() + SEPERATE + active.getAppID() + SEPERATE + SUFFIX;
		} else {
			return null;
		}
	}

	public static String getKey(AdsClick click) {
		if (click != null) {
			return click.getIdfa() + SEPERATE + click.getAppName() + SEPERATE + SUFFIX;
		} else {
			return null;
		}
	}

	public static String getKey(ActiveBase base) {
		if (base == null) {
			return null;
		}

		if (base instanceof ActiveAidewei) {
			ActiveAidewei active = (ActiveAidewei) base;
			return active.getIdfa().toUpperCase() + SEPERATE + active.getAppName() + SEPERATE + SUFFIX;
		} else if (base instanceof ActiveLimei) {
			ActiveLimei active = (ActiveLimei) base;
			return active.getIdfa().toUpperCase() + SEPERATE + active.getTitle() + SEPERATE + SUFFIX;
		} else if (base instanceof ActiveYouMi) {
			ActiveYouMi active = (ActiveYouMi) base;
			return active.getDevice().toUpperCase() + SEPERATE + active.getAd() + SEPERATE + SUFFIX;
		} else if (base instanceof ActiveDomob) {
			ActiveDomob active = (ActiveDomob) base;
			return active.getDevice().toUpperCase() + SEPERATE + active.getAd() + SEPERATE + SUFFIX;
		} else if (base instanceof ActiveWanpu) {
			ActiveWanpu active = (ActiveWanpu) base;
			return active.getUdid().toUpperCase() + SEPERATE + active.getAd_name() + SEPERATE + SUFFIX;
		} else {
			return null;
		}
	}
	
	public static String getUsedAppIdKey(Integer appId) {
		if (null != appId) {
			return appId + SEPERATE + "USED" + SEPERATE + "APPID" + SEPERATE + SUFFIX;
		} else {
			return null;
		}
	}
}
