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
public class SionVideoCrawler {
    public static List<String> fetchVideoUrl(String url) {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setActiveXNative(false);
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
        List<Element> infoListEle = document.getElementsByClass("card-feed");//获取元素节点等
        List<Element> contentListEle = document.getElementsByAttributeValue("node-type", "feed_list_content");
        String video_src = null;
        String pic_src = null;
        List relist = new ArrayList();
        for (Element i : infoListEle) {
            Elements el = i.getElementsByClass("WB_video_h5");
            String info = el.attr("action-data");
            List<Element> contentEl=i.getElementsByAttributeValue("node-type", "feed_list_content");
            String content=contentEl.get(0).ownText();
            FetchInfo fetchInfo = new FetchInfo();
            try {
                video_src = info.split("video_src")[1].split("=")[1].split("&")[0];
                pic_src = info.split("cover_img")[1].split("=")[1].split("&")[0];
            } catch (Exception ex) {
                System.out.println("无法获取视频路径");
            }
            fetchInfo.setPicSrc(pic_src);
            fetchInfo.setVideoSrc(video_src);
            fetchInfo.setContent(content);
            relist.add(fetchInfo);
        }
        return relist;
    }

    public static String formatString(String s) {
        s = s.replace("%2F", "/").replace("%3F", "?").replace("%3D", "=").replace("%26", "&").replace("%2C", ",").replace("%3A", ":");
        return s;
    }
}
