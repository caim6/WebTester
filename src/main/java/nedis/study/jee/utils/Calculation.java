package nedis.study.jee.utils;

/**
 * Created by caim6 on 24.12.2015.
 */
public class Calculation {
    public static int getMaxPage(Long allCount, Integer count) {
        Double d = (double) allCount;
        return (int) Math.ceil(d / count);
    }
}
