package com.ipeaksoft.moneyday.core.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.lang.StringUtils;

import com.ipeaksoft.moneyday.core.entity.ClusterGameAccount;


public class ClusterPool {
	
	
	public static ClusterPool pool=null;
	
	private Queue<ClusterGameAccount> queue=null;
	
	//私有化
	private ClusterPool (){
		queue=new ArrayDeque<ClusterGameAccount>(10000);
	}
	/**
	 * <p>获取池实例</p>
	 * @return
	 */
	public static ClusterPool getInstance(){
		if(pool==null){
			synchronized (ClusterPool.class) {
				if(pool==null){
					pool=new ClusterPool();
				}
			}
		}
		return pool;
	}
	/**
	 * <p>添加</p>
	 * @param result
	 */
	public void add(ClusterGameAccount result){
		synchronized (queue) {
			this.queue.add(result);
		}
	}
	/**
	 * <p>当前池数据量大小</p>
	 * @return
	 */
	public int getPoolSize(){
		synchronized (queue) {
			return queue.size();
		}
	}
	/**
	 * <p>每次获取批量的点击数据</p>
	 * @return
	 */
	public List<ClusterGameAccount> getBattchList(){
	  synchronized (queue) {
		int size=queue.size();
		List<ClusterGameAccount> crList=new ArrayList<ClusterGameAccount>();
			for(int i=1;i<=size;i++){
				crList.add(this.queue.poll());
			}
			return crList;
	  }
	}
}
