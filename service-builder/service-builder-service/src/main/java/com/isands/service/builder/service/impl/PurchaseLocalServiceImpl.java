/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.isands.service.builder.service.impl;

import com.isands.service.builder.model.Purchase;
import com.isands.service.builder.service.base.PurchaseLocalServiceBaseImpl;

import com.isands.service.builder.service.persistence.PurchasePersistence;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.isands.service.builder.model.Purchase",
        service = AopService.class
)
public class PurchaseLocalServiceImpl extends PurchaseLocalServiceBaseImpl {
    public List<Purchase> getPurchases(int start, int end, OrderByComparator<Purchase> orderByComparator) {
        return purchasePersistence.findAll(start, end, orderByComparator);
    }
}