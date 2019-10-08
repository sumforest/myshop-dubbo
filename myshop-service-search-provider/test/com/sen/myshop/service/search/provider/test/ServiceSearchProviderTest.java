package com.sen.myshop.service.search.provider.test;

import com.sen.myshop.service.search.dto.TbSearchDto;
import com.sen.myshop.service.search.provider.MyshopServiceSearchProviderApplication;
import com.sen.myshop.service.search.provider.mapper.TbSearchMapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Sen
 * @Date: 2019/10/6 20:14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyshopServiceSearchProviderApplication.class)
public class ServiceSearchProviderTest {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private TbSearchMapper tbSearchMapper;

    @Test
    public void addToSolr() {

        //创建文档对象
        SolrInputDocument document = new SolrInputDocument();

        //想文档域添加对象
        document.setField("id", 536563);
        document.setField("tb_item_title", "阿尔卡特 (OT-927) 炭黑 联通3G手机 双卡双待");

        //添加文件
        try {
            solrClient.add(document);
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        try {
            solrClient.deleteById("536563");
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initSolr() {
        List<TbSearchDto> tbSearchDtos = tbSearchMapper.listTbSearchDto();
        for (TbSearchDto tbSearchDto : tbSearchDtos) {
            //新键文档对象
            SolrInputDocument document = new SolrInputDocument();

            //向文档域添加对象
            document.setField("id", tbSearchDto.getId());
            document.setField("tb_item_title", tbSearchDto.getTbItemTile());
            document.setField("tb_item_sell_point", tbSearchDto.getTbItemSellPoint());
            document.setField("tb_item_cid", tbSearchDto.getTbItemCid());
            document.setField("tb_item_cname", tbSearchDto.getTbItemCname());
            document.setField("tb_item_desc", tbSearchDto.getTbItemDesc());

            //向solr添加文档
            try {
                solrClient.add(document);
                solrClient.commit();
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void testQueryDocument() {

        //创建查询对象
        SolrQuery query = new SolrQuery();

        //设置查询对象
        query.setQuery("手机");

        //设置分页
        query.setStart(0);
        query.setRows(10);

        //设置默认搜索域
        query.set("df", "tb_item_keywords");

        //设置高亮显示
        query.setHighlight(true);
        query.addHighlightField("tb_item_title");
        query.setHighlightSimplePre("<span style:'color:red'>");
        query.setHighlightSimplePost("</span>");

        try {
            //执行查询操作
            QueryResponse queryResponse = solrClient.query(query);

            //获取查询结果集
            SolrDocumentList results = queryResponse.getResults();

            //获取高亮显示结果集
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();

            //遍历结果集
            for (SolrDocument result : results) {
                String title = "";
                List<String> strings = highlighting.get(result.get("id")).get("tb_item_title");
                if (strings != null && strings.size() > 0) {
                    title = strings.get(0);
                } else {
                    title = (String) result.get("tb_item_title");
                }
                System.out.println(title);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
