package caim.study.jee.utils;


public class Calculation {
    public static int getMaxPage(Long allCount, Integer count) {
        Double d = (double) allCount;
        return (int) Math.ceil(d / count);
    }
}
