create table isands_ElectroEmployee (
	mvccVersion LONG default 0 not null,
	id_ LONG not null primary key,
	ElectroTypeId LONG,
	employeeId LONG,
	companyId LONG
);

create table isands_ElectroType (
	mvccVersion LONG default 0 not null,
	electroTypeId LONG not null primary key,
	name VARCHAR(100) null,
	companyId LONG
);

create table isands_Electronics (
	mvccVersion LONG default 0 not null,
	electronicsId LONG not null primary key,
	name VARCHAR(150) null,
	ElectroTypeId LONG,
	price LONG,
	count INTEGER,
	inStock BOOLEAN,
	archive BOOLEAN,
	description TEXT null,
	companyId LONG
);

create table isands_Employee (
	mvccVersion LONG default 0 not null,
	employeeId LONG not null primary key,
	lastName VARCHAR(100) null,
	firstName VARCHAR(100) null,
	patronymic VARCHAR(100) null,
	birthDay DATE null,
	positionId LONG,
	gender INTEGER,
	companyId LONG
);

create table isands_PositionType (
	mvccVersion LONG default 0 not null,
	positionTypeId LONG not null primary key,
	name VARCHAR(100) null,
	companyId LONG
);

create table isands_Purchase (
	mvccVersion LONG default 0 not null,
	purchaseId LONG not null primary key,
	electronicsId LONG,
	employeeId LONG,
	purchaseDate DATE null,
	count INTEGER,
	companyId LONG,
	purchaseTypeId LONG
);

create table isands_PurchaseType (
	mvccVersion LONG default 0 not null,
	purchaseTypeId LONG not null primary key,
	name VARCHAR(100) null,
	companyId LONG
);