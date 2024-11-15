package Facebook;

import java.util.*;

public class WebCrawlerMultithreaded {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        HashSet<String> visited = new HashSet<>();
        visited.add(startUrl);
        String host = getHost(startUrl);
        Queue<String> queue = new LinkedList<>();
        queue.add(startUrl);

        while (!queue.isEmpty()) {
            String url = queue.poll();
            for (String s:htmlParser.getUrls(url)) {
                if (getHost(s).equals(host) && !visited.contains(url)) {
                    queue.add(s);
                    visited.add(s);
                }
            }
        }
        return new ArrayList<>(visited);
    }

    private String getHost(String url) {
        int count = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                count++;
            }
            if (count == 3) {
                return url.substring(0, i);
            }
        }
        return url;
    }
}
