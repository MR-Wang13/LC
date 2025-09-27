package ng.amazon.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Printer {

    public int maxPages(int[] pages, int[] thresholds){
        int n = pages.length;
        List<Print> prints = new ArrayList<>();
        for(int i = 0; i < pages.length; i++){
            prints.add(new Print(pages[i],thresholds[i],i));
        }
        prints.sort((a, b) -> {
            if (a.thresholds == b.thresholds) {
                return b.pages - a.pages;
            } else {
                return b.thresholds - a.thresholds;
            }
        });
        int max = 0;
        for(int actives = 1; actives <= thresholds.length; actives++){
            if(prints.get(actives - 1).thresholds >= actives){
                List<Print> tmp = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    if(prints.get(i).thresholds >= actives){
                        tmp.add(prints.get(i));
                    }
                }
                tmp.sort((a, b) -> b.pages - a.pages);
                int curPages = 0;
                for(int i = 0; i < tmp.size()&&i<actives; i++){
                    curPages += tmp.get(i).pages;
                }
                max = Math.max(max, curPages);
            }
        }
        return max;
    }
}
class Print{
    int pages;
    int thresholds;
    int id;
    public Print(int pages, int thresholds, int id){
        this.pages = pages;
        this.thresholds = thresholds;
        this.id = id;
    }
}