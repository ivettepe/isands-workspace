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

import com.isands.service.builder.service.base.EmployeeLocalServiceBaseImpl;

import com.isands.service.builder.service.persistence.impl.constants.isandsPersistenceConstants;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.isands.service.builder.model.Employee",
        service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
    public enum GENDER {
        MALE(0), FEMALE(1), OTHER(3), UNKNOWN(4);
        private final int value;

        GENDER(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public String getGenderById(int genderId) {
        return EnumSet.allOf(GENDER.class)
                .stream()
                .filter(g -> g.getValue() == genderId)
                .findFirst()
                .orElse(GENDER.UNKNOWN).toString();
    }

    public List<String> getGenderList() {
        return EnumSet.allOf(GENDER.class)
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList());
    }
}