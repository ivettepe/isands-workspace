package com.isands.web.date.compare;

import com.isands.service.builder.model.Purchase;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class PurchaseDateComparator extends OrderByComparator<Purchase> {
    private static final Log logger = LogFactoryUtil.getLog(PurchaseDateComparator.class);
    private boolean _asc;

    public PurchaseDateComparator(boolean asc) {
        _asc = asc;
    }

    public int compare(Purchase p1, Purchase p2) {
        logger.info("Comparing " + p1 + " and " + p2);
        boolean before = p1.getPurchaseDate().before(p2.getPurchaseDate());
        if (_asc) {
            return before ? -1 : 1;
        } else {
            return before ? 1 : -1;
        }
    }
}
