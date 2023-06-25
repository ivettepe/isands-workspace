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

package com.isands.service.builder.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the StatisticsHolder service. Represents a row in the &quot;isands_StatisticsHolder&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StatisticsHolderModel
 * @generated
 */
@ImplementationClassName(
	"com.isands.service.builder.model.impl.StatisticsHolderImpl"
)
@ProviderType
public interface StatisticsHolder extends StatisticsHolderModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.isands.service.builder.model.impl.StatisticsHolderImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StatisticsHolder, String> STAT_NAME_ACCESSOR =
		new Accessor<StatisticsHolder, String>() {

			@Override
			public String get(StatisticsHolder statisticsHolder) {
				return statisticsHolder.getStatName();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<StatisticsHolder> getTypeClass() {
				return StatisticsHolder.class;
			}

		};

}