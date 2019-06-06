package io.renren.modules.generator.utils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

/**
 * Created by Administrator on 2019/5/14 16:48
 */
public class SolrUtil {
    private static SolrClient solrClient;
    private static String url;
    static {
        url = "http://localhost:8983/solr/ResAndRec";
        solrClient = new HttpSolrClient.Builder(url).build();
    }

    /*
    * 保存或更新solr
    *
    */
    public static <T> boolean saveSolrResources(T solrEntity){
        DocumentObjectBinder binder = new DocumentObjectBinder();
        SolrInputDocument doc = binder.toSolrInputDocument(solrEntity);
        try {
            solrClient.add(doc);
            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /*
    * 删除solr数据
    */
    public static boolean removeSolrData(String id) {
        try {
            solrClient.deleteById(id);
            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
    * 查询
    * */
    public static QueryResponse query(String keywords) throws SolrServerException, IOException {
        SolrQuery query = new SolrQuery();
        query.setQuery(keywords);
        QueryResponse rsp = solrClient.query(query);
        return rsp;
    }

}
