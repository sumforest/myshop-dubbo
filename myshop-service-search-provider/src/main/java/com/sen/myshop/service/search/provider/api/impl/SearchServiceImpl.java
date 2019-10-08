package com.sen.myshop.service.search.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sen.myshop.service.search.api.SearchService;
import com.sen.myshop.service.search.dto.TbSearchDto;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Sen
 * @Date: 2019/10/6 23:15
 * @Description:
 */
@Service(version = "${services.versions.search.v1}")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SolrClient solrClient;

    @Override
    public List<TbSearchDto> listTbSearchDtos(String query, int start, int row) {
        //创建查询对象
        SolrQuery solrQuery = new SolrQuery();

        //查询条件
        solrQuery.setQuery(query);

        //设置分页
        solrQuery.setStart((start - 1) * row);
        solrQuery.setRows(row);

        //设置默认搜索域
        solrQuery.set("df", "tb_item_keywords");

        //设置高亮显示
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("tb_item_title");
        solrQuery.setHighlightSimplePre("<span style:'color:red'>");
        solrQuery.setHighlightSimplePost("</span>");

        //创建返回对象
        List<TbSearchDto> tbSearchDtos = new ArrayList<>();
        try {
            //执行查询操作
            QueryResponse queryResponse = solrClient.query(solrQuery);

            //获取查询结果集
            SolrDocumentList results = queryResponse.getResults();

            //获取高亮显示结果集
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();

            //遍历结果集
            for (SolrDocument result : results) {
                TbSearchDto tbSearchDto = new TbSearchDto();
                String title = "";
                List<String> strings = highlighting.get(result.get("id")).get("tb_item_title");
                if (strings != null && strings.size() > 0) {
                    title = strings.get(0);
                } else {
                    title = (String) result.get("tb_item_title");
                }

                //封装TbSearchDto
                tbSearchDto.setId(Long.parseLong(String.valueOf(result.get("id"))));
                tbSearchDto.setTbItemCid(Long.parseLong(String.valueOf(result.get("tb_item_cid"))));
                tbSearchDto.setTbItemCname((String) result.get("tb_item_cname"));
                tbSearchDto.setTbItemDesc((String) result.get("tb_item_desc"));
                tbSearchDto.setTbItemSellPoint((String) result.get("tb_item_sell_point"));
                tbSearchDto.setTbItemTile(title);

                //封装返回结果
                tbSearchDtos.add(tbSearchDto);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tbSearchDtos;
    }
}
