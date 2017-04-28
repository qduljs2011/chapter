package com.baobaotao.study.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperClient {
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zk=new ZooKeeper("localhost:2181,localhost:2182,localhost:2183", 1000*60, e->{System.out.println("监听到了事件:"+e.getType());});
		//
		zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		//
	}
}
