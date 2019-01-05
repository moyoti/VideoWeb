package com.my.util;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.my.pojo.FetchInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 20:53 2018/12/21
 */
public class BilibiliVideoCrawler {
    public static List<String> fetchVideoUrl(String url) {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setActiveXNative(true);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
        webClient.getOptions().setUseInsecureSSL(true);
        HtmlPage page = null;
        try {
            page = webClient.getPage(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //webClient.waitForBackgroundJavaScript(300000);
        //webClient.setJavaScriptTimeout(0);
        String pageXml = page.asXml();//直接将加载完成的页面转换成xml格式的字符串


        Document document = Jsoup.parse(pageXml);//获取html文档
        List<Element> infoListEle = document.getElementsByClass("matrix");//获取元素节点等
        String video_src = null;
        String pic_src = null;
        List relist = new ArrayList();
        for (Element i : infoListEle) {
            Elements el = i.getElementsByClass("lazy-img");
            pic_src=el.get(0).child(0).attr("src");
            String content=i.getElementsByClass("headline").get(0).getElementsByTag("a").get(0).attr("title");
            video_src=i.getElementsByClass("headline").get(0).getElementsByClass("avid").get(0).ownText();
            FetchInfo fetchInfo=new FetchInfo();
            fetchInfo.setContent(content);
            fetchInfo.setPicSrc(pic_src);
            fetchInfo.setVideoSrc(video_src);
            relist.add(fetchInfo);
        }
        return relist;
    }
}
