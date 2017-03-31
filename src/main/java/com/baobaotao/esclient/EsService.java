package com.baobaotao.esclient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Service;

import com.baobaotao.domain.Product;
import com.baobaotao.util.ObjectUtil;

@Service
public class EsService {
	private TransportClient client;
	@PostConstruct
	public void initClient() throws UnknownHostException{
		Settings settings=Settings.builder().put("cluster.name", "elasticsearch").put("client.transport.sniff", true).build();
		TransportClient client=new PreBuiltTransportClient(settings);
		client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		this.client=client;
	}
	
	@PreDestroy
	public void destroy(){
		if(this.client!=null){
			this.client.close();
		}
	}

	public TransportClient getClient() {
		return client;
	}

	public void setClient(TransportClient client) {
		this.client = client;
	}
	
	public void bulkIndexProduct(List<Product> proList) {
		BulkRequestBuilder bulk=client.prepareBulk();
		try {
			for(int i=0;i<proList.size();i++){
				Product product=proList.get(i);
				bulk.add(client.prepareIndex("crawler", "product",product.getId()+"").setSource(XContentFactory.jsonBuilder().startObject().field("selfId", product.getId()).field("factory", product.getFactory()).field("approvalNumber", product.getApprovalNumber()).field("saleLog", product.getSaleLog()).field("createTime", product.getCreateTime()).field("dataId", product.getDataId()).field("productName",product.getProductName()).field("detailUrl",product.getDetailUrl()).field("product_price",ObjectUtil.getDoub(product.getProduct_price())).endObject()));
			}
		} catch (IOException e) {
			System.out.println("构建json数据出错");
			e.printStackTrace();
		}
		BulkResponse  bulkResponse  =  bulk.get();
		if  (bulkResponse.hasFailures())  {
			System.out.println("批量添加索引出现错误!!!!!!!!!!!!!!");
			bulkResponse.forEach(o1->{System.out.println(o1.getFailureMessage());});
		        //  process  failures  by  iterating  through  each  bulk  response  item
		}
		System.out.println("批量添加索引成功");
	}
}
