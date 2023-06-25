/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.isands.service.builder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatisticsHolderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatisticsHolderLocalService
 * @generated
 */
public class StatisticsHolderLocalServiceWrapper
	implements ServiceWrapper<StatisticsHolderLocalService>,
			   StatisticsHolderLocalService {

	public StatisticsHolderLocalServiceWrapper(
		StatisticsHolderLocalService statisticsHolderLocalService) {

		_statisticsHolderLocalService = statisticsHolderLocalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _statisticsHolderLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public StatisticsHolderLocalService getWrappedService() {
		return _statisticsHolderLocalService;
	}

	@Override
	public void setWrappedService(
		StatisticsHolderLocalService statisticsHolderLocalService) {

		_statisticsHolderLocalService = statisticsHolderLocalService;
	}

	private StatisticsHolderLocalService _statisticsHolderLocalService;

}