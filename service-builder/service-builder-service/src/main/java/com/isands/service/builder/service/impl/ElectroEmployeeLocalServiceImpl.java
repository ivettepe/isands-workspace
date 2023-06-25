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

import com.isands.service.builder.model.ElectroEmployee;
import com.isands.service.builder.service.base.ElectroEmployeeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.isands.service.builder.model.ElectroEmployee",
        service = AopService.class
)
public class ElectroEmployeeLocalServiceImpl
        extends ElectroEmployeeLocalServiceBaseImpl {
    public List<ElectroEmployee> findByEmployee(Long employeeId) {
        return electroEmployeePersistence.findByEmployee(employeeId);
    }

    public List<ElectroEmployee> findByElectroType(Long electroTypeId) {
        return electroEmployeePersistence.findByElectroType(electroTypeId);
    }
}