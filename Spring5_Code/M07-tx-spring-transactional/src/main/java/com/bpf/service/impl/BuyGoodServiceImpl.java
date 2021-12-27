package com.bpf.service.impl;

import com.bpf.bean.Good;
import com.bpf.bean.Sale;
import com.bpf.dao.GoodDao;
import com.bpf.dao.SaleDao;
import com.bpf.except.GoodNotEnoughException;
import com.bpf.service.BuyGoodService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(
        propagation = Propagation.REQUIRED,
        isolation = Isolation.DEFAULT,
        timeout = 20, readOnly = false,
        rollbackFor = {NullPointerException.class, GoodNotEnoughException.class})
/**
 * rollbackFor: 表示当抛出的异常属于 NullPointerException 或 GoodNotEnoughException，事务一定回滚，
 *          否则如果是 RuntimeException，事务也一定回滚。
 */
public class BuyGoodServiceImpl implements BuyGoodService {

    private SaleDao saleDao;
    private GoodDao goodDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodDao(GoodDao goodDao) {
        this.goodDao = goodDao;
    }

    @Override
    public void buy(Integer goodId, Integer num) {
        // 添加订单信息
        Sale sale = new Sale(goodId, num);
        saleDao.insertSale(sale);

        // 查询商品状态
        Good good = goodDao.selectById(goodId);
        if (good == null) {
            throw new GoodNotEnoughException("商品[" + goodId + "]不存在");
        } else if (good.getAmount() < num) {
            throw new GoodNotEnoughException("商品[" + goodId + "]库存不足: " + good.getAmount() + "<" + num);
        }

        // 修改库存
        Good buyGood = new Good(goodId, num);
        goodDao.updateGood(buyGood);
    }
}