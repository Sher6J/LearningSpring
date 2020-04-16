package cn.sher6j.proxy;

/**
 * 对生产厂家要求的接口
 * @author sher6j
 * @create 2020-04-14-16:05
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
