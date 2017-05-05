package com.ipeaksoft.moneyday.core.util;

import java.util.HashSet;
import java.util.Set;

public enum PersistRedisKey {
	LangYiTaskMap("LangYiTaskMap"),//hash, adudid->taskId , default for xiguamei
	LangYiTaskMapTJZ("LangYiTaskMapTJZ"), //hash, adudid->taskId, for TaoJinZhe
	LangYiTaskJsonMap("LangYiTaskJsonMap"),//hash, adudid->json from langyi, for xiguamei
	LangYiTaskJsonMapTJZ("LangYiTaskJsonMapTJZ"),//hash, adudid->json from langyi, for taojinzhe
	LangYiOnlineTask("LangYiOnlineTask"), //set, adudid
	
	
	BatMobiTaskMapStudio("BatMobiTaskMapStudio"), //hash, adid-> taskId
	BatMobiPriceMapStudio("BatMobiPriceMapStudio"), //hash, adid-> price
	BatMobiOnlineTaskStudio("BatMobiOnlineTaskStudio"), //set, adid

	BatMobiTaskMapXiguamei("BatMobiTaskMapXiguamei"), //hash, adid-> taskId
	BatMobiPriceMapXiguamei("BatMobiPriceMapXiguamei"), //hash, adid-> price
	BatMobiOnlineTaskXiguamei("BatMobiOnlineTaskXiguamei"), //set, adid

	
	MobvistaTaskMapStudio("MobvistaTaskMapStudio"), //hash, adid-> taskId
	MobvistaPriceMapStudio("MobvistaPriceMapStudio"), //hash, adid-> price
	MobvistaOnlineTaskStudio("MobvistaOnlineTaskStudio"), //set, adid

	MobvistaTaskMapXiguamei("MobvistaTaskMapXiguamei"), //hash, adid-> taskId
	MobvistaPriceMapXiguamei("MobvistaPriceMapXiguamei"), //hash, adid-> price
	MobvistaOnlineTaskXiguamei("MobvistaOnlineTaskXiguamei"), //set, adid


	YeahMobiTaskMapStudio("YeahMobiTaskMapStudio"), //hash, adid-> taskId
	YeahMobiPriceMapStudio("YeahMobiPriceMapStudio"), //hash, adid-> price
	YeahMobiOnlineTaskStudio("YeahMobiOnlineTaskStudio"), //set, adid

	YeahMobiTaskMapXiguamei("YeahMobiTaskMapXiguamei"), //hash, adid-> taskId
	YeahMobiPriceMapXiguamei("YeahMobiPriceMapXiguamei"), //hash, adid-> price
	YeahMobiOnlineTaskXiguamei("YeahMobiOnlineTaskXiguamei"), //set, adid

	
	AvazuTaskMapStudio("AvazuTaskMapStudio"), //hash, adid-> taskId
	AvazuPriceMapStudio("AvazuPriceMapStudio"), //hash, adid-> price
	AvazuOnlineTaskStudio("AvazuOnlineTaskStudio"), //set, adid

	AvazuTaskMapXiguamei("AvazuTaskMapXiguamei"), //hash, adid-> taskId
	AvazuPriceMapXiguamei("AvazuPriceMapXiguamei"), //hash, adid-> price
	AvazuOnlineTaskXiguamei("AvazuOnlineTaskXiguamei"), //set, adid
	
	AppcoachOnlineTaskStudio("AppcoachOnlineTaskStudio"), //set, adid
	AppcoachTaskMapStudio("AppcoachTaskMapStudio"), //hash, adid-> taskId
	AppcoachPriceMapStudio("AppcoachPriceMapStudio"), //hash, adid-> price

	AppcoachTaskMapXiguamei("AppcoachTaskMapXiguamei"), //hash, adid-> taskId
	AppcoachPriceMapXiguamei("AppcoachPriceMapXiguamei"), //hash, adid-> price
	AppcoachOnlineTaskXiguamei("AppcoachOnlineTaskXiguamei"), //set, adid
	
	
	WanPuOnlineTaskStudio("WanPuOnlineTaskStudio"), //set, adid
	WanPuOnlineTaskXiguamei("WanPuOnlineTaskXiguamei"), //set, adid
	WanPuTaskMapStudio("WanPuTaskMapStudio"), //hash, adid-> taskId
	WanPuTaskMapXiguamei("WanPuTaskMapXiguamei"), //hash, adid-> taskId
	WanPuPriceMapStudio("WanPuPriceMapStudio"), //hash, adid-> price
	WanPuPriceMapXiguamei("WanPuPriceMapXiguamei"), //hash, adid-> price
	
	
	DianRuOnlineTaskStudio("DianRuOnlineTaskStudio"), //set, adid
	DianRuOnlineTaskXiguamei("DianRuOnlineTaskXiguamei"), //set, adid
	DianRuTaskMapStudio("DianRuTaskMapStudio"), //hash, adid-> taskId
	DianRuTaskMapXiguamei("DianRuTaskMapXiguamei"), //hash, adid-> taskId
	DianRuPriceMapStudio("DianRuPriceMapStudio"), //hash, adid-> price
	DianRuPriceMapXiguamei("DianRuPriceMapXiguamei"), //hash, adid-> price
	

;


	private final String prefix;

	/**
	 * @param prefix
	 */
	private PersistRedisKey(String prefix) {
		this.prefix = prefix;
	}

	public String of(Object key) {
		if (key != null) {
			return this.prefix + key;
		} else {
			return this.prefix;
		}
	}

	static {
		Set<String> keys = new HashSet<>();
		for (PersistRedisKey prefix : PersistRedisKey.values()) {
			boolean add = keys.add(prefix.prefix);
			if (!add) {
				throw new RuntimeException("duplicate redis key prefix found:" + prefix);
			}
		}
	}

	public String getValue() {
		return this.prefix;
	}
}
