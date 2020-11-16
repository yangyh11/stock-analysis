package com.yangyh.stockdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yangyh.stockdemo.entity.CapitalEntity;
import com.yangyh.stockdemo.entity.CapitalHoldEntity;
import com.yangyh.stockdemo.entity.CapitalInfoEntity;
import com.yangyh.stockdemo.entity.CapitalStockAddEntity;
import com.yangyh.stockdemo.entity.CapitalStockNewAddEntity;
import com.yangyh.stockdemo.entity.CapitalStockReductionEntity;
import com.yangyh.stockdemo.mapper.CapitalHoldMapper;
import com.yangyh.stockdemo.mapper.CapitalInfoMapper;
import com.yangyh.stockdemo.mapper.CapitalMapper;
import com.yangyh.stockdemo.mapper.CapitalStockAddMapper;
import com.yangyh.stockdemo.mapper.CapitalStockNewAddMapper;
import com.yangyh.stockdemo.mapper.CapitalStockReductionMapper;
import com.yangyh.stockdemo.mapper.Top40CapitalHoldMapper;
import com.yangyh.stockdemo.service.CapitalStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: yangyh
 * @create: 2020-08-11 23:55
 */
@Service
public class CapitalStockServiceImpl implements CapitalStockService {

    /**
     * 个股港资详情
     */
    String url1 = "https://eq.10jqka.com.cn/HSHKCapitalCount/api/querypositiondetail/day/%s.txt";


    /** 港资机构 */
    String brokerDataUrl = "https://eq.10jqka.com.cn/HSHKCapitalCount/api/getBrokerData/sortType/desc/sortBy/marketvalue/pageNum/%s";

    /**
     * 港资详情
     */
    String capitalUrl = "https://eq.10jqka.com.cn/HSHKCapitalCount/index.php?op=getBrokerDataFromPc&api=querybrokerinfo&brokercode=%s";

    /**
     * 机构全部持仓
     */
    String url2 = "https://eq.10jqka.com.cn/HSHKCapitalCount/index.php?op=getBrokerDataFromPc&api=queryholddetail&brokercode=%s&size=20&type=1&ordertype=desc&field=marketvalue&page=1";
    /**
     * 机构昨日建仓
     */
    String buildUrl = "https://eq.10jqka.com.cn/HSHKCapitalCount/index.php?op=getBrokerDataFromPc&api=queryholddetail&brokercode=%s&size=20&type=2&ordertype=desc&field=marketvalue&page=1";
    /**
     * 昨日加仓
     */
    String addUrl = "https://eq.10jqka.com.cn/HSHKCapitalCount/index.php?op=getBrokerDataFromPc&api=queryholddetail&brokercode=%s&size=20&type=3&ordertype=desc&field=marketvalue&page=1";
    /**
     * 昨日减仓
     */
    String reductionUrl = "https://eq.10jqka.com.cn/HSHKCapitalCount/index.php?op=getBrokerDataFromPc&api=queryholddetail&brokercode=%s&size=20&type=4&ordertype=desc&field=marketvalue&page=1";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CapitalMapper capitalMapper;
    @Autowired
    private CapitalInfoMapper capitalInfoMapper;

    @Autowired
    private CapitalStockNewAddMapper capitalStockNewAddMapper;
    @Autowired
    private CapitalStockAddMapper addMapper;
    @Autowired
    private CapitalStockReductionMapper reductionMapper;

    @Autowired
    private CapitalHoldMapper capitalHoldMapper;

    @Autowired
    private Top40CapitalHoldMapper top40CapitalHoldMapper;

    @Override
    public void saveCapitalInfo() {

        boolean finishFlag = false;

        int count = 0;
        int pageNum = 1;
        while (!finishFlag){
            String url = String.format(brokerDataUrl, pageNum);
            String resultStr = restTemplate.getForObject(url, String.class);
            JSONObject resultJson = JSONObject.parseObject(resultStr);
            JSONArray list = resultJson.getJSONObject("data").getJSONArray("list");

            if (list.size() != 0){
                list.forEach(data -> capitalInfoMapper.save(JSONObject.toJavaObject((JSON) data, CapitalInfoEntity.class)));
                count += list.size();
                pageNum++;
            } else {
                finishFlag = true;
            }
        }
        System.out.println("save capitalInfo to DB count:" + count);
    }

    @Override
    public void buildStock() {
        List<String> brokerCodeList = getBrokerCodeList();
        for (String brokerCode : brokerCodeList) {
            String url = String.format(buildUrl, brokerCode);
            String resultStr = restTemplate.getForObject(url, String.class);
            JSONObject resultJson = JSONObject.parseObject(resultStr);
            JSONObject result = resultJson.getJSONObject("result");
            int count = result.getInteger("count");
            if (count > 20) {
                resultStr = restTemplate.getForObject(url.replace("size=20", "size=" + count), String.class);
                result = JSONObject.parseObject(resultStr).getJSONObject("result");
            }
            List<JSONObject> list = (List<JSONObject>) result.get("result");
            for (JSONObject json : list) {
                CapitalStockNewAddEntity capitalStockNewAddEntity = JSONObject.toJavaObject(json, CapitalStockNewAddEntity.class);
                capitalStockNewAddMapper.save(capitalStockNewAddEntity);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void addStock() {
        List<String> brokerCodeList = getBrokerCodeList();
        for (String brokerCode : brokerCodeList) {
            String url = String.format(addUrl, brokerCode);
            String resultStr = restTemplate.getForObject(url, String.class);
            JSONObject resultJson = JSONObject.parseObject(resultStr);
            JSONObject result = resultJson.getJSONObject("result");
            List<JSONObject> list = (List<JSONObject>) result.get("result");
            int count = result.getInteger("count");
            while (count > 20 && list.size() == 20) {
                resultStr = restTemplate.getForObject(url.replace("size=20", "size=" + count), String.class);
                result = JSONObject.parseObject(resultStr).getJSONObject("result");
            }

            List<JSONObject> list1 = (List<JSONObject>) result.get("result");
            for (JSONObject json : list1) {
                CapitalStockAddEntity addEntity = JSONObject.toJavaObject(json, CapitalStockAddEntity.class);
                addMapper.save(addEntity);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据保存完成！");
    }

    @Override
    public void reductionStock() {
        List<String> brokerCodeList = getBrokerCodeList();
        int insertSize = 0;
        for (String brokerCode : brokerCodeList) {
            String url = String.format(reductionUrl, brokerCode);
            String resultStr = restTemplate.getForObject(url, String.class);
            JSONObject resultJson = JSONObject.parseObject(resultStr);
            JSONObject result = resultJson.getJSONObject("result");
            int count = result.getInteger("count");
            if (count > 20) {
                resultStr = restTemplate.getForObject(url.replace("size=20", "size=" + count), String.class);
                result = JSONObject.parseObject(resultStr).getJSONObject("result");
            }
            List<JSONObject> list = (List<JSONObject>) result.get("result");
            for (JSONObject json : list) {
                CapitalStockReductionEntity reductionEntity = JSONObject.toJavaObject(json, CapitalStockReductionEntity.class);
                reductionMapper.save(reductionEntity);
                insertSize++;
            }
            System.out.println("insert into db:" + insertSize);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据保存完成！");
    }

    @Override
    public void holdStock() {
        List<String> brokerCodeList = getBrokerCodeList();
        int saveCount = 0;

        for (String brokerCode : brokerCodeList) {
            List<String> urlList = new ArrayList<>(2);
            urlList.add(String.format(addUrl, brokerCode));
            urlList.add(String.format(reductionUrl, brokerCode));

            for (String url : urlList) {
                String resultStr = restTemplate.getForObject(url, String.class);
                JSONObject resultJson = JSONObject.parseObject(resultStr);
                JSONObject result = resultJson.getJSONObject("result");
                int count = result.getInteger("count");
                if (count == 0) {
                    continue;
                } else if (count > 20) {
                    resultStr = restTemplate.getForObject(url.replace("size=20", "size=" + count), String.class);
                    try {
                        result = JSONObject.parseObject(resultStr).getJSONObject("result");
                    } catch (Exception e) {
                        System.out.println("----------------" + resultStr + " " + count);
                        e.printStackTrace();
                    }
                }
                List<JSONObject> list = (List<JSONObject>) result.get("result");

                List<CapitalHoldEntity> capitalHoldEntityList = new ArrayList<>();
                for (JSONObject json : list) {
                    CapitalHoldEntity capitalHoldEntity = JSONObject.toJavaObject(json, CapitalHoldEntity.class);
                    capitalHoldEntityList.add(capitalHoldEntity);
                }
                capitalHoldMapper.saveBatch(capitalHoldEntityList);
                saveCount += capitalHoldEntityList.size();
                System.out.println("insert into db:" + capitalHoldEntityList.size() + " total save:" + saveCount);

            }
        }
        System.out.println("数据保存完成！");
    }

    @Override
    public void top40CapitalHoldStock() {
        Set<String> brokerSet = getTop40Capital().keySet();
        int saveCount = 0;

        for (String brokerCode : brokerSet) {
            List<String> urlList = new ArrayList<>(2);
            urlList.add(String.format(addUrl, brokerCode));
            urlList.add(String.format(reductionUrl, brokerCode));

            for (String url : urlList) {
                String resultStr = restTemplate.getForObject(url, String.class);
                JSONObject resultJson = JSONObject.parseObject(resultStr);
                JSONObject result = resultJson.getJSONObject("result");
                int count = result.getInteger("count");
                if (count == 0) {
                    continue;
                } else if (count > 20) {
                    resultStr = restTemplate.getForObject(url.replace("size=20", "size=" + count), String.class);
                    try {
                        result = JSONObject.parseObject(resultStr).getJSONObject("result");
                    } catch (Exception e) {
                        System.out.println("----------------" + resultStr + " " + count);
                        e.printStackTrace();
                    }
                }
                List<JSONObject> list = (List<JSONObject>) result.get("result");

                List<CapitalHoldEntity> capitalHoldEntityList = new ArrayList<>();
                for (JSONObject json : list) {
                    CapitalHoldEntity capitalHoldEntity = JSONObject.toJavaObject(json, CapitalHoldEntity.class);
                    capitalHoldEntityList.add(capitalHoldEntity);
                }
                top40CapitalHoldMapper.saveBatch(capitalHoldEntityList);
                saveCount += capitalHoldEntityList.size();
                System.out.println("insert into db:" + capitalHoldEntityList.size() + " total save:" + saveCount);

            }
        }
        System.out.println("数据保存完成！");
    }

    @Override
    public Map<String, CapitalInfoEntity> getTop40Capital(){
        Map<String, CapitalInfoEntity> map = new HashMap<>();
        List<CapitalInfoEntity> top20AllMount = capitalInfoMapper.getTop20AllMount();
        List<CapitalInfoEntity> top20ProfitlossrateCapital = capitalInfoMapper.getTop20ProfitlossrateCapital();
        top20AllMount.forEach(data -> map.put(data.getBrokercode(), data));
        top20ProfitlossrateCapital.forEach(data -> map.put(data.getBrokercode(), data));
        System.out.println(map.size());
        return map;
    }

    private List<String> getBrokerCodeList() {
        List<CapitalInfoEntity> capitalList = capitalInfoMapper.queryByMap(null);
        List<String> brokerCodeList = new ArrayList<>(capitalList.size());
        capitalList.forEach(capital -> brokerCodeList.add(capital.getBrokercode()));
        return brokerCodeList;
    }
}
